package com.senla.ui.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.senla.service.interfaces.ISitService;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.ui.observer.interfaces.IObserver;

import annotation.PropertyConfigurator;
import annotation.annotations.ConfigProperty;
import dependency.DependencyManager;

public class TestClass {

	public static void main(String[] args) {
		try {
			Test test = new Test();
			PropertyConfigurator pc = new PropertyConfigurator();
			pc.configure(test);
			System.out.println(test.q);
			System.out.println(Arrays.toString(test.array));
			System.out.println(test.list);
			System.out.println(test.list1);
			Class as = ISitService.class;
			DependencyManager.getInstance(IMasterStorage.class);
			ClassLoader cl = ClassLoader.getSystemClassLoader();
			System.out.println(cl.loadClass("com.senla.service.SitService"));
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