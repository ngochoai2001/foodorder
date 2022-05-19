/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Account;
import model.Users;

/**
 *
 * @author ACER
 */
public class Test {
    public static void main(String[] args) {
        UsersDAO u = new UsersDAO();
        System.out.println(4/3);
        System.out.println(u.logincheck("ngochoai", "010101"));
    }
    
}
