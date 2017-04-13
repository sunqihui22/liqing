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
    public String departtype;
    public String department;
    public String bianhao;
    public String userType;
    public String exampleType;
    public String handleType;
    public String equipmentID="";
    public String userpositon="";


    public String getBiaoduan() {
        return biaoduan;
    }

    public void setBiaoduan(String biaoduan) {
        this.biaoduan = biaoduan;
    }

    public  String biaoduan="";

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBiaoshi() {
        return biaoshi;
    }

    public void setBiaoshi(String biaoshi) {
        this.biaoshi = biaoshi;
    }

    public String biaoshi;

    public DepartmentBean() {
    }

    public DepartmentBean(String departmentID, String departmentName, int fromto) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.fromto = fromto;
    }

    public DepartmentBean(String departmentID, String updateDepartTime,String funtype,String type,String departmentName) {
        this.departmentID = departmentID;
        this.departtype = type;
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

    @Override
    public String toString() {
        return "DepartmentBean{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", fromto=" + fromto +
                ", updateDepartTime='" + updateDepartTime + '\'' +
                ", funtype='" + funtype + '\'' +
                ", departtype='" + departtype + '\'' +
                ", department='" + department + '\'' +
                ", bianhao='" + bianhao + '\'' +
                ", userType='" + userType + '\'' +
                ", exampleType='" + exampleType + '\'' +
                ", handleType='" + handleType + '\'' +
                ", equipmentID='" + equipmentID + '\'' +
                ", userpositon='" + userpositon + '\'' +
                ", biaoduan='" + biaoduan + '\'' +
                ", biaoshi='" + biaoshi + '\'' +
                '}';
    }
}
