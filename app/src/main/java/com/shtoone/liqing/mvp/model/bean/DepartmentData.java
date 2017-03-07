package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by leguang on 2016/8/4 0004.
 */
public class DepartmentData implements Cloneable, Serializable {
    public String departmentID;
    public String updateDepartTime;
    public String funtype;
    public String type;
    public String departmentName;

    public DepartmentData() {
    }

    public DepartmentData(String departmentID, String updateDepartTime,String funtype,String type,String departmentName) {
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
