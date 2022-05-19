/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Product;
import model.Rating;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ACER
 */
@MultipartConfig
public class ProductServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        Account a = (Account) session.getAttribute("user");
        ProductDAO pdao = new ProductDAO();
        List<Product> list = null;
        if (action == null) {
            int catid = Integer.parseInt(request.getParameter("catid"));
            list = pdao.getProductByCatid(catid);
            request.setAttribute("catid", catid);
        } else {
            if (action.equalsIgnoreCase("cat")) {
                int catid = Integer.parseInt(request.getParameter("catid"));
                list = pdao.getProductByCatid(catid);
                request.setAttribute(action, pdao);
            }
            if (action.equalsIgnoreCase("search")) {
                String key = request.getParameter("key");
                list = pdao.getProductByKey(key);
            } else if (action.equals("detail")) {
                int proid = Integer.parseInt(request.getParameter("proid"));
                Product p = pdao.getProductByID(proid);
//                String displayimg = request.getParameter("displayimg");
//                if (displayimg != null) {
//                    p.setDisplayimg(displayimg);
//                }

                request.setAttribute("p", p);
                request.setAttribute("displayimg", p.getDisplayimg());

                request.getRequestDispatcher("productDetail.jsp").forward(request, response);

            } else if (action.equals("all")) {
                list = pdao.getAll();
            }

        }
        request.setAttribute("plist", list);
        if (a != null) {
            if (a.getRoleid() == 3) {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

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
//        processRequest(request, response);
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        String action = request.getParameter("action");

        if (action != null) {
            HttpSession session = request.getSession();

            if (action.equalsIgnoreCase("insertRating")) {
                int proid = Integer.parseInt(request.getParameter("proid"));
                int point = Integer.parseInt(request.getParameter("rate"));
                String content = request.getParameter("content");
                String username = (String) session.getAttribute("username");
                Rating r = new Rating(proid, point, content, username);
                ProductDAO pdao = new ProductDAO();
                pdao.addRating(r);
                Product p = pdao.getProductByID(proid);
                p.addRatingToList(r);
                response.sendRedirect(request.getContextPath() + "/product?action=detail&proid=" + proid);

            }
        } else {

        }
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
