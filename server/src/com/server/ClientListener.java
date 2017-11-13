package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import com.senla.controller.IController;
import com.senla.message.Message;

public class ClientListener implements Runnable {
	private Thread clientThread;
	private IController controller;
	private Socket socket;
	private static final String CLIENT_DISCONNECTED = "Client disconnected";
	private static final String SESSION_END_SIGNAL = "avada kedavra";

	@Override
	public void run() {
		Class<?> controllerClass = controller.getClass();
		try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());) {
			clientThread.start();
			while (true) {
				Message msg = (Message) ois.readObject();
				String stingPartOfMessage = msg.getMessage().toString();
				if (stingPartOfMessage.equals(SESSION_END_SIGNAL)) {
					System.out.println(CLIENT_DISCONNECTED);
					break;
				} else {
					try {
						Class<?>[] parametersClass = null;
						Object[] parameters = msg.getParameters();
						if (parameters != null) {
							parametersClass = new Class<?>[parameters.length];
							for (int i = 0; i < parameters.length; i++) {
								parametersClass[i] = parameters[i].getClass();
							}
						}
						Method m = controllerClass.getMethod(stingPartOfMessage, parametersClass);
						Object toSend = m.invoke(controller, msg.getParameters());
						oos.writeObject(new Message(toSend == null ? "success" : toSend));
					} catch (NoSuchMethodException e) {
						oos.writeObject(new Message("no such method"));
					} catch (SecurityException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						oos.writeObject(new Message(e.getMessage()));
					}

				}

			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			clientThread.interrupt();
			socket.close();
		}
	}

	public ClientListener(Socket socket, IController controller) {
		this.socket = socket;
		this.controller = controller;
	}

	public void start() {
			clientThread = new Thread(this);
	}

}
