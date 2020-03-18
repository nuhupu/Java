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
import model.DAO;

/**
 *
 * @author nhozk
 */
@ManagedBean
@SessionScoped
public class custBean {

    private String CustID;
    private String Password;
    private String CustName;
    private int Age;
    private String Address;

    private int min;
    private int max;

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

    public custBean() {
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
    DAO dao = new DAO();

    //hàm check login
    public String checkLogin() {
        if (dao.checkLogin(CustID, Password)) {
            CustID = "";
            Password = "";
            return "insert.xhtml";
        } else {
            return "login.xhtml";
        }
    }

    //hàm check insert
    public String insert() {
        if (dao.insert(CustID, Password, CustName, Age, Address)) {
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
        List<Customer> list = dao.show();
        return list;
    }

    //dinh nghia ham delete
    public String delete(String id) {
        if (dao.delete(id)) {
            return "show.xhtml";
        } else {
            return "error.xhtml";
        }
    }

    //show trang search
    public String search() {
        return "result";
    }

    //show ket qua search
    public List<Customer> searchResult() {
        List<Customer> result = dao.search(min, max);
        return result;

    }
}
