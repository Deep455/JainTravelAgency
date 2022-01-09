package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Employee;
import com.jaintravelagency.jaintravelagency.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDetailsServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByEmpId(empId);
        List<GrantedAuthority> grantList = new ArrayList<>();
        String[] roles = employee.getRole().split(" ");
        for(int i=0;i<roles.length;i++){
            GrantedAuthority authority = new SimpleGrantedAuthority(roles[i]);
            grantList.add(authority);
        }
        System.out.print(roles[0]);

        return new org.springframework.security.core.userdetails.User(
                employee.getEmpId(), employee.getPassword(),grantList
        );

    }
}
