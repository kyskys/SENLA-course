package loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigLoader {

	public Map<Object, Object> load() throws IOException {
		Map<Object, Object> result = new HashMap<Object, Object>();
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("config.properties");
		props.load(fis);
		for (String key : props.stringPropertyNames()) {
			result.put(key, props.getProperty(key));
		}
		return result;
	}
}
