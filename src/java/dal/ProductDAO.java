/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Rating;

/**
 *
 * @author ACER
 */
public class ProductDAO extends DBContext {

    public List<String> getImgUrlByProId(int proid) {
        String sql = "select * from Image where proid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, proid);
            ResultSet rs = st.executeQuery();
            List<String> imgurl = new ArrayList<String>();
            while (rs.next()) {
                imgurl.add(rs.getString("imgurl"));
            }
            return imgurl;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByCatid(int catid) {
        String sql = "select * from Product where catid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, catid);
            ResultSet rs = st.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                int proid = rs.getInt("proid");
                String name = rs.getString("name");
//                int catid = rs.getInt("catid");
                float price = rs.getFloat("price");
                String describe = rs.getString("describe");

                List<String> imgurl = getImgUrlByProId(proid);
                List<Rating> rating = getRating(proid);
                Product p = new Product(proid, catid, name, describe, price, imgurl, rating);
                list.add(p);

            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public List<Product> getAll() {
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                int proid = rs.getInt("proid");
                String name = rs.getString("name");
                int catid = rs.getInt("catid");
                float price = rs.getFloat("price");
                String describe = rs.getString("describe");
                int available = rs.getInt("available");
                List<String> imgurl = getImgUrlByProId(proid);
                List<Rating> rating = getRating(proid);
                Product p = new Product(proid, catid, name, describe, price, imgurl, rating, available);
                if(available==1) list.add(p);
            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    public List<Product> getAllAdmin() {
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                int proid = rs.getInt("proid");
                String name = rs.getString("name");
                int catid = rs.getInt("catid");
                float price = rs.getFloat("price");
                String describe = rs.getString("describe");
                int available = rs.getInt("available");
                List<String> imgurl = getImgUrlByProId(proid);
                List<Rating> rating = getRating(proid);
                Product p = new Product(proid, catid, name, describe, price, imgurl, rating, available);
                list.add(p);
            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public Product getProductByID(int id) {
        String sql = "Select * from Product where proid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int proid = rs.getInt("proid");
                String name = rs.getString("name");
                int catid = rs.getInt("catid");
                float price = rs.getFloat("price");
                String describe = rs.getString("describe");
                int available = rs.getInt("available");

                List<String> imgurl = getImgUrlByProId(proid);
                List<Rating> rating = getRating(proid);
                Product p = new Product(proid, catid, name, describe, price, imgurl, rating,available);
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByKey(String key) {
        String sql = "select * from Product where name like ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                int catid = rs.getInt("catid");
                int proid = rs.getInt("proid");
                String name = rs.getString("name");
//                int catid = rs.getInt("catid");
                float price = rs.getFloat("price");
                String describe = rs.getString("describe");
                int available = rs.getInt("available");
                List<String> imgurl = getImgUrlByProId(proid);
                List<Rating> rating = getRating(proid);
                Product p = new Product(proid, catid, name, describe, price, imgurl, rating, available);
                list.add(p);

            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public List<Rating> getRating(int proid) {
        List<Rating> rating = new ArrayList<>();
        String sql = "select * from Rating where proid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, proid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int point = rs.getInt("point");
                String content = rs.getString("content");
                String username = rs.getString("username");
                Rating r = new Rating(id, proid, point, content, username);
                rating.add(r);
            }
            return rating;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rating;
    }

    public boolean addRating(Rating rating) {
        String sql = "insert into Rating(proid, point, content, username) values(?, ?, ?, ?)";
        String sql2 = "SELECT @@IDENTITY as LastID";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st.setInt(1, rating.getProid());
            st.setInt(2, rating.getPoint());
            st.setString(3, rating.getContent());
            st.setString(4, rating.getUsername());
            st.executeUpdate();
            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                rating.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addProduct(Product p) {
        String sqlAddPro = "insert into Product(name, catid, price, describe) values (?, ?,?, ?)";
        boolean res = true;
        try {
            connection.setAutoCommit(false);
            PreparedStatement stAddPro = connection.prepareStatement(sqlAddPro, Statement.RETURN_GENERATED_KEYS);
            stAddPro.setString(1, p.getName());
            stAddPro.setInt(2, p.getCatid());
            stAddPro.setFloat(3, p.getPrice());
            stAddPro.setString(4, p.getDescribe());
            int s = stAddPro.executeUpdate();
            //get id of the new inserted product
            ResultSet generatedKeys = stAddPro.getGeneratedKeys();
            if (generatedKeys.next()) {
                p.setProid(generatedKeys.getInt(1));
                //insertIamge
                for (String i : p.getImg()) {
                    String sqlAddProImg = "insert into Image(proid, imgurl) values(?,?)";
                    PreparedStatement stAddProImg = connection.prepareStatement(sqlAddProImg);
                    stAddProImg.setInt(1, p.getProid());
                    stAddProImg.setString(2, i);
                    int x  = stAddProImg.executeUpdate();
                }
            }
        } catch (Exception e) {
            res = false;
            try {
                connection.rollback();
            } catch (Exception ex) {
                res = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);//set this line into comment in JUnit test mode
            } catch (Exception ex) {
                res = false;
                ex.printStackTrace();
            }
        }
        return res;
    }
    public boolean updatePro(Product p){
         String sqlAddPro = "update Product set name = ? , catid = ?, price = ?, describe = ?,  available = ? where proid = ?";
        boolean res = true;
        try {
            PreparedStatement stAddPro = connection.prepareStatement(sqlAddPro, Statement.RETURN_GENERATED_KEYS);
            stAddPro.setString(1, p.getName());
            stAddPro.setInt(2, p.getCatid());
            stAddPro.setFloat(3, p.getPrice());
            stAddPro.setString(4, p.getDescribe());
            stAddPro.setInt(5, p.getAvailable());
            stAddPro.setInt(6, p.getProid());
            int s = stAddPro.executeUpdate();
            //get id of the new inserted product
           
        } catch (Exception e) {
            res = false;
        }
        return res;
    }
    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        System.out.println(pdao.getProductByKey("cháo").size());
    }

    public void deletePhoto(int proid, String img) {
        String sql = "delete from Image where proid = ? and imgurl = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, proid);
            st.setString(2, img);
            int x = st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void updateImage(Product p, List<String>newImg) {
        try{
        for (String i : newImg) {
                    String sqlAddProImg = "insert into Image(proid, imgurl) values(?,?)";
                    PreparedStatement stAddProImg = connection.prepareStatement(sqlAddProImg);
                    stAddProImg.setInt(1, p.getProid());
                    stAddProImg.setString(2, i);
                    int x  = stAddProImg.executeUpdate();
                }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
