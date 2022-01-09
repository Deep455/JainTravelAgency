package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Customer> customerRowMapper = new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(rs.getString("customerId"), rs.getString("name"), rs.getString("gender"), rs.getString("phoneNo"), rs.getString("email"), rs.getString("dob"));
        }
    };

    @Override
    public Customer findCustomerByCustomerId(String customerId) {
        String sqlQuery = "select * from customer where customerId='"+customerId+"'";
        Customer customer = jdbcTemplate.queryForObject(sqlQuery, customerRowMapper);
        return customer;
    }

    @Override
    public boolean customerIdExists(String customerId) {
        String query = "select count(*) from customer where customerId='"+customerId+"'";
        int cnt = jdbcTemplate.queryForObject(query,Integer.class);
        if(cnt>0){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public void saveCustomer(Customer customer) {
        String query = "insert into customer(customerId,name,gender,phoneNo,email,dob) values(?,?,?,?,?,?)";
        jdbcTemplate.update(query,customer.getCustomerId(),customer.getName(),customer.getGender(),customer.getPhoneNo(),customer.getEmail(),customer.getDob());
    }

}
