package org.meriloo.customers.dao.Impl;

import org.hibernate.SessionFactory;
import org.meriloo.customers.dao.CustomerDAO;
import org.meriloo.customers.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        //System.out.println("Hei!");
        sessionFactory.getCurrentSession().save(customer);
        //System.out.println("Hoi!");
    }
}
