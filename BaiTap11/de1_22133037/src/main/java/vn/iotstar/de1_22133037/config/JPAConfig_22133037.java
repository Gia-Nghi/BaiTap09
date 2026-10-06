package vn.iotstar.de1_22133037.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig_22133037 {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("de1_22133037");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}