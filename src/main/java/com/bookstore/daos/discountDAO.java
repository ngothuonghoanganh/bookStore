/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.discountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import com.bookstore.utils.MyConnection;

/**
 *
 * @author Admin
 */
public class discountDAO {

    private Connection conn = null;
    private PreparedStatement prStm = null;
    private ResultSet rs = null;

    private void closeConn() {
        try {

            if (rs != null) {
                rs.close();
            }
            if (prStm != null) {
                prStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }

    public boolean insertNew(discountDTO discount) throws SQLException, ClassNotFoundException, NamingException {
        boolean success = false;
        try {
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "INSERT INTO discounts("
                        + "discountPercent, "
                        + "startDate,"
                        + "endDate,"
                        + "code,"
                        + "status) "
                        + " VALUES(?,?,?,?,?)"; // Default roleID = 3 <--> Employee
                prStm = conn.prepareStatement(sql);
                prStm.setFloat(1, discount.getPercent());
                prStm.setDate(2, discount.getStartDate());
                prStm.setDate(3, discount.getEndDate());
                prStm.setString(4, discount.getCode().toUpperCase());
                prStm.setString(5, "active");
                int rowEffect = prStm.executeUpdate();
                if (rowEffect == 0) {
                    success = false;
                } else {
                    success = true;
                }
            }
        } catch (Exception e) {
            success = false;
            System.out.println(e);
        } finally {
            closeConn();
        }
        return success;
    }

    public List<discountDTO> getAllDiscount() throws SQLException, NamingException {
        List<discountDTO> listResouces = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT id, discountPercent, code, startDate, endDate from discounts where status = 'active'";
            prStm = conn.prepareStatement(sql);
            rs = prStm.executeQuery();
            while (rs.next()) {
                discountDTO discount = new discountDTO();
                discount.setId(rs.getInt("id"));
                discount.setPercent(rs.getFloat("discountPercent"));
                discount.setStartDate(rs.getDate("startDate"));
                discount.setEndDate(rs.getDate("endDate"));
                discount.setCode(rs.getString("code"));
                listResouces.add(discount);
            }
        } finally {
            closeConn();
        }
        return listResouces;
    }

    public discountDTO getOneDiscount(String code) throws SQLException, NamingException {
        discountDTO discount = new discountDTO();
        try {

            conn = MyConnection.getMyConnection();
            String sql = "SELECT id, discountPercent, code, startDate, endDate from discounts where status = 'active' and code = ? and GETDATE() >= startDate and GETDATE() <= endDate";
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, code);
            rs = prStm.executeQuery();
            while (rs.next()) {
                discount.setId(rs.getInt("id"));
                discount.setPercent(rs.getFloat("discountPercent"));
                discount.setStartDate(rs.getDate("startDate"));
                discount.setEndDate(rs.getDate("endDate"));
                discount.setCode(rs.getString("code"));
            }
        } finally {
            closeConn();
        }
        return discount;
    }
}
