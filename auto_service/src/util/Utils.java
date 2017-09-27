package util;

import java.util.List;

import entities.BaseEntity;

public class Utils {
	public static <T extends BaseEntity> String getListAsString(List<T> list) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			result.append(list.get(i).getAsString()).append("\n");
		}
		return result.toString();
	}
}
