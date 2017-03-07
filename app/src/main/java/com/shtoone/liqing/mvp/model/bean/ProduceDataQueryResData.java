package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/8.
 */
public class ProduceDataQueryResData implements Serializable {

    private String clwd;
    private String sjlq;
    private String sjysb;
    private int bianhao;
    private String shijian;
    private String deptId;
    private String shebeibianhao;

    public String getClwd() {
        return clwd;
    }

    public void setClwd(String clwd) {
        this.clwd = clwd;
    }

    public String getSjlq() {
        return sjlq;
    }

    public void setSjlq(String sjlq) {
        this.sjlq = sjlq;
    }

    public String getSjysb() {
        return sjysb;
    }

    public void setSjysb(String sjysb) {
        this.sjysb = sjysb;
    }

    public int getBianhao() {
        return bianhao;
    }

    public void setBianhao(int bianhao) {
        this.bianhao = bianhao;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getShebeibianhao() {
        return shebeibianhao;
    }

    public void setShebeibianhao(String shebeibianhao) {
        this.shebeibianhao = shebeibianhao;
    }

    @Override
    public String toString() {
        return "ProduceDataQueryResData{" +
                "clwd='" + clwd + '\'' +
                ", sjlq='" + sjlq + '\'' +
                ", sjysb='" + sjysb + '\'' +
                ", bianhao=" + bianhao +
                ", shijian='" + shijian + '\'' +
                ", deptId='" + deptId + '\'' +
                ", shebeibianhao='" + shebeibianhao + '\'' +
                '}';
    }
}
