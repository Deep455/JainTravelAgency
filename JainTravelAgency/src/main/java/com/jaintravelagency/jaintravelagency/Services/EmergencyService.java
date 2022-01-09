package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Emergency;

public interface EmergencyService {
    public void saveEmergency(Emergency emergency);
    public boolean EmergencyNoExists(String phoneNo);
    public Emergency findEmergencyByPhoneNo(String phoneNo);
}
