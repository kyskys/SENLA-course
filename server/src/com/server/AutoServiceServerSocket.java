package com.server;

import java.io.IOException;
import java.net.ServerSocket;

import com.senla.controller.IController;
import com.server.ClientListener;

import dependency.DependencyManager;
import util.AnnotationHandler;

public class AutoServiceServerSocket {
	private final static int port = 6565;
	private final static String SERVER_INITIALIZATION = "Server started";
	private final static String SERVER_WAITING_FOR_CONNECTION = "waiting for a client...";
	private final static String SERVER_CONNECTION_SUCCESS = "Client connected";

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
			IController cont = DependencyManager.getInstance(IController.class);
			AnnotationHandler.configure(cont);
			System.out.println(SERVER_INITIALIZATION);
			while (true) {
				System.out.println(SERVER_WAITING_FOR_CONNECTION);
				ClientListener listener = new ClientListener(ss.accept());
				listener.start();
				System.out.println(SERVER_CONNECTION_SUCCESS);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
