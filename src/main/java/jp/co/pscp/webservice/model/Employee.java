/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.pscp.webservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andysilver
 */
@XmlRootElement
public class Employee implements Serializable {

    private int empId;
    private String empName;
    private Date Birthday;
    private boolean isResigned;

    private List<SalaryDetails> salarys;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public boolean isIsResigned() {
        return isResigned;
    }

    public void setIsResigned(boolean isResigned) {
        this.isResigned = isResigned;
    }

    public List<SalaryDetails> getSalarys() {
        return salarys;
    }

    public void setSalarys(List<SalaryDetails> salarys) {
        this.salarys = salarys;
    }

}
