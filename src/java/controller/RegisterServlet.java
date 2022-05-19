/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Users;

/**
 *
 * @author ACER
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (action.equals("changeProfile")) {
            request.getRequestDispatcher("changeProfile.jsp").forward(request, response);

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
            if (action.equals("change")) {
                HttpSession session = request.getSession();
                Account a = (Account) session.getAttribute("user");
                session.removeAttribute("user");

                String fullname = request.getParameter("fullname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                UsersDAO udao = new UsersDAO();
                Users u = udao.getUserByAccount(a.getUsername(), a.getPassword());
                u.setFullname(fullname);
                u.setEmail(email);
                u.setAddress(address);
                u.setPhone(phone);
                int test = udao.update(u);

                session.setAttribute("user", a);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            }
        } else {
            String fullname = request.getParameter("fullname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String gen = request.getParameter("gender");
            int gender = 0;
            if (gen.equalsIgnoreCase("1")) {
                gender = 1;
            }
            UsersDAO u = new UsersDAO();
            if (u.checkTrung(username)) {
                request.setAttribute("res", "Tên đăng nhập đã tồn tại");
                request.getRequestDispatcher("register.jsp").forward(request, response);

            } else {
                Account a = new Account(1, username, password);
                Users user = new Users(gender, fullname);
                boolean check = u.insertUser(user, a);
                request.setAttribute("res", "Đăng kí thành công");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

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
