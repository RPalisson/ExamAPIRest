package com.humanbooster.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.humanbooster.model.Task;

import java.util.List;

public class TaskDAO {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(task);
            session.getTransaction().commit();
        }
    }

    public Task findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Task.class, id);
        }
    }

    public List<Task> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Person", Task.class).list();
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Task t = session.find(Task.class, id);
            if (t != null) session.remove(t);
            session.getTransaction().commit();
        }
    }
}
