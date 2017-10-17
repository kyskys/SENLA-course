package loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigLoader {
	Path configPath;

	public ConfigLoader() throws IOException {
		Path configPath = Paths.get("properties.config");
		if (!Files.exists(configPath)) {
			Files.createFile(configPath);
		}
	}

	public Map<Object, Object> load() throws IOException {
		Map<Object, Object> result = new HashMap<Object, Object>();
		List<String> lines = Files.readAllLines(configPath);
		for (String line : lines) {
			String[] property = line.split(":");
			result.put(property[0], property[1]);
		}
		return result;
	}
}
