/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author nuhupu
 */
@ManagedBean(name = "st")
@SessionScoped
public class stBean implements Serializable {

    private String id, password, studentname;
    private int age;
    DAL dal = new DAL();

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

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DAL getDal() {
        return dal;
    }

    public void setDal(DAL dal) {
        this.dal = dal;
    }

    public stBean() {
    }

    public String checkLogin() {
        if (dal.checkLogin(id, password)) {
            return "success";
        } else {
            return "fail";
        }
    }

    public List<Student> showAll(){
        List<Student> list = dal.getAll();
        return list;
    }
    //return ten6 view
    public String insert() {
        if (dal.insertStudent(id, password,studentname,age)) {
             return "success";
        } else {
            return "fail";
        }
    }
}
