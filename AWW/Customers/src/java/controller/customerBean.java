/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Customer;
import model.DAL;

/**
 *
 * @author sirac
 */
@ManagedBean
@SessionScoped
public class customerBean {
    private String CustID;
    private String Password;
    private String CustName;
    private int Age;
    private String Address;
    DAL dal = new DAL();
private int min,max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    /**
     * Creates a new instance of customerBean
     */
    public customerBean() {
    }
    
    //hàm check login
    public String checkLogin() {
        if (dal.checkLogin(CustID, Password)) {
            CustID = "";
            Password = "";
            return "insert.xhtml";
        } else {
            return "login.xhtml";
        }
    }

    //hàm check insert
    public String insert() {
        if (dal.insert(CustID,Password, CustName,Age,  Address )) {
            CustID = "";
            Password = "";
            CustName = "";
            Age = 0;
            Address = "";
            return "show.xhtml";
        } else {
            return "error.xhtml";
        }
    }

    //hàm show
    public List<Customer> show() {
        List<Customer> list = dal.show();
        return list;
    }

    //dinh nghia ham delete
    public String delete(String id) {
        if (dal.delete(id)) {
            return "show.xhtml";
        } else {
            return "error.xhtml";
        }
    }

    //show trang search
    public String search() {
        return "result";
    }

//    show ket qua search
    public List<Customer> searchResult() {
        List<Customer> result = dal.search(min, max);
        return result;

    }
}
