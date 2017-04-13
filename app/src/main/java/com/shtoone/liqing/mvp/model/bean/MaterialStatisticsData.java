package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * @author: Administrator
 * @time 2017-03-15 10:28
 * @email 770164810@qq.com
 */

public class MaterialStatisticsData {


    /**
     * data : [{"cblx":"","mbpeibi":"11325.3","name":"实际粉料1","scpeibi":"","sgpeibi":"","wucha":"11.65","yongliang":"12645.12"},{"cblx":"","mbpeibi":"0.0","name":"实际粉料2","scpeibi":"","sgpeibi":"","wucha":"0.00","yongliang":"0.00"},{"cblx":"","mbpeibi":"78296.6","name":"实际骨料1","scpeibi":"","sgpeibi":"","wucha":"-55.56","yongliang":"34795.55"},{"cblx":"","mbpeibi":"195695.8","name":"实际骨料2","scpeibi":"","sgpeibi":"","wucha":"-55.70","yongliang":"86694.03"},{"cblx":"","mbpeibi":"195778.0","name":"实际骨料3","scpeibi":"","sgpeibi":"","wucha":"-55.71","yongliang":"86700.86"},{"cblx":"","mbpeibi":"149230.1","name":"实际骨料4","scpeibi":"","sgpeibi":"","wucha":"-58.51","yongliang":"61911.85"},{"cblx":"","mbpeibi":"149940.8","name":"实际骨料5","scpeibi":"","sgpeibi":"","wucha":"-58.24","yongliang":"62618.51"}]
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
         * mbpeibi : 11325.3
         * name : 实际粉料1
         * scpeibi :
         * sgpeibi :
         * wucha : 11.65
         * yongliang : 12645.12
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
