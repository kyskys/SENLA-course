package observer;

import java.io.PrintStream;

import observer.interfaces.IObserver;

public class ConsoleDisplayer implements IObserver {
	private PrintStream displayer = System.out;

	@Override
	public void display(String str) {
		displayer.println(str);
	}

}
