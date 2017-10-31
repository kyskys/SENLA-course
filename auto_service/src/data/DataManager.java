package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.danco.training.TextFileWorker;
import com.senla.entities.*;

import annotation.Configurable;
import util.AnnotationHandler;

public class DataManager<T extends BaseEntity> {
	private String path;
	private TextFileWorker tfw;
	@Configurable
	private ISCVManager<T> manager;

	public DataManager(String path, ISCVManager<T> manager) {
		this.path = String.format("%s.txt", path);
		this.manager = manager;
		AnnotationHandler.configure(this);
	}

	public void exportEntities() {
		tfw.writeToFile(manager.exportSCV());
	}

	public void importEntities() {
		String[] lines = tfw.readFromFile();
		for (String line : lines)
			manager.importSCV(line);
	}

	public void init() throws IOException {
		Path filePath = Paths.get(path);
		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
		tfw = new TextFileWorker(path);
	}
}