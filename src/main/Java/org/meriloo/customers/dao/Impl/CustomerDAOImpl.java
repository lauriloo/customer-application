package org.meriloo.customers.dao.Impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.meriloo.customers.dao.CustomerDAO;
import org.meriloo.customers.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Lauri on 27.10.2015.
 */
@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Customer customer) {

        sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        String queryString = "FROM Customer";
        Query query = session.createQuery(queryString);

        return  query.list();
    }
}
