/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.OrderDAO;
import dal.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
//import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.CartItem;
import model.Order;
import model.OrderItem;
import model.Users;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ACER
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

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
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
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
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) session.getAttribute("username");
        OrderDAO odao = new OrderDAO();

        if (action == null) {
            Account a = (Account) session.getAttribute("user");
            UsersDAO udao = new UsersDAO();
            Users u = udao.getUserByAccount(a.getUsername(), a.getPassword());
            if (u.getAddress() == null || u.getPhone() == null) {
                response.sendRedirect("changeProfile.jsp");
            } else {
                request.getRequestDispatcher("bill.jsp").forward(request, response);
            }
        } else {
            if (action.equals("viewHistory")) {
                List<OrderItem> history = odao.historyItem(username);
                session.setAttribute("history", history);
                request.getRequestDispatcher("viewHistory.jsp").forward(request, response);
            } else if (action.equals("change")) {
                response.sendRedirect("changeProfile.jsp");
            } else if (action.endsWith("changeStatus")) {
                String status = request.getParameter("status");
                int orderid = Integer.parseInt(request.getParameter("orderid"));
                odao.changeStatus(orderid, status);
                session.removeAttribute("history");
                session.setAttribute("history", odao.AllItem());
                request.getRequestDispatcher("viewHistory.jsp").forward(request, response);

            }
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

        HttpSession session = request.getSession();
        OrderDAO odao = new OrderDAO();
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");
        if (action == null) {
            List<CartItem> list = (List<CartItem>) session.getAttribute("cartList");
            Account a = (Account) session.getAttribute("user");

            Date adddate = new Date();
            String status = "Đặt hàng thành công";
            Order o = new Order(username, adddate, status);

            odao.insertOrder(o);
            UsersDAO udao = new UsersDAO();
            //insert order thanh cong se co orderid
            CartDAO cdao = new CartDAO();
            int orderid = o.getOrderid();
            for (CartItem c : list) {
                odao.insertOrderItem(c, orderid);
                cdao.deleteFromCart(cdao.getCartIdByAccount(a), c.getProduct());
            }
            list.removeAll(list);
            if(session.getAttribute("history")!=null){
                session.removeAttribute("history"); //xoa lich su san co
                session.setAttribute("history", odao.historyItem(username));
            }
            request.getRequestDispatcher("viewHistory.jsp").forward(request, response);

        }else if (action.endsWith("changeStatus")) {
                String status = request.getParameter("status");
                int orderid = Integer.parseInt(request.getParameter("orderid"));
                boolean check = odao.changeStatus(orderid, status);
                session.removeAttribute("history");
                session.setAttribute("history", odao.AllItem());
                request.getRequestDispatcher("listOrder.jsp").forward(request, response);

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
