package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    public void saveVehicle(Vehicle vehicle);
    public boolean vehicleRegNoExists(String regNo);
    public Vehicle findVehicleByRegNo(String regNo);
    public List<Vehicle> showVehicle();
    public void deleteVehicle(String regNo);
}
