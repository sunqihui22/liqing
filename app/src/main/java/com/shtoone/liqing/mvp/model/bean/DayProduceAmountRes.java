package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
public class DayProduceAmountRes {


    /**
     * data : [{"dailycl":"250361.10","dailymd":"","dailykd":"","dailyxzcl":"","dailyps":"94","dailyxh":"","dailybeizhu":"","dailybuwei":"","dailyrq":"2016-10-20","dailysbbh":"G345lq0101","dailyid":20007,"dailyhd":"","dailycd":"","dailysjhd":""},{"dailycl":"6205.40","dailymd":"","dailykd":"","dailyxzcl":"","dailyps":"3","dailyxh":"","dailybeizhu":"","dailybuwei":"","dailyrq":"2016-10-16","dailysbbh":"G345lq0101","dailyid":20006,"dailyhd":"","dailycd":"","dailysjhd":""},{"dailycl":"34354.90","dailymd":"","dailykd":"","dailyxzcl":"","dailyps":"16","dailyxh":"","dailybeizhu":"","dailybuwei":"","dailyrq":"2016-10-15","dailysbbh":"G345lq0101","dailyid":10006,"dailyhd":"","dailycd":"","dailysjhd":""},{"dailycl":"522657.10","dailymd":"","dailykd":"","dailyxzcl":"","dailyps":"201","dailyxh":"","dailybeizhu":"","dailybuwei":"","dailyrq":"2016-10-13","dailysbbh":"G345lq0101","dailyid":10005,"dailyhd":"","dailycd":"","dailysjhd":""},{"dailycl":"313944.10","dailymd":"","dailykd":"","dailyxzcl":"","dailyps":"147","dailyxh":"","dailybeizhu":"","dailybuwei":"","dailyrq":"2016-10-09","dailysbbh":"G345lq0101","dailyid":10004,"dailyhd":"","dailycd":"","dailysjhd":""},{"dailycl":"57246.00","dailymd":"","dailykd":"","dailyxzcl":"","dailyps":"26","dailyxh":"","dailybeizhu":"","dailybuwei":"","dailyrq":"2016-10-08","dailysbbh":"G345lq0101","dailyid":10003,"dailyhd":"","dailycd":"","dailysjhd":""},{"dailycl":"592871.40","dailymd":"","dailykd":"","dailyxzcl":"","dailyps":"268","dailyxh":"","dailybeizhu":"","dailybuwei":"","dailyrq":"2016-10-06","dailysbbh":"G345lq0101","dailyid":10002,"dailyhd":"","dailycd":"","dailysjhd":""},{"dailycl":"836952.30","dailymd":"5","dailykd":"3","dailyxzcl":"1","dailyps":"329","dailyxh":"10","dailybeizhu":"6","dailybuwei":"7","dailyrq":"2016-10-03","dailysbbh":"G345lq0101","dailyid":2,"dailyhd":"4.0","dailycd":"2","dailysjhd":"9"},{"dailycl":"4597.10","dailymd":"6","dailykd":"4","dailyxzcl":"1","dailyps":"2","dailyxh":"11","dailybeizhu":"7","dailybuwei":"8","dailyrq":"2016-09-19","dailysbbh":"G345lq0101","dailyid":1,"dailyhd":"5.0","dailycd":"3","dailysjhd":"10"}]
     * success : true
     */

    private boolean success;
    /**
     * dailycl : 250361.10
     * dailymd :
     * dailykd :
     * dailyxzcl :
     * dailyps : 94
     * dailyxh :
     * dailybeizhu :
     * dailybuwei :
     * dailyrq : 2016-10-20
     * dailysbbh : G345lq0101
     * dailyid : 20007
     * dailyhd :
     * dailycd :
     * dailysjhd :
     */

    private List<DayProduceAmountResData> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DayProduceAmountResData> getData() {
        return data;
    }

    public void setData(List<DayProduceAmountResData> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "DayProduceAmountRes{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
