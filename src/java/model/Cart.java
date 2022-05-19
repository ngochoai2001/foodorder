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
public class Cart implements Serializable{
    private Account a;
    private List<CartItem> list;
    private int totalQuantity;
    private float totalMoney;
    public Cart() {
    }

    public Cart(Account a, List<CartItem> list) {
        this.a = a;
        this.list = list;
        int totalQuantity = 0;
        float totalMoney = 0;
        for(CartItem c: list){
            totalQuantity+=c.getQuantity();
            totalMoney+=((float)c.getQuantity())*c.getProduct().getPrice();
        }
        this.totalQuantity =  totalQuantity;
        this.totalMoney = totalMoney;
    }

    public Account getA() {
        return a;
    }

    public void setA(Account a) {
        this.a = a;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }
    public void setTotal(){
        
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public float getTotalMoney() {
        return totalMoney;
    }
    
}
