package com.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AutoServiceClientSocket {
	private static final int port = 6565;
	private static InetAddress ip;
	@SuppressWarnings("unused")
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
			@SuppressWarnings("resource")
			Socket s = new Socket(ip, port);
			System.out.print("enstabilished");
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			while(true) {
				System.out.print("vvedi che to");
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				out.writeObject(str);
				Object msg = in.readObject();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
