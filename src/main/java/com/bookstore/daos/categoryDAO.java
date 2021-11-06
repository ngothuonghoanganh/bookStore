/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.CategoriesDTOs;
import com.bookstore.dtos.categoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
            List<Integer> intValues = new ArrayList<>();

           JAXBContext jc = JAXBContext.newInstance(CategoriesDTOs.class);
            Marshaller mar = jc.createMarshaller();
            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\CategoriesXML.xml");

            Unmarshaller u = jc.createUnmarshaller();
            CategoriesDTOs Categories = (CategoriesDTOs) u.unmarshal(f);
            
            for (categoryDTO Cat : Categories.getCategories()) {
                intValues.add(Cat.getId());
            }
            
            category.setId(Collections.max(intValues)+1);
            
            Categories.getCategories().add(category);
            
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            mar.setAdapter(new IDAdapter());
            mar.marshal(Categories,f);
        }catch (Exception e) {
                System.out.println(e);
        }  finally {
            closeConn();
        }
    }

    public List<categoryDTO> getAllCate() throws SQLException, NamingException {
        CategoriesDTOs listCate = null;
        try {
//             System.out.println(username);
            JAXBContext jc = JAXBContext.newInstance(CategoriesDTOs.class);

            Unmarshaller u = jc.createUnmarshaller();

            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\CategoriesXML.xml");

            listCate = (CategoriesDTOs) u.unmarshal(f);

        } catch (Exception e) {
                System.out.println(e);
        } finally {
            closeConn();
        }
        return listCate.getCategories();
    }
}
