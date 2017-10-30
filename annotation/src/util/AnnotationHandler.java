package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import annotation.ConfigProperty;
import annotation.Configurable;
import annotation.Injectable;
import handlers.ConfigPropertyHandler;
import handlers.ConfigurableHandler;
import handlers.IHandler;
import handlers.InjectableHandler;

public class AnnotationHandler {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AnnotationHandler.class);
	private static Map<Class<? extends Annotation>, IHandler> map = new LinkedHashMap<Class<? extends Annotation>, IHandler>();

	static {
		map.put(Injectable.class, new InjectableHandler());
		map.put(Configurable.class, new ConfigurableHandler());
		map.put(ConfigProperty.class, new ConfigPropertyHandler());
	}

	public static <T extends Object> void configure(T object) {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			for (Class<? extends Annotation> ann : map.keySet()) {
				if (field.isAnnotationPresent(ann)) {
					try {
						map.get(ann).handle(object, field);
					} catch (Throwable e) {
						logger.error(e);
					}
				}
			}
		}
	}

}
