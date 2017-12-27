package handlers;

import java.lang.reflect.Field;

import dependency.DependencyManager;


public class InjectableHandler implements IHandler {

	@Override
	public void handle(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {
		boolean fieldAccessibleState = field.isAccessible();
		field.setAccessible(true);
		field.set(object, DependencyManager.getInstance(field.getType()));
		field.setAccessible(fieldAccessibleState);
	}
}