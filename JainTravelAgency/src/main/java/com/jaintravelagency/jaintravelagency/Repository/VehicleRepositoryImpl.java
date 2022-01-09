package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Vehicle;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{
    JdbcTemplate jdbcTemplate;

    public VehicleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Vehicle> vehicleRowMapper = new RowMapper<Vehicle>() {
        @Override
        public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Vehicle(rs.getString("regNo"), rs.getString("available"), rs.getInt("distanceTravelled"), rs.getInt("buyingPrice"), rs.getString("handlerId"), rs.getInt("purchaseYear"), rs.getString("company"), rs.getString("color"), rs.getString("model"), rs.getInt("seatingCapacity"));
        }
    };

    @Override
    public void saveVehicle(Vehicle vehicle) {
        String query = "insert into vehicle(regNo,available,distanceTravelled,buyingPrice,handlerId,purchaseYear,company,color,model,seatingCapacity) values(?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,vehicle.getRegNo(), vehicle.getAvailable(), vehicle.getDistanceTravelled(), vehicle.getBuyingPrice(), vehicle.getHandlerId(), vehicle.getPurchaseYear(), vehicle.getCompany(), vehicle.getColor(), vehicle.getModel(), vehicle.getSeatingCapacity());
    }

    @Override
    public boolean vehicleRegNoExists(String regNo) {
        String query = "select count(*) from vehicle where regNo='"+regNo+"'";
        int cnt = jdbcTemplate.queryForObject(query,Integer.class);
        if(cnt>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Vehicle findVehicleByRegNo(String regNo) {
        String sqlQuery = "select * from vehicle where regNo='"+regNo+"'";
        Vehicle vehicle = jdbcTemplate.queryForObject(sqlQuery, vehicleRowMapper);
        return vehicle;
    }

    @Override
    public List<Vehicle> showVehicle(){
        String sqlQuery = "select * from vehicle";
        return jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
    }

    @Override
    public void deleteVehicle(String regNo) {
        String sqlQuery = "delete from vehicle where regNo='"+regNo+"'";
        jdbcTemplate.update(sqlQuery);
    }
}
