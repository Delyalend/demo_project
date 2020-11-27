package com.example.demo.repo;

import com.example.demo.model.PostalItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PostalItemRepositoryImpl implements PostalItemRepository {

    //JPA
    //@PersistenceContext
    //private EntityManager entityManager;

    //Hibernate
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<PostalItem> findAll() {
        //JPA
        //TypedQuery<PostalItem> query = entityManager.createQuery("select p from PostalItem p", PostalItem.class);

        //Hibernate
        Session session = sessionFactory.openSession();
        Query<PostalItem> query = session.createQuery("select p from PostalItem p", PostalItem.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public PostalItem getOne(Long id) {
        //JPA
        //return entityManager.find(PostalItem.class, id);

        //Hibernate
        Session session = sessionFactory.openSession();
        return session.find(PostalItem.class, id);
    }

    @Override
    @Transactional
    public void save(PostalItem postalItem) {
        //JPA
        //entityManager.persist(postalItem);

        //Hibernate
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(postalItem);
        session.getTransaction().commit();
    }
}
