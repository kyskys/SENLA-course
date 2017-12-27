package com.senla.ui.action;

import dependency.DependencyManager;
import handler.MessageHandler;
import message.Message;

public abstract class Action implements IAction {

	protected MessageHandler handler = DependencyManager.getInstance(MessageHandler.class);
	// @Injectable
	// @Configurable
	// private IObservable observable;

	public Object sendMessage(String messageToSend, Object... objectsToSend) {
		try {
			return handler.send(new Message(messageToSend, objectsToSend)).getMessage();
		} catch (Throwable e) {
			// observable.notifyAllObservers(e);
			e.printStackTrace();
		}
		return null;
	}

	public void notifyAllObservers(Object str) {
		// observable.notifyAllObservers(str.toString());
		System.out.println(str.toString());
	}
}
