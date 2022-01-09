package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Vehicle;
import com.jaintravelagency.jaintravelagency.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.saveVehicle(vehicle);
    }

    @Override
    public boolean vehicleRegNoExists(String regNo) {
        return vehicleRepository.vehicleRegNoExists(regNo);
    }

    @Override
    public Vehicle findVehicleByRegNo(String regNo) {
        return vehicleRepository.findVehicleByRegNo(regNo);
    }

    @Override
    public List<Vehicle> showVehicle(){
        return vehicleRepository.showVehicle();
    }

    @Override
    public void deleteVehicle(String regNo) {
        vehicleRepository.deleteVehicle(regNo);
    }
}
