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
 * @author sirac
 */
@ManagedBean
@SessionScoped
public class studentBean implements Serializable {

    private String studentCode, studentname, password;

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
    private int age;

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    DAL dal = new DAL();

    public studentBean() {
    }

    //ham checkLogin
    public String checkLogin() {
        if (dal.checkLogin(studentCode, password)) {
            return "succes";
        } else {
            return "fail";
        }
    }

    //ham displayall
    public List<Student> displayAll() {
        List<Student> list = dal.displayAll();
        return list;
    }

    public String insert() {
        if (dal.insertStudent(studentCode, password, studentname, age)) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String deleteStudent(String code) {
        if (dal.deleteStudent(code)) {
            return "success";
        } else {
            return "fail";
        }
    }

    //ham search student by id
    public List<Student> searchById(String code) {
        List<Student> list = dal.showDetail(code);
        for (Student st : list) {
            this.studentCode = st.getStudentCode();
            this.studentname = st.getStudentname();
            this.age = st.getAge();
        }
        return list;
    }
}
