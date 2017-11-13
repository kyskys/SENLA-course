package com.senla.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.senla.ui.util.UIController;
import com.senla.message.Message;

import annotation.ConfigProperty;
import handler.MessageHandler;
import util.AnnotationHandler;

public class AutoServiceClientSocket {
	@ConfigProperty(configName = "system.properties", propertyName = "AutoServiceClientSocket.port")
	private static int port;
	@ConfigProperty(configName = "system.properties", propertyName = "AutoServiceClientSocket.ip")
	private static String ip;
	private static MessageHandler handler;
	private static final String CONNECTION_SUCCESSFUL = "Connected to server!";

	public static void main(String[] args) {
		try (Socket socket = new Socket(ip, port);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
			System.out.println(CONNECTION_SUCCESSFUL);
			UIController ui = new UIController();
			AnnotationHandler.configure(ui);
			ui.start();
			handler = new MessageHandler() {

				@Override
				public Message send(Message msg) {
					try {
						out.writeObject(msg);
						out.flush();
						return (Message) in.readObject();
					} catch (IOException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			};
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Message send(Message msg) {
		return handler.send(msg);
	}

}
