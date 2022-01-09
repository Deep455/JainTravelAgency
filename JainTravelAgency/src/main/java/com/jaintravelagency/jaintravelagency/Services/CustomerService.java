package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Customer;

public interface CustomerService {
    public Customer findCustomerByCustomerId(String customerId);
    public boolean customerIdExists(String customerId);
    public void saveCustomer(Customer customer);
}
