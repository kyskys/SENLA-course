package handler;

import com.senla.message.Message;

public interface MessageHandler {
	Message send(Message msg);
}
