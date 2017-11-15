package com.senla.observer.client;

import java.util.ArrayList;
import java.util.List;

import com.senla.observer.interfaces.IExceptionObserver;
import com.senla.observer.interfaces.IObservable;
import com.senla.observer.interfaces.IObserver;

import annotation.ConfigProperty;

public class ClientObservable implements IObservable {
	@ConfigProperty(configName = "config.properties", propertyName = "ClientObservable.exceptionObservers", type = IObserver.class)
	private List<IExceptionObserver> exceptionObservers = new ArrayList<IExceptionObserver>();

	@Override
	public void addObserver(IObserver o) {

	}

	@Override
	public void removeObserver(IObserver o) {

	}

	@Override
	public void addObserver(IExceptionObserver o) {
		exceptionObservers.add(o);
	}

	@Override
	public void removeObserver(IExceptionObserver o) {
		exceptionObservers.remove(o);
	}

	@Override
	public void notifyAllObservers(String str) {

	}

	@Override
	public void notifyAllObservers(Throwable e) {
		for (IExceptionObserver eo : exceptionObservers) {
			eo.display(e);
		}
	}

}
