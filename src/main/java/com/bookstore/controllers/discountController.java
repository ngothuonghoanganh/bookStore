/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.daos.discountDAO;
import com.bookstore.dtos.discountDTO;
import com.bookstore.dtos.userDTO;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Discount", urlPatterns = {"/Discount"})
public class discountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String DISCOUNT_PAGE = "discount.jsp";
    private static final String ERROR_PAGE = "error.jsp";
    private static final String SEARCH_CONTROLLER = "SearchServlet";

    protected void processResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR_PAGE;
        try {
            HttpSession session = request.getSession();
            userDTO user = (userDTO) session.getAttribute("USER");
            request.setAttribute("user", user);

            discountDAO categoryDAO = new discountDAO();
            List<discountDTO> discounts = categoryDAO.getAllDiscounts();
            request.setAttribute("discounts", discounts);
            url = DISCOUNT_PAGE;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String error = "";
        try {
            String discountCode = request.getParameter("discountCode");
            System.out.println(request.getParameter("startDate"));
//            System.out.println(Date.valueOf(request.getParameter("startDate")));
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));

            discountDTO discountDTO = new discountDTO();
            discountDTO.setDiscountCode(discountCode);
            discountDTO.setStartDate(startDate);
            discountDTO.setEndDate(endDate);
            discountDTO.setPercent(discountPercent);

            discountDAO discountDAO = new discountDAO();
            boolean success = discountDAO.insertNew(discountDTO);
            if (!success) {
                error = "Add new Discount fail";
            }
        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            if (!error.equals("")) {
                response.sendRedirect("Discount?message=" + error);
            } else {
                response.sendRedirect("Discount");
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
        processResponse(request, response);
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
