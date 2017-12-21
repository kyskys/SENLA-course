package com.senla.ui.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.senla.observer.interfaces.IExceptionObserver;
import com.senla.observer.interfaces.IObserver;
import com.senla.observer.ui.ErrorLogger;
import com.senla.ui.action.garage.ShowAllGarages;

import annotation.ConfigProperty;
import util.AnnotationHandler;

public class TestClass {
	public static TestClass obj;

	public static void main(String[] args) {

	}

	public static void init1() {
		obj = new TestClass();
	}

	public static void init2() {
		obj = new TestClass();
	}
}
