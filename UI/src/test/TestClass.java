package test;

import observer.ConsoleDisplayer;
import observer.UIObservable;
import observer.interfaces.IObservable;
import observer.interfaces.IObserver;

public class TestClass {

	public static void main(String[] args) {
		System.out.println("qq");
		IObservable observable = new UIObservable();
		// IObserver logger = new Logger();
		IObserver consoleDisplayer = new ConsoleDisplayer();
		// observable.addObserver(logger);
		observable.addObserver(consoleDisplayer);
		observable.notifyAllObservers("hello world");
	}
}
