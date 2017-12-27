package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.senla.controller.IController;

import message.Message;


public class ClientListener implements Runnable {
	private Thread clientThread;
	private IController controller;
	private Socket socket;
	//private IObservable observable;
	private static final String CLIENT_DISCONNECTED = "Client disconnected";
	private static final String SESSION_END_SIGNAL = "avada kedavra";

	@Override
	public void run() {
		{
			try (Socket socket = this.socket;
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());) {
				while (true) {
					Message msg = (Message) ois.readObject();
					String stringPartOfMessage = msg.getMessage().toString();
					if (stringPartOfMessage.equals(SESSION_END_SIGNAL)) {
						System.out.println(CLIENT_DISCONNECTED);
						oos.writeObject(new Message("Goodbye!"));
						break;
					} else {
						Object toSend = MethodInvoker.invoke(controller, msg.getMessage().toString(),
								msg.getParameters());
						oos.writeObject(new Message(toSend == null ? "success" : toSend));
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				// observable.notifyAllObservers(e);
			} finally {
				clientThread.interrupt();
			}
		}
	}

	public ClientListener(Socket socket, IController controller) {
		// this.observable = observable;
		this.socket = socket;
		this.controller = controller;
	}

	public void start() {
		clientThread = new Thread(this);
		clientThread.start();
	}

}
