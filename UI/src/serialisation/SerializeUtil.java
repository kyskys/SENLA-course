package serialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class Serializer {
=======
public class SerializeUtil {
>>>>>>> 9847ba0... переделал toString у энтитей (через String.format), начал работу над файлом конфигурации и сериализацией, убрал старый формат загрузки данных
=======
public class SerializeUtil {
>>>>>>> 9847ba0... переделал toString у энтитей (через String.format), начал работу над файлом конфигурации и сериализацией, убрал старый формат загрузки данных
=======
public class Serializer {
>>>>>>> 35a4210... создал загрузчик конфигурации
	public static void serializeObject(Object obj, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	public static Object deserializeObject(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}
