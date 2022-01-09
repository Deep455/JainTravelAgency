package com.jaintravelagency.jaintravelagency.Repository;


import com.jaintravelagency.jaintravelagency.Models.Emergency;

public interface EmergencyRepository {
    public void saveEmergency(Emergency emergency);
    public boolean EmergencyPhoneNoExists(String phoneNo);
    public Emergency findEmergencyByPhoneNo(String phoneNo);

}
