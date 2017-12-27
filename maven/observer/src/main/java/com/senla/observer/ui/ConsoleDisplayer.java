package com.senla.observer.ui;

import java.io.PrintStream;

import com.senla.observer.interfaces.IObserver;

public class ConsoleDisplayer implements IObserver {
	private PrintStream displayer = System.out;

	@Override
	public void display(String str) {
		displayer.println(str);
	}

}
