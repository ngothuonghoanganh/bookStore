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
import com.bookstore.dtos.userDTO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListBookToBuy", urlPatterns = {"/ListBookToBuy"})
public class listBookToBuyController extends HttpServlet {

    private static final String BOOK_PAGE = "listBuyBook.jsp";
    private static final String ERROR_PAGE = "error.jsp";
    private static final int PAGE_SIZE = 20;

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
        String url = ERROR_PAGE;
        try {
            String bookName = request.getParameter("bookName") != null ? request.getParameter("bookName") : "";
            String categoryName = request.getParameter("categoryName") != null ? request.getParameter("categoryName") : "";
            int page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 0;
            float minPrice = (request.getParameter("minPrice") != null && !request.getParameter("minPrice").equals("")) ? Float.parseFloat(request.getParameter("minPrice")) : 0;
            float maxPrice = (request.getParameter("maxPrice") != null && !request.getParameter("maxPrice").equals("")) ? Float.parseFloat(request.getParameter("maxPrice")) : 100000000;

            url = BOOK_PAGE;
            categoryDAO categoryDAO = new categoryDAO();
            List<categoryDTO> listCate = categoryDAO.getAllCate();
            request.setAttribute("categories", listCate);

            bookDAO bookDAO = new bookDAO();
            int countBook = 0;
            int paging = (int) Math.ceil(countBook / 20);
            List<bookDTO> listBook = bookDAO.getAllBook();
            request.setAttribute("books", listBook);
            request.setAttribute("paging", paging);
            request.setAttribute("bookName", bookName);
            request.setAttribute("categoryName", categoryName);
            request.setAttribute("minPrice", minPrice);
            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("page", page);

            HttpSession session = request.getSession();
            userDTO user = (userDTO) session.getAttribute("USER");
            request.setAttribute("user", user);

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
