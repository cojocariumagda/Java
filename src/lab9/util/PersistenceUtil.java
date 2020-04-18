package lab9.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil persistenceUtil = null;
    public static EntityManagerFactory entityManagerFactory;
    private PersistenceUtil() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public static EntityManagerFactory getSinglePersistence()
    {
        if (persistenceUtil == null)
        {
            persistenceUtil = new PersistenceUtil();
        }
        return entityManagerFactory;
    }

}
