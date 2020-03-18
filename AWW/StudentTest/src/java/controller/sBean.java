/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.DAO;
import model.Student;

/**
 *
 * @author nhozk
 */
@ManagedBean
@SessionScoped
public class sBean {

    private String username;
    private String password;
    private String StudentId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }


    public sBean() {
    }

    DAO dao = new DAO();

    //hàm check login
    public String checkLogin() {
        int check = dao.checkLogin(username, password);
        switch (check) {
            case 1:
                username = "";
                return "admin.xhtml";
            case 2:
                username = "";
                return "guest.xhtml";
            default:
                return "error.xhtml";
        }
    }

    //hàm show
    public List<Student> show() {
        List<Student> list = dao.show();
        return list;
    }
    
    
    //dinh nghia ham delete
    public String delete(String id) {
        if (dao.delete(id)) {
            return "success.xhtml";
        } else {
            return "error.xhtml";
        }
    }
}
