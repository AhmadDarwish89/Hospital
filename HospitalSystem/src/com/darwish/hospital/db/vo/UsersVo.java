/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darwish.hospital.db.vo;

import com.darwish.hospital.db.type.UsersType;

/**
 *
 * @author ahmad
 */
public class UsersVo {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UsersType getUserTYpe() {
        return UserTYpe;
    }

    public void setUserTYpe(UsersType UserTYpe) {
        this.UserTYpe = UserTYpe;
    }
    private UsersType UserTYpe;
    
}
