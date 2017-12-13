package com.senla.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.senla.entities.BaseEntity;

public class Utils {
	
	public static <T extends BaseEntity> String getListAsString(List<T> list) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			result.append(list.get(i).toString()).append("\n");
		}
		return result.toString();
	}

	public static String convertDateToString(Date date) {
		return new SimpleDateFormat("dd.MM.yyyy").format(date);
	}

	public static Date convertStringToDate(String str) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> Comparator<T> nullSafeCompare(Comparator<T> comparator) {
		return new Comparator<T>() {

			@Override
			public int compare(T a, T b) {
				if (a == null) {
					return b == null ? 0 : -1;
				} else if (b == null) {
					return 1;
				}
				return comparator.compare(a, b);
			}
		};
	}
}
