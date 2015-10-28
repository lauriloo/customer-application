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
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/editcustomer", method = RequestMethod.GET)
    public String editCustomer(@RequestParam("id") Integer customerId, Model model) {
        Customer customer = customerDisplayService.getCustomer(customerId);
        CustomerDTO customerDTO = customerDisplayService.buildCustomerDTO(customer);
        model.addAttribute("customerAttribute", customerDTO);
        model.addAttribute("customerIdAttribute", customerId);
        return "editCustomer";
    }

    @RequestMapping(value = "/editcustomer", method = RequestMethod.POST)
    public String postEditCustomer(@RequestParam("id") Integer customerId,
                                   @ModelAttribute("customerAttribute") CustomerDTO customerDTO
                                   ) {

        Customer customer = customerDisplayService.getCustomer(customerId);
        customerDisplayService.updateCustomerData(customer, customerDTO);
        customerDisplayService.saveOldCustomer(customer);
        return "redirect:/listcustomers";
    }

    @RequestMapping(value = "/deletecustomer", method = RequestMethod.GET)
    public String deleteCustomer(@RequestParam("id") Integer customerId, Model model) {
        customerDisplayService.deleteCustomer(customerId);
        return "redirect:/listcustomers";
    }

}
