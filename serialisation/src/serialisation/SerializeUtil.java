package serialisation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializeUtil {
	private String filePath;
	private String fileName;

	public SerializeUtil(String fileName, String filePath) {
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public void serializeObject(Object obj) throws FileNotFoundException, IOException {
		try (FileOutputStream fos = new FileOutputStream(filePath + fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(obj);
		}
	}

	public Object deserializeObject() throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream(filePath + fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			Object obj = ois.readObject();
			return obj;
		}
	}

	public void init() throws IOException {
		File file = new File(filePath + fileName);
		Files.createDirectories(Paths.get(filePath));
		file.createNewFile();

	}
}
