package com.senla.ui.action;

import com.senla.message.Message;
import com.senla.observer.interfaces.IObservable;

import annotation.Configurable;
import annotation.Injectable;
import dependency.DependencyManager;
import handler.MessageHandler;
import util.AnnotationHandler;

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
