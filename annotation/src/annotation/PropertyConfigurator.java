package annotation;

import java.lang.reflect.Field;
import java.util.Properties;

public class PropertyConfigurator {
	private Configurations configs = new Configurations();

	public <T extends Object> void configure(T object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getFields()) {
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
				field.setAccessible(true);
				for (TypeParser e : TypeParser.values()) {
					if (e.clazz.equals(type)) {
						field.set(object, e.parse(propValue));
					}
				}

			}
		}
	}
}
