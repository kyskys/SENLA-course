package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.danco.training.TextFileWorker;
import com.senla.entities.BaseEntity;

public abstract class AbstractDataManager<T extends BaseEntity> {
	protected Path filePath;
	protected TextFileWorker tfw;

	public AbstractDataManager(String Path) {
		filePath = Paths.get(Path);
		if (!Files.exists(filePath)) {
			try {
				Files.createFile(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		tfw = new TextFileWorker(Path);
	}

	public void save() {
		String[] toWrite = new String[entities.size()];
		for (int i = 0; i < entities.size(); i++) {
			toWrite[i] = convertEntityToString(entities.get(i));
		}
		tfw.writeToFile(toWrite);
	}

	public String[] load() {
		return tfw.readFromFile();
	}
}