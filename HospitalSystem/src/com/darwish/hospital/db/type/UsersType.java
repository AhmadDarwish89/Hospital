/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darwish.hospital.db.type;

/**
 *
 * @author ahmad
 */
public enum UsersType {
    ADMIN(1,"admin"),DOCTOR(2,"doctor"), NURSE(3,"nurse");
    private static Object Userstype;
    
    private int id;
    private String type;
    
    private UsersType(int id, String type){
        this.id=id;
        this.type=type;
        
    }
    public static UsersType getUserTypeByid(int id){
        for(UsersType usersType:UsersType.values()){
            if(usersType.getId()==id){
                return usersType;
            }
        }
        return null;
    }
public static UsersType getUserTypeByType(String Type){
        for(UsersType usersType:UsersType.values()){
            if(usersType.getType()==Type){
                return usersType;
            }
        }
        return null;
    }
    public static Object getUserstype() {
        return Userstype;
    }

    public static void setUserstype(Object Userstype) {
        UsersType.Userstype = Userstype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
      
    
}
