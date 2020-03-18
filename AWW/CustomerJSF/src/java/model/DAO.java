/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhozk
 */
public class DAO implements Serializable {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    //ham ket noi
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=Customers;user=sa;password=123";
            con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //ham dong ket noi
    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public boolean checkLogin(String username, String password) {
        Customer st = null;
        try {
            con = getConnection();
            String sql = "select * from Customer where CustID=? and Password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<Customer> show() {
        List<Customer> list = new ArrayList<>();
        try {
            con = getConnection();
            String sql = "select * from Customer";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                Customer st = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getInt(4), rs.getString(5));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean insert(String CustID, String Password, String CustName, int Age, String Address) {
        try {
            con = getConnection();
            String sql = "Insert into Customer values (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, CustID);
            ps.setString(2, Password);
            ps.setString(3, CustName);
            ps.setInt(4, Age);
            ps.setString(5, Address);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean delete(String code) {
        try {
            con = getConnection();
            String sql = "Delete from Customer where CustID=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, code);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
    
    
    public List<Customer> search(int min, int max) {
        List<Customer> list = new ArrayList<>();
        try {
            con = getConnection();
            String sql = "select * from Customer where Age >= ? and Age <= ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, min);
            ps.setInt(2, max);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                Customer st = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getInt(4), rs.getString(5));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
}
