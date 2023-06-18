package com.example.spring_rest.dao;

import com.example.spring_rest.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
// Класс, который ответственен за работу с Базой данных
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("from User  ", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<?> query = session.createQuery("delete from User " +
                "where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

}