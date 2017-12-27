package com.senla.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.senla.ui.util.UIController;

import annotation.ConfigProperty;
import annotation.Injectable;
import handler.MessageHandler;
import util.AnnotationHandler;

public class AutoServiceClientSocket {
	@ConfigProperty(configName = "config.properties", propertyName = "AutoServiceClientSocket.port", type = int.class)
	private int port;
	@ConfigProperty(configName = "config.properties", propertyName = "AutoServiceClientSocket.ip", type = String.class)
	private String ip;
	@Injectable
	private MessageHandler handler;
	// @Injectable
	// @Configurable
	// private IObservable observers;
	private static final String CONNECTION_SUCCESSFUL = "Connected to server!";

	public static void main(String[] args) {
		AutoServiceClientSocket client = new AutoServiceClientSocket();
		AnnotationHandler.configure(client);
		client.start();
	}

	public void start() {
		try (Socket socket = new Socket(InetAddress.getByName(ip), port);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
			System.out.println(CONNECTION_SUCCESSFUL);
			UIController ui = new UIController();
			AnnotationHandler.configure(ui);
			handler.initStreams(in, out);
			ui.start();
		} catch (IOException e) {
			// observers.notifyAllObservers(e);
			e.printStackTrace();
		}
	}
}
