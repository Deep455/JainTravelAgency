package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Trip;
import com.jaintravelagency.jaintravelagency.Repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService{

    private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void saveTrip(Trip trip) {
        tripRepository.saveTrip(trip);
    }

    @Override
    public boolean tripNoExists(String tripNo) {
        return tripRepository.tripNoExists(tripNo);
    }

    @Override
    public Trip findTripByTripNo(String tripNo) {
        return tripRepository.findTripByTripNo(tripNo);
    }

    @Override
    public List<Trip> showTrip() {
        return tripRepository.showTrip();
    }

    @Override
    public void deleteTrip(String tripNo) {
        tripRepository.deleteTrip(tripNo);
    }
}
