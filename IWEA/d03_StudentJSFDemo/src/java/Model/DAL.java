/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.*;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author nuhupu
 */
public class DAL implements Serializable {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public DAL() {
    }

    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:8084;database=StudentJSF;id=sa;password=123;";
            con = DriverManager.getConnection(url,"nuhupu","123");
            return con;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void CloseConnection() {
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
        }
    }

    public boolean checkLogin(String id, String password) {
        con = getCon();
        String sqlSelect = "select*from student where id=? and password=?";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, id);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            CloseConnection();
        }
        return false;
    }

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        try {
            con = getCon();
            String sqlSelect = "select * from student";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student st = new Student(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseConnection();
        }
        return list;
    }

    public boolean insertStudent(String id, String pass, String name, int age) {
        try {
            con = getCon();
            String sqlInsert = "Insert into student values(?,?,?,?)";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, id);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setInt(4, age);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            CloseConnection();
        }
        return false;
    }
}
