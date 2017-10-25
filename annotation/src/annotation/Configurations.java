package annotation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Configurations {
	private Map<String, Properties> configInstanceMap = new HashMap<>();

	public Properties getConfigByString(String path) {
		if (configInstanceMap.containsKey(path)) {
			return configInstanceMap.get(path);
		} else {
			try {
				addNewConfigToMap(path);
				return configInstanceMap.get(path);
			} catch (Throwable e) {
				Iterator<Properties> values = configInstanceMap.values().iterator();
				if(values.hasNext()) {
					return values.next();
				}
			}
		}
		return null;
	}

	public void addNewConfigToMap(String path) throws FileNotFoundException, IOException {
		try (FileInputStream fis = new FileInputStream(path);) {
			Properties props = new Properties();
			props.load(fis);
			configInstanceMap.put(path, props);
		}
	}
}
