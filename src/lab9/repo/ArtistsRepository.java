package lab9.repo;

import lab9.entity.Artists;
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

public class ArtistsRepository implements JpaRepository<Artists, Integer>{

    @Override
    public <S extends Artists> S save(S s) {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(s);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return null;
    }


    public Artists _findById(Integer id) {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Artists artists = entityManager.find(Artists.class, id);

        return artists;
    }

    public List<Artists> _findByName (String name)
    {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getSinglePersistence();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNamedQuery("Albums.findByName").setParameter("name", name);
        List<Artists> artists = new ArrayList<Artists>(query.getResultList());

        return artists;
    }

    @Override
    public List<Artists> findAll() {
        return null;
    }

    @Override
    public List<Artists> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Artists> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Artists> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Artists artists) {

    }

    @Override
    public void deleteAll(Iterable<? extends Artists> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Artists> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Artists> findById(Integer integer) {
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
    public <S extends Artists> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Artists> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Artists getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Artists> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Artists> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Artists> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Artists> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Artists> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Artists> boolean exists(Example<S> example) {
        return false;
    }
}