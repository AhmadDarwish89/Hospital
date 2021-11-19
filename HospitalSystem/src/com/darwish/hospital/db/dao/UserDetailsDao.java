/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darwish.hospital.db.dao;

import static com.darwish.hospital.db.dao.Dao.closeConnection;
import com.darwish.hospital.db.type.UsersType;
import com.darwish.hospital.db.vo.UserDetailsVo;
import com.darwish.hospital.db.vo.UsersVo;
import com.darwish.hospital.view.UsersView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author ahmad
 */
public class UserDetailsDao extends Dao implements DaoList<UserDetailsVo>{
    private static UserDetailsDao userDetailsDao;
    private UserDetailsDao(){
    }
    public static UserDetailsDao getInstance(){
        if (userDetailsDao==null){
            userDetailsDao=new UserDetailsDao();
        }
        return userDetailsDao;
    }
    
     
     
    
    @Override
    public List<UserDetailsVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(UserDetailsVo udv) throws Exception {
        Connection con =null;
        PreparedStatement ps=null;
        int count=0;
        try{
            con=getConnection();
            con.setAutoCommit(false);
            String userSql = "INSERT INTO users(USER_NAME,PASSWORD,USER_TYPE,ID) VALUES(?,?,?,?)";
             ps=con.prepareCall(userSql);
            ps.setString(1, udv.getUsersVo().getUsername());
            ps.setString(2, udv.getUsersVo().getPassword());
            ps.setInt(3, udv.getUsersVo().getUserTYpe().getId());
            ps.setInt(4, udv.getUsersVo().getId());
            ps.executeUpdate();
        
            String UserDetailsSql = "INSERT INTO user_details(USER_ID,FIRST_NAME,FATHER_NAME,MOBILE,IMAGE) VALUES(?,?,?,?,?)";
            ps=con.prepareCall(UserDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.setString(2, udv.getFirstName());
            ps.setString(3, udv.getFatherName());
            ps.setString(4, udv.getMobile());
            ps.setBytes(5, udv.getImage());
             
            ps.executeUpdate();
            con.commit();
            count=1;
            
        } catch(Exception ex){
            con.rollback();
            JOptionPane.showMessageDialog(null, ex);
             
        } finally{
            ps.close();
            closeConnection(con);
        }
        return count;
    }


    @Override
    public int update(UserDetailsVo udv) throws Exception {
        
        Connection con =null;
        PreparedStatement ps=null;
        int count=0;
        try{
            con=getConnection();
            con.setAutoCommit(false);
            String userSql = "UPDATE users SET USER_TYPE=? WHERE ID=?";
             ps=con.prepareCall(userSql);
            ps.setString(1, udv.getUsersVo().getUsername());
            ps.setString(2, udv.getUsersVo().getPassword());
            ps.setInt(3, udv.getUsersVo().getUserTYpe().getId());
            ps.setInt(4, udv.getUsersVo().getId());
            ps.executeUpdate();
        
            String UserDetailsSql = "UPDATE user_details SET FIRST_NAME=?,FATHER_NAME=?, MOBILE=?, IMAGE=? WHERE USER_ID=?";
            ps=con.prepareCall(UserDetailsSql);
            ps.setString(1, udv.getFirstName());
            ps.setString(2, udv.getFatherName());
            ps.setString(3, udv.getMobile());
            ps.setBytes(4, udv.getImage());
            ps.setInt(5, udv.getUsersVo().getId());
            ps.executeUpdate();
            con.commit();
            count=1;
        } catch(Exception ex){
            con.rollback();
        } finally{
            ps.close();
            closeConnection(con);
        }
        return count;
    }

   
    @Override
    public UserDetailsVo getData(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetailsVo getDataById(int id) throws Exception {
        Connection con =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        UserDetailsVo userDetailsVo =null;
        UsersVo usersVo = null;
       
        try{
            con=getConnection();
           
            String userSql = "SELECT users.ID,users.USER_NAME,users.PASSWORD,users.USER_TYPE,user_details.FIRST_NAME,user_details.FATHER_NAME,user_details.MOBILE,user_details.IMAGE FROM users INNER JOIN user_details ON user_details.USER_ID= users.ID WHERE users.ID=? ";
             ps=con.prepareCall(userSql);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            while (rs.next()){
                usersVo =new UsersVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUsername(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType usersType =UsersType.getUserTypeByid(rs.getInt("ID"));
                usersVo.setUserTYpe(usersType);
                userDetailsVo.setFirstName(rs.getString("FIRST_NAME"));
                userDetailsVo.setFatherName(rs.getString("FATHER_NAME"));
                userDetailsVo.setMobile(rs.getString("MOBILE"));
                userDetailsVo.setImage(rs.getBytes("IMAGE"));
                
                
            }
        } catch(Exception ex){
            con.rollback();
        } finally{
            ps.close();
            closeConnection(con);
        }
        return count;
        
    }

    @Override
    public int delete(UserDetailsVo udv) throws Exception {
     Connection con =null;
        PreparedStatement ps=null;
        int count=0;
        try{
            con=getConnection();
            con.setAutoCommit(false);
            String UserDetailsSql = "DELETE FROM user_details WHERE USER_iD=? ";
            ps=con.prepareCall(UserDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
           
            ps.executeUpdate();
        
            String userSql = "DELETE FROM users WHERE ID=?";
            ps=con.prepareCall(userSql);
            ps.setInt(1, udv.getUsersVo().getId());
            
            ps.executeUpdate();
            con.commit();
            count=1;
        } catch(Exception ex){
            con.rollback();
        } finally{
            ps.close();
            closeConnection(con);
        }
        return count;
        
    }
    }

 
