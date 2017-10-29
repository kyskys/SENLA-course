package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import handlers.IHandler;

public class AnnotationHandler {
	private static HashMap<Class<? extends Annotation>, IHandler> map = new HashMap<Class<? extends Annotation>, IHandler>();

	public <T extends Object> void configure(T object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			for (Class<? extends Annotation> ann : map.keySet()) {
				if (field.isAnnotationPresent(ann)) {
					map.get(ann).handle(object, field);
				}
			}
		}
	}

	public void addAnnotationHandlerToMap(Class<? extends Annotation> annotation, IHandler annotationHandler) {
		map.put(annotation, annotationHandler);
	}

	public HashMap<Class<? extends Annotation>, IHandler> getMap() {
		return map;
	}

	public void setMap(HashMap<Class<? extends Annotation>, IHandler> map) {
		AnnotationHandler.map = map;
	}

}
