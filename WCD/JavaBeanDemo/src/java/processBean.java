
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author sirac
 */
@Named(value = "processBean")
@Dependent
public class processBean {

    /**
     * Creates a new instance of processBean
     */
    public processBean() {
        
    }
    String username,password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isCheckLogin(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433; database = useraccount";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select *from users where username=? and password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery());
            if(rs.next()){
                ps.close();
                rs.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
