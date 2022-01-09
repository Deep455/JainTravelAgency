package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.EmployeeInsuranceDetails;
import com.jaintravelagency.jaintravelagency.Repository.EmployeeInsuranceDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeInsuranceDetailsServiceImpl implements EmployeeInsuranceDetailsService{

    private EmployeeInsuranceDetailsRepository employeeInsuranceDetailsRepository;

    public EmployeeInsuranceDetailsServiceImpl(EmployeeInsuranceDetailsRepository employeeInsuranceDetailsRepository) {
        this.employeeInsuranceDetailsRepository = employeeInsuranceDetailsRepository;
    }

    @Override
    public void saveEmployeeInsuranceDetails(EmployeeInsuranceDetails employeeInsuranceDetails) {
        employeeInsuranceDetailsRepository.saveEmployeeInsuranceDetails(employeeInsuranceDetails);
    }

    @Override
    public boolean EmployeeInsuranceNoExists(String insuranceNo) {
        return employeeInsuranceDetailsRepository.EmployeeInsuranceNoExists(insuranceNo);
    }

    @Override
    public EmployeeInsuranceDetails findVehicleByRegNo(String insuranceNo) {
        return employeeInsuranceDetailsRepository.findVehicleByRegNo(insuranceNo);
    }
}
