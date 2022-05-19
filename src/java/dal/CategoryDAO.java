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
import model.Category;
import model.Product;

/**
 *
 * @author ACER
 */
public class CategoryDAO extends DBContext{
    public Category getCatById(int catid){
        String sql = "select * from Category";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
   
    public List<Category> getAllCategory(){
        ArrayList<Category> list = new ArrayList<>();
        try{
            String sql = "select * from Category";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int catid = rs.getInt("catid");
                String name = rs.getString("name");
                String imgurl = rs.getString("imgurl");
                Category c = new Category(catid, name, imgurl);
                list.add(c);
                
            }
            return list;
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
        
        return null;
    }
//    public boolean addCategory(Category c) {
//        String sqlAddPro = "insert into Category(name, catid, price, describe) values (?, ?,?, ?)";
//        boolean res = true;
//        try {
//            connection.setAutoCommit(false);
//            PreparedStatement stAddPro = connection.prepareStatement(sqlAddPro);
//            stAddPro.setString(1, p.getName());
//            stAddPro.setInt(2, p.getCatid());
//            stAddPro.setFloat(3, p.getPrice());
//            stAddPro.setString(4, p.getDescribe());
//            stAddPro.executeUpdate();
//            //get id of the new inserted product
//            ResultSet generatedKeys = stAddPro.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                p.setProid(generatedKeys.getInt(1));
//                //insertIamge
//                for (String i : p.getImg()) {
//                    String sqlAddProImg = "insert into Image(proid, imgurl) values(?,?)";
//                    PreparedStatement stAddProImg = connection.prepareStatement(sqlAddProImg);
//                    stAddProImg.setInt(1, p.getProid());
//                    stAddProImg.setString(2, i);
//                    stAddProImg.executeUpdate();
//                }
//            }
//        } catch (Exception e) {
//            res = false;
//            try {
//                connection.rollback();
//            } catch (Exception ex) {
//                res = false;
//                ex.printStackTrace();
//            }
//            e.printStackTrace();
//        } finally {
//            try {
//                //con.setAutoCommit(true);//set this line into comment in JUnit test mode
//            } catch (Exception ex) {
//                res = false;
//                ex.printStackTrace();
//            }
//        }
//        return res;
//    }
    public void deleteCategory(int catid){
        
    }
    public static void main(String[] args) {
        CategoryDAO cdao = new CategoryDAO();
        ArrayList<Category> list = (ArrayList<Category>) cdao.getAllCategory();
        for(Category c: list){
            System.out.println(c);
        }
    }
}
