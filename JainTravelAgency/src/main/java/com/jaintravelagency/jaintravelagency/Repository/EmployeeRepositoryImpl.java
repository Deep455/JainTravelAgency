package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
class EmployeeRepositoryImpl implements EmployeeRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(rs.getString("empId"), rs.getString("name"), rs.getString("panCardNo"), rs.getString("drivingLicenseNo"), rs.getString("aadharNo"), rs.getString("phoneNo"), rs.getString("address"), rs.getString("dob"), rs.getString("emergencyPhoneNo"), rs.getString("role"), rs.getString("password"));
        }
    };

    @Override
    public Employee findEmployeeByEmpId(String empId) {
        String sqlQuery = "select * from employee where empId='"+empId+"'";
        Employee employee = jdbcTemplate.queryForObject(sqlQuery, employeeRowMapper);
        return employee;
    }

    @Override
    public boolean employeeIdExists(String empId) {

        String query = "select count(*) from employee where empId='"+empId+"'";
        int cnt = jdbcTemplate.queryForObject(query,Integer.class);
        if(cnt>0){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public void saveEmployee(Employee employee) {
        String query = "insert into employee(empId,name,panCardNo,drivingLicenseNo,aadharNo,phoneNo,address,dob,emergencyPhoneNo,role,password) values(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,employee.getEmpId(),employee.getName(),employee.getPanCardNo(),employee.getDrivingLicenseNo(),employee.getAadharNo(),employee.getPhoneNo(),employee.getAddress(),employee.getDob(),employee.getEmergencyPhoneNo(),employee.getRole(),employee.getPassword());
    }

    @Override
    public List<Employee> showEmployee() {
        String sqlQuery = "select * from employee";
        return jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public void deleteEmployee(String empId) {
        String sqlQuery = "delete from employee where empId='"+empId+"'";
        jdbcTemplate.update(sqlQuery);
    }
}
