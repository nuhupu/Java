/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.DAL;

/**
 *
 * @author sirac
 */
public class insertAction extends ActionSupport {
    private String custid,custname,custaddr,password;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustaddr() {
        return custaddr;
    }

    public void setCustaddr(String custaddr) {
        this.custaddr = custaddr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public insertAction() {
        
    }
    
    public String execute() throws Exception {
        DAL dal = new DAL();
        if(dal.insert(custid,password,custname,custaddr)){
            return "success";
        }
        else{
            return "error";
        }
    }

    @Override
    public void validate() {

        if(custname.length() == 0)
        {
            addFieldError("custname","custname cannot blank");
        }
         if(password.length()==0)
        {
            addFieldError("password","password cannot blank");
        }
    }
   
}
