package util;

import java.util.List;

import entities.BaseEntity;

public class Utils<T extends BaseEntity> {
	public static String getListAsString(List<BaseEntity> list) {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			result.append("id: "+list.get(i).getId()+"\n");
		}
		return result.toString();
	}
}
