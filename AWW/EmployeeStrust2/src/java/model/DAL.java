package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DAL {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public DAL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;database=EmpDB";
            con = DriverManager.getConnection(url, "sa", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //hàm kết nối
    public Connection getCon()
    {
        return con;
    }
    //hàm Insert new Employee
    public boolean insert(String username,String password,String empName,
            String empAdd, boolean roles){
        con =getCon();
        try {
            ps = con.prepareStatement("insert into employee values(?,?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, empName);
            ps.setString(4, empAdd);
            ps.setBoolean(5, roles);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //hàm show
    public  List<employee> show()
    {
        List<employee> list = new ArrayList<employee>();
        try {
            ps = con.prepareStatement("select * from employee");
            rs = ps.executeQuery();
            while (rs.next()) {                
                employee emp = new employee();
                emp.setUsername(rs.getString(1));
                emp.setPassword(rs.getString(2));
                emp.setEmpname(rs.getString(3));
                emp.setEmpadd(rs.getString(4));
                emp.setRoles(rs.getBoolean(5));
                list.add(emp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //hàm delete
    public boolean delete(String username)
    {   con =getCon();
        try {
            ps = con.prepareStatement("delete from employee where username=?");
            ps.setString(1, username);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //ham login
    public boolean checkLogin(String username, String password)
    {  con =getCon();
        try {
            ps = con.prepareStatement("select * from employee where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
