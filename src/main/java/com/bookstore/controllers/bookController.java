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
import com.bookstore.utils.SecureUUIDUtil;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Book", urlPatterns = {"/Book"})
@MultipartConfig
public class bookController extends HttpServlet {

    private static final String BOOK_PAGE = "book.jsp";
    private static final String ERROR_PAGE = "error.jsp";
    private static final int PAGE_SIZE = 20;

    protected void processResponse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR_PAGE;
        try {
            String bookName = request.getParameter("bookName") != null ? request.getParameter("bookName") : "";
            String categoryName = request.getParameter("categoryName") != null ? request.getParameter("categoryName") : "";
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

    private String saveImage(Part imgFile, String fileName, String fileType) throws IOException {
        BufferedImage image = ImageIO.read(imgFile.getInputStream());
        if (image != null) {
            String fullPath = getServletContext().getRealPath("/uploads");
            String ProjectPath = fullPath;
            File imageDir = new File(ProjectPath + File.separator + fileName + "." + fileType);
//            System.out.println(imageDir);
            imageDir.getParentFile().mkdirs();
            ImageIO.write(image, fileType, imageDir);
            return "./uploads/" + fileName + "." + fileType;
        } else {
            throw new IOException("Not " + fileType + " image");
        }
    }

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
        String imgDir = "";
        try {
            String title = request.getParameter("title");
//            String image = request.getParameter("image");
            String description = request.getParameter("description");
            String author = request.getParameter("author");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            //Date importDate = Date.valueOf(request.getParameter("importDate"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float price = Float.parseFloat(request.getParameter("price"));
            String name = request.getParameter("bookName");

            Part image = request.getPart("image");
            if (image != null) {
                if (image.getSize() > 0) {
                    String fileType = image.getContentType();
                    String imageFileName = SecureUUIDUtil.getSecureUUID();
                    switch (fileType) {
                        case "image/png":
                            imgDir = saveImage(image, imageFileName, "png");
                            break;
                        case "image/jpg":
                            imgDir = saveImage(image, imageFileName, "jpg");
                            break;
                        case "image/jpeg":
                            imgDir = saveImage(image, imageFileName, "jpg");
                            break;
                        case "image/gif":
                            imgDir = saveImage(image, imageFileName, "gif");
                            break;
                    }
                }
            }

            categoryDAO categoryDao = new categoryDAO();

            categoryDTO cate = categoryDao.getOneCate(categoryId);

            System.out.println(author);
            bookDAO bookDAO = new bookDAO();
            bookDAO.insertNewBook(new bookDTO(title, "", description, author, categoryId, cate.getCategoryName(), quantity, "active", price, name));
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
