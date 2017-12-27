package handler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import message.Message;

public interface MessageHandler {
	Message send(Message msg) throws IOException, ClassNotFoundException;

	void initStreams(ObjectInputStream ois, ObjectOutputStream oos);
}
