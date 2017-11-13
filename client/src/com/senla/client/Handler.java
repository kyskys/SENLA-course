package com.senla.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.senla.message.Message;

import handler.MessageHandler;

public class Handler implements MessageHandler {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	@Override
	public Message send(Message msg) {
		try {
			oos.writeObject(msg);
			oos.flush();
			return (Message) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void initStreams(ObjectInputStream ois, ObjectOutputStream oos) {
		this.ois = ois;
		this.oos = oos;
	}
}
