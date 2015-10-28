package org.meriloo.customers.dao;

import org.meriloo.customers.domain.Customer;

import java.util.List;

/**
 * Created by Lauri on 27.10.2015.
 */
public interface CustomerDAO {

    public void save(Customer customer);

    public List<Customer> getCustomers();

    public Customer getCustomer(Integer id);

    public void deleteCustomer(Integer id);

    public void update(Customer customer);

}
