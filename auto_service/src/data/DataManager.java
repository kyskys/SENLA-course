package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.danco.training.TextFileWorker;
import com.senla.entities.*;

public class DataManager<T extends BaseEntity> {
	private String path;
	private TextFileWorker tfw;
	private ISCVManager<T> manager;

	public DataManager(String path) {
		this.path = path;
	}

	public void save(T entity) {
		tfw.writeToFile(new String[] { manager.exportSCV(entity) });
	}

	public void load(T entity) {
		manager.importSCV(tfw.readFromFile()[0]);
	}

	public void init() throws IOException {
		Path filePath = Paths.get(path);
		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
		tfw = new TextFileWorker(path);
	}
}

enum TypeEntityEnum {
	GARAGE, SIT, ORDER, MASTER
}