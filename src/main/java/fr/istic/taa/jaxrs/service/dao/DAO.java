package fr.istic.taa.jaxrs.service.dao;

import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Post;

import javax.persistence.*;
import java.util.List;

public class DAO {

    public DAO() {
        manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
        tx = manager.getTransaction();
    }

    private EntityManager manager;
    private EntityTransaction tx;

    public void updateEntity(Entity entity) {
        tx.begin();
        manager.merge(entity);
        tx.commit();
    }

    public void updateBoard(Board entity) {
        tx.begin();
        manager.merge(entity);
        tx.commit();
    }

    public void addEntity(Entity entity) {
        tx.begin();
        manager.persist(entity);
        tx.commit();
    }

    public void addPost(Post entity) {
        tx.begin();
        manager.persist(entity);
        tx.commit();
    }

    public void addBoard(Board entity) {
        tx.begin();
        manager.persist(entity);
        tx.commit();
    }

    public void removeEntity(Entity entity) {
        tx.begin();
        manager.remove(entity);
        tx.commit();
    }

    public Post findPostFromId(long id) {
        return manager.find(Post.class,id);
    }

    public Post findCategoryFromId(long id) {
        return manager.find(Post.class,id);
    }

    public Board findBoardFromId(long id) {
        return manager.find(Board.class,id);
    }

    public List<Post> getPosts() {
        return manager.createQuery("SELECT a from Post a").getResultList();
    }

    public List<Board> getBoards() {
        return manager.createQuery("SELECT a from Board a").getResultList();
    }

    public List<Board> getCategories() {
        return manager.createQuery("SELECT a from Category a").getResultList();
    }
}
