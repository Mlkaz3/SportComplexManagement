/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 * @author 
 * Chan Mei Hui 19WMR11908
 * Chen Chee Yong 19WMR11909
 * Ong Yi Jie 19WMR11855
 * Winnie Yap Xiang Loo 19WMR11981
 */
public class User implements Serializable{
    
    private String userName;
    private String userID;
    private String userCategory;
    private String userTel;

    public User(String userName, String userID, String userCategory, String userTel) {
        this.userName = userName;
        this.userID = userID;
        this.userCategory = userCategory;
        this.userTel = userTel;
    }

    public User() {
       
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", userID=" + userID + ", userCategory=" + userCategory + ", userTel=" + userTel + '}';
    }
}
