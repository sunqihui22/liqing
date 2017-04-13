package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchStatisticsData implements Serializable {

    /**
     * data : [{"cblx":"","mbpeibi":"89.7","name":"2#仓","scpeibi":"","sgpeibi":"","wucha":"-5.02","yongliang":"85.2"},{"cblx":"","mbpeibi":"142.5","name":"3#仓","scpeibi":"","sgpeibi":"","wucha":"-4.56","yongliang":"136.0"},{"cblx":"","mbpeibi":"71.5","name":"4#仓","scpeibi":"","sgpeibi":"","wucha":"-4.06","yongliang":"68.6"},{"cblx":"","mbpeibi":"17.1","name":"5#仓","scpeibi":"","sgpeibi":"","wucha":"-1.17","yongliang":"16.9"},{"cblx":"","mbpeibi":"127.1","name":"6#仓","scpeibi":"","sgpeibi":"","wucha":"-4.09","yongliang":"121.9"},{"cblx":"","mbpeibi":"7.8","name":"矿粉1","scpeibi":"","sgpeibi":"","wucha":"-3.85","yongliang":"7.5"},{"cblx":"","mbpeibi":"11.3","name":"矿粉2","scpeibi":"","sgpeibi":"","wucha":"-7.08","yongliang":"10.5"},{"cblx":"","mbpeibi":"20.8","name":"沥青","scpeibi":"","sgpeibi":"","wucha":"0.48","yongliang":"20.9"}]
     * success : true
     * tableName : 兴华高速LM1标
     */

    private boolean success;
    private String tableName;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cblx :
         * mbpeibi : 89.7
         * name : 2#仓
         * scpeibi :
         * sgpeibi :
         * wucha : -5.02
         * yongliang : 85.2
         */

        private String cblx;
        private String mbpeibi;
        private String name;
        private String scpeibi;
        private String sgpeibi;
        private String wucha;
        private String yongliang;

        public String getCblx() {
            return cblx;
        }

        public void setCblx(String cblx) {
            this.cblx = cblx;
        }

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
