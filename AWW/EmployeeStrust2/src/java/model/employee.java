package model;
public class employee {
    private String username,password,empname,empadd;
    private boolean  roles;

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

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpadd() {
        return empadd;
    }

    public void setEmpadd(String empadd) {
        this.empadd = empadd;
    }

    public boolean isRoles() {
        return roles;
    }

    public void setRoles(boolean roles) {
        this.roles = roles;
    }

    public employee() {
    }

    public employee(String username, String password, String empname, String empadd, boolean roles) {
        this.username = username;
        this.password = password;
        this.empname = empname;
        this.empadd = empadd;
        this.roles = roles;
    }
    
}
