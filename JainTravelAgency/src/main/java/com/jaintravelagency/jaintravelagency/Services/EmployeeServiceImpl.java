package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Employee;
import com.jaintravelagency.jaintravelagency.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee.setRole("normalemployee");
        employeeRepository.saveEmployee(employee);
    }

    @Override
    public Employee findEmployeeByEmpId(String empId) {
        return employeeRepository.findEmployeeByEmpId(empId);
    }

    @Override
    public boolean employeeIdExists(String empId) {
        return employeeRepository.employeeIdExists(empId);
    }

    @Override
    public List<Employee> showEmployee() {
        return employeeRepository.showEmployee();
    }

    @Override
    public void deleteEmployee(String empId) {
        employeeRepository.deleteEmployee(empId);
    }
}
