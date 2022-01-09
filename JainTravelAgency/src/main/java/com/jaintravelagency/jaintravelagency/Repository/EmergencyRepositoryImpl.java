package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Emergency;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmergencyRepositoryImpl implements EmergencyRepository{
    JdbcTemplate jdbcTemplate;

    public EmergencyRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Emergency> emergencyRowMapper = new RowMapper<Emergency>() {
        @Override
        public Emergency mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Emergency(rs.getString("phoneNo"), rs.getString("forWhom"), rs.getString("name"), rs.getString("relation"));
        }
    };

    @Override
    public void saveEmergency(Emergency emergency) {
        String query = "insert into emergency(phoneNo,forWhom,name,relation,) values(?,?,?,?)";
        jdbcTemplate.update(query,emergency.getPhoneNo(), emergency.getForWhom(), emergency.getName(), emergency.getRelation());

    }

    @Override
    public boolean EmergencyPhoneNoExists(String phoneNo) {
        String query = "select count(*) from emergency where phoneNo='"+phoneNo+"'";
        int cnt = jdbcTemplate.queryForObject(query,Integer.class);
        if(cnt>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Emergency findEmergencyByPhoneNo(String phoneNo) {
        String sqlQuery = "select * from emergency where phoneNo='"+phoneNo+"'";
        Emergency emergency = jdbcTemplate.queryForObject(sqlQuery, emergencyRowMapper);
        return emergency;
    }
}
