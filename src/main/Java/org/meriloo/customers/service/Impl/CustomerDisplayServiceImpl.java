package org.meriloo.customers.service.Impl;

import org.meriloo.customers.dao.CustomerDAO;
import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.dto.CustomerDTO;
import org.meriloo.customers.service.CustomerDisplayService;
import org.meriloo.customers.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lauri on 27.10.2015.
 */
@Service
public class CustomerDisplayServiceImpl implements CustomerDisplayService {

    @Autowired
    private CustomerDAO customerDao;
    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customers = customerDao.getCustomers();
        return customers;
    }

    @Override
    public Customer getCustomer(Integer id) {
        Customer customer = customerDao.getCustomer(id);
        return customer;
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public CustomerDTO buildCustomerDTO(Customer customer) {
        return customerDTOBuider(customer);
    }

    @Override
    public void saveOldCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void updateCustomerData(Customer customer, CustomerDTO customerDTO) {
        if(customer != null && customerDTO != null){
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setDateOfBirth(customerDTO.getDateOfBirth());
            customer.setUserName(customerDTO.getUserName());
            customer.setPassword(customerDTO.getPassword());
            try{
                customerRegistrationService.hashPassword(customer);
            } catch (Exception e) {
                customer.setPassword("");
            }
        }
    }



    private CustomerDTO customerDTOBuider(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        customerDTO.setUserName(customer.getUserName());

        return customerDTO;
    }



}
