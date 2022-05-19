/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class Users implements Serializable{
    private int userid, gender;
    private String fullname, email, phone, address;

    public Users(int userid, int gender, String fullname, String email, String phone, String address) {
        this.userid = userid;
        this.gender = gender;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public Users(int gender, String fullname) {
        this.gender = gender;
        this.fullname = fullname;
    }
    
    public Users() {
    }

    public Users( int gender, String fullname, String email, String phone, String address) {
        this.gender = gender;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
