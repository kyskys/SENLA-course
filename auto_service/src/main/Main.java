package main;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.senla.storage.interfaces.ISitStorage;

public class Main {

	static Map<Object, Object> instanceMap = new HashMap<Object, Object>();

	public static void main(String[] args) {
		
			Class<?> fa = com.senla.service.interfaces.ISitService.class;
			Class<?> as = ISitService.class;
		
		// initMap();
	}

	public static void initMap() {
		loadMapForPath("resources/configStorage.properties");

		loadMapForPath("resources/configService.properties");

	}

	private static void loadMapForPath(String path) {
		try (FileInputStream fis = new FileInputStream(path);) {
			Properties p = new Properties();
			p.load(fis);
			for (String key : p.stringPropertyNames()) {
				// Object cli = Class.forName(p.getProperty(key)).newInstance();
				// Class<?> cl = Class.forName(key);
				ClassLoader cl = ClassLoader.getSystemClassLoader();
				instanceMap.put(cl.loadClass(key), cl.loadClass(p.getProperty(key)).newInstance());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
