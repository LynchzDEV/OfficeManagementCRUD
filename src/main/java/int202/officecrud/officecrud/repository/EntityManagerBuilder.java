package int202.officecrud.officecrud.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import int202.officecrud.officecrud.model.Environment;

public class EntityManagerBuilder {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}