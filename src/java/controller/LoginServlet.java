/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.CategoryDAO;
import dal.OrderDAO;
import dal.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.Category;
import model.OrderItem;

/**
 *
 * @author ACER
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsersDAO u = new UsersDAO();
        if (u.logincheck(username, password) != null) {
            HttpSession session = request.getSession();
            Account a = u.logincheck(username, password);
            session.setAttribute("user", a);
            session.setAttribute("u", u.getUserByAccount(username, password));

            if (a.getRoleid() == 1) {
//            session.setAttribute("account", u.logincheck(username, password));
                session.setAttribute("username", username);
                session.setAttribute("fullname", u.getUserByAccount(username, password).getFullname());
                CartDAO cartd = new CartDAO();
                int cartid = cartd.getCartIdByAccount(a);
                List<CartItem> cartList = cartd.getListItem(cartid);
                session.setAttribute("cartList", cartList);
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("utf-8");
                CategoryDAO cdao = new CategoryDAO();
                List<Category> list = cdao.getAllCategory();
                session.setAttribute("category", list);
                OrderDAO odao = new OrderDAO();
                List<OrderItem> history = odao.historyItem(username);
                session.setAttribute("history", history);
                response.sendRedirect(request.getContextPath()+"/home");
            } else if (a.getRoleid() == 2) {
                response.sendRedirect(request.getContextPath() + "/admin?action=viewOrder");
            } else if (a.getRoleid() == 3) {
                response.sendRedirect(request.getContextPath() + "/admin");
            }
        } else {
            request.setAttribute("errorlogin", "Sai thong tin dang nhap");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
