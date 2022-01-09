package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.EmployeeInsuranceDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmployeeInsuranceDetailsRepositoryImpl implements EmployeeInsuranceDetailsRepository{

    JdbcTemplate jdbcTemplate;

    public EmployeeInsuranceDetailsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<EmployeeInsuranceDetails> employeeInsuranceDetailsRowMapper = new RowMapper<EmployeeInsuranceDetails>() {
        @Override
        public EmployeeInsuranceDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new EmployeeInsuranceDetails(rs.getString("insuranceNo"), rs.getString("currentStatus"), rs.getString("insuranceProvider"), rs.getString("startingDate"), rs.getString("expiryDate"), rs.getString("insuranceType"), rs.getInt("amountInsured"), rs.getString("beneficiary"));
        }
    };


    @Override
    public void saveEmployeeInsuranceDetails(EmployeeInsuranceDetails employeeInsuranceDetails) {
        String query = "insert into employeeinsurancedetails(insuranceNo,currentStatus,insuranceProvider,startingDate,expiryDate,insuranceType,amountInsured,beneficiary) values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,employeeInsuranceDetails.getInsuranceNo(), employeeInsuranceDetails.getCurrentStatus(), employeeInsuranceDetails.getInsuranceProvider(), employeeInsuranceDetails.getStartingDate(), employeeInsuranceDetails.getExpiryDate(), employeeInsuranceDetails.getInsuranceType(), employeeInsuranceDetails.getAmountInsured(), employeeInsuranceDetails.getBeneficiary());
    }

    @Override
    public boolean EmployeeInsuranceNoExists(String insuranceNo) {
        String query = "select count(*) from employeeinsurancedetails where insuranceNo='"+insuranceNo+"'";
        int cnt = jdbcTemplate.queryForObject(query,Integer.class);
        if(cnt>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public EmployeeInsuranceDetails findVehicleByRegNo(String insuranceNo) {
        String sqlQuery = "select * from employeeinsurancedetails where insuranceNo='"+insuranceNo+"'";
        EmployeeInsuranceDetails employeeInsuranceDetails = jdbcTemplate.queryForObject(sqlQuery, employeeInsuranceDetailsRowMapper);
        return employeeInsuranceDetails;
    }
}
