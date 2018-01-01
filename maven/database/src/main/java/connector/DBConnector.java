package connector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnector {
	static {
		init();
	}
	private static EntityManagerFactory factory;
	private static final String PERSISTENCE_NAME = "PERSISTENCE";

	public static void init() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		}
	}

	public static EntityManager getManager() {
		return factory.createEntityManager();
	}
}
