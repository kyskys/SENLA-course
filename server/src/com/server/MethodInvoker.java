package com.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoker {
	public static Object invoke(Object object, String methodName, Object[] parameters) {
		try {
			Class<?> clazz = object.getClass();
			Class<?>[] parametersClass = null;
			if (parameters != null) {
				parametersClass = new Class<?>[parameters.length];
				for (int i = 0; i < parameters.length; i++) {
					parametersClass[i] = parameters[i].getClass();
				}
			}
			Method m = clazz.getMethod(methodName, parametersClass);
			return m.invoke(object, parameters);
		} catch (

		NoSuchMethodException e) {
			return new String("no such method");
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return new String(e.getMessage());
		}
	}
}
