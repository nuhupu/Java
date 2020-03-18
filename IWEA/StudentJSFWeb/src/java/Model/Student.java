/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Student {
    private String studentCode,password,studentname;
    private int age;

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
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

    public Student(String studentCode, String password, String studentname, int age) {
        this.studentCode = studentCode;
        this.password = password;
        this.studentname = studentname;
        this.age = age;
    }

    public Student() {
    }
    
    public Student(String studentCode,  String studentname, int age) {
        this.studentCode = studentCode;
        this.password = password;
        this.studentname = studentname;
        this.age = age;
    }
}
