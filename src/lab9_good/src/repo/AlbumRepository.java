package repo;

import entity.AlbumsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository {
    public void create(AlbumsEntity albumsEntity)
    {
        EntityManagerFactory entityManagerFactory = util.PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(albumsEntity);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public AlbumsEntity findById(int id)
    {
        EntityManagerFactory entityManagerFactory = util.PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        AlbumsEntity albumsEntity = entityManager.find(AlbumsEntity.class, id);

        entityManager.close();
        return albumsEntity;
    }

    public List<AlbumsEntity> findByName (String name)
    {
        EntityManagerFactory entityManagerFactory = util.PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery<AlbumsEntity> query = entityManager.createNamedQuery("AlbumsEntity.findByName", AlbumsEntity.class)
                                                                        .setParameter("name", name);
        List<AlbumsEntity> results = query.getResultList();

        entityManager.close();
        return results;
    }

    public List<AlbumsEntity> findByArtists (String artistName)
    {
        EntityManagerFactory entityManagerFactory = util.PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        TypedQuery<AlbumsEntity> query = entityManager.createNamedQuery("AlbumsEntity.findByArtists", AlbumsEntity.class)
                .setParameter("name", artistName);
        System.out.println(query.getResultList());
        List<AlbumsEntity> results = query.getResultList();

        entityManager.close();
        return results;
    }

}
