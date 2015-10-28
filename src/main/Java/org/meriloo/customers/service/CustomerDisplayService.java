package org.meriloo.customers.service;

import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.dto.CustomerDTO;

import java.util.List;

/**
 * Created by Lauri on 27.10.2015.
 */
public interface CustomerDisplayService {

    public List<Customer> getAllCustomers();

    public Customer getCustomer(Integer Id);

    public void deleteCustomer(Integer customerId);

    public CustomerDTO buildCustomerDTO(Customer customer);

    public void saveOldCustomer(Customer customer);

    public void updateCustomerData(Customer customer, CustomerDTO customerDTO);


}
