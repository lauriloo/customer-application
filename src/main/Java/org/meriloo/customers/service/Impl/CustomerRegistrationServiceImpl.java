package org.meriloo.customers.service.Impl;

import org.meriloo.customers.dao.CustomerDAO;
import org.meriloo.customers.dao.Impl.CustomerDAOImpl;
import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.dto.CustomerDTO;
import org.meriloo.customers.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lauri on 27.10.2015.
 */
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    @Autowired
    CustomerDAO customerDao;


    @Override
    public void saveNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerBuider(customerDTO);
        customerDao.save(customer);
    }

    private Customer customerBuider(CustomerDTO customerDTO){
        Customer customer = new Customer();

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setUserName(customerDTO.getUserName());

        customer.setPassword(customerDTO.getPassword());

        return customer;
    }


}
