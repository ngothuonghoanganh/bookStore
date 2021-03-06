/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.daos.bookDAO;
import com.bookstore.daos.categoryDAO;
import com.bookstore.dtos.bookDTO;
import com.bookstore.dtos.categoryDTO;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateBook", urlPatterns = {"/UpdateBook"})
public class updateBookController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int id = Integer.parseInt(request.getParameter("bookId"));
            String title = request.getParameter("title");
//            String image = request.getParameter("image");
            String description = request.getParameter("description");
            String author = request.getParameter("author");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));

            //Date importDate = new Date(266464646);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float price = Float.parseFloat(request.getParameter("price"));
            String name = request.getParameter("bookName");
            categoryDAO categoryDao = new categoryDAO();

            categoryDTO cate = categoryDao.getOneCate(categoryId);

            bookDAO bookDAO = new bookDAO();
            bookDAO.updateNewBook(new bookDTO(id, title, "", description, author, categoryId, cate.getCategoryName(), quantity, "active", price, name));
            System.out.println(quantity);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            response.sendRedirect("Book");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
