/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nhozk
 */
public class Customer {

    private String CustID;
    private String Password;
    private String CustName;
    private int Age;
    private String Address;

    public Customer() {
    }

    public Customer(String CustID, String Password, String CustName, int Age, String Address) {
        this.CustID = CustID;
        this.Password = Password;
        this.CustName = CustName;
        this.Age = Age;
        this.Address = Address;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

}
