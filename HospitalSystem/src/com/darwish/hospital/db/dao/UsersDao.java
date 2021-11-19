/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darwish.hospital.db.dao;


import com.darwish.hospital.db.type.UsersType;
import com.darwish.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


/**
 *
 * @author ahmad
 */
public class UsersDao extends Dao implements DaoList<UsersVo>{
    private static UsersDao usersDao;
    private UsersDao(){
        
    }
    public static UsersDao getInstance(){
        if(usersDao==null){
            usersDao=new UsersDao();
         
        }
    return usersDao;
    }

    @Override
    public List<UsersVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(UsersVo uv) throws Exception {
        Connection con =null;
        int count=0;
        try{
            con=getConnection();
            String sql = "INSERT INTO users(USERS_NAME,PASSWORD,USER_TYPE,ID) VALUES(?,?,?,?)";
            PreparedStatement ps=con.prepareCall(sql);
            ps.setString(1, uv.getUsername());
            ps.setString(2, uv.getPassword());
            ps.setInt(3, uv.getUserTYpe().getId());
            ps.setInt(4, uv.getId());
            count=ps.executeUpdate();
            ps.close();
        } catch(Exception ex){
        } finally{
            closeConnection(con);
        }
        return count;
    }
            

    @Override
    public int update(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersVo getData(UsersVo uv) throws Exception {
        
        Connection  con=null;
        UsersVo usersVo=null;
        ResultSet rs=null;
        try{
            con = getConnection();
            String sql="SELECT * FROM users WHERE USER_NAME='" +uv.getUsername()+"'AND PASSWORD='" +uv.getPassword()+"'";
            PreparedStatement ps= con.prepareCall(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                    usersVo=new UsersVo();
                    usersVo.setId(rs.getInt("id"));
                    usersVo.setUsername(rs.getString("USER_NAME"));
                    usersVo.setPassword(rs.getString("PASSWORD"));
                    UsersType usersType=UsersType.getUserTypeByid(rs.getInt("USER_TYPE"));
                    usersVo.setUserTYpe(usersType);
                    
                }
                rs.close();
                ps.close();
        }catch(Exception ex){
         }
        finally{
            closeConnection(con);
        }
        return usersVo;
        
    
    
}

    @Override
    public UsersVo getDataById(int id) throws Exception {
       Connection  con=null;
        UsersVo usersVo=null;
        ResultSet rs=null;
        try{
            con = getConnection();
            String sql="SELECT * FROM users WHERE ID=?";
            PreparedStatement ps= con.prepareCall(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                    usersVo=new UsersVo();
                    usersVo.setId(rs.getInt("id"));
                    usersVo.setUsername(rs.getString("USER_NAME"));
                    usersVo.setPassword(rs.getString("PASSWORD"));
                    UsersType usersType=UsersType.getUserTypeByid(rs.getInt("USER_TYPE"));
                    usersVo.setUserTYpe(usersType);
                    
                }
                rs.close();
                ps.close();
        }catch(Exception ex){
         }
        finally{
            closeConnection(con);
        }
        return usersVo;
        
        
    }
}
    

    