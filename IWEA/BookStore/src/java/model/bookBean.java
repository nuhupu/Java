/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sirac
 */
@ManagedBean
@SessionScoped
public class bookBean implements Serializable {

    /**
     * Creates a new instance of insertBean
     */
    private String bookCode;
    private String title;
    private int price;

    
    DAL dal = new DAL();

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public bookBean() {
    }

    public DAL getDal() {
        return dal;
    }

    public void setDal(DAL dal) {
        this.dal = dal;
    }

    public List<book> showAll() {
        List<book> list = new ArrayList<book>();
        list = dal.getAll();
        return list;
    }

    public String delete(String code) {
        if (dal.deleteBook(code)) {
            return "index";
        } else {
            return "fail";
        }
    }

    //return ten6 view
    public String insert() {
        if (dal.insertBook(bookCode, title, price)) {
            return "index";
        } else {
            return "fail";
        }
    }
    public List<book> result;

    public List<book> getResult() {
        return result;
    }

    public void setResult(List<book> result) {
        this.result = result;
    }
    private int from,to;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
    public String search(){
         List<book> list = new ArrayList<book>();
        list = dal.searchFromToPrice(from, to);
       
        result = list;
        return "index";
    }
   
}
