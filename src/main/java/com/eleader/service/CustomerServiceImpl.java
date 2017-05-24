package com.eleader.service;

import com.eleader.domain.Customer;
import com.eleader.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Konrad on 2017-05-24.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long idCustomer) {

        return customerRepository.findOne(idCustomer);
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long idCustomer) {

        customerRepository.delete(idCustomer);
    }
}
