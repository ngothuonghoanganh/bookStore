/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.daos.bookDAO;
import com.bookstore.dtos.bookDTO;
import com.bookstore.dtos.dealDetailDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateCart", urlPatterns = {"/UpdateCart"})
public class updateCartController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        String error = "";

        try {
            int bookId = Integer.parseInt(request.getParameter("id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            bookDAO bookDAO = new bookDAO();
            HttpSession session = request.getSession();
            ArrayList<dealDetailDTO> carts = (ArrayList<dealDetailDTO>) session.getAttribute("CART");
            bookDTO book = bookDAO.getOneBook(bookId);
            System.out.println(book.getName());
            if (book.getQuantity() < quantity) {
                error = "'" + book.getName() + "'" + " out of stock and only have " + book.getQuantity();
            } else {
                for (dealDetailDTO cart : carts) {
                    if (cart.getBookId() == bookId) {
                        cart.setQuantity(quantity);
                        cart.setPrice(book.getPrice() * quantity);
                    }
                }
//                carts.forEach(cart -> {
//                    if (cart.getBookId().equals(bookId)) {
//                        cart.setQuantity(quantity);
//                        cart.setPrice(book.getPrice() * quantity);
//                    }
//                });
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (!error.equals("")) {
                response.sendRedirect("ListDeal?message=" + error);
            } else {
                response.sendRedirect("ListDeal");
            }
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
