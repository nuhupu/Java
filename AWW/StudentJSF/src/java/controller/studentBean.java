/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.DAL;
import model.student;

/**
 *
 * @author sirac
 */
@ManagedBean
@SessionScoped
public class studentBean {
private String id, password,studentName;
private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public studentBean() {
    }
    DAL dal = new DAL();
    public String checkLogin(){
        if(dal.checkLogin(id,password)){
            return "success";
        }
        else{
            return "fail";
        }
    }
    
    public List<student> show(){
        List<student> list = dal.show();
        return list;
    }
    
    public String insert(){
        if(dal.insert(id, password, studentName, age)){
            return "index.xhtml";
        }
        else
        {
            return "insert.xhtml";
        }
    }
    
     public String delete(String id){
        if(dal.delete(id)){
            return "index.xhtml";
        }
        else
        {
            return "fail";
        }
    }
    
}
