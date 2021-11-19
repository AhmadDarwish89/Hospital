/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darwish.hospital.validation;

/**
 *
 * @author ahmad
 */
public class Validation {
    public static boolean isEmpty(String... text){
        for (String s : text){
            if (s.isEmpty()){
                return true;
                
            }
        }
        return false;
    }
    public static boolean isEmpty(int... value){
        for(int i:value){
            if(i<0){
                return true;
            }
        }
        return false;
        
    }
    public static boolean isDigit(String... text){
        for (String s: text){
            if(!s.matches("[0-9]+")){
                return false;
            }
        }
        return true;
    }
    public static boolean isText(String... text){
        for (String s: text){
            if(!s.matches("[a-z]+")){
                return false;
                
            }
        }
        return true;
        
    }
}

