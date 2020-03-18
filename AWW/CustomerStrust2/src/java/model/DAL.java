/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sirac
 */
public class DAL {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    //viet ham ket noi voi SQL server
    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=customerDb;user=sa;password=123";
            con = DriverManager.getConnection(url);
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

    public List<Customer> show() {
        List<Customer> list = new ArrayList<Customer>();
        con = getCon();
        try {
            ps = con.prepareStatement("select * from customer");
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer cus = new Customer();
                cus.setCustId(rs.getString(1));
                cus.setCustName(rs.getString(2));
                cus.setPassword(rs.getString(3));
                cus.setCustaddr(rs.getString(4));
                list.add(cus);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(String custid, String password, String custname, String custaddr) {
        con = getCon();
        String sql = "Insert into customer values(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, custid);
            ps.setString(2, password);
            ps.setString(3, custname);
            ps.setString(4, custaddr);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String custid) {
        con = getCon();
        try {
            ps = con.prepareStatement("delete from customer where custid = ?");
            ps.setString(1, custid);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
