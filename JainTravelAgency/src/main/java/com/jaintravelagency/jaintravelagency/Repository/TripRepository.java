package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Trip;

import java.util.List;

public interface TripRepository {
    public void saveTrip(Trip trip);
    public boolean tripNoExists(String tripNo);
    public Trip findTripByTripNo(String tripNo);
    public List<Trip> showTrip();
    public void deleteTrip(String tripNo);
}
