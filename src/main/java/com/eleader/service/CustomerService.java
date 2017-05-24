package com.eleader.service;

import com.eleader.domain.Customer;
import org.springframework.stereotype.Service;

/**
 * Created by Konrad on 2017-05-24.
 */
@Service
public interface CustomerService {

    Iterable<Customer> getAllCustomers();

    Customer getCustomerById(Long idCustomer);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long idCustomer);
}
