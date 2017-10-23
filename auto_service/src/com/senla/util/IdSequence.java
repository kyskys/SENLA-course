package com.senla.util;

import java.util.List;

import com.senla.entities.BaseEntity;

public class IdSequence {
	private static long id = 0;

	public static long getId() {
		return ++id;
	}

	@SafeVarargs
	public static void recountId(List<? extends BaseEntity>... lists) {
		for (List<? extends BaseEntity> x : lists) {
			for (BaseEntity y : x) {
				if (y.getId() > id) {
					id = y.getId();
				}
			}
		}
	}
}
