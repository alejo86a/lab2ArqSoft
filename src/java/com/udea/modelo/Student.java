/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alejandro
 */

@Entity
@Table
@NamedQueries(@NamedQuery(name="Student.getAll",query="SELECT e from Student e"))
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int studentId;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private int yearlevel;

    public Student() {
    }
    
    public Student(int studentId, String firstname, String lastname, int yearlevel) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearlevel = yearlevel;
    }
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearLevel() {
        return yearlevel;
    }

    public void setYearLevel(int yearlevel) {
        this.yearlevel = yearlevel;
    }
    
    
}
