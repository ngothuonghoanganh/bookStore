/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.daos.bookDAO;
import com.bookstore.daos.dealDAO;
import com.bookstore.daos.discountDAO;
import com.bookstore.dtos.bookDTO;
import com.bookstore.dtos.dealDTO;
import com.bookstore.dtos.dealDetailDTO;
import com.bookstore.dtos.discountDTO;
import com.bookstore.dtos.userDTO;
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
@WebServlet(name = "ConfirmDeal", urlPatterns = {"/ConfirmDeal"})

public class confirmDealController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean statusDeal = false;
        String error = "";
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            discountDTO discountSession = (discountDTO) session.getAttribute("DISCOUNT");
            String discountCode = "";
            if (discountSession != null) {
                discountCode = discountSession.getCode();
            }
            discountDAO discountDAO = new discountDAO();
            discountDTO discount = discountDAO.getOneDiscount(discountCode);

            dealDTO deal = new dealDTO();
            dealDAO dealDAO = new dealDAO();

            ArrayList<dealDetailDTO> carts = (ArrayList<dealDetailDTO>) session.getAttribute("CART");
            userDTO user = (userDTO) session.getAttribute("USER");

            float totalPrice = 0;

            if (discount.getCode() == null) {
                discount.setPercent(0);
            }
            for (dealDetailDTO cart : carts) {
                totalPrice = totalPrice + cart.getPrice();
            }
            float discountPrice = 0;
            if (discount.getCode() != null) {
                discountPrice = ((totalPrice * discount.getPercent()) / 100);
                deal.setDiscountId(discount.getId());
            } else {
                deal.setDiscountId(null);
            }

            totalPrice = totalPrice - discountPrice;

//            deal.setUserId(user.getId());
            deal.setUserId(user.getId());
            deal.setDiscountPirce(discountPrice);
            deal.setTotalPrice(totalPrice);
            bookDAO bookDAO = new bookDAO();
            for (dealDetailDTO cart : carts) {
                bookDTO book = bookDAO.getOneBook(cart.getBookId());
                System.out.println(cart.getQuantity());
                System.out.println(book.getQuantity() < cart.getQuantity());
                if (book.getQuantity() < cart.getQuantity()) {
                    error = "'" + book.getName() + "'" + " out of stock and only have " + book.getQuantity();
                }
            }
            if (error.equals("")) {
                statusDeal = dealDAO.confirmOrder(deal, carts);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (statusDeal) {
                HttpSession session = request.getSession();
                session.removeAttribute("CART");
                response.sendRedirect("listDeal");
            }
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
