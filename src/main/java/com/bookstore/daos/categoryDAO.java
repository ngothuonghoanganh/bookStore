/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.categoryDTO;
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
public class categoryDAO {

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

    public void insertNew(categoryDTO category) throws SQLException, ClassNotFoundException, NamingException {
        try {
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "INSERT INTO categories("
                        + "categoryName) "
                        + " VALUES(?)"; // Default roleID = 3 <--> Employee
                prStm = conn.prepareStatement(sql);
                prStm.setString(1, category.getCategoryName());
                prStm.executeUpdate();
            }
        } finally {
            closeConn();
        }
    }
    
        public List<categoryDTO> getAllCate() throws SQLException, NamingException{
        List<categoryDTO> listCate = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT id, categoryName FROM categories";
            prStm = conn.prepareStatement(sql);
            rs = prStm.executeQuery();
            while(rs.next()){
                categoryDTO cate = new categoryDTO();
                cate.setId(rs.getInt("id"));
                cate.setCategoryName(rs.getString("categoryName"));
                listCate.add(cate);
            }
        } finally {
            closeConn();
        }
        return listCate;
        }
}
