package com.example.demo.repo;

import com.example.demo.model.PostOffice;
import com.example.demo.service.PostOfficeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PostOfficeRepositoryImpl implements PostOfficeRepository {

    @Autowired
    private PostOfficeService postOfficeService;

    //JPA
    //@PersistenceContext
    //private EntityManager entityManager;

    //Hibernate
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<PostOffice> findAll() {
        //JPA
        //return query.getResultList();
        //TypedQuery<PostOffice> query = entityManager.createQuery("select p from PostOffice p", PostOffice.class);

        //Hibernate
        Session session = sessionFactory.openSession();
        Query<PostOffice> query = session.createQuery("select p from PostOffice p", PostOffice.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public PostOffice findOne(String index) {
        //JPA
        //return entityManager.find(PostOffice.class, index);

        //Hibernate
        Session session = sessionFactory.openSession();
        return session.find(PostOffice.class, index);
    }

    @Override
    @Transactional
    public void save(PostOffice postOffice) {
        //JPA
        //entityManager.persist(postOffice);

        //Hibernate
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(postOffice);
        session.getTransaction().commit();
    }
}
