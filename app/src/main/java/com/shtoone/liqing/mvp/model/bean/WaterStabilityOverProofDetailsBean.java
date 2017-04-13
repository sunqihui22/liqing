package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/15.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityOverProofDetailsBean implements Serializable {


    /**
     * success : true
     * swData : [{"cblx":"","mbpeibi":"5.0","name":"水泥1","scpeibi":"4.10","sgpeibi":"4.00","wucha":"-0.90","yongliang":"1803.54"},{"cblx":"","mbpeibi":"","name":"水泥2","scpeibi":"0.00","sgpeibi":"0.00","wucha":"0.00","yongliang":"0.00"},{"cblx":"","mbpeibi":"11","name":"5-10mm","scpeibi":"9.79","sgpeibi":"10.00","wucha":"-1.21","yongliang":"4308.74"},{"cblx":"","mbpeibi":"27","name":"10-20mm","scpeibi":"25.10","sgpeibi":"25.00","wucha":"-1.90","yongliang":"11043.85"},{"cblx":"","mbpeibi":"27","name":"10-30mm","scpeibi":"24.78","sgpeibi":"25.00","wucha":"-2.22","yongliang":"10902.53"},{"cblx":"6","mbpeibi":"35","name":"石粉1","scpeibi":"20.45","sgpeibi":"20.00","wucha":"5.34","yongliang":"9000.16"},{"cblx":"","mbpeibi":"","name":"石粉2","scpeibi":"19.89","sgpeibi":"20.00","wucha":"5.34","yongliang":"8750.87"}]
     * swHead : {"baocunshijian":"2017-02-24 06:47:47:478","bhjName":"LM1标水稳1#机","chuliaoshijian":"2017-02-23 17:27:10","zcl":"44006.15"}
     * swjg : {"beizhu":"bbb","chulifangshi":"无需处理","chulijieguo":"无需处理","chuliren":"admin","confirmdate":"2017-03-14 17:27:38","filePath":"hntChaobiaoAttachment/24965-1490771100196.png","shenpidate":"2017-03-29 15:08:00","wentiyuanyin":"系统错误，目标配合比未转换，实际不影响施工。","yezhuren":"admin","yezhuyijian":"aaaa"}
     */

    private boolean success;
    private SwHeadEntity swHead;
    private SwjgEntity swjg;
    private List<SwDataEntity> swData;

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

    public SwjgEntity getSwjg() {
        return swjg;
    }

    public void setSwjg(SwjgEntity swjg) {
        this.swjg = swjg;
    }

    public List<SwDataEntity> getSwData() {
        return swData;
    }

    public void setSwData(List<SwDataEntity> swData) {
        this.swData = swData;
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

    public static class SwjgEntity {
        /**
         * beizhu : bbb
         * chulifangshi : 无需处理
         * chulijieguo : 无需处理
         * chuliren : admin
         * confirmdate : 2017-03-14 17:27:38
         * filePath : hntChaobiaoAttachment/24965-1490771100196.png
         * shenpidate : 2017-03-29 15:08:00
         * wentiyuanyin : 系统错误，目标配合比未转换，实际不影响施工。
         * yezhuren : admin
         * yezhuyijian : aaaa
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
         * cblx :
         * mbpeibi : 5.0
         * name : 水泥1
         * scpeibi : 4.10
         * sgpeibi : 4.00
         * wucha : -0.90
         * yongliang : 1803.54
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
