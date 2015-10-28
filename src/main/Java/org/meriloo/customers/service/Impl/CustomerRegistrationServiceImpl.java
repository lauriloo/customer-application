package org.meriloo.customers.service.Impl;

import org.meriloo.customers.dao.CustomerDAO;
import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.dto.CustomerDTO;
import org.meriloo.customers.service.CustomerRegistrationService;
import org.meriloo.customers.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lauri on 27.10.2015.
 */
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    @Autowired
    private CustomerDAO customerDao;
    @Autowired
    private PasswordService passwordService;

    @Override
    public void saveNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerBuider(customerDTO);
        customerDao.save(customer);
    }

    @Override
    public void hashPassword(Customer customer) throws Exception {
        String password = customer.getPassword();
        if(password != null && password.length() > 0){
            password = passwordService.getSaltedHash(password);
            customer.setPassword(password);
        } else {
            throw new Exception();
        }
    }

    private Customer customerBuider(CustomerDTO customerDTO){
        Customer customer = new Customer();

        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setUserName(customerDTO.getUserName());
        customer.setPassword(customerDTO.getPassword());
        try{
            hashPassword(customer);
        } catch (Exception e) {
            customer.setPassword("");
        }

        return customer;
    }


}
