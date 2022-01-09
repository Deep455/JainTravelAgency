package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Employee;

import java.util.List;

public interface EmployeeService {
    public void saveEmployee(Employee employee);
    public boolean employeeIdExists(String empId);
    public Employee findEmployeeByEmpId(String EmpId);
    public List<Employee> showEmployee();
    public void deleteEmployee(String empId);
}
