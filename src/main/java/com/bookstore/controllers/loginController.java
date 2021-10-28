/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.daos.userDAO;
import com.bookstore.dtos.userDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.naming.NamingException;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class loginController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(loginController.class.getName());
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String ERROR_PAGE = "error.jsp";
    private static final String HOME_PAGE = "home.jsp";

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
        String url = ERROR_PAGE;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            if (username == null || password == null) {
                url = LOGIN_PAGE;

            } else {
                userDAO dao = new userDAO();
                userDTO user = dao.checkLogin(username, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", user);
                    System.out.println(user.getFullName() + " " + user.getRoleID());
                    url = HOME_PAGE;
                } else {
                    request.setAttribute("MSG_ERROR", "Invalid username or password");
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException | NamingException ex) {
            request.setAttribute("ERROR", "Some thing was wrong");
            url = ERROR_PAGE;
        } finally {
            if (url.equals(HOME_PAGE)) {
                response.sendRedirect("home");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        }
    }

    protected void processResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR_PAGE;
        try {
            url = LOGIN_PAGE;
        } catch (Exception ex) {
            request.setAttribute("ERROR", "Some thing was wrong");
            url = ERROR_PAGE;
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
