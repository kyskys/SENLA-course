package dependency;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DependencyManager {
	static Map<Object, Object> instanceMap = new HashMap<Object, Object>();
	static {
		initMap();
	}

	public static void initMap() {
		loadMapForPath("src/main/resources/configStorage.properties");
		loadMapForPath("src/main/resources/configService.properties");
		//loadMapForPath("resources/system.properties");

	}

	private static void loadMapForPath(String path) {
		try (FileInputStream fis = new FileInputStream(path);) {
			Properties p = new Properties();
			p.load(fis);
			for (String key : p.stringPropertyNames()) {
				instanceMap.put(Class.forName(key), Class.forName(p.getProperty(key)).newInstance());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> c) {
		return (T) instanceMap.get(c);
	}
}
