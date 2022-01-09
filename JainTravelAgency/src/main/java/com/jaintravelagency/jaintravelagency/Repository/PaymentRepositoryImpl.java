package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Payment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository{

    JdbcTemplate jdbcTemplate;

    public PaymentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Payment> paymentRowMapper = new RowMapper<Payment>() {
        @Override
        public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Payment(rs.getString("paymentReceiptNo"), rs.getString("dateOfPayment"), rs.getInt("amountPaid"), rs.getString("tripNo"), rs.getInt("taxes"), rs.getInt("fines"));
        }
    };

    @Override
    public void savePayment(Payment payment) {
        String query = "insert into payment(paymentReceiptNo,dateOfPayment,amountPaid,tripNo,taxes,fines) values(?,?,?,?,?,?)";
        jdbcTemplate.update(query,payment.getPaymentReceiptNo(),payment.getDateOfPayment(), payment.getAmountPaid(), payment.getTripNo(), payment.getTaxes(), payment.getFines());
    }

    @Override
    public boolean paymentReceiptNoExists(String paymentReceiptNo) {
        String query = "select count(*) from payment where paymentReceiptNo='"+paymentReceiptNo+"'";
        int cnt = jdbcTemplate.queryForObject(query,Integer.class);
        if(cnt>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Payment findPaymentByPaymentReceiptNo(String paymentReceiptNo) {
        String sqlQuery = "select * from payment where paymentReceiptNo='"+paymentReceiptNo+"'";
        Payment payment = jdbcTemplate.queryForObject(sqlQuery, paymentRowMapper);
        return payment;
    }

}
