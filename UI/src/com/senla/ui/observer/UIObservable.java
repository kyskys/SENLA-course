package com.senla.ui.observer;

import java.util.ArrayList;
import java.util.List;

import com.senla.ui.observer.interfaces.IExceptionObserver;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.observer.interfaces.IObserver;

import annotation.annotations.ConfigProperty;

public class UIObservable implements IObservable {
	@ConfigProperty(configName="config.properties",propertyName="UIObservable.observers",type=IObserver.class)
	private List<IObserver> observers = new ArrayList<IObserver>();
	@ConfigProperty(configName="config.properties",propertyName="UIObservable.exceptionObservers",type=IObserver.class)
	private List<IExceptionObserver> exceptionObservers = new ArrayList<IExceptionObserver>();

	@Override
	public void addObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void addObserver(IExceptionObserver o) {
		exceptionObservers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void removeObserver(IExceptionObserver o) {
		exceptionObservers.remove(o);
	}

	@Override
	public void notifyAllObservers(String str) {
		for (IObserver o : observers) {
			o.display(str);
		}
	}

	@Override
	public void notifyAllObservers(Throwable e) {
		for (IObserver o : observers) {
			o.display(e.getMessage());
		}
		for (IExceptionObserver eo : exceptionObservers) {
			eo.display(e);
		}
	}
}
