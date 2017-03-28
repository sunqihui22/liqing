package com.shtoone.liqing.mvp.model.bean;


import java.io.Serializable;

/**
 * 用户实体类
 * Created by leguang on 2016/5/11 0031.
 */
public class UserInfoBean implements Cloneable, Serializable{

    /**
     * biaoshi :
     * chuzhi : 1
     * shenehe : 1
     * success : true
     * userFullName : 管理员
     * userType : 1
     */

    private String biaoshi;
    private int chuzhi;
    private int shenehe;
    private boolean success;
    private String userFullName;
    private String userType;

    public String getBiaoshi() {
        return biaoshi;
    }

    public void setBiaoshi(String biaoshi) {
        this.biaoshi = biaoshi;
    }

    public int getChuzhi() {
        return chuzhi;
    }

    public void setChuzhi(int chuzhi) {
        this.chuzhi = chuzhi;
    }

    public int getShenehe() {
        return shenehe;
    }

    public void setShenehe(int shenehe) {
        this.shenehe = shenehe;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

//    public UserInfoBean clone()
//    {
//        try {
//            return  this.clone();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

    //克隆
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
