package com.server;

import java.io.IOException;
import java.net.ServerSocket;

import com.senla.controller.Controller;
import com.senla.controller.IController;
import serialisation.Serializer;
import com.server.ClientListener;

import annotation.ConfigProperty;
import annotation.Configurable;
import annotation.Injectable;
import dependency.DependencyManager;
import util.AnnotationHandler;

public class AutoServiceServerSocket {
	@ConfigProperty(configName = "system.properties", propertyName = "AutoServiceServerSocket.port")
	private static int port;
	@ConfigProperty(configName = "config.properties", propertyName = "AutoServiceServerSocket.serializerFileName")
	private String serializerFileName;
	@ConfigProperty(configName = "config.properties", propertyName = "AutoServiceServerSocket.serializerFilePath")
	private String serializerFilePath;
	@Injectable
	@Configurable
	private static IController controller;
	private static Serializer serializer;

	private final static String SERVER_INITIALIZATION = "Server started";
	private final static String SERVER_WAITING_FOR_CONNECTION = "waiting for a client...";
	private final static String SERVER_CONNECTION_SUCCESS = "Client connected";

	public static void start() {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
			System.out.println(SERVER_INITIALIZATION);
			while (true) {
				System.out.println(SERVER_WAITING_FOR_CONNECTION);
				ClientListener listener = new ClientListener(ss.accept(), controller);
				listener.start();
				System.out.println(SERVER_CONNECTION_SUCCESS);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO sdelat serializaciu pri prerivanii treda
		/*
		 * serializer = new Serializer(serializerFileName, serializerFilePath);
		 * serializer.updateProperties(); serializer.load();
		 */
	}
}
