package dependency;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DependencyManager {
	static Map<Object, Object> instanceMap = new HashMap<Object, Object>();
	{
		try {
			initMap();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void initMap()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		loadMapForPath("resources/configStorage.properties");
		loadMapForPath("resources/configService.properties");
	}

	private static void loadMapForPath(String path)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		try (FileInputStream fis = new FileInputStream(path);) {
			Properties p = new Properties();
			p.load(fis);
			for (String key : p.stringPropertyNames()) {
				instanceMap.put(Class.forName(key), Class.forName(p.getProperty(key)).newInstance());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> c) {
		return (T) instanceMap.get(c);
	}
}
