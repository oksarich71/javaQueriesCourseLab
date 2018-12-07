package com.example.coursebookingsystem.repositories.CustomerRepositories;

import com.example.coursebookingsystem.models.Course;
import com.example.coursebookingsystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


public class CustomerRepositoryImpl implements CustomerRepositoryCustom {


    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> getAllCustomersForGivenCourse(Long courseId) {
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);

            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", courseId));
            results = cr.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Customer> getAllCustomersFromTownForCourse(String town, Long courseId) {
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);

            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", courseId));
            cr.add(Restrictions.eq("town", town));
            results = cr.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Customer> getCustomersOverAgeInTownForCourse(int age, String town, Long courseId){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);

            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", courseId));
            cr.createAlias("booking.course", "course");
            cr.add(Restrictions.eq("course.town", town));
            cr.add(Restrictions.gt("age", age));
            results = cr.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}

