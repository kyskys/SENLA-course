package observer;

import java.util.ArrayList;
import java.util.List;

import observer.interfaces.IObservable;
import observer.interfaces.IObserver;

public class UIObservable implements IObservable {
	private List<IObserver> observers = new ArrayList<IObserver>();
	private static UIObservable instance = getInstance();

	private UIObservable() {
	}

	public static UIObservable getInstance() {
		if (instance == null) {
			return new UIObservable();
		} else {
			return instance;
		}
	}

	@Override
	public void addObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyAllObservers(String str) {
		for (IObserver o : observers) {
			o.display(str);
		}
	}

}
