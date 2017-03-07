package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by leguang on 2016/8/4 0004.
 */
public class DepartmentBean implements Cloneable, Serializable {
    public String departmentID;
    public String departmentName;
    public int fromto;

    public String updateDepartTime;
    public String funtype;
    public String type;
    public String department;


    public DepartmentBean() {
    }

    public DepartmentBean(String departmentID, String departmentName, int fromto) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.fromto = fromto;
    }

    public DepartmentBean(String departmentID, String updateDepartTime,String funtype,String type,String departmentName) {
        this.departmentID = departmentID;
        this.type = type;
        this.updateDepartTime = updateDepartTime;
        this.funtype = funtype;
        this.departmentName=departmentName;
    }

    //克隆
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
