/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Product implements Serializable {

    private int proid, catid;
    private String name, describe;
    private float price;
    private List<String> img;
    private String displayimg;
    private List<Rating> rating;
    private int available;

    public Product(int proid, int catid, String name, String describe, float price, List<String> img, String displayimg, List<Rating> rating, int available) {
        this.proid = proid;
        this.catid = catid;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.img = img;
        this.displayimg = displayimg;
        this.rating = rating;
        this.available = available;
    }

    public Product() {
    }

    public Product(int proid, int catid, String name, String describe, float price, List<String> img, List<Rating> rating, int available) {
        this.proid = proid;
        this.catid = catid;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.img = img;
        if(img.size()!=0)
        this.displayimg = img.get(0);
        this.rating = rating;
        this.available = available;
    }

    public Product(int proid, int catid, String name, String describe, float price, List<String> img, List<Rating> rating) {
        this.proid = proid;
        this.catid = catid;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.img = img;
        this.displayimg = img.get(0);
        this.rating = rating;
    }

    public Product(int catid, String name, String describe, float price, List<String> img) {
        this.catid = catid;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.img = img;
    }

    public Product(int proid, int catid, String name, String describe, float price, List<String> img) {
        this.proid = proid;
        this.catid = catid;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.displayimg = img.get(0);
        this.img = img;
    }

    public Product(int catid, String name, String describe, float price, List<String> img, int available) {
        this.catid = catid;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.img = img;
        this.available = available;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public String getDisplayimg() {
        return displayimg;
    }

    public void setDisplayimg(String displayimg) {
        this.displayimg = displayimg;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    public void addRatingToList(Rating r) {
        this.rating.add(r);
    }
    public int getPointRating(){
        int point = 0;
        for(Rating r: rating){
            point+=r.getPoint();
        }
        if(rating.size()!=0) return point/rating.size();
        return 0;
    }
    public String toString() {
        return "" + proid;
    }
}
