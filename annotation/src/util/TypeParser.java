package util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TypeParser {

	public static Object parse(String toParse, Class<?> clazz) {
		if (clazz.isPrimitive()) {
			if (clazz.equals(int.class)) {
				return Integer.parseInt(toParse);
			} else if (clazz.equals(long.class)) {
				return Long.parseLong(toParse);
			} else if (clazz.equals(boolean.class)) {
				return Boolean.parseBoolean(toParse);
			}
		} else {
			if (clazz.equals(Boolean.class)) {
				return Boolean.valueOf(toParse);
			} else if (clazz.equals(Integer.class)) {
				return Integer.valueOf(toParse);
			} else if (clazz.equals(Long.class)) {
				return Long.valueOf(toParse);
			} else {
				return toParse;
			}
		}
		return null;
	}

	public static Object parseArray(String toParse, Class<?> clazz) {
		String[] values = toParse.split(" ");
		Object array = Array.newInstance(clazz, values.length);
		for (int i = 0; i < values.length; i++) {
			Array.set(array, i, TypeParser.parse(values[i], clazz));
		}
		return array;

	}

	@SuppressWarnings("unchecked")
	public static <T> Object parseList(String toParse, Class<T> clazz)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String[] values = toParse.split(" ");
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < values.length; i++) {
			list.add((T) Class.forName(values[i]).newInstance());
		}
		return list;
	}

}