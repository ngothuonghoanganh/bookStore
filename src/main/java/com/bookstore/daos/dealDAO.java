/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.dealDTO;
import com.bookstore.dtos.dealDetailDTO;
import com.bookstore.dtos.dealList;
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
public class dealDAO {

    private Connection conn = null;
    private PreparedStatement prStm = null;
    private ResultSet rs = null;

    private void closeConn() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (prStm != null) {
            prStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean confirmOrder(dealDTO deals, ArrayList<dealDetailDTO> cart) throws SQLException, NamingException {
        try {
            conn = MyConnection.getMyConnection();
            conn.setAutoCommit(false);
            String sqlOrder = "INSERT INTO deals (userId, discountId, discountPrice, totalPrice, status)"
                    + "VALUES(?,?,?,?,?)";
            prStm = conn.prepareStatement(sqlOrder, new String[]{"id"});
            prStm.setInt(1, deals.getUserId());
            prStm.setInt(2, deals.getDiscountId());
            prStm.setFloat(3, deals.getDiscountPirce());
            prStm.setFloat(4, deals.getTotalPrice());
            prStm.setString(5, "active");

            int rowEffect = prStm.executeUpdate();
            if (rowEffect == 0) {
                conn.rollback();
                return false;
            }
            rs = prStm.getGeneratedKeys();
            String dealId = "";
            if (rs.next()) {
                dealId = rs.getString(1);
            } else {
                conn.rollback();
                return false;
            }
            System.out.println(deals);
            // add detail
            String sqlOrderDetail = "INSERT INTO dbo.dealDetail ( dealId, bookId, quantity, price ) VALUES  ( (select top 1 id from deals where userId = ? and DateInserted = (select max(DateInserted) from deals where userId = ?)), ?, ?, ?)";
            for (dealDetailDTO book : cart) {
                prStm = conn.prepareStatement(sqlOrderDetail);
                prStm.setInt(1, deals.getUserId());
                prStm.setInt(2, deals.getUserId());
                prStm.setInt(3, book.getBookId());
                prStm.setInt(4, book.getQuantity());
                prStm.setFloat(5, book.getPrice());
                rowEffect = prStm.executeUpdate();
                if (rowEffect == 0) {
                    conn.rollback();
                    return false;
                }
            }
            if (deals.getDiscountId() != null) {
                //delete discount 
                String sqlUpdateStatusDiscount = "Update discounts set status = 'used' where id = ?";
                prStm = conn.prepareStatement(sqlUpdateStatusDiscount);
                prStm.setInt(1, deals.getDiscountId());
                rowEffect = prStm.executeUpdate();
                if (rowEffect == 0) {
                    conn.rollback();
                    return false;
                }
            }

            String sqlDecreaseQuantity = "UPDATE dbo.books SET quantity = quantity - ? WHERE id = ?";
            for (dealDetailDTO book : cart) {
                prStm = conn.prepareStatement(sqlDecreaseQuantity);
                prStm.setInt(1, book.getQuantity());
                prStm.setInt(2, book.getBookId());
                rowEffect = prStm.executeUpdate();
                if (rowEffect == 0) {
                    conn.rollback();
                    return false;
                }
            }
            conn.commit();
            return true;
        } finally {
            closeConn();
        }
    }

    public List<dealList> getAllDeal(String bookName, String createDate, String userId) throws SQLException, NamingException {
        List<dealList> listResouces = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "select "
                    + "deals.id as id,"
                    + "deals.discountPrice as discountPrice,"
                    + "deals.totalPrice as totalPrice,"
                    + "dealDetail.quantity as quantity,"
                    + "dealDetail.price as price,"
                    + "users.name as fullName,"
                    + "deals.createDate as createDate,"
                    + "books.name as bookName "
                    + "from deals LEFT JOIN users on deals.userId = users.id "
                    + "LEFT JOIN dealDetail on deals.id = dealDetail.dealId "
                    + "LEFT JOIN books on dealDetail.bookId = books.id where deals.id in (select dealId from dealDetail dd join books b on "
                    + "dd.bookId = b.id where b.name like ?) and deals.createDate like ? and users.id like ?";
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, "%" + bookName + "%");
            prStm.setString(2, "%" + createDate + "%");
            prStm.setString(3, "%" + userId + "%");

//            prStm.setInt(3, paging);
//            prStm.setInt(4, pageSize);
            rs = prStm.executeQuery();
            while (rs.next()) {
                listResouces.add(new dealList(rs.getInt("id"), rs.getString("fullName"), rs.getFloat("discountPrice"), rs.getFloat("totalPrice"), rs.getFloat("price"), rs.getInt("quantity"), rs.getDate("createDate"), rs.getString("BookName")));
            }
        } finally {
            closeConn();
        }
        return listResouces;
    }

}
