package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import config.AutoServiceConfig;

public class TestClass {

	public static void main(String[] args) throws IOException {
		String fp = AutoServiceConfig.getInstance().getSerializerFilePath();
		String fn = AutoServiceConfig.getInstance().getSerializerFileName();
		Path path = Paths.get(fp);
		Files.createDirectories(path);
		System.out.println(path);
		File file = new File(fp+fn);
		file.createNewFile();
	}
}
