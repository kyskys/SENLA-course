package com.senla.ui.test;

import java.util.Collections;
import java.util.List;

import annotation.ConfigProperty;
import annotation.PropertyConfigurator;

public class TestClass {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Test test = new Test();
		PropertyConfigurator pc = new PropertyConfigurator();
		pc.configure(test);
		System.out.println(test.q);
		System.out.println(test.isBlaBlaEnabled);
/*		System.out.println(test.x);
		System.out.println(test.c);
		System.out.println(test.v);
		System.out.println(test.isBlaBlaEnabled);*/
	}

}

class Test {
	@ConfigProperty(configName = "config.properties", propertyName = "Test.isBlaBlaEnabled", type = Boolean.class)
	public boolean q;
	@ConfigProperty(configName = "configs.properties", propertyName = "Test.isBlaBlaEnabledss")
	public boolean isBlaBlaEnabled;
	/*@ConfigProperty(configName = "configs.properties", propertyName = "Test.int", type = Integer.class)
	public int x;
	@ConfigProperty(configName = "configs.properties", propertyName = "Test.long", type = Long.class)
	public long c;
	@ConfigProperty(configName = "configs.properties", propertyName = "Test.collection", type = Collections.class)
	public List<?> v;*/
}