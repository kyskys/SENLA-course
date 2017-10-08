package observer;

import java.util.ArrayList;
import java.util.List;

import observer.interfaces.IObservable;
import observer.interfaces.IObserver;

public class UIObservable implements IObservable {
	private List<IObserver> observers = new ArrayList<IObserver>();

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
		for( IObserver o : observers) {
			o.display(str);
		}
	}

}
