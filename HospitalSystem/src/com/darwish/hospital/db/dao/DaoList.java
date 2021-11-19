/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darwish.hospital.db.dao;

import java.util.List;

/**
 *
 * @author ahmad
 */
public interface DaoList<T> {
    public List<T> LoadAll()throws Exception;
    public int insert(T t) throws Exception;
    public int  update(T t) throws Exception;
    public int  delete(T t) throws Exception;
    public T getData(T t) throws Exception;
    public T getDataById(int id) throws Exception;
    
    
    
    
}
