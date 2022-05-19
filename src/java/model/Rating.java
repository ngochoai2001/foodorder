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
public class Rating implements Serializable{
    private int id, proid, point;
    private String content, username;

    public Rating() {
    }

    public Rating(int proid, int point, String content, String username) {
        this.proid = proid;
        this.point = point;
        this.content = content;
        this.username = username;
    }

    public Rating(int id, int proid, int point, String content, String username) {
        this.id = id;
        this.proid = proid;
        this.point = point;
        this.content = content;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
