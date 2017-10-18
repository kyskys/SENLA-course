package serialisation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import config.AutoServiceConfig;

public class SerializeUtil {

	public static void serializeObject(Object obj) throws IOException {
		String fp = AutoServiceConfig.getInstance().getSerializerFilePath();
		String fn = AutoServiceConfig.getInstance().getSerializerFileName();
		File file = new File(fp + fn);
		if (!file.exists()) {
			Files.createDirectories(Paths.get(fp));
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(AutoServiceConfig.getInstance().getSerializerFilePath()
				+ AutoServiceConfig.getInstance().getSerializerFileName());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	public static Object deserializeObject() throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(AutoServiceConfig.getInstance().getSerializerFilePath()
				+ AutoServiceConfig.getInstance().getSerializerFileName());
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}
