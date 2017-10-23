package com.senla.ui.observer;

import java.io.PrintStream;

import com.senla.ui.observer.interfaces.IObserver;

public class ConsoleDisplayer implements IObserver {
	private PrintStream displayer = System.out;

	@Override
	public void display(String str) {
		displayer.println(str);
	}

}
