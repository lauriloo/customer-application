package org.meriloo.customers.service.Impl;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Lauri on 29.10.2015.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration({"file:src/test/resources/applicationContext.xml"})
public class CustomerRegistrationServiceImplTest extends TestCase {

    @Autowired
    CustomerRegistrationService customerRegistrationService;

    public void testSaveNewCustomer() throws Exception {

    }

    @Test
    public void testHashPassword() throws Exception {
        Customer customer = new Customer();
        customer.setPassword("Password1");
        customerRegistrationService.hashPassword(customer);
        System.out.println(customer.getPassword());
        Assert.assertNotEquals("Password1",customer.getPassword());
    }
}