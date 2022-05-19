/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Order {
    private int orderid;
    private Account a;

    public Account getA() {
        return a;
    }

    public void setA(Account a) {
        this.a = a;
    }
    private String username;
    private Date adddate;
    private String status;
    private List<OrderItem> list;
    public Order() {
    }

    public Order(String username, Date adddate, String status) {
        this.username = username;
        this.adddate = adddate;
        this.status = status;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }
    
    public Order(int orderid, String username, Date adddate) {
        this.orderid = orderid;
        this.username = username;
        this.adddate = adddate;
        this.status = "Đặt hàng thành công";
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public float getTongTien(){
        float tong = 0;
        for(OrderItem o: list){
            tong+=o.getCartitem().getQuantity()*o.getCartitem().getProduct().getPrice();
        } 
        return tong;
    }
    
    
}
