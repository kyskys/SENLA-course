package annotation;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

import annotation.annotations.ConfigProperty;
import annotation.annotations.Configurable;
import annotation.annotations.Injectable;
import dependency.DependencyManager;

public class PropertyConfigurator {
	private Configurations configs = new Configurations();

	public <T extends Object> void configure(T object)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(Injectable.class)) {
				boolean fieldAccessibleState = field.isAccessible();
				field.setAccessible(true);
				field.set(object, DependencyManager.getInstance(field.getType()));
				field.setAccessible(fieldAccessibleState);

			}
			if (field.isAnnotationPresent(Configurable.class)) {
				boolean fieldAccessibleState = field.isAccessible();
				field.setAccessible(true);
				new PropertyConfigurator().configure(field.get(object));
				field.setAccessible(fieldAccessibleState);

			}
			if (field.isAnnotationPresent(ConfigProperty.class)) {
				ConfigProperty config = field.getAnnotation(ConfigProperty.class);
				Properties props;
				String propValue;
				Class<?> type;
				props = configs.getConfigByString(config.configName());
				propValue = props.getProperty(config.propertyName());
				if (config.propertyName() == null || config.propertyName().isEmpty() || propValue == null) {
					propValue = props.getProperty(String.format("%s.%s", clazz.getSimpleName(), field.getName()));
				}
				if (config.type() == null || config.type().equals(Object.class)) {
					type = field.getType();
				} else {
					type = config.type();
				}
				boolean fieldAccessibleState = field.isAccessible();
				field.setAccessible(true);

				if (field.getType().isArray()) {
					field.set(object, field.getType().cast(TypeParser.parseArray(propValue, type)));
				} else if (field.getType().isAssignableFrom(List.class)) {
					field.set(object, field.getType().cast(TypeParser.parseList(propValue, type)));
				} else {
					field.set(object, TypeParser.parse(propValue, type));
				}
				field.setAccessible(fieldAccessibleState);
			}
		}
	}
}
