package serialisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serializer {
	private static long id = 0;
	public static List<Course> courses;
	public static List<Lector> lectors;
	public static List<Lection> lections;
	public static List<Student> students;

	public static long getId() {
		return ++id;
	}

	public static void recountId(List<? extends BaseModel>... lists) {
		for (List<? extends BaseModel> x : lists) {
			for (BaseModel y : x) {
				if (y.getId() > id) {
					id = y.getId();
				}
			}
		}
	}

	public static void save(String fileName) throws IOException {
		List<Object> list = new ArrayList<Object>();
		list.add(courseService);
		list.add(lectorService);
		list.add(lectionService);
		list.add(studentService);
		SerializeUtil.serializeObject(list, fileName);
	}

	public static void load(String fileName) throws ClassNotFoundException, IOException {
		List<Object> list;
		try {
			list = (List<Object>) SerializeUtil.deserializeObject(fileName);
			courseService = (List<Course>) list.get(0);
			lectorService = (List<Lector>) list.get(1);
			lectionService = (List<Lection>) list.get(2);
			studentService = (List<Student>) list.get(3);
			recountId(courseService, lectorService, lectionService, studentService);
		} catch (IOException e) {
		}
	}
}
