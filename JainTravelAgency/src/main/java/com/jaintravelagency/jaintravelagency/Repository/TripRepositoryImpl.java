package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Trip;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TripRepositoryImpl implements TripRepository{
    JdbcTemplate jdbcTemplate;

    public TripRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Trip> tripRowMapper = new RowMapper<Trip>() {
        @Override
        public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Trip(rs.getString("tripNo"), rs.getString("driverId"), rs.getInt("journeyDistance"), rs.getString("customerId"), rs.getInt("fuelConsumed"), rs.getString("vehicleRegNo"), rs.getString("receiptNo"));
        }
    };

    @Override
    public void saveTrip(Trip trip) {
        String query = "insert into trip(tripNo,driverId,journeyDistance,customerId,fuelConsumed,vehicleRegNo,receiptNo) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,trip.getTripNo(), trip.getDriverId(), trip.getJourneyDistance(), trip.getCustomerId(), trip.getFuelConsumed(), trip.getVehicleRegNo(), trip.getReceiptNo());

    }

    @Override
    public boolean tripNoExists(String tripNo) {
        String query = "select count(*) from trip where tripNo='"+tripNo+"'";
        int cnt = jdbcTemplate.queryForObject(query,Integer.class);
        if(cnt>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Trip findTripByTripNo(String tripNo) {
        String sqlQuery = "select * from trip where tripNo='"+tripNo+"'";
        Trip trip = jdbcTemplate.queryForObject(sqlQuery, tripRowMapper);
        return trip;
    }

    @Override
    public List<Trip> showTrip() {
        String sqlQuery = "select * from trip";
        return jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<Trip>(Trip.class));
    }

    @Override
    public void deleteTrip(String tripNo) {
        String sqlQuery = "delete from trip where tripNo='"+tripNo+"'";
        jdbcTemplate.update(sqlQuery);
    }

}
