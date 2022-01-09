package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Customer;
import com.jaintravelagency.jaintravelagency.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerByCustomerId(String customerId) {
        return customerRepository.findCustomerByCustomerId(customerId);
    }

    @Override
    public boolean customerIdExists(String customerId) {
        return customerRepository.customerIdExists(customerId);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }
}
