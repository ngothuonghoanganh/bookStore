/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

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
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class addToCartController extends HttpServlet {

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
            ArrayList<dealDetailDTO> arr = new ArrayList<>();
            dealDetailDTO dealDetail = new dealDetailDTO();

            String bookId = request.getParameter("bookId");
            String bookName = request.getParameter("bookName");
            String image = request.getParameter("image");

            int quantity = 1;
            float price = Float.parseFloat(request.getParameter("price"));

//            dealDetail.setBookId(bookId);
            dealDetail.setBookName(bookName);
            dealDetail.setPrice(price);
            dealDetail.setQuantity(quantity);

            HttpSession session = request.getSession();
            ArrayList<dealDetailDTO> carts = (ArrayList<dealDetailDTO>) session.getAttribute("CART");
            System.out.println(carts);
            if (carts == null || carts.isEmpty()) {
                arr.add(dealDetail);
                session.setAttribute("CART", arr);
            } else {
//                for (dealDetailDTO cart : carts) {
//                    if (!cart.getBookId().equals(bookId)) {
//                        carts.add(dealDetail);
//                        session.removeAttribute("CART");
//                        session.setAttribute("CART", carts);
//                    }
//                }
            }

        } catch (NumberFormatException e) {
        } finally {
            response.sendRedirect("ListDeal");
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
