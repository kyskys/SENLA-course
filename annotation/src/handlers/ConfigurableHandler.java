package handlers;

import java.lang.reflect.Field;

public class ConfigurableHandler implements IHandler {

	@Override
	public void handle(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {
		boolean fieldAccessibleState = field.isAccessible();
		field.setAccessible(true);
		new AnnotationHandler().configure(field.get(object));
		field.setAccessible(fieldAccessibleState);
	}

}
