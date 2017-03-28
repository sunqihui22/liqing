package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/15.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityOverProofDetailsBean implements Serializable {


    /**
     * swHead : {"baocunshijian":"2017-02-24 06:41:51","bhjName":"LM1标水稳1#机","chuliaoshijian":"2017-02-23 17:22:10","zcl":"44224.90"}
     * swData : [{"mbpeibi":"5.0","name":"实际粉料1","scpeibi":"4.04","sgpeibi":"4.00","wucha":"-0.96","yongliang":"1788.07"},{"mbpeibi":"","name":"实际粉料2","scpeibi":"0.00","sgpeibi":"0.00","wucha":"0.00","yongliang":"0.00"},{"mbpeibi":"11","name":"实际骨料1","scpeibi":"9.94","sgpeibi":"10.00","wucha":"-1.06","yongliang":"4394.25"},{"mbpeibi":"27","name":"实际骨料2","scpeibi":"25.02","sgpeibi":"25.00","wucha":"-1.98","yongliang":"11066.74"},{"mbpeibi":"27","name":"实际骨料3","scpeibi":"25.11","sgpeibi":"25.00","wucha":"-1.89","yongliang":"11104.45"},{"mbpeibi":"35","name":"实际骨料4","scpeibi":"19.89","sgpeibi":"20.00","wucha":"4.93","yongliang":"8796.45"},{"mbpeibi":"","name":"实际骨料5","scpeibi":"20.04","sgpeibi":"20.00","wucha":"4.93","yongliang":"8863.01"}]
     * swjg : {"beizhu":"","chulifangshi":"无需处理","chulijieguo":"无需处理","chuliren":"郭胜伟","confirmdate":"","filePath":"","shenpidate":"","wentiyuanyin":"系统错误，目标配合比未转换，实际不影响施工。","yezhuren":"","yezhuyijian":""}
     * success : true
     */

    private SwHeadEntity swHead;
    private SwjgEntity swjg;
    private boolean success;
    private List<SwDataEntity> swData;

    public SwHeadEntity getSwHead() {
        return swHead;
    }

    public void setSwHead(SwHeadEntity swHead) {
        this.swHead = swHead;
    }

    public SwjgEntity getSwjg() {
        return swjg;
    }

    public void setSwjg(SwjgEntity swjg) {
        this.swjg = swjg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<SwDataEntity> getSwData() {
        return swData;
    }

    public void setSwData(List<SwDataEntity> swData) {
        this.swData = swData;
    }

    public static class SwHeadEntity {
        /**
         * baocunshijian : 2017-02-24 06:41:51
         * bhjName : LM1标水稳1#机
         * chuliaoshijian : 2017-02-23 17:22:10
         * zcl : 44224.90
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

    public static class SwjgEntity {
        /**
         * beizhu :
         * chulifangshi : 无需处理
         * chulijieguo : 无需处理
         * chuliren : 郭胜伟
         * confirmdate :
         * filePath :
         * shenpidate :
         * wentiyuanyin : 系统错误，目标配合比未转换，实际不影响施工。
         * yezhuren :
         * yezhuyijian :
         */

        private String beizhu;
        private String chulifangshi;
        private String chulijieguo;
        private String chuliren;
        private String confirmdate;
        private String filePath;
        private String shenpidate;
        private String wentiyuanyin;
        private String yezhuren;
        private String yezhuyijian;

        public String getBeizhu() {
            return beizhu;
        }

        public void setBeizhu(String beizhu) {
            this.beizhu = beizhu;
        }

        public String getChulifangshi() {
            return chulifangshi;
        }

        public void setChulifangshi(String chulifangshi) {
            this.chulifangshi = chulifangshi;
        }

        public String getChulijieguo() {
            return chulijieguo;
        }

        public void setChulijieguo(String chulijieguo) {
            this.chulijieguo = chulijieguo;
        }

        public String getChuliren() {
            return chuliren;
        }

        public void setChuliren(String chuliren) {
            this.chuliren = chuliren;
        }

        public String getConfirmdate() {
            return confirmdate;
        }

        public void setConfirmdate(String confirmdate) {
            this.confirmdate = confirmdate;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getShenpidate() {
            return shenpidate;
        }

        public void setShenpidate(String shenpidate) {
            this.shenpidate = shenpidate;
        }

        public String getWentiyuanyin() {
            return wentiyuanyin;
        }

        public void setWentiyuanyin(String wentiyuanyin) {
            this.wentiyuanyin = wentiyuanyin;
        }

        public String getYezhuren() {
            return yezhuren;
        }

        public void setYezhuren(String yezhuren) {
            this.yezhuren = yezhuren;
        }

        public String getYezhuyijian() {
            return yezhuyijian;
        }

        public void setYezhuyijian(String yezhuyijian) {
            this.yezhuyijian = yezhuyijian;
        }
    }

    public static class SwDataEntity {
        /**
         * mbpeibi : 5.0
         * name : 实际粉料1
         * scpeibi : 4.04
         * sgpeibi : 4.00
         * wucha : -0.96
         * yongliang : 1788.07
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
