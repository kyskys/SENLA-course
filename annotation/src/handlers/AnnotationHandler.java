package handlers;

import java.lang.reflect.Field;

import annotation.ConfigProperty;
import annotation.Configurable;
import annotation.Injectable;

public class AnnotationHandler {

	public <T extends Object> void configure(T object)
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			IHandler handler = null;
			// sdelat eto krasivee
			if (field.isAnnotationPresent(Injectable.class)) {
				handler = new InjectableHandler();
				handler.handle(object, field);
			}
			if (field.isAnnotationPresent(Configurable.class)) {
				handler = new ConfigurableHandler();
				handler.handle(object, field);
			}
			if (field.isAnnotationPresent(ConfigProperty.class)) {
				handler = new ConfigPropertyHandler();
				handler.handle(object, field);
			}
		}
	}
}
