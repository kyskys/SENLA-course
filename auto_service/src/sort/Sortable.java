package sort;

import entities.BaseEntity;

public abstract class Sortable<T extends BaseEntity> {
	protected abstract boolean sort(SortParameters sp);
}
