package util;

import entity.AEntity;

public class Helper {
	
	public static int searchEmpty(AEntity[] mas){
		for(int i=0;i<mas.length;i++) {
			if(mas[i]==null) {
				return i;
			}
		}
		return -1;
	}
	public static int searchEntity(AEntity[] mas, AEntity o) {
		for(int i=0;i<mas.length;i++) {
			if(mas[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
}
