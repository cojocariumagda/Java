package repo;

import entity.ArtistsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {
    public void create(ArtistsEntity artistsEntity)
    {
        EntityManagerFactory entityManagerFactory = util.PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(artistsEntity);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public ArtistsEntity findById(int id)
    {
        EntityManagerFactory entityManagerFactory = util.PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        ArtistsEntity artistsEntity = entityManager.find(ArtistsEntity.class, id);

        entityManager.close();
        return artistsEntity;
    }

    public List<ArtistsEntity> findByName (String name)
    {
        EntityManagerFactory entityManagerFactory = util.PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery<ArtistsEntity> query = entityManager.createNamedQuery("ArtistsEntity.findByName", ArtistsEntity.class).setParameter("name", name);
        List<ArtistsEntity> results = query.getResultList();

        entityManager.close();
        return results;
    }
}
