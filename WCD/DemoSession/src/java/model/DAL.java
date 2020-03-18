package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.DispatcherType;

/**
 *
 * @author sirac
 */
public class DAL implements Serializable{

    Connection con;
    ResultSet rs;
    PreparedStatement ps;

    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; database=DemoSession";
            con = DriverManager.getConnection(url, "sa", "123");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //viet ham dong ket noi
    public void CloseConnection() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (con != null) {
                con.close();
            }

            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
        }
    }

    public List<user> getAll() {
        List<user> list = new ArrayList<user>();
        try {
            con = getCon();
            String sqlSelect = "select * from cellphone";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                user st = new user ( rs.getString(1),
                       rs.getString(2));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }
    
    public List<user> selectCellPhone(int id) {
        List<user> list = new ArrayList<user>();
        try {
            con = getCon();
            String sqlSelect = "select * from cellphone where cellCode = ?";
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
              user  st = new user ( rs.getString(1),
                      rs.getString(2));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }

    public boolean login(String username,String password){
         List<user> list = new ArrayList<user>();
        try {
            con = getCon();
            String sqlInsert = "select * from users where username = '?' and password = '?' ";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, username);                              
            ps.setString(2, password); 
            rs = ps.executeQuery();
             while (rs.next()) {
              user  st = new user ( rs.getString(1),
                      rs.getString(2));
                list.add(st);
            }
      if(rs.next()){
          request.dis;
      }
             if(list.isEmpty()){
                 return false;
             }
             else{
                 return true;
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return false;
    }
    
    public boolean insertCellPhone(String name, int price,String manufacturer) {
        try {
            con = getCon();
            String sqlInsert = "Insert into cellphone values (?,?,?)";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, name);                       
            ps.setInt(2, price); 
            ps.setString(3, manufacturer); 
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return false;
    }

    public boolean updateCellPhone(int code,String name, int price,String manufacturer) {
        try {
            con = getCon();
            String sqlInsert = "UPDATE user SET cellName = '?', price= '?',manufacturer ='?' " +
"WHERE cellCode = ?;";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, name);                       
            ps.setInt(2, price); 
            ps.setString(3, manufacturer);
            ps.setInt(4, code); 
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return false;
    }
    
    public boolean deleteCellPhone(String code) {
        try {
            con = getCon();
            String sqlDelete = "delete from user where cellCode =?";
            ps = con.prepareStatement(sqlDelete);
            ps.setString(1, code);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return false;
    }

    public List<user> searchFromToPrice(int from, int to) {
        List<user> list = new ArrayList<user>();
        try {
            con = getCon();
            String sqlSelect = "select * from cellphone where price >= ? and price <= ?";
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                //chu y thu tu cac column giong database
                user cd = new user (rs.getString(1),
                        rs.getString(2));
                list.add(cd);
            }         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }
    
    
}
