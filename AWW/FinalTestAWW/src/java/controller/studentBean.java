/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Student;
import model.DAL;

/**
 *
 * @author sirac
 */
@ManagedBean
@SessionScoped
public class studentBean {
    private String studentId;
    private String studentName;
    private String studentEmail;
    private String studentAddress;
    private String studentPhone;
    private String password;
    private String username;
    private int role;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    DAL dal = new DAL();

    /**
     * Creates a new instance of customerBean
     */
    public studentBean() {
    }
    
    //hàm check login
    public String checkLogin() {
        int vrole=dal.checkLogin(username, password);
        switch (vrole) {
            case 0:
                username = "";
                password = "";
                return "show.xhtml";
            case 1:
                username = "";
                password = "";
                return "delete.xhtml";
            default:
                return "error.xhtml";
        }
    }

    //hàm show
    public List<Student> show() {
        List<Student> list = dal.show();
        return list;
    }

    //dinh nghia ham delete
    public String delete(String id) {
        if (dal.delete(id)) {
            return "success.xhtml";
        } else {
            return "error.xhtml";
        }
    }


}
