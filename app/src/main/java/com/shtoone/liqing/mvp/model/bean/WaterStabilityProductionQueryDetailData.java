package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/21.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityProductionQueryDetailData implements Serializable {


    /**
     * data : [{"mbpeibi":"4.00","name":"水泥1","scpeibi":"","sgpeibi":"","wucha":"4.10","yongliang":"1803.54"},{"mbpeibi":"0.00","name":"水泥2","scpeibi":"","sgpeibi":"","wucha":"0.00","yongliang":"0.00"},{"mbpeibi":"10.00","name":"5-10mm","scpeibi":"","sgpeibi":"","wucha":"9.79","yongliang":"4308.74"},{"mbpeibi":"25.00","name":"10-20mm","scpeibi":"","sgpeibi":"","wucha":"25.10","yongliang":"11043.85"},{"mbpeibi":"25.00","name":"10-30mm","scpeibi":"","sgpeibi":"","wucha":"24.78","yongliang":"10902.53"},{"mbpeibi":"20.00","name":"石粉1","scpeibi":"","sgpeibi":"","wucha":"20.45","yongliang":"9000.16"},{"mbpeibi":"20.00","name":"石粉2","scpeibi":"","sgpeibi":"","wucha":"19.89","yongliang":"8750.87"}]
     * success : true
     * swChartDataList : [{"maxPassper":"3.0","minPassper":"0.0","name":"0.075","passper":"3.1","standPassper":"2.7","wcz":"0.40","yjsx":"4.70","yjxx":"0.70","yjz":"-2~2"},{"maxPassper":"15.0","minPassper":"8.0","name":"0.6","passper":"13.6","standPassper":"12.0","wcz":"1.60","yjsx":"16.00","yjxx":"8.00","yjz":"-4~4"},{"maxPassper":"28.0","minPassper":"16.0","name":"2.36","passper":"24.4","standPassper":"21.4","wcz":"3.00","yjsx":"25.40","yjxx":"17.40","yjz":"-4~4"},{"maxPassper":"35.0","minPassper":"25.0","name":"4.75","passper":"36.8","standPassper":"32.1","wcz":"4.70","yjsx":"38.10","yjxx":"26.10","yjz":"-6~6"},{"maxPassper":"58.0","minPassper":"38.0","name":"9.5","passper":"51.3","standPassper":"47.1","wcz":"4.20","yjsx":"53.10","yjxx":"41.10","yjz":"-6~6"},{"maxPassper":"86.0","minPassper":"68.0","name":"19","passper":"77.5","standPassper":"74.7","wcz":"2.80","yjsx":"80.70","yjxx":"68.70","yjz":"-6~6"},{"maxPassper":"100.0","minPassper":"100.0","name":"31.5","passper":"100.1","standPassper":"100.0","wcz":"0.10","yjsx":"106.00","yjxx":"94.00","yjz":"-6~6"}]
     * swHead : {"baocunshijian":"2017-02-24 06:47:47:478","bhjName":"LM1标水稳1#机","chuliaoshijian":"2017-02-23 17:27:10","zcl":"44006.15"}
     */

    private boolean success;
    private SwHeadEntity swHead;
    private List<DataEntity> data;
    private List<SwChartDataListEntity> swChartDataList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public SwHeadEntity getSwHead() {
        return swHead;
    }

    public void setSwHead(SwHeadEntity swHead) {
        this.swHead = swHead;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<SwChartDataListEntity> getSwChartDataList() {
        return swChartDataList;
    }

    public void setSwChartDataList(List<SwChartDataListEntity> swChartDataList) {
        this.swChartDataList = swChartDataList;
    }

    public static class SwHeadEntity {
        /**
         * baocunshijian : 2017-02-24 06:47:47:478
         * bhjName : LM1标水稳1#机
         * chuliaoshijian : 2017-02-23 17:27:10
         * zcl : 44006.15
         */

        private String baocunshijian;
        private String bhjName;
        private String chuliaoshijian;
        private String zcl;

        public String getBaocunshijian() {
            return baocunshijian;
        }

        public void setBaocunshijian(String baocunshijian) {
            this.baocunshijian = baocunshijian;
        }

        public String getBhjName() {
            return bhjName;
        }

        public void setBhjName(String bhjName) {
            this.bhjName = bhjName;
        }

        public String getChuliaoshijian() {
            return chuliaoshijian;
        }

        public void setChuliaoshijian(String chuliaoshijian) {
            this.chuliaoshijian = chuliaoshijian;
        }

        public String getZcl() {
            return zcl;
        }

        public void setZcl(String zcl) {
            this.zcl = zcl;
        }
    }

    public static class DataEntity {
        /**
         * mbpeibi : 4.00
         * name : 水泥1
         * scpeibi :
         * sgpeibi :
         * wucha : 4.10
         * yongliang : 1803.54
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

    public static class SwChartDataListEntity {
        /**
         * maxPassper : 3.0
         * minPassper : 0.0
         * name : 0.075
         * passper : 3.1
         * standPassper : 2.7
         * wcz : 0.40
         * yjsx : 4.70
         * yjxx : 0.70
         * yjz : -2~2
         */

        private String maxPassper;
        private String minPassper;
        private String name;
        private String passper;
        private String standPassper;
        private String wcz;
        private String yjsx;
        private String yjxx;
        private String yjz;

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

        public String getWcz() {
            return wcz;
        }

        public void setWcz(String wcz) {
            this.wcz = wcz;
        }

        public String getYjsx() {
            return yjsx;
        }

        public void setYjsx(String yjsx) {
            this.yjsx = yjsx;
        }

        public String getYjxx() {
            return yjxx;
        }

        public void setYjxx(String yjxx) {
            this.yjxx = yjxx;
        }

        public String getYjz() {
            return yjz;
        }

        public void setYjz(String yjz) {
            this.yjz = yjz;
        }
    }
}
