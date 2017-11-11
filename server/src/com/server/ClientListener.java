package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import com.senla.controller.IController;

import dependency.DependencyManager;
import message.Message;

public class ClientListener implements Runnable {
	private Thread clientThread;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	private IController controller;
	private static final String CLIENT_DISCONNECTED = "cliend disconnected";
	private static final String SESSION_END_SIGNAL = "avada kedavra";

	@Override
	public void run() {
		try {
			while (true) {
				Message msg = (Message) ois.readObject();
				if (msg.getMessage().equals(SESSION_END_SIGNAL)) {
					System.out.println(CLIENT_DISCONNECTED);
					break;
				} else {
					Class<?> controllerClass = controller.getClass();
					try {
						Class<?>[] parametersClass = null;
						Object[] parameters = msg.getParameters();
						if (parameters != null) {
							parametersClass = new Class<?>[parameters.length];
							for (int i = 0; i < parameters.length; i++) {
								parametersClass[i] = parameters[i].getClass();
							}
						}
						Method m = controllerClass.getMethod(msg.getMessage(), parametersClass);
						Object toSend = m.invoke(controller, msg.getParameters());
						if (toSend != null) {
							oos.writeObject(new Message(toSend.toString()));
						} else
							oos.writeObject(new Message("success"));
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException e) {
						oos.writeObject(new Message("no such method"));
					}

				}

			}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				end();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ClientListener(Socket socket) {
		this.socket = socket;
		this.controller = DependencyManager.getInstance(IController.class);
	}

	public void start() throws IOException {
		clientThread = new Thread(this);
		oos = new ObjectOutputStream(socket.getOutputStream());
		oos.flush();
		ois = new ObjectInputStream(socket.getInputStream());
		clientThread.start();
	}

	public void end() throws IOException {
		if (ois != null) {
			ois.close();
		}
		if (oos != null) {
			oos.close();
		}
		if (clientThread != null) {
			clientThread.interrupt();
		}
		if (socket != null) {
			socket.close();
		}
	}
}
