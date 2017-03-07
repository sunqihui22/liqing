package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
public class TotalAmountRes {


    /**
     * data : [{"primaryPer":"80.59","primaryps":"357","highps":"0","panshu":"443","xb":"9","middleps":"36","xa":"2016","changliang":"1132865.8","middlePer":"8.13","highPer":"0.00"},{"primaryPer":"56.76","primaryps":"1235","highps":"0","panshu":"2176","xb":"10","middleps":"72","xa":"2016","changliang":"5545717.9","middlePer":"3.31","highPer":"0.00"}]
     * success : true
     */

    private boolean success;
    /**
     * primaryPer : 80.59
     * primaryps : 357
     * highps : 0
     * panshu : 443
     * xb : 9
     * middleps : 36
     * xa : 2016
     * changliang : 1132865.8
     * middlePer : 8.13
     * highPer : 0.00
     */

    private List<TotalAmountItemData> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<TotalAmountItemData> getData() {
        return data;
    }

    public void setData(List<TotalAmountItemData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TotalAmountRes{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
