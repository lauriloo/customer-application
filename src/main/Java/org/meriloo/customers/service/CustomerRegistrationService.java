package org.meriloo.customers.service;

import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.dto.CustomerDTO;

/**
 * Created by Lauri on 27.10.2015.
 */
public interface CustomerRegistrationService {

    public void saveNewCustomer(CustomerDTO customerDTO);

    public void hashPassword(Customer customer) throws Exception;

}
