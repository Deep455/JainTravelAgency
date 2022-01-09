package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Emergency;
import com.jaintravelagency.jaintravelagency.Repository.EmergencyRepository;
import org.springframework.stereotype.Service;

@Service
public class EmergencyServiceImpl implements EmergencyService{
    private EmergencyRepository emergencyRepository;

    public EmergencyServiceImpl(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    @Override
    public void saveEmergency(Emergency emergency) {
        emergencyRepository.saveEmergency(emergency);

    }

    @Override
    public boolean EmergencyNoExists(String phoneNo) {
        return emergencyRepository.EmergencyPhoneNoExists(phoneNo);
    }

    @Override
    public Emergency findEmergencyByPhoneNo(String phoneNo) {
        return emergencyRepository.findEmergencyByPhoneNo(phoneNo);
    }
}
