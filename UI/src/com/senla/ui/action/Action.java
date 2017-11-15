package com.senla.ui.action;

import com.senla.message.Message;
import com.senla.observer.interfaces.IObservable;

import annotation.Configurable;
import annotation.Injectable;
import handler.MessageHandler;
import util.AnnotationHandler;

public abstract class Action implements IAction {
	@Injectable
	private MessageHandler handler;
	@Injectable
	@Configurable
	private IObservable observable;

	public Action() {
		AnnotationHandler.configure(this);
	}

	public Object sendMessage(String messageToSend, Object... objectsToSend) {
		try {
			return handler.send(new Message(messageToSend, objectsToSend)).getMessage();
		} catch (Throwable e) {
			observable.notifyAllObservers(e);
		}
		return null;
	}

	public void notifyAllObservers(Object str) {
		observable.notifyAllObservers(str.toString());
	}
}
