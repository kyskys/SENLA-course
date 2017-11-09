package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import message.Message;

public class ClientListener implements Runnable {
	private Thread clientThread = null;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;

	@Override
	public void run() {
		try {
			while (true) {
				String msg = (String) ois.readObject();
				if (msg.equals("avada kedavra")) {
					break;
				} else {
					oos.writeObject(msg);
				}

			}
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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
	}

	public void start() throws IOException {
		clientThread = new Thread(this);
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		clientThread.run();
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
