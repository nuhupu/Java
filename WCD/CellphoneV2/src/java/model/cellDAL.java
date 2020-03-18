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
public class cellDAL implements Serializable {

    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;

    public cellDAL() {
    }

    //ham ket noi
    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=CellPhoneDB;user=sa;password=123";
            con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //ham dong ket noi
    public static void closeConnection() {
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

    public static List<Cellphone> show() {
        List<Cellphone> list = new ArrayList<>();
        try {
            con = getConnection();
            String sql = "select * from Cellphone";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                Cellphone st = new Cellphone(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean insert(String title, int price, String man) {
        try {
            con = getConnection();
            String sql = "Insert into Cellphone(cellName,price,manufacturer) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setInt(2, price);
            ps.setString(3, man);

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

    public boolean update(int code, String name, int price, String man) {
        try {
            con = getConnection();
            String sql = "update Cellphone "
                    + "set cellName = ?, price=?, manufacturer=? "
                    + "where cellCode = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3, man);
            ps.setInt(4, code);

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
            String sql = "Delete from Cellphone where cellCode=? ";
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

    public List<Cellphone> search(int min, int max) {
        List<Cellphone> list = new ArrayList<>();
        try {
            con = getConnection();
            String sql = "select * from Cellphone where price >= ? and price <= ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, min);
            ps.setInt(2, max);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                Cellphone st = new Cellphone(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public Cellphone showByID(String ID) {
        Cellphone st = null;
        try {
            con = getConnection();
            String sql = "select * from Cellphone where cellCode=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                st = new Cellphone(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return st;
    }
}
