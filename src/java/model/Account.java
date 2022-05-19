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
public class Account implements Serializable{
    private int userid, roleid;
    private String username, password;
    private Users u;

    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }
    
    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int roleid, String username, String password) {
        this.roleid = roleid;
        this.username = username;
        this.password = password;
    }
    
    public Account(int userid, int roleid, String username, String password) {
        this.userid = userid;
        this.roleid = roleid;
        this.username = username;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
        return username;
    }
    
}
