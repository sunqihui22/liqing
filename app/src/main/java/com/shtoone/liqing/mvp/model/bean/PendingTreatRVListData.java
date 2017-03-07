package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gesangdianzi on 2016/9/2.
 */
public class PendingTreatRVListData implements Serializable{

    private int bianhao;
    private String shijian;
    private String shebeibianhao;
    private String chuli;

    public String getChuli() {
        return chuli;
    }

    public void setChuli(String chuli) {
        this.chuli = chuli;
    }

    private List<PendingTreatRVItemData> lists;

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public int getBianhao() {
        return bianhao;
    }

    public void setBianhao(int bianhao) {
        this.bianhao = bianhao;
    }

    public String getShebeibianhao() {
        return shebeibianhao;
    }

    public void setShebeibianhao(String shebeibianhao) {
        this.shebeibianhao = shebeibianhao;
    }

    public List<PendingTreatRVItemData> getLists() {
        return lists;
    }

    public void setLists(List<PendingTreatRVItemData> lists) {
        this.lists = lists;
    }


    @Override
    public String toString() {
        return "PendingTreatRVListData{" +
                "bianhao=" + bianhao +
                ", shijian='" + shijian + '\'' +
                ", shebeibianhao='" + shebeibianhao + '\'' +
                ", chuli='" + chuli + '\'' +
                ", lists=" + lists +
                '}';
    }
}
