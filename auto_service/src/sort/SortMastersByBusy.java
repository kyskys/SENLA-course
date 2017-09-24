package sort;

import java.util.Comparator;

import entities.Master;

public class SortMastersByBusy implements Comparator<Master> {

	@Override
	public int compare(Master m1, Master m2) {
		Boolean b1 = m1.isBusy();
		Boolean b2 = m2.isBusy();
		return b1.compareTo(b2);
	}

}
