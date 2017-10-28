package handlers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

import annotation.ConfigProperty;
import util.Configurations;
import util.TypeParser;

public class ConfigPropertyHandler implements IHandler {
	private Configurations configs = new Configurations();

	@Override
	public void handle(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {
		ConfigProperty config = field.getAnnotation(ConfigProperty.class);
		Properties props;
		String propValue;
		Class<?> type;
		props = configs.getConfigByString(config.configName());
		propValue = props.getProperty(config.propertyName());
		if (config.propertyName() == null || config.propertyName().isEmpty() || propValue == null) {
			propValue = props.getProperty(String.format("%s.%s", object.getClass(), field.getName()));
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
			try {
				field.set(object, field.getType().cast(TypeParser.parseList(propValue, type)));
			} catch (InstantiationException | ClassNotFoundException e) {
				throw new IllegalArgumentException(e);
				// mojno li tak delat? mojet svoi exception pridymat?
			}
		} else {
			field.set(object, TypeParser.parse(propValue, type));
		}
		field.setAccessible(fieldAccessibleState);
	}
}