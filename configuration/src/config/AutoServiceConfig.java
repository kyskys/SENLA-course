package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AutoServiceConfig {
	Properties props;
	static AutoServiceConfig instance;

	private AutoServiceConfig() throws IOException {
		props = new Properties();
		FileInputStream fis = new FileInputStream("config.properties");
		props.load(fis);
	}

	public String getSerializerFilePath() {
		return props.getProperty("serializerFilePath");
	}

	public String getSerializerFileName() {
		return props.getProperty("serializerFileName");
	}

	public boolean isShiftOrderTimeEnabled() {
		return Boolean.getBoolean(props.getProperty("shiftOrderTimeEnabled"));
	}

	public boolean isCreateDeleteSitEnabled() {
		return Boolean.getBoolean(props.getProperty("createDeleteSitEnabled"));
	}

	public boolean isDeleteOrderEnabled() {
		return Boolean.getBoolean(props.getProperty("deleteOrderEnabled"));
	}

	public static AutoServiceConfig getInstance() throws IOException {
		if (instance == null) {
			instance = new AutoServiceConfig();
		}
		return instance;
	}
}
