package com.senla.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.senla.ui.util.UIController;
import annotation.ConfigProperty;
import dependency.DependencyManager;
import handler.MessageHandler;
import util.AnnotationHandler;

public class AutoServiceClientSocket {
	@ConfigProperty(configName = "system.properties", propertyName = "AutoServiceClientSocket.port")
	private static int port;
	@ConfigProperty(configName = "system.properties", propertyName = "AutoServiceClientSocket.ip")
	private static String ip;
	private static MessageHandler handler = DependencyManager.getInstance(MessageHandler.class);
	private static final String CONNECTION_SUCCESSFUL = "Connected to server!";

	public static void main(String[] args) {
		try (Socket socket = new Socket(ip, port);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
			System.out.println(CONNECTION_SUCCESSFUL);
			UIController ui = new UIController();
			AnnotationHandler.configure(ui);
			handler.initStreams(in, out);
			ui.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
