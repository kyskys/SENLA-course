package sort;

import entities.BaseEntity;

public abstract class Sortable<T extends BaseEntity> {
	private boolean sort(SortParameters sp);
}
