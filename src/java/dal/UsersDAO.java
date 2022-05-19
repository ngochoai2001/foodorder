/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Product;
import model.Users;

/**
 *
 * @author ACER
 */
public class UsersDAO extends DBContext{
    
     public int update(Users u){
        String sql = "update Users set fullname= (?), email=(?), phone=(?), address=(?) where userid = (?) ";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            String fullname = u.getFullname();
            st.setString(1, fullname);
            st.setString(2, u.getEmail());
            st.setString(3, u.getPhone());
            st.setString(4, u.getAddress());
            st.setInt(5, u.getUserid());
            return st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
    public boolean insertUser(Users user, Account a){
        
        String sql1 = "insert into Users(fullname, gender) values(?,?)";
        String sql = "SELECT @@IDENTITY as LastID";
        String sql2 = "insert into Account (username, password, roleid, userid) values(?,?,?,?)";
        String sql3 = "insert into Cart (username) values (?) ";
        try{
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setString(1, user.getFullname());
            st1.setInt(2, user.getGender());
            int run = st1.executeUpdate();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            int userid  = 0;
            if(rs.next()){
                userid = rs.getInt("LastID");
                System.out.println(userid);
            }
            PreparedStatement st2 = connection.prepareStatement(sql2);
            PreparedStatement st3 = connection.prepareStatement(sql3);
            st2.setString(1, a.getUsername());
            st2.setString(2, a.getPassword());
            st2.setInt(3, 1);
            st2.setInt(4, userid);
            if(run!=0) st2.executeUpdate();
            else return false;
            st3.setString(1, a.getUsername());
            st3.executeUpdate();
            return true;
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
              
        return false;
    }
    public boolean checkTrung(String username){
        String sql = "select * from Account where username = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            return rs.next();
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
        
        
    }
    public Account logincheck(String username,String password){
        String sql = "select * from Account where username = ? and password = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            int roleid = 1, userid = 0;
            while(rs.next()){
                roleid = rs.getInt("roleid");
                userid = rs.getInt("userid");
                return new Account(userid, roleid, username, password);

            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public Users getUserByAccount(String username, String password){
        Account a = logincheck(username, password);
        String sql = "select * from Users where userid = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getUserid());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int gender = rs.getInt("gender");
                
                return new Users(a.getUserid(), gender, fullname, email, phone, address);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
