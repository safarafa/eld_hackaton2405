package com.eleader.controller;

import com.eleader.domain.Customer;
import com.eleader.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Konrad on 2017-05-24.
 */
@RestController
@RequestMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Customer> getAllCustomers(){

        LOGGER.info("Received request to get all customers");

        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/{idCustomer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Customer getCustomer(@PathVariable Long idCustomer){

        return customerService.getCustomerById(idCustomer);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Customer createNewCustomer(@RequestBody Customer customer){

        return customerService.saveCustomer(customer);
    }

    @RequestMapping(value = "/delete/{idCustomer}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long idCustomer){

        customerService.deleteCustomer(idCustomer);
    }
}
