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
public class deleteAction extends ActionSupport {
    private String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public deleteAction() {
    }
    
    public String execute() throws Exception {
       DAL dal = new DAL();
       if(dal.delete(custId)){
           return "success";
       }
       else{
           return "error";
       }
    }
    
}
