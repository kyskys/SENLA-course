package data;

import java.util.List;

import com.senla.entities.BaseEntity;

public abstract class AbstractCSVManager<T extends BaseEntity> {

	public String[] getListAsArray(List<T> list) {
		int size = list.size();
		String[] result = new String[size];
		for (int i = 0; i < size; i++) {
			result[i] = convertEntityToCSVString(list.get(i));
		}
		return result;
	}

	public static String convertListToCSVString(List<? extends BaseEntity> list) {
		StringBuilder result = new StringBuilder();
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				result.append(list.get(i).getId()).append(",");
			}
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	abstract public String convertEntityToCSVString(T entity);
}
