package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import com.senla.controller.IController;
import com.senla.message.Message;
import com.senla.observer.interfaces.IObservable;

import serialisation.Serializer;

public class ClientListener implements Runnable {
	private Thread clientThread;
	private IController controller;
	private Socket socket;
	private IObservable observable;
	private Serializer serializer;
	private static final String CLIENT_DISCONNECTED = "Client disconnected";
	private static final String SESSION_END_SIGNAL = "avada kedavra";
	private static final String START_SERIALIZATION = "serialize";

	@Override
	public void run() {
		Class<?> controllerClass = controller.getClass();
		{
			try (Socket socket = this.socket;
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());) {
				while (true) {
					Message msg = (Message) ois.readObject();
					String stringPartOfMessage = msg.getMessage().toString();
					if (stringPartOfMessage.equals(SESSION_END_SIGNAL)) {
						System.out.println(CLIENT_DISCONNECTED);
						break;
					} else if (stringPartOfMessage.equals(START_SERIALIZATION)) {
						serializer.save();
						oos.writeObject(new Message("data serialized"));
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
							Method m = controllerClass.getMethod(stringPartOfMessage, parametersClass);
							Object toSend = m.invoke(controller, msg.getParameters());
							oos.writeObject(new Message(toSend == null ? "success" : toSend));
						} catch (NoSuchMethodException e) {
							oos.writeObject(new Message("no such method"));
							observable.notifyAllObservers(e);
						} catch (SecurityException | IllegalAccessException | IllegalArgumentException
								| InvocationTargetException e) {
							oos.writeObject(new Message(e.getMessage()));
							observable.notifyAllObservers(e);
						}

					}

				}
			} catch (IOException | ClassNotFoundException e) {
				observable.notifyAllObservers(e);
			} finally {
				clientThread.interrupt();
			}
		}
	}

	public ClientListener(Socket socket, IController controller, IObservable observable, Serializer serializer) {
		this.observable = observable;
		this.socket = socket;
		this.controller = controller;
		this.serializer = serializer;
	}

	public void start() {
		clientThread = new Thread(this);
		clientThread.start();
	}

}
