package com.kobe.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/14
 * @Time 12:07
 * @Note ……
 */
public class Emp {

    private int id;

    private String name;

    private int age;

    private String job;

    private int salary;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date entryDate;

    private int manageId;

    private int deptId;

    public Emp() {
    }

    public Emp(int id, String name, int age, String job, int salary, Date entryDate, int manageId, int deptId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.salary = salary;
        this.entryDate = entryDate;
        this.manageId = manageId;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getEntryDate() {

        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getManageId() {
        return manageId;
    }

    public void setManageId(int manageId) {
        this.manageId = manageId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Emp emp = (Emp) o;
        return id == emp.id && age == emp.age && salary == emp.salary && manageId == emp.manageId && deptId == emp.deptId && Objects.equals(name, emp.name) && Objects.equals(job, emp.job) && Objects.equals(entryDate, emp.entryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, job, salary, entryDate, manageId, deptId);
    }

    @Override
    public String toString() {
        return "Emp{" + "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", entryDate=" + entryDate +
                ", manageId=" + manageId +
                ", deptId=" + deptId +
                '}';
    }
}
