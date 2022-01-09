package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Employee;

import java.util.List;

public interface EmployeeRepository {
    public Employee findEmployeeByEmpId(String empId);
    public boolean employeeIdExists(String empId);
    public void saveEmployee(Employee employee);
    public List<Employee> showEmployee();
    public void deleteEmployee(String empId);
}
