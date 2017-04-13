package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/17.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchOverProofDetailsBean implements Serializable {

    /**
     * lqHead : {"bhjName":"test1","caijishijian":"2016-07-31 18:08:17:195","chuliaoshijian":"2016-07-23 10:17:32","cl":"2109.00"}
     * lqData : [{"cblx":"","mbpeibi":"","name":"1#仓","scpeibi":"0.00","sgpeibi":"0.00","wucha":"","yongliang":"0.00"},{"cblx":"","mbpeibi":"","name":"2#仓","scpeibi":"20.63","sgpeibi":"20.92","wucha":"-0.29","yongliang":"416.00"},{"cblx":"","mbpeibi":"","name":"3#仓","scpeibi":"30.26","sgpeibi":"32.43","wucha":"-2.17","yongliang":"610.00"},{"cblx":"","mbpeibi":"","name":"4#仓","scpeibi":"13.69","sgpeibi":"14.64","wucha":"-0.95","yongliang":"276.00"},{"cblx":"6","mbpeibi":"","name":"5#仓","scpeibi":"6.20","sgpeibi":"5.23","wucha":"0.97","yongliang":"125.00"},{"cblx":"","mbpeibi":"","name":"6#仓","scpeibi":"25.35","sgpeibi":"27.20","wucha":"-1.85","yongliang":"511.00"},{"cblx":"","mbpeibi":"","name":"7#仓","scpeibi":"0.00","sgpeibi":"0.00","wucha":"","yongliang":"0.00"},{"cblx":"","mbpeibi":"","name":"矿粉1","scpeibi":"0.00","sgpeibi":"0.00","wucha":"","yongliang":"0.00"},{"cblx":"","mbpeibi":"","name":"矿粉2","scpeibi":"3.87","sgpeibi":"4.18","wucha":"-0.31","yongliang":"78.00"},{"cblx":"","mbpeibi":"","name":"沥青","scpeibi":"4.41","sgpeibi":"4.40","wucha":"0.01","yongliang":"93.00"},{"cblx":"","mbpeibi":"","name":"添加剂","scpeibi":"0.00","sgpeibi":"0.00","wucha":"","yongliang":"0.00"},{"cblx":"","mbpeibi":"","name":"油石比(%)","scpeibi":"0.00","sgpeibi":"4.60","wucha":"0.01","yongliang":"4.61"}]
     * lqjg : {"beizhu":"测试备注","chulifangshi":"测试处理方式","chulijieguo":"测试处理结果","chuliren":"admin","confirmdate":"2017-03-01 14:34:34","filePath":"","shenpidate":"2017-1-1","wentiyuanyin":"测试处置内容","yezhuren":"admin","yezhuyijian":"没意见"}
     * success : true
     */

    private LqHeadEntity lqHead;
    private LqjgEntity lqjg;
    private boolean success;
    private List<LqDataEntity> lqData;

    public LqHeadEntity getLqHead() {
        return lqHead;
    }

    public void setLqHead(LqHeadEntity lqHead) {
        this.lqHead = lqHead;
    }

    public LqjgEntity getLqjg() {
        return lqjg;
    }

    public void setLqjg(LqjgEntity lqjg) {
        this.lqjg = lqjg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
         * caijishijian : 2016-07-31 18:08:17:195
         * chuliaoshijian : 2016-07-23 10:17:32
         * cl : 2109.00
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

    public static class LqjgEntity {
        /**
         * beizhu : 测试备注
         * chulifangshi : 测试处理方式
         * chulijieguo : 测试处理结果
         * chuliren : admin
         * confirmdate : 2017-03-01 14:34:34
         * filePath :
         * shenpidate : 2017-1-1
         * wentiyuanyin : 测试处置内容
         * yezhuren : admin
         * yezhuyijian : 没意见
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

    public static class LqDataEntity {
        /**
         * cblx :
         * mbpeibi :
         * name : 1#仓
         * scpeibi : 0.00
         * sgpeibi : 0.00
         * wucha :
         * yongliang : 0.00
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
