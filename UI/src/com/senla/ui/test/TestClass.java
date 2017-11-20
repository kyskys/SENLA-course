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

	public static void main(String[] args) {
		ShowAllGarages gs = new ShowAllGarages();
		Class<?> clazz = gs.getClass();
		while (clazz != null) {
			clazz = clazz.getSuperclass();
			System.out.println(clazz);
		}
		/*
		 * System.out.println(test.c); System.out.println(test.v);
		 * System.out.println(test.isBlaBlaEnabled);
		 */
	}

}
