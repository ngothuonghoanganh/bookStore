/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.daos;

import com.bookstore.dtos.bookDTO;
import com.bookstore.dtos.bookDTOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import com.bookstore.utils.MyConnection;
import java.io.File;
import java.util.Collections;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Admin
 */
public class bookDAO {

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
    
    public void insertNewBook(bookDTO book) throws SQLException, ClassNotFoundException, NamingException {
        try {
            List<Integer> intValues = new ArrayList<>();

           JAXBContext jc = JAXBContext.newInstance(bookDTOs.class);
            Marshaller mar = jc.createMarshaller();
            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\BooksXML.xml");

            Unmarshaller u = jc.createUnmarshaller();
            bookDTOs Books = (bookDTOs) u.unmarshal(f);
            
            for (bookDTO Book : Books.getListBooks()) {
                intValues.add(Book.getId());
            }
            
            book.setId(Collections.max(intValues)+1);
            
            Books.getListBooks().add(book);
            
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            mar.setAdapter(new IDAdapter());
            mar.marshal(Books,f);
        }catch (Exception e) {
                System.out.println(e);
        }  finally {
            closeConn();
        }
    }
    public List<bookDTO> getAllBook() throws SQLException, NamingException {
        bookDTOs listBook = null;
        try {
//             System.out.println(username);
            JAXBContext jc = JAXBContext.newInstance(bookDTOs.class);

            Unmarshaller u = jc.createUnmarshaller();

            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\BooksXML.xml");

            listBook = (bookDTOs) u.unmarshal(f);

        } catch (Exception e) {
                System.out.println(e);
        } finally {
            closeConn();
        }
        return listBook.getListBooks();
    }
    public bookDTO getOneBook(int bookID) throws NamingException, SQLException {
        try {
            System.out.println(bookID);
            JAXBContext jc = JAXBContext.newInstance(bookDTOs.class);

            Unmarshaller u = jc.createUnmarshaller();

            File f = new File("C:\\Users\\Admin\\Desktop\\bookStore\\BooksXML.xml");

            bookDTOs books = (bookDTOs) u.unmarshal(f);

            for (bookDTO book : books.getListBooks()) {
                if(book.getId() == bookID){
                    return book;
                }
//                        if (book.getId() = bookID) {
//                    return book;
//                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            closeConn();
        }
        return null;
    }
//    public void insertNew(bookDTO book) throws SQLException, ClassNotFoundException, NamingException {
//        try {
//            conn = MyConnection.getMyConnection();
//            if (conn != null) {
//                String sql = "INSERT INTO books("
//                        + "title, "
//                        + "image, "
//                        + "description,"
//                        + "author,"
//                        + "categoryId,"
//                        + "importDate,"
//                        + "quantity,"
//                        + "status,"
//                        + "price,"
//                        + "name) "
//                        + " VALUES(?,?,?,?,?,?,?,?,?,?)"; // Default roleID = 3 <--> Employee
//                prStm = conn.prepareStatement(sql);
//                prStm.setNString(1, book.getTitle());
//                prStm.setString(2, book.getImage());
//                prStm.setNString(3, book.getDescription());
//                prStm.setNString(4, book.getAuthor());
//                prStm.setInt(5, book.getCategoryId());
//                prStm.setDate(6, book.getImportDate());
//                prStm.setInt(7, book.getQuantity());
//                prStm.setString(8, book.getStatus());
//                prStm.setFloat(9, book.getPrice());
//                prStm.setNString(10, book.getName());
//                prStm.executeUpdate();
//            }
//        } finally {
//            closeConn();
//        }
//    }

//    public List<bookDTO> getAllBook(String bookName, String categoryName, float minPrice, float maxPrice, int paging, int pageSize) throws SQLException, NamingException {
//        List<bookDTO> listResouces = new ArrayList<>();
//        try {
//            conn = MyConnection.getMyConnection();
//            String sql = "SELECT rs.id as id,"
//                    + "rs.name as name,"
//                    + "rs.importDate as importDate,"
//                    + "rs.quantity as quantity, "
//                    + "rs.price as price,"
//                    + "rs.image as image,"
//                    + "rs.title as title,"
//                    + "rs.author as author,"
//                    + "rs.description as description,"
//                    + "rs.status as status,"
//                    + "ct.id as categoryId,"
//                    + "ct.categoryName as categoryName FROM books rs join categories ct on rs.categoryId = ct.id"
//                    + " Where rs.name like ? and ct.categoryName like ? and price BETWEEN ? and ? and rs.status='active' ORDER BY rs.name"
//                    + " OFFSET ? ROWS\n"
//                    + "FETCH NEXT ? ROWS ONLY OPTION (RECOMPILE)";
//            prStm = conn.prepareStatement(sql);
//            prStm.setString(1, "%" + bookName + "%");
//            prStm.setString(2, "%" + categoryName + "%");
//            prStm.setFloat(3, minPrice);
//            prStm.setFloat(4, maxPrice);
//            prStm.setInt(5, paging);
//            prStm.setInt(6, pageSize);
//            rs = prStm.executeQuery();
//            while (rs.next()) {
//                listResouces.add(new bookDTO(rs.getInt("id"), rs.getString("title"), rs.getString("image"), rs.getString("description"), rs.getString("author"), rs.getInt("categoryId"), rs.getString("categoryName"), rs.getDate("importDate"), rs.getInt("quantity"), rs.getString("status"), rs.getFloat("price"), rs.getString("name")));
//            }
//        } finally {
//            closeConn();
//        }
//        return listResouces;
//    }

    public int countBook(String bookname, String categoryName, float minPrice, float maxPrice) throws SQLException, NamingException {
        int count = 0;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT COUNT(*) as count FROM books rs left join categories ct on rs.categoryId = ct.id"
                    + " Where rs.name like ? and ct.categoryName like ? and price BETWEEN ? and ? and rs.status ='active'";
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, "%" + bookname + "%");
            prStm.setString(2, "%" + categoryName + "%");
            prStm.setFloat(3, minPrice);
            prStm.setFloat(4, maxPrice);
            rs = prStm.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } finally {
            closeConn();
        }
        return count;
    }

    public bookDTO getOneBook(String bookId) throws SQLException, NamingException {
        bookDTO book = new bookDTO();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT id, name, title, image, description, price, quantity FROM books"
                    + " Where id = ?";
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, bookId);
            rs = prStm.executeQuery();
            while (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setTitle(rs.getString("Title"));
                book.setImage(rs.getString("image"));
                book.setQuantity(rs.getInt("quantity"));
                book.setDescription(rs.getString("description"));
                book.setPrice(rs.getFloat("price"));
            }
        } finally {
            closeConn();
        }
        return book;
    }

    public boolean update(bookDTO book) throws SQLException, NamingException {
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE books SET title = ?, description = ?, price = ?, author = ?, importDate = ?, quantity = ?, categoryId = ?, name = ? WHERE id = ? AND status ='active'";
            prStm = conn.prepareStatement(sql);
            prStm.setNString(1, book.getTitle());
            prStm.setNString(2, book.getDescription());
            prStm.setFloat(3, book.getPrice());
            prStm.setNString(4, book.getAuthor());
            prStm.setDate(5, book.getImportDate());
            prStm.setInt(6, book.getQuantity());
            prStm.setInt(7, book.getCategoryId());
            prStm.setString(8, book.getName());
            prStm.setInt(9, book.getId());
            int rowEffect = prStm.executeUpdate();
            if (rowEffect > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

    public boolean updateStatus(bookDTO book) throws SQLException, NamingException {
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE books SET status = ? WHERE id = ? AND status ='active'";
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, book.getStatus());
            prStm.setInt(2, book.getId());

            int rowEffect = prStm.executeUpdate();
            if (rowEffect > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

}
