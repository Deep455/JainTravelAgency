package com.jaintravelagency.jaintravelagency.Repository;


import com.jaintravelagency.jaintravelagency.Models.Customer;

public interface CustomerRepository {
    public Customer findCustomerByCustomerId(String customerId);
    public boolean customerIdExists(String customerId);
    public void saveCustomer(Customer customer);
}
