/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controllers;

import com.bookstore.daos.dealDAO;
import com.bookstore.dtos.dealDetailDTO;
import com.bookstore.dtos.dealHistoryDTO;
import com.bookstore.dtos.dealList;
import com.bookstore.dtos.discountDTO;
import com.bookstore.dtos.userDTO;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ListDeal", urlPatterns = {"/ListDeal"})
public class listDealController extends HttpServlet {

    private static final String LIST_DEAL_PAGE = "listDeal.jsp";
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR_PAGE;
        try {
            String bookName = request.getParameter("bookName") != null ? request.getParameter("bookName") : "";
            String createDate = request.getParameter("createDate") != null ? request.getParameter("createDate") : "";

            HttpSession session = request.getSession();
            ArrayList<dealDetailDTO> carts = (ArrayList<dealDetailDTO>) session.getAttribute("CART");
//            System.out.println(carts);
            userDTO user = (userDTO) session.getAttribute("USER");
            request.setAttribute("user", user);
            request.setAttribute("carts", carts);
            discountDTO discountSession = (discountDTO) session.getAttribute("DISCOUNT");
            if (discountSession != null) {
                System.out.println(discountSession.getPercent());
            }
            dealDAO dealDAO = new dealDAO();
            String userId = "";
//            if (!user.getRoleID().equals("admin")) {
//                userId = user.getId();
//            }
            List<dealList> dealLists = dealDAO.getAllDeal(userId);
            ArrayList<dealHistoryDTO> dealHis = new ArrayList<>();

            for (dealList dealList : dealLists) {
                for (dealHistoryDTO dealHi : dealHis) {
//                    if (dealHi.getId().equals(dealList.getId())) {
//                        dealHistoryDTO dealH = new dealHistoryDTO();
//                        dealH.setId(dealList.getId());
//                        dealH.setFullName(dealList.getFullName());
//                        dealH.setDiscountPrice(dealList.getDiscountPrice());
//                        dealH.setTotalPrice(dealList.getTotalPrice());
//                        dealH.setCreatDate(dealList.getCreatDate());
//                        dealHis.add(dealH);
//                    }
                }
            }

//            dealLists.forEach(dealList -> {
//                if (!dealHis.stream().anyMatch(b -> b.getId().equals(dealList.getId()))) {
//                    dealHistoryDTO dealH = new dealHistoryDTO();
//                    dealH.setId(dealList.getId());
//                    dealH.setFullName(dealList.getFullName());
//                    dealH.setDiscountPrice(dealList.getDiscountPrice());
//                    dealH.setTotalPrice(dealList.getTotalPrice());
//                    dealH.setCreatDate(dealList.getCreatDate());
//                    dealHis.add(dealH);
//                }
//            });
            for (dealHistoryDTO dealHistory : dealHis) {
                ArrayList<dealList> dealListG = new ArrayList<>();
                for (dealList dealList : dealLists) {
//                    if (dealHistory.getId().equals(dealList.getId())) {
//                        dealList dealH = new dealList();
//                        dealH.setId(dealList.getId());
//                        dealH.setFullName(dealList.getFullName());
//                        dealH.setDiscountPrice(dealList.getDiscountPrice());
//                        dealH.setTotalPrice(dealList.getTotalPrice());
//                        dealH.setPrice(dealList.getPrice());
//                        dealH.setQuantity(dealList.getQuantity());
//                        dealH.setBookName(dealList.getBookName());
//                        dealListG.add(dealH);
//                    }
                }
//                dealLists.forEach(dealList -> {
//                    if (dealHistory.getId().equals(dealList.getId())) {
//                        dealList dealH = new dealList();
//                        dealH.setId(dealList.getId());
//                        dealH.setFullName(dealList.getFullName());
//                        dealH.setDiscountPrice(dealList.getDiscountPrice());
//                        dealH.setTotalPrice(dealList.getTotalPrice());
//                        dealH.setPrice(dealList.getPrice());
//                        dealH.setQuantity(dealList.getQuantity());
//                        dealH.setBookName(dealList.getBookName());
//                        dealListG.add(dealH);
//                    }
//                });
                dealHistory.setDealList(dealListG);
            }
//            dealHis.forEach(dealHistory -> {
//                ArrayList<dealList> dealListG = new ArrayList<>();
//                dealLists.forEach(dealList -> {
//                    if (dealHistory.getId().equals(dealList.getId())) {
//                        dealList dealH = new dealList();
//                        dealH.setId(dealList.getId());
//                        dealH.setFullName(dealList.getFullName());
//                        dealH.setDiscountPrice(dealList.getDiscountPrice());
//                        dealH.setTotalPrice(dealList.getTotalPrice());
//                        dealH.setPrice(dealList.getPrice());
//                        dealH.setQuantity(dealList.getQuantity());
//                        dealH.setBookName(dealList.getBookName());
//                        dealListG.add(dealH);
//                    }
//                });
//                dealHistory.setDealList(dealListG);
//            });
            request.setAttribute("dealHistory", dealHis);
            request.setAttribute("discount", discountSession);
            url = LIST_DEAL_PAGE;
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
