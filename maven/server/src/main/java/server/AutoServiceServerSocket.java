package server;

import java.io.IOException;
import java.net.ServerSocket;

import com.senla.controller.IController;

//import com.senla.observer.interfaces.IObservable;

import annotation.ConfigProperty;
import annotation.Configurable;
import annotation.Injectable;
import connector.DBConnector;
import server.ClientListener;
import util.AnnotationHandler;
import util.SessionManager;

public class AutoServiceServerSocket {
	@ConfigProperty(configName = "config.properties", propertyName = "AutoServiceServerSocket.port", type = int.class)
	private int port;
	@Injectable
	@Configurable
	private IController controller;
	// @Injectable
	// @Configurable
	// private IObservable observable;

	private final static String SERVER_INITIALIZATION = "Server started";
	private final static String SERVER_WAITING_FOR_CONNECTION = "waiting for a client...";
	private final static String SERVER_CONNECTION_SUCCESS = "Client connected";

	public static void main(String[] args) {
		AutoServiceServerSocket server = new AutoServiceServerSocket();
		AnnotationHandler.configure(server);
		server.start();
	}

	public void start() {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
			SessionManager.setConnection(DBConnector.getConnection());
			System.out.println(SERVER_INITIALIZATION);
			while (true) {
				System.out.println(SERVER_WAITING_FOR_CONNECTION);
				ClientListener listener = new ClientListener(ss.accept(), controller);
				listener.start();
				System.out.println(SERVER_CONNECTION_SUCCESS);
			}
		} catch (IOException e) {
			// observable.notifyAllObservers(e);
		}
	}
}
