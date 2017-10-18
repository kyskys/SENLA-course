package serialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
	static String filePath;

	public SerializeUtil(String filePath) {
		this.filePath = filePath;
	}

	public static void serializeObject(Object obj) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	public static Object deserializeObject() throws ClassNotFoundException, IOException {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			ois.close();
			return obj;
	}
}
