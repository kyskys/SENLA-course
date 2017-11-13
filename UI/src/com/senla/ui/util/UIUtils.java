package com.senla.ui.util;

import com.senla.message.Message;

import dependency.DependencyManager;
import handler.MessageHandler;
import observer.interfaces.IObservable;

public class UIUtils {
	public static Object sendMessage(String messageToSend, Object... objectsToSend) {
		return DependencyManager.getInstance(MessageHandler.class).send(new Message(messageToSend, objectsToSend))
				.getMessage();
	}

	public static void notifyAllObservers(Object str) {
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(str.toString());
	}
}
