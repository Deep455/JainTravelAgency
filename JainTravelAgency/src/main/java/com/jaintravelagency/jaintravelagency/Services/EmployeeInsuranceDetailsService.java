package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.EmployeeInsuranceDetails;

public interface EmployeeInsuranceDetailsService {
    public void saveEmployeeInsuranceDetails(EmployeeInsuranceDetails employeeInsuranceDetails);
    public boolean EmployeeInsuranceNoExists(String insuranceNo);
    public EmployeeInsuranceDetails findVehicleByRegNo(String insuranceNo);
}
