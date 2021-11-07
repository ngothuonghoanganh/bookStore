/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.CategoriesDTOs;
import com.bookstore.dtos.DiscountDTOs;
import com.bookstore.dtos.dealDTO;
import com.bookstore.dtos.discountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import com.bookstore.utils.MyConnection;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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

    public List<discountDTO> getAllDiscounts() throws SQLException, NamingException, JAXBException {
        DiscountDTOs listDiscounts = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(discountDTO.class);
            Unmarshaller u = jc.createUnmarshaller();
            File f = new File("C:\\Users\\tranv\\Downloads\\bookStore\\discountsXML.xml");
            listDiscounts = (DiscountDTOs) u.unmarshal(f);

        } catch (Error e) {
            System.out.println("Error at getAllDiscount: " + e);
        }
        return listDiscounts.getDiscounts();
    }

    public discountDTO getOneDiscount(String code) throws SQLException, NamingException, JAXBException {
        discountDTO discount = new discountDTO();
        try {

            JAXBContext jc = JAXBContext.newInstance(discountDTO.class);
            Unmarshaller u = jc.createUnmarshaller();
            File f = new File("C:\\Users\\tranv\\Downloads\\bookStore\\discountsXML.xml");
            List<discountDTO> listDiscounts = getAllDiscounts();
            for (discountDTO x : listDiscounts) {
                if (x.getCode().equals(code)) {
                    discount = x;
                }
            }
        }catch(Exception e){
            System.out.println("Error at getOneDiscount: "+e);
        }
        return discount;
    }

    public List<discountDTO> getAllDiscount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
