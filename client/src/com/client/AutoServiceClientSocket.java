package com.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observer;

import com.senla.ui.util.UIController;

import api.ClientSocket;
import dependency.DependencyManager;
import message.Message;
import observer.interfaces.IObservable;
import util.AnnotationHandler;

public class AutoServiceClientSocket implements ClientSocket {
	private static final int port = 6565;
	private static InetAddress ip;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	private static Socket sock;

	private static void getConfig() {
		try {
			ip = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			getConfig();
			sock = new Socket(ip, port);
			System.out.print("enstabilished");
			out = new ObjectOutputStream(sock.getOutputStream());
			out.flush();
			in = new ObjectInputStream(sock.getInputStream());
			UIController ui = new UIController();
			AnnotationHandler.configure(ui);
			ui.init();
			ui.start();
			do {
				Message msg = (Message) in.readObject();
				System.out.println(msg.getMessage());
			} while (true);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

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

	@Override
	public Message read() {
		try {
			return (Message) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
