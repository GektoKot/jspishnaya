package dao;

import entity.User;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserDaoHibernate implements UserDaoIF {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Optional<User> findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.of(session.get(User.class, Integer.parseInt(id)));
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            userList = session.createQuery("from User", User.class).getResultList();
            transaction.commit();
        }
        return userList;
    }

    @Override
    public boolean save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
        return findById(String.valueOf(user.getId())).isPresent();
    }

    @Override
    public boolean update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
//        return findById(String.valueOf(user.getId())).isPresent();
        return false;
    }

    @Override
    public boolean delete(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
//        return findById(String.valueOf(user.getId())).isEmpty();
        return false;
    }
}
