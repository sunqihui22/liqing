package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by gesangdianzi on 2016/9/5.
 */
public class PendingTreatRVItemData implements Serializable{

    private String name;
    private String data;
    private String cb;


    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PendingTreatRVItemData{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", cb='" + cb + '\'' +
                '}';
    }
}
