/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Console;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAL implements Serializable {
//khai bao cac bien de ket noi voi server

    Connection con;
    ResultSet rs;
    PreparedStatement ps;

    //viet ham ket noi voi SQL server
    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; database=StudentJSFWeb";
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
        } finally {

        }
    }

    //ham login
    public boolean checkLogin(String id, String password) {
        con = getCon();//mo ket noi de lam viec voi database
        String sqlSelect = "select * from student where studentCode=? and password = ?";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, id);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
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

    //ham hien thi tat ca du lieu trong database ra trang web
    public List<Student> displayAll() {
        List<Student> list = new ArrayList<Student>();
        try {
            con = getCon();
            String sqlSelect = "select * from student";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student st = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }

    //ham insert new student
    public boolean insertStudent(String studentCode, String password, String name, int age) {
        try {
            con = getCon();
            String sqlInsert = "Insert into student values (?,?,?,?)";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, studentCode);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setInt(4, age);
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
    
    //ham delete student
    public boolean deleteStudent(String id){
        try {
            con = getCon();
            String sqlDelete = "delete from student where studentCode =?";
            ps= con.prepareStatement(sqlDelete);
            ps.setString(1, id);
            if(ps.executeUpdate()>0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            CloseConnection();
        }
        return false;
    }
    
    //ham Detail giong search theo id
    public List<Student> showDetail(String id){
        List<Student> list = new ArrayList<Student>();
        try {
            con = getCon();
            String sqlSearch = "select *from student where studentCode =?";
            ps = con.prepareStatement(sqlSearch);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Student st = new Student(rs.getString(1),rs.getString(3),rs.getInt(4));                
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            CloseConnection();
        }
        return list;
    }
}
