package com.example.coursebookingsystem.repositories.CourseRepositories;

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

public class CourseRepositoryImpl implements CourseRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> getAllCoursesWithGivenRating(int rating) {
        List<Course> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("rating", rating));
            results = cr.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
          session.close();
        }
        return results;
    }

    @Transactional
    public List<Course> getAllCoursesForGivenCustomer(Long customerId) {
            List<Course> results = null;
            Session session = entityManager.unwrap(Session.class);

            try {
                Criteria cr = session.createCriteria(Course.class);
                cr.createAlias("bookings", "booking");
                cr.add(Restrictions.eq("booking.customer.id", customerId));
                results = cr.list();
            } catch (HibernateException ex) {
                ex.printStackTrace();
            } finally {
                session.close();
            }
            return results;
        }
    }



