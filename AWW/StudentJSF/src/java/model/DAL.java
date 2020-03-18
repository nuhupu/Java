package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAL {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public DAL() {
    }

    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url =  "jdbc:sqlserver://localhost:1433;database=StudentsJSF;user=sa;password=123";
            con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkLogin() {
        return true;
    }

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

    public boolean checkLogin(String id, String password) {
        try {
            con = getCon();
            String sql = "select * from student where id = ? and password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);

            rs = ps.executeQuery();
            //xu ly ket qua
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<student> show() {
        List<student> list = new ArrayList<>();
        try {
            con = getCon();
            String sql = "select * from student";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //xu ly ket qua
            while (rs.next()) {
                student st = new student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean insert(String id, String password, String studentName, int age) {
        try {
            con = getCon();
            String sql = "Insert into student(id,password,studentName,age) values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, studentName);
            ps.setInt(4, age);
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
            con = getCon();
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

    public boolean delete(String id) {
        try {
            con = getCon();
            String sql = "Delete from student where id=? ";
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
//
//    public List<student> search(int min, int max) {
//        List<student> list = new ArrayList<>();
//        try {
//            con = getCon();
//            String sql = "select * from Cellphone where price >= ? and price <= ?";
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, min);
//            ps.setInt(2, max);
//            rs = ps.executeQuery();
//            //xu ly ket qua
//            while (rs.next()) {
//                student st = new student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
//                list.add(st);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//        return list;
//    }
//
//    public Cellphone showByID(String ID) {
//        Cellphone st = null;
//        try {
//            con = getConnection();
//            String sql = "select * from Cellphone where cellCode=?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, ID);
//            rs = ps.executeQuery();
//            //xu ly ket qua
//            while (rs.next()) {
//                st = new Cellphone(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//        return st;
//    }
//    
}
