/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.ProductDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.CartItem;
import model.Product;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addtocart"})
public class AddToCartServlet extends HttpServlet {

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
            out.println("<title>Servlet AddToCartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartServlet at " + request.getContextPath() + "</h1>");
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

        int quantity = 0;
        if(!action.equals("delete")) 
            quantity = Integer.parseInt(request.getParameter("quantity"));
        int proid = Integer.parseInt(request.getParameter("proid"));
       
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        
        List<CartItem> cartList = (List<CartItem>) session.getAttribute("cartList");
        boolean exist = false;
        //duyrt
        CartDAO cartd = new CartDAO();
        int cartid = cartd.getCartIdByAccount(a);
        //lay tu csdl
        ProductDAO pdao = new ProductDAO();
        Product p = pdao.getProductByID(proid);
        
        if(action.equals("add")){
            for(CartItem c: cartList){
            int id = c.getProduct().getProid();
            if(id==proid){
                exist = true;
                int currentQuantity = c.getQuantity();
                c.setQuantity(quantity+currentQuantity);
                //tang so luong
                cartd.updateCart(cartid, quantity+currentQuantity, p);
            }
        }
        // khong co proid trong gio hang
        if(!exist){
            
            
            cartList.add(new CartItem(quantity,p));
            //them moi gioop hang
            // cap nhat csdl
            
            cartd.addToCart(cartid, quantity, p);
        }
        }
        else if(action.equals("delete")){
            // xoa khoi man hinh
            for(CartItem c: cartList){
                Product pp = c.getProduct();
                if(pp.getProid()== proid) {
                        cartList.remove(c);
                        break;
                }
                
            }
            //xoa trong csdl
            cartd.deleteFromCart(cartid, p);
        }
        else if(action.equals("update")){
            for(CartItem c: cartList){
            int id = c.getProduct().getProid();
            if(id==proid){
                c.setQuantity(quantity);
                //cap nhat sl
                cartd.updateCart(cartid, quantity, p);
                break;
            }
        }
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
        
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
        String action = request.getParameter("action");

        int quantity = 0;
        if(!action.equals("delete")) 
            quantity = Integer.parseInt(request.getParameter("quantity"));
        int proid = Integer.parseInt(request.getParameter("proid"));

        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        
        List<CartItem> cartList = (List<CartItem>) session.getAttribute("cartList");
        boolean exist = false;
        //duyrt
        CartDAO cartd = new CartDAO();
        int cartid = cartd.getCartIdByAccount(a);
        //lay tu csdl
        ProductDAO pdao = new ProductDAO();
        Product p = pdao.getProductByID(proid);
        
        if(action.equals("add")){
            for(CartItem c: cartList){
            int id = c.getProduct().getProid();
            if(id==proid){
                exist = true;
                int currentQuantity = c.getQuantity();
                c.setQuantity(quantity+currentQuantity);
                //tang so luong
                cartd.updateCart(cartid, quantity+currentQuantity, p);
            }
        }
        // khong co proid trong gio hang
        if(!exist){
            
            
            cartList.add(new CartItem(quantity,p));
            //them moi gioop hang
            // cap nhat csdl
            
            cartd.addToCart(cartid, quantity, p);
        }
        }
        else if(action.equals("delete")){
            // xoa khoi man hinh
            for(CartItem c: cartList){
                Product pp = c.getProduct();
                if(pp.getProid()== proid) {
                        cartList.remove(c);
                        break;
                }
                
            }
            //xoa trong csdl
            cartd.deleteFromCart(cartid, p);
        }
        else if(action.equals("update")){
            for(CartItem c: cartList){
            int id = c.getProduct().getProid();
            if(id==proid){
                c.setQuantity(quantity);
                //cap nhat sl
                cartd.updateCart(cartid, quantity, p);
                break;
            }
        }
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
        
              
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
