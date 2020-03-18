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
            String url = "jdbc:sqlserver://localhost:1433; database=MKBookStore";
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

    public List<Book> getAll() {
        List<Book> list = new ArrayList<Book>();
        try {
            con = getCon();
            String sqlSelect = "select * from Book";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book st = new Book(rs.getString(1), rs.getString(2),
                        rs.getInt(3));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }

    public boolean insertBook(String bookCode, String title, int price) {
        try {
            con = getCon();
            String sqlInsert = "Insert into Book values (?,?,?)";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, bookCode);
            ps.setString(2, title);
            ps.setInt(3, price);
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

    public boolean deleteBook(String code) {
        try {
            con = getCon();
            String sqlDelete = "delete from Book where bookCode =?";
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

    public List<Book> searchFromToPrice(int from, int to) {
        List<Book> list = new ArrayList<Book>();
        try {
            con = getCon();
            String sqlSelect = "select * from Book where price >= ? and price <= ?";
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book cd = new Book(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(cd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return null;
    }
    
    
}
