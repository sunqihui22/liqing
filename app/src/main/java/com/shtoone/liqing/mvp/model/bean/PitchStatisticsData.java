package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchStatisticsData implements Serializable {

    /**
     * data : [{"mbpeibi":"90.2","name":"2#仓","scpeibi":"","sgpeibi":"","wucha":"-5.10","yongliang":"85.6"},{"mbpeibi":"143.2","name":"3#仓","scpeibi":"","sgpeibi":"","wucha":"-4.47","yongliang":"136.8"},{"mbpeibi":"72.0","name":"4#仓","scpeibi":"","sgpeibi":"","wucha":"-4.03","yongliang":"69.1"},{"mbpeibi":"17.1","name":"5#仓","scpeibi":"","sgpeibi":"","wucha":"-1.17","yongliang":"16.9"},{"mbpeibi":"128.0","name":"6#仓","scpeibi":"","sgpeibi":"","wucha":"-4.14","yongliang":"122.7"},{"mbpeibi":"8.0","name":"矿粉1","scpeibi":"","sgpeibi":"","wucha":"-5.00","yongliang":"7.6"},{"mbpeibi":"11.3","name":"矿粉2","scpeibi":"","sgpeibi":"","wucha":"-7.08","yongliang":"10.5"},{"mbpeibi":"20.9","name":"沥青","scpeibi":"","sgpeibi":"","wucha":"0.48","yongliang":"21.0"}]
     * success : true
     */

    private boolean success;
    /**
     * mbpeibi : 90.2
     * name : 2#仓
     * scpeibi :
     * sgpeibi :
     * wucha : -5.10
     * yongliang : 85.6
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
