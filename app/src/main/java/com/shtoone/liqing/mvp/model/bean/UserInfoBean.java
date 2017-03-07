package com.shtoone.liqing.mvp.model.bean;


import java.util.List;

/**
 * 用户实体类
 * Created by leguang on 2016/5/11 0031.
 */
public class UserInfoBean {

    /**
     * SMSGroup : []
     * departId : 297ee90c4447f8a4014447fbba1e0015
     * departName : G345线玛曲至青海久治公路
     * quanxian : {"hntchaobiaoReal":true,"hntchaobiaoSp":true,"syschaobiaoReal":true}
     * success : true
     * type : GL
     * updateDepartTime : 2015-12-02 12:12:36
     * userFullName : 上海同望
     * userPhoneNum : 15972036794
     * userRole : 4
     * xmmc : 项目APP
     */

    private String departId;
    private String departName;
    /**
     * hntchaobiaoReal : true
     * hntchaobiaoSp : true
     * syschaobiaoReal : true
     */

    private QuanxianEntity quanxian;
    private boolean success;
    private String type;
    private String updateDepartTime;
    private String userFullName;
    private String userPhoneNum;
    private String userRole;
    private String xmmc;
    private List<?> SMSGroup;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public QuanxianEntity getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(QuanxianEntity quanxian) {
        this.quanxian = quanxian;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateDepartTime() {
        return updateDepartTime;
    }

    public void setUpdateDepartTime(String updateDepartTime) {
        this.updateDepartTime = updateDepartTime;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public List<?> getSMSGroup() {
        return SMSGroup;
    }

    public void setSMSGroup(List<?> SMSGroup) {
        this.SMSGroup = SMSGroup;
    }

    public static class QuanxianEntity {
        private boolean hntchaobiaoReal;
        private boolean hntchaobiaoSp;
        private boolean syschaobiaoReal;

        public boolean isHntchaobiaoReal() {
            return hntchaobiaoReal;
        }

        public void setHntchaobiaoReal(boolean hntchaobiaoReal) {
            this.hntchaobiaoReal = hntchaobiaoReal;
        }

        public boolean isHntchaobiaoSp() {
            return hntchaobiaoSp;
        }

        public void setHntchaobiaoSp(boolean hntchaobiaoSp) {
            this.hntchaobiaoSp = hntchaobiaoSp;
        }

        public boolean isSyschaobiaoReal() {
            return syschaobiaoReal;
        }

        public void setSyschaobiaoReal(boolean syschaobiaoReal) {
            this.syschaobiaoReal = syschaobiaoReal;
        }
    }
}
