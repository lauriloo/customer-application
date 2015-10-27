package org.meriloo.customers.service.Impl;

import org.meriloo.customers.dao.CustomerDAO;
import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.service.CustomerDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lauri on 27.10.2015.
 */
@Service
public class CustomerDisplayServiceImpl implements CustomerDisplayService {

    @Autowired
    CustomerDAO customerDao;

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customers = customerDao.getCustomers();
        return customers;
    }


}
