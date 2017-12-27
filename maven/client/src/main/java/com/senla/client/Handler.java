package com.senla.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import handler.MessageHandler;
import message.Message;

public class Handler implements MessageHandler {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	@Override
	public Message send(Message msg) throws IOException, ClassNotFoundException {
		oos.writeObject(msg);
		oos.flush();
		return (Message) ois.readObject();
	}

	@Override
	public void initStreams(ObjectInputStream ois, ObjectOutputStream oos) {
		this.ois = ois;
		this.oos = oos;
	}
}
