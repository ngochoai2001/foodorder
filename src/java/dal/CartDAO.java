/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.CartItem;
import model.Product;

/**
 *
 * @author ACER
 */
public class CartDAO extends DBContext{
    public List<Product> getCartItem(){
        
        
        
        
        return null;
    }
    public int getCartIdByAccount(Account a){
        String username = a.getUsername();
//        int cartid = 
        String sql = "select * from Cart where username = (?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                int cartid = rs.getInt("cartid");
                return cartid;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
    public List<CartItem> getListItem(int cartid){
        String sql = "select * from CartItem c, Product p where p.proid = c.proid and cartid = (?)";
        List<CartItem> list = new ArrayList<>();
        try{
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartid);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int proid = rs.getInt("proid");
                String name = rs.getString("name");
                int catid = rs.getInt("catid");
                float price = rs.getFloat("price");
                String describe = rs.getString("describe");
                ProductDAO pdao = new  ProductDAO();
                List<String> imgurl = pdao.getImgUrlByProId(proid);
                Product p = new Product(proid, catid, name, describe, price, imgurl);
                CartItem e = new CartItem(rs.getInt("quantity"), p);
                list.add(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return list;
    }
    public int addToCart(int cartid, int quantity, Product p){
        String sql = "insert into CartItem (cartid, proid, quantity) values (?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartid);
            st.setInt(2, p.getProid());
            st.setInt(3, quantity);
            int res = st.executeUpdate();
            return res;
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
        return 0;
    }
    public int deleteFromCart(int cartid, Product p){
        String sql = "delete from CartItem where cartid = (?) and proid = (?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartid);
            st.setInt(2, p.getProid());
            int res = st.executeUpdate();
            return res;
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
    public int updateCart(int cartid, int newquantity, Product p){
        String sql = "update CartItem set quantity = (?) where cartid = (?) and proid = (?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, newquantity);
            st.setInt(2, cartid);
            st.setInt(3, p.getProid());
            return st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
    public static void main(String[] args) {
        CartDAO cartdao = new CartDAO();
        Product p = new Product();
        p.setProid(2);
//        System.out.println(cartdao.addToCart(6, 2, p));
        System.out.println(cartdao.deleteFromCart(6, p));
        
    }
}
