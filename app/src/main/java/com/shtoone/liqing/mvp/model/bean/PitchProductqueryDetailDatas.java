package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/22.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchProductqueryDetailDatas implements Serializable {


    /**
     * lqChartDataList : [{"maxPassper":"7","minPassper":"3","name":"0.075","passper":"5.2","standPassper":""},{"maxPassper":"8","minPassper":"4","name":"0.15","passper":"6.7999997","standPassper":""},{"maxPassper":"9","minPassper":"5","name":"0.3","passper":"9.7","standPassper":""},{"maxPassper":"13","minPassper":"7","name":"0.6","passper":"14.900002","standPassper":""},{"maxPassper":"16","minPassper":"10","name":"1.18","passper":"21.599998","standPassper":""},{"maxPassper":"23","minPassper":"15","name":"2.36","passper":"29.8","standPassper":""},{"maxPassper":"33","minPassper":"25","name":"4.75","passper":"45.300003","standPassper":""},{"maxPassper":"49","minPassper":"39","name":"9.5","passper":"71.700005","standPassper":""},{"maxPassper":"59","minPassper":"49","name":"13.2","passper":"94.8","standPassper":""},{"maxPassper":"66","minPassper":"57","name":"16","passper":"30.5","standPassper":""},{"maxPassper":"72","minPassper":"63","name":"19","passper":"100.1","standPassper":""},{"maxPassper":"90","minPassper":"82","name":"26.5","passper":"30.5","standPassper":""},{"maxPassper":"100","minPassper":"90","name":"31.5","passper":"30.5","standPassper":""},{"maxPassper":"100","minPassper":"100","name":"37.5","passper":"30.5","standPassper":""},{"maxPassper":"100","minPassper":"100","name":"53","passper":"30.5","standPassper":""}]
     * lqHead : {"bhjName":"test1","caijishijian":"2016-06-23 09:36:39:104","chuliaoshijian":"2016-07-20 21:34:21","cl":"3983.1"}
     * lqData : [{"mbpeibi":"","name":"1#仓","scpeibi":"34.03","sgpeibi":"21.0","wucha":"13.03","yongliang":"1301.0"},{"mbpeibi":"","name":"2#仓","scpeibi":"34.0","sgpeibi":"12.0","wucha":"-2.66","yongliang":"357.0"},{"mbpeibi":"","name":"3#仓","scpeibi":"23.5","sgpeibi":"16.0","wucha":"7.52","yongliang":"899.0"},{"mbpeibi":"","name":"4#仓","scpeibi":"16.8","sgpeibi":"25.0","wucha":"-8.18","yongliang":"643.0"},{"mbpeibi":"","name":"5#仓","scpeibi":"11.4","sgpeibi":"24.0","wucha":"-12.62","yongliang":"435.0"},{"mbpeibi":"","name":"6#仓","scpeibi":"0.0","sgpeibi":"","wucha":"","yongliang":"0.0"},{"mbpeibi":"","name":"7#仓","scpeibi":"0.0","sgpeibi":"","wucha":"","yongliang":"0.0"},{"mbpeibi":"","name":"矿粉1","scpeibi":"4.9","sgpeibi":"","wucha":"","yongliang":"187.6"},{"mbpeibi":"","name":"矿粉2","scpeibi":"0.0","sgpeibi":"1.0","wucha":"-1.00","yongliang":"0.0"},{"mbpeibi":"","name":"沥青","scpeibi":"4.0","sgpeibi":"3.8","wucha":"0.19","yongliang":"160.5"},{"mbpeibi":"","name":"添加剂","scpeibi":"0.0","sgpeibi":"1.0","wucha":"-1.00","yongliang":""}]
     * success : true
     */

    private LqHeadEntity lqHead;
    private boolean success;
    private List<LqChartDataListEntity> lqChartDataList;
    private List<LqDataEntity> lqData;

    public LqHeadEntity getLqHead() {
        return lqHead;
    }

    public void setLqHead(LqHeadEntity lqHead) {
        this.lqHead = lqHead;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<LqChartDataListEntity> getLqChartDataList() {
        return lqChartDataList;
    }

    public void setLqChartDataList(List<LqChartDataListEntity> lqChartDataList) {
        this.lqChartDataList = lqChartDataList;
    }

    public List<LqDataEntity> getLqData() {
        return lqData;
    }

    public void setLqData(List<LqDataEntity> lqData) {
        this.lqData = lqData;
    }

    public static class LqHeadEntity {
        /**
         * bhjName : test1
         * caijishijian : 2016-06-23 09:36:39:104
         * chuliaoshijian : 2016-07-20 21:34:21
         * cl : 3983.1
         */

        private String bhjName;
        private String caijishijian;
        private String chuliaoshijian;
        private String cl;

        public String getBhjName() {
            return bhjName;
        }

        public void setBhjName(String bhjName) {
            this.bhjName = bhjName;
        }

        public String getCaijishijian() {
            return caijishijian;
        }

        public void setCaijishijian(String caijishijian) {
            this.caijishijian = caijishijian;
        }

        public String getChuliaoshijian() {
            return chuliaoshijian;
        }

        public void setChuliaoshijian(String chuliaoshijian) {
            this.chuliaoshijian = chuliaoshijian;
        }

        public String getCl() {
            return cl;
        }

        public void setCl(String cl) {
            this.cl = cl;
        }
    }

    public static class LqChartDataListEntity {
        /**
         * maxPassper : 7
         * minPassper : 3
         * name : 0.075
         * passper : 5.2
         * standPassper :
         */

        private String maxPassper;
        private String minPassper;
        private String name;
        private String passper;
        private String standPassper;

        public String getMaxPassper() {
            return maxPassper;
        }

        public void setMaxPassper(String maxPassper) {
            this.maxPassper = maxPassper;
        }

        public String getMinPassper() {
            return minPassper;
        }

        public void setMinPassper(String minPassper) {
            this.minPassper = minPassper;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassper() {
            return passper;
        }

        public void setPassper(String passper) {
            this.passper = passper;
        }

        public String getStandPassper() {
            return standPassper;
        }

        public void setStandPassper(String standPassper) {
            this.standPassper = standPassper;
        }
    }

    public static class LqDataEntity {
        /**
         * mbpeibi :
         * name : 1#仓
         * scpeibi : 34.03
         * sgpeibi : 21.0
         * wucha : 13.03
         * yongliang : 1301.0
         */

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
