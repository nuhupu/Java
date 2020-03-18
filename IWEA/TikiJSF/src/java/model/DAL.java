package model;

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
            String url = "jdbc:sqlserver://localhost:1433; database=TikiJSF";
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
            String sqlSelect = "select * from tiki";
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                cellphone st = new cellphone(rs.getString(1), rs.getString(2),
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

    public boolean insertCellPhone(String proId, String proName, int price) {
        try {
            con = getCon();
            String sqlInsert = "Insert into tiki values (?,?,?)";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, proId);
            ps.setString(2, proName);
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

    public boolean deleteCellPhone(String code) {
        try {
            con = getCon();
            String sqlDelete = "delete from tiki where proId =?";
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
            String sqlSelect = "select * from tiki where price >= ? and price <= ?";
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                cellphone cd = new cellphone(rs.getString(1), rs.getString(2), rs.getInt(3));
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
