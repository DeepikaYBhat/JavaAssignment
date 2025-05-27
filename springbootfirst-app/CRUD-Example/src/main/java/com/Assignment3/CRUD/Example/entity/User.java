package com.Assignment3.CRUD.Example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class User {

    @Id
    private int empid;

    private String empname;
    private String salary;
    private String dob;


    public int getEmpid() { return empid; }
    public void setEmpid(int empid) { this.empid = empid; }



    public String getEmpname() { return empname; }
    public void setEmpname(String empname) { this.empname = empname; }

    public String getSalary() { return salary;}
    public void setSalary(String salary) { this.salary = salary; }

    public String getDob() { return dob;}
    public void setDob(String dob) { this.dob = dob; }

}
