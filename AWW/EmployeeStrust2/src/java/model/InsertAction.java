package model;

import com.opensymphony.xwork2.ActionSupport;

public class InsertAction extends ActionSupport {
    private String username;
    private String password;
    private String empname;
    private String empadd;
    private boolean roles;

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
    
    public InsertAction() {
    }    
    public String execute() throws Exception {
       DAL dal = new DAL();
       if(dal.insert(username, password, empname, empadd, roles))
       {
           return "success";
       }else {
           return "error";
       }
    }

    @Override
    public void validate() {
        if(username.length()==0)
        {
            addFieldError("username", "Please enter username");
        }
        if(password.length()==0)
        {
            addFieldError("password", "Please enter password");
        }
        if(empname.length()==0)
        {
            addFieldError("empname", "Employee name can not blank");
        }
        if(empadd.length()==0)
        {
            addFieldError("empadd", "Address can not blank");
        }
    }
}

