package lab9.repo;

import lab9.entity.Albums;
import lab9.util.PersistenceUtil;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumsRepository implements JpaRepository<Albums, Integer>{

    @Override
    public <S extends Albums> S save(S s) {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //Albums newAlbum = new Albums("Album1", 3, 2020);
        entityManager.persist(s);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return null;
    }


    public Albums _findById(Integer id) {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Albums albums = entityManager.find(Albums.class, id);


        return albums;
    }

    public List<Albums> _findByName (String name)
    {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNamedQuery("Albums.findByName").setParameter("name", name);
        List<Albums> albums = new ArrayList<Albums>(query.getResultList());

        return albums;
    }

    public List<Albums> _findByArtist (String artist)
    {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNamedQuery("Albums.findByArtist").setParameter("id", artist);
        List<Albums> albums = new ArrayList<Albums>(query.getResultList());

        return albums;

    }

    @Override
    public List<Albums> findAll() {
        return null;
    }

    @Override
    public List<Albums> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Albums> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Albums> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Albums albums) {

    }

    @Override
    public void deleteAll(Iterable<? extends Albums> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Albums> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Albums> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Albums> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Albums> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Albums getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Albums> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Albums> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Albums> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Albums> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Albums> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Albums> boolean exists(Example<S> example) {
        return false;
    }
}