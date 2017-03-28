package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/23.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchDayProductQueryData implements Serializable {


    /**
     * data : [{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"559214.4","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"176.0","dailyrq":"2015-12-18","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1701613.3","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"532.0","dailyrq":"2015-12-17","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1303787.9","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"409.0","dailyrq":"2015-12-16","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"723952.7","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"227.0","dailyrq":"2015-12-15","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"714644.1","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"224.0","dailyrq":"2015-12-12","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"521617.7","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"165.0","dailyrq":"2015-12-11","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"2001905.3","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"612.0","dailyrq":"2015-12-10","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1241975.3","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"379.0","dailyrq":"2015-12-09","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"378818.3","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"119.0","dailyrq":"2015-12-08","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1601582.0","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"501.0","dailyrq":"2015-12-07","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1109463.8","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"339.0","dailyrq":"2015-12-06","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1791646.0","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"560.0","dailyrq":"2015-12-04","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1346811.3","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"409.0","dailyrq":"2015-12-03","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1008615.8","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"302.0","dailyrq":"2015-12-02","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"},{"banhezhanminchen":"test1","dailybuwei":"","dailycd":"0.0","dailycl":"1251567.3","dailyhd":"0.0","dailykd":"0.0","dailymd":"0.0","dailyps":"375.0","dailyrq":"2015-12-01","dailysjhd":"0.0","dailyxh":"","dailyxzcl":"0.0"}]
     * success : true
     */

    private boolean success;
    private List<DataEntity> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * banhezhanminchen : test1
         * dailybuwei :
         * dailycd : 0.0
         * dailycl : 559214.4
         * dailyhd : 0.0
         * dailykd : 0.0
         * dailymd : 0.0
         * dailyps : 176.0
         * dailyrq : 2015-12-18
         * dailysjhd : 0.0
         * dailyxh :
         * dailyxzcl : 0.0
         */

        private String banhezhanminchen;
        private String dailybuwei;
        private String dailycd;
        private String dailycl;
        private String dailyhd;
        private String dailykd;
        private String dailymd;
        private String dailyps;
        private String dailyrq;
        private String dailysjhd;
        private String dailyxh;
        private String dailyxzcl;

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public String getDailybuwei() {
            return dailybuwei;
        }

        public void setDailybuwei(String dailybuwei) {
            this.dailybuwei = dailybuwei;
        }

        public String getDailycd() {
            return dailycd;
        }

        public void setDailycd(String dailycd) {
            this.dailycd = dailycd;
        }

        public String getDailycl() {
            return dailycl;
        }

        public void setDailycl(String dailycl) {
            this.dailycl = dailycl;
        }

        public String getDailyhd() {
            return dailyhd;
        }

        public void setDailyhd(String dailyhd) {
            this.dailyhd = dailyhd;
        }

        public String getDailykd() {
            return dailykd;
        }

        public void setDailykd(String dailykd) {
            this.dailykd = dailykd;
        }

        public String getDailymd() {
            return dailymd;
        }

        public void setDailymd(String dailymd) {
            this.dailymd = dailymd;
        }

        public String getDailyps() {
            return dailyps;
        }

        public void setDailyps(String dailyps) {
            this.dailyps = dailyps;
        }

        public String getDailyrq() {
            return dailyrq;
        }

        public void setDailyrq(String dailyrq) {
            this.dailyrq = dailyrq;
        }

        public String getDailysjhd() {
            return dailysjhd;
        }

        public void setDailysjhd(String dailysjhd) {
            this.dailysjhd = dailysjhd;
        }

        public String getDailyxh() {
            return dailyxh;
        }

        public void setDailyxh(String dailyxh) {
            this.dailyxh = dailyxh;
        }

        public String getDailyxzcl() {
            return dailyxzcl;
        }

        public void setDailyxzcl(String dailyxzcl) {
            this.dailyxzcl = dailyxzcl;
        }
    }
}
