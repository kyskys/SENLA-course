package data;

import com.senla.entities.BaseEntity;

public interface ISCVManager<T extends BaseEntity> {
	void importSCV(String data);
	String exportSCV(T entity);
}
