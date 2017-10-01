package manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.danco.training.TextFileWorker;

import entities.BaseEntity;

public abstract class AbstractFileManager<T extends BaseEntity> {
	protected String filePath;
	protected TextFileWorker tfw;

	public AbstractFileManager(String filePath) {
		this.filePath = filePath;
		if (!Files.exists(Paths.get(filePath))) {
			try {
				Files.createFile(Paths.get(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tfw = new TextFileWorker(filePath);
	}

	abstract public String ConvertEntityToString(T entity);

	public String ConvertListToString(List<? extends BaseEntity> list) {
		StringBuilder result = new StringBuilder();
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				result.append(list.get(i).getId() + ",");
			}
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	public void save(List<T> entities) {
		String[] toWrite = new String[entities.size()];
		for (int i = 0; i < entities.size(); i++) {
			toWrite[i] = ConvertEntityToString(entities.get(i));
		}
		tfw.writeToFile(toWrite);
	}

	public String[] load() {
		return tfw.readFromFile();
	}
}
