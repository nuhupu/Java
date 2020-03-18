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
public class Student {

    private String StudentId;
    private String StudentName;
    private String StudentEmail;
    private String StudentAddress;
    private String StudentPhone;

    public Student(String StudentId, String StudentName, String StudentEmail, String StudentAddress, String StudentPhone) {
        this.StudentId = StudentId;
        this.StudentName = StudentName;
        this.StudentEmail = StudentEmail;
        this.StudentAddress = StudentAddress;
        this.StudentPhone = StudentPhone;
    }

    public Student() {
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String StudentEmail) {
        this.StudentEmail = StudentEmail;
    }

    public String getStudentAddress() {
        return StudentAddress;
    }

    public void setStudentAddress(String StudentAddress) {
        this.StudentAddress = StudentAddress;
    }

    public String getStudentPhone() {
        return StudentPhone;
    }

    public void setStudentPhone(String StudentPhone) {
        this.StudentPhone = StudentPhone;
    }

}
