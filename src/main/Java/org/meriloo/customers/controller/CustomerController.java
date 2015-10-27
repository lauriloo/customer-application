package org.meriloo.customers.controller;

import org.meriloo.customers.domain.Customer;
import org.meriloo.customers.dto.CustomerDTO;
import org.meriloo.customers.service.CustomerDisplayService;
import org.meriloo.customers.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Lauri on 26.10.2015.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerRegistrationService customerRegistrationService;

    @Autowired
    CustomerDisplayService customerDisplayService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/addnewcustomer", method = RequestMethod.GET)
    public String getAddCustomer(Model model) {
        model.addAttribute("customerAttribute", new CustomerDTO());
        return "addNewCustomer";
    }


    @RequestMapping(value = "/addnewcustomer", method = RequestMethod.POST)
    public String postAddCustomer(
            @ModelAttribute("customerAttribute") CustomerDTO customer) {

        customerRegistrationService.saveNewCustomer(customer);
        return "redirect:/";
    }

    @RequestMapping(value = "/listcustomers", method = RequestMethod.GET)
    public String listCustomers(Model model) {

        List<Customer> customers = customerDisplayService.getAllCustomers();
        model.addAttribute("listOfCustomersAttribute", customers);
        return "listCustomers";
    }

}
