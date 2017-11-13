package com.senla.ui.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import annotation.ConfigProperty;
import observer.ErrorLogger;
import observer.interfaces.IExceptionObserver;
import observer.interfaces.IObserver;
import util.AnnotationHandler;

public class TestClass {

	public static void main(String[] args) {
		try {
			Test test = new Test();
			AnnotationHandler.configure(test);
			System.out.println(test.q);
			System.out.println(Arrays.toString(test.array));
			System.out.println(test.list);
			IExceptionObserver error = new ErrorLogger();
			error.display(new IOException("qq"));
			int i = 0;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		/*
		 * System.out.println(test.c); System.out.println(test.v);
		 * System.out.println(test.isBlaBlaEnabled);
		 */
	}

}

class Test {
	@ConfigProperty(configName = "config.properties", propertyName = "Test.isBlaBlaEnabled", type = Boolean.class)
	public boolean q;
	@ConfigProperty(configName = "configs.properties", propertyName = "Test.array", type = int.class)
	public int[] array;
	@ConfigProperty(configName = "configs.properties", propertyName = "Test.list", type = IObserver.class)
	public List<IObserver> list;
	public List<IObserver> list1 = new ArrayList<IObserver>();
	/*
	 * @ConfigProperty(configName = "configs.properties", propertyName =
	 * "Test.long", type = Long.class) public long c;
	 * 
	 * @ConfigProperty(configName = "configs.properties", propertyName =
	 * "Test.collection", type = Collections.class) public List<?> v;
	 */
}