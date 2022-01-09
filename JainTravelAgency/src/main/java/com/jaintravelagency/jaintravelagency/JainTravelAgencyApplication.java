package com.jaintravelagency.jaintravelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JainTravelAgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JainTravelAgencyApplication.class, args);
    }

}
