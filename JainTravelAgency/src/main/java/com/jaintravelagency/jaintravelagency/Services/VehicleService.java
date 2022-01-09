package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Vehicle;

import java.util.List;

public interface VehicleService {
    public void saveVehicle(Vehicle vehicle);
    public boolean vehicleRegNoExists(String regNo);
    Vehicle findVehicleByRegNo(String regNo);
    public List<Vehicle> showVehicle();
    public void deleteVehicle(String regNo);
}
