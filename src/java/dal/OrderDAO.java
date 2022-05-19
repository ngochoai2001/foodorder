/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Account;
import model.CartItem;
import model.Order;
import model.OrderItem;
import model.Users;

/**
 *
 * @author ACER String sql1 = "insert into Users(fullname, gender) values(?,?)";
 * String sql = "SELECT @@IDENTITY as LastID";
 */
public class OrderDAO extends DBContext {

    public boolean insertOrder(Order o) {
        String sql = "insert into  Orders(username, adddate,status) values(?,?,?) ";
        String sql2 = "SELECT @@IDENTITY as orderid";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st.setString(1, o.getUsername());
            st.setDate(2, new java.sql.Date(o.getAdddate().getTime()));
            st.setString(3, o.getStatus());
            int test = st.executeUpdate();

            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                int orderid = rs.getInt("orderid");
                o.setOrderid(orderid);
            }

            if (test == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean insertOrderItem(CartItem c, int orderid) {
        String sql = "insert into OrderItem(orderid, proid,quantity) values(?,?,?) ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderid);
            st.setInt(2, c.getProduct().getProid());
            st.setInt(3, c.getQuantity());
            int test = st.executeUpdate();
            if (test == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public List<OrderItem> historyItem(String username) {
        //orderid cua username
        String sql = "select * from OrderItem o1, Orders o2 where o1.orderid=o2.orderid and  o2.username = ?";
        List<OrderItem> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            ProductDAO pdao = new ProductDAO();
            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                int proid = rs.getInt("proid");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                Date orderDate = rs.getDate("adddate");
                OrderItem oi = new OrderItem(orderid, new CartItem(quantity, pdao.getProductByID(proid)), status, orderDate);
                list.add(oi);

            }
            Collections.sort(list, new Comparator<OrderItem>() {
                @Override
                public int compare(OrderItem t, OrderItem t1) {
                    return -t.getOrderDate().compareTo(t1.getOrderDate());
                }
            });
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<OrderItem> getListOrderItem(Order o) {
        //orderid cua username
        String sql = "select * from OrderItem o1, Orders o2 where o1.orderid=o2.orderid and  o2.username = ? and o2.orderid = ?";
        List<OrderItem> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, o.getUsername());
            st.setInt(2, o.getOrderid());
            ResultSet rs = st.executeQuery();
            ProductDAO pdao = new ProductDAO();
            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                int proid = rs.getInt("proid");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                Date orderDate = rs.getDate("adddate");
                OrderItem oi = new OrderItem(orderid, new CartItem(quantity, pdao.getProductByID(proid)), status, orderDate);
                list.add(oi);

            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean changeStatus(int orderid, String status) {
        String sql = "update Orders set status = ? where orderid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            st.setInt(2, orderid);
            st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public List<Order> AllItem() {
        //orderid cua username
        String sql = "select * from OrderItem o1, Orders o2 where o1.orderid=o2.orderid ";
        List<OrderItem> list = new ArrayList();
        List<Order> lo = this.getOrder();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            ProductDAO pdao = new ProductDAO();
            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                int proid = rs.getInt("proid");
                int quantity = rs.getInt("quantity");
                String status = rs.getString("status");
                Date orderDate = rs.getDate("adddate");
                OrderItem oi = new OrderItem(orderid, new CartItem(quantity, pdao.getProductByID(proid)), status, orderDate);
                list.add(oi);
                for(Order o: lo){
                    if(o.getOrderid()==orderid){
                        o.getList().add(oi);
                        break;
                    }
                }
                
            }
            Collections.sort(list, new Comparator<OrderItem>() {
                @Override
                public int compare(OrderItem t, OrderItem t1) {
                    return -t.getOrderDate().compareTo(t1.getOrderDate());
                }
            });
            return lo;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lo;
    }

    public List<Order> getOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from Orders o , Account a, Users u where o.username=a.username and a.userid = u.userid";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                
                Account a = new Account();
                a.setUsername(rs.getString("username"));
                Users u = new Users();
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setAddress(rs.getString("address"));
                a.setU(u);
                String status = rs.getString("status");
                Date orderDate = rs.getDate("adddate");
                List<OrderItem> lo = new ArrayList<>();
                Order o = new Order();
                o.setList(lo);
                o.setOrderid(orderid);
                o.setA(a);
                o.setAdddate(orderDate);
                o.setStatus(status);
                list.add(o);

                
            }
            Collections.sort(list, new Comparator<Order>() {
                @Override
                public int compare(Order t, Order t1) {
                    return -t.getAdddate().compareTo(t1.getAdddate());
                }
            });
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
