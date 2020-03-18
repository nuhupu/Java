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
            String url = "jdbc:sqlserver://localhost:1433;database=StudentDB;user=sa;password=123";
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

    public int checkLogin(String username, String password) {
        try {
            con = getConnection();
            String sql = "select * from Registration where username=? and password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                Registration st = new Registration(rs.getString(1), rs.getString(2), rs.getInt(3));
                if (st.getRole() == 1) {
                    return 1;
                } else {
                    return 2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return 3;
    }

    public List<Student> show() {
        List<Student> list = new ArrayList<>();
        try {
            con = getConnection();
            String sql = "select * from Student";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                Student st = new Student(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean delete(String id) {
        try {
            con = getConnection();
            String sql = "Delete from Student where StudentId=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
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
}
