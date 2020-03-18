/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.DAL;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.cellphone;

/**
 *
 * @author sirac
 */
@ManagedBean
@SessionScoped
public class cellBean implements Serializable {

    /**
     * Creates a new instance of insertBean
     */
    private String proId;
    private String proName;
    private int price;
    DAL dal = new DAL();

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public cellBean() {
    }

    public DAL getDal() {
        return dal;
    }

    public void setDal(DAL dal) {
        this.dal = dal;
    }

    public List<cellphone> showAll() {
        List<cellphone> list = new ArrayList<cellphone>();
        list = dal.getAll();
        return list;
    }

    public String delete(String id){
        if(dal.deleteCellPhone(id)){
            return "showAll";
        }
        else return "fail";
    }
    //return ten6 view
    public String insert() {
        if (dal.insertCellPhone(proId, proName, price)) {
            return "showAll";
        } else {
            return "fail";
        }
    }
}
