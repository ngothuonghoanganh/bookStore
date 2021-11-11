/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.categoryDTO;
import com.bookstore.dtos.roleDTO;
import com.bookstore.dtos.userDTO;
import com.bookstore.dtos.userDTOs;
import com.bookstore.utils.IDAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import com.bookstore.utils.MyConnection;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
    
    public void insertNew(userDTO user) throws SQLException, ClassNotFoundException, NamingException, JAXBException {
        
        try {
            List<Integer> intValues = new ArrayList<>();
            
            JAXBContext jc = JAXBContext.newInstance(userDTOs.class);
            Marshaller mar = jc.createMarshaller();
            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\userXML.xml");
            
            Unmarshaller u = jc.createUnmarshaller();
            userDTOs users = (userDTOs) u.unmarshal(f);
            
            for (userDTO us : users.getUser()) {
                intValues.add(us.getId());
            }
            
            user.setId(Collections.max(intValues) + 1);
            user.setRole(new roleDTO(1, "user"));
            users.getUser().add(user);
            
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.setAdapter(new IDAdapter());
            mar.marshal(users, f);
//            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\userXML.xml");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
