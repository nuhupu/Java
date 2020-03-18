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
            String url = "jdbc:sqlserver://localhost:1433; database=HR";
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

    public List<employee> getAll() {
        List<employee> list = new ArrayList<employee>();
        try {
            con = getCon();
            String sqlSelect = "select * from employee";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                employee st = new employee(rs.getString(1), rs.getString(2),
                        rs.getInt(3),rs.getInt(4),rs.getString(5));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }

    public boolean insertPhone(String code, String name,int salary,int age, String email) {
        try {
            con = getCon();
            String sqlInsert = "Insert into employee values (?,?,?,?,?)";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, code);
            ps.setString(2, name);            
            ps.setInt(3, salary);
            ps.setInt(4, age);            
            ps.setString(5, email);
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

    public boolean deleteEmployee(String code) {
        try {
            con = getCon();
            String sqlDelete = "delete from employee where empCode =?";
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

    public List<employee> searchFromToPrice(int from, int to) {
        List<employee> list = new ArrayList<employee>();
        try {
            con = getCon();
            String sqlSelect = "select * from employee where salary >= ? and salary <= ?";
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                //chu y thu tu cac column giong database
                employee cd = new employee(rs.getString(1), rs.getString(2),
                        rs.getInt(3),rs.getInt(4),rs.getString(5));
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
