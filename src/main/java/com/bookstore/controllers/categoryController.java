/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.daos.categoryDAO;
import com.bookstore.dtos.categoryDTO;
import com.bookstore.dtos.userDTO;
import java.io.IOException;
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
@WebServlet(name = "Category", urlPatterns = {"/Category"})
public class categoryController extends HttpServlet {

    private static final String CATEGORY_PAGE = "category.jsp";
    private static final String ERROR_PAGE = "error.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR_PAGE;
        try {
            HttpSession session = request.getSession();
            userDTO user = (userDTO) session.getAttribute("USER");
            request.setAttribute("user", user);
            categoryDAO categoryDAO = new categoryDAO();
            List<categoryDTO> listCate = categoryDAO.getAllCate();
            request.setAttribute("categories", listCate);
            url = CATEGORY_PAGE;
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
        try {
            String categoryName = request.getParameter("categoryName");

            categoryDAO categoryDAO = new categoryDAO();
            categoryDAO.insertNew(new categoryDTO(categoryName));
        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            response.sendRedirect("category");
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
