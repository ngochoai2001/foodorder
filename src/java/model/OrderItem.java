/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class OrderItem {
    private int orderid;
    private CartItem cartitem;
    private String status;
    private Date orderDate;
    public OrderItem() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderItem(int orderid, CartItem cartitem, String status, Date orderDate) {
        this.orderid = orderid;
        this.cartitem = cartitem;
        this.status = status;
        this.orderDate = orderDate;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderItem(int orderid, CartItem cartitem, String status) {
        this.orderid = orderid;
        this.cartitem = cartitem;
        this.status = status;
    }
    
    public OrderItem(int orderid, CartItem cartitem) {
        this.orderid = orderid;
        this.cartitem = cartitem;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public CartItem getCartitem() {
        return cartitem;
    }

    public void setCartitem(CartItem cartitem) {
        this.cartitem = cartitem;
    }
    
}
