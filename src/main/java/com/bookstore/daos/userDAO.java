/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.userDTO;
import com.bookstore.dtos.userDTOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import com.bookstore.utils.MyConnection;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Admin
 */
public class userDAO {

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

    public userDTO checkLogin(String username, String password) throws NamingException, SQLException {
//        userDTO user = null;
        try {
            System.out.println(username);
            JAXBContext jc = JAXBContext.newInstance(userDTOs.class);

            Unmarshaller u = jc.createUnmarshaller();

            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\userXML.xml");

            userDTOs users = (userDTOs) u.unmarshal(f);

            for (userDTO user : users.getUser()) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
//            System.out.println(username + password);
//            conn = MyConnection.getMyConnection();
//            String sql = "SELECT u.id, u.name as fullName, r.name AS roleName FROM dbo.users AS u JOIN dbo.roles AS r ON r.id = u.roleId WHERE u.username = ? COLLATE SQL_Latin1_General_CP1_CS_AS AND u.password = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
//            prStm = conn.prepareStatement(sql);
//            prStm.setString(1, username);
//            prStm.setString(2, password);
//            rs = prStm.executeQuery();
//            if (rs.next()) {
//                user = new userDTO();
//                user.setId(rs.getString("id"));
//                user.setFullName(rs.getString("fullName"));
//                user.setRoleID(rs.getString("roleName"));
//            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            closeConn();
        }
        return null;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "Select userID "
                        + " FROM users "
                        + " Where userID=?";
                prStm = conn.prepareStatement(sql);
                prStm.setString(1, userID);
                rs = prStm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConn();
        }
        return check;
    }

    public void insertNew(userDTO user) throws SQLException, ClassNotFoundException, NamingException {

        try {
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "INSERT INTO users("
                        + "userName, password,"
                        + " name, roleId) "
                        + " VALUES(?,?,?,(select id from roles where name = 'user'))"; // Default roleID = 3 <--> Employee
                prStm = conn.prepareStatement(sql);
                prStm.setString(1, user.getUsername());
                prStm.setNString(2, user.getPassword());
                prStm.setNString(3, user.getFullName());

                prStm.executeUpdate();
            }
        } finally {
            closeConn();
        }
    }
}
