package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.EmployeeInsuranceDetails;

public interface EmployeeInsuranceDetailsRepository {
    public void saveEmployeeInsuranceDetails(EmployeeInsuranceDetails employeeInsuranceDetails);
    public boolean EmployeeInsuranceNoExists(String insuranceNo);
    public EmployeeInsuranceDetails findVehicleByRegNo(String insuranceNo);
}
