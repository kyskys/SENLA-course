package handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.senla.message.Message;

public interface MessageHandler {
	Message send(Message msg);

	void initStreams(ObjectInputStream ois, ObjectOutputStream oos);
}
