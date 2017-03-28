package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * @author: Administrator
 * @time 2017-03-15 10:28
 * @email 770164810@qq.com
 */

public class MaterialStatisticsData {


    /**
     * data : [{"mbpeibi":"26627.8","name":"实际粉料1","scpeibi":"","sgpeibi":"","wucha":"53.78","yongliang":"40947.01"},{"mbpeibi":"7.8","name":"实际粉料2","scpeibi":"","sgpeibi":"","wucha":"193.97","yongliang":"22.93"},{"mbpeibi":"214939.1","name":"实际骨料1","scpeibi":"","sgpeibi":"","wucha":"-26.45","yongliang":"158087.73"},{"mbpeibi":"426915.8","name":"实际骨料2","scpeibi":"","sgpeibi":"","wucha":"-33.48","yongliang":"283978.09"},{"mbpeibi":"399507.5","name":"实际骨料3","scpeibi":"","sgpeibi":"","wucha":"-35.78","yongliang":"256570.73"},{"mbpeibi":"327165.5","name":"实际骨料4","scpeibi":"","sgpeibi":"","wucha":"-34.96","yongliang":"212800.05"},{"mbpeibi":"328721.9","name":"实际骨料5","scpeibi":"","sgpeibi":"","wucha":"-34.78","yongliang":"214378.63"}]
     * success : true
     */

    private boolean success;
    /**
     * mbpeibi : 26627.8
     * name : 实际粉料1
     * scpeibi :
     * sgpeibi :
     * wucha : 53.78
     * yongliang : 40947.01
     */

    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String mbpeibi;
        private String name;
        private String scpeibi;
        private String sgpeibi;
        private String wucha;
        private String yongliang;

        public String getMbpeibi() {
            return mbpeibi;
        }

        public void setMbpeibi(String mbpeibi) {
            this.mbpeibi = mbpeibi;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScpeibi() {
            return scpeibi;
        }

        public void setScpeibi(String scpeibi) {
            this.scpeibi = scpeibi;
        }

        public String getSgpeibi() {
            return sgpeibi;
        }

        public void setSgpeibi(String sgpeibi) {
            this.sgpeibi = sgpeibi;
        }

        public String getWucha() {
            return wucha;
        }

        public void setWucha(String wucha) {
            this.wucha = wucha;
        }

        public String getYongliang() {
            return yongliang;
        }

        public void setYongliang(String yongliang) {
            this.yongliang = yongliang;
        }
    }
}
