package com.senla.sort;

import java.util.Comparator;

import com.senla.entities.Master;

public class SortMastersByAlphabet implements Comparator<Master> {

	@Override
	public int compare(Master m1, Master m2) {
		String n1 = m1.getName();
		String n2 = m2.getName();
		return n1.compareTo(n2);
	}

}
