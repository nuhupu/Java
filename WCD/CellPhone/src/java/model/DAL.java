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
            String url = "jdbc:sqlserver://localhost:1433; database=CellPhoneDB";
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

    public List<cellphone> getAll() {
        List<cellphone> list = new ArrayList<cellphone>();
        try {
            con = getCon();
            String sqlSelect = "select * from cellphone";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                cellphone st = new cellphone (rs.getInt(1), rs.getString(2),
                        rs.getInt(3),rs.getString(4));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }
    
    public List<cellphone> selectCellPhone(int id) {
        List<cellphone> list = new ArrayList<cellphone>();
        try {
            con = getCon();
            String sqlSelect = "select * from cellphone where cellCode = ?";
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
              cellphone  st = new cellphone (rs.getInt(1), rs.getString(2),
                        rs.getInt(3),rs.getString(4));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
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
            String sqlInsert = "UPDATE cellphone SET cellName = '?', price= '?',manufacturer ='?' " +
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
            String sqlDelete = "delete from cellphone where cellCode =?";
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

    public List<cellphone> searchFromToPrice(int from, int to) {
        List<cellphone> list = new ArrayList<cellphone>();
        try {
            con = getCon();
            String sqlSelect = "select * from cellphone where price >= ? and price <= ?";
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                //chu y thu tu cac column giong database
                cellphone cd = new cellphone (rs.getInt(1), rs.getString(2),
                        rs.getInt(3),rs.getString(4));
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
