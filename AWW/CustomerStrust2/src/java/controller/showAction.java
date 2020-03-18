/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.DAL;

/**
 *
 * @author sirac
 */
public class showAction extends ActionSupport {
    List<Customer> list = new ArrayList<Customer>();

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }

   
    
    public showAction() {
    }
    
    public String execute() throws Exception {
           DAL dal = new DAL();
           list =dal.show();
        if(list!=null){
            return "success";
        }
        else{
            return "error";
        }
    }
    
}
