package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityOverProofBean implements Serializable {


    /**
     * data : [{"bianhao":"24965","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-02-23 17:27:10","shenhe":"1","sjf1":"1803.54","sjf2":"","sjg1":"4308.7","sjg2":"11043.8","sjg3":"10902.5","sjg4":"9000.2","sjg5":"8750.9","zcl":"44006.15"},{"bianhao":"24964","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-02-23 17:22:10","shenhe":"0","sjf1":"1788.07","sjf2":"","sjg1":"4394.3","sjg2":"11066.7","sjg3":"11104.5","sjg4":"8796.5","sjg5":"8863.0","zcl":"44224.90"},{"bianhao":"24963","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-02-23 17:17:10","shenhe":"0","sjf1":"1758.68","sjf2":"","sjg1":"4452.0","sjg2":"11167.9","sjg3":"11094.3","sjg4":"8765.7","sjg5":"8963.7","zcl":"44443.51"}]
     * field : {"bianhao":"编号","bzhName":"拌合站名称","chuli":"","clTime":"出料时间","shenhe":"","sjf1":"水泥1","sjf2":"水泥2","sjg1":"5-10mm","sjg2":"10-20mm","sjg3":"10-30mm","sjg4":"石粉1","sjg5":"石粉2","zcl":"总产量"}
     * isShow : {"bianhao":"","bzhName":"","chuli":"","clTime":"1","shenhe":"","sjf1":"1","sjf2":"1","sjg1":"1","sjg2":"1","sjg3":"1","sjg4":"1","sjg5":"1","zcl":"1"}
     * success : true
     */

    private FieldEntity field;
    private IsShowEntity isShow;
    private boolean success;
    private List<DataEntity> data;

    public FieldEntity getField() {
        return field;
    }

    public void setField(FieldEntity field) {
        this.field = field;
    }

    public IsShowEntity getIsShow() {
        return isShow;
    }

    public void setIsShow(IsShowEntity isShow) {
        this.isShow = isShow;
    }

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

    public static class FieldEntity {
        /**
         * bianhao : 编号
         * bzhName : 拌合站名称
         * chuli :
         * clTime : 出料时间
         * shenhe :
         * sjf1 : 水泥1
         * sjf2 : 水泥2
         * sjg1 : 5-10mm
         * sjg2 : 10-20mm
         * sjg3 : 10-30mm
         * sjg4 : 石粉1
         * sjg5 : 石粉2
         * zcl : 总产量
         */

        private String bianhao;
        private String bzhName;
        private String chuli;
        private String clTime;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String zcl;

        public String getBianhao() {
            return bianhao;
        }

        public void setBianhao(String bianhao) {
            this.bianhao = bianhao;
        }

        public String getBzhName() {
            return bzhName;
        }

        public void setBzhName(String bzhName) {
            this.bzhName = bzhName;
        }

        public String getChuli() {
            return chuli;
        }

        public void setChuli(String chuli) {
            this.chuli = chuli;
        }

        public String getClTime() {
            return clTime;
        }

        public void setClTime(String clTime) {
            this.clTime = clTime;
        }

        public String getShenhe() {
            return shenhe;
        }

        public void setShenhe(String shenhe) {
            this.shenhe = shenhe;
        }

        public String getSjf1() {
            return sjf1;
        }

        public void setSjf1(String sjf1) {
            this.sjf1 = sjf1;
        }

        public String getSjf2() {
            return sjf2;
        }

        public void setSjf2(String sjf2) {
            this.sjf2 = sjf2;
        }

        public String getSjg1() {
            return sjg1;
        }

        public void setSjg1(String sjg1) {
            this.sjg1 = sjg1;
        }

        public String getSjg2() {
            return sjg2;
        }

        public void setSjg2(String sjg2) {
            this.sjg2 = sjg2;
        }

        public String getSjg3() {
            return sjg3;
        }

        public void setSjg3(String sjg3) {
            this.sjg3 = sjg3;
        }

        public String getSjg4() {
            return sjg4;
        }

        public void setSjg4(String sjg4) {
            this.sjg4 = sjg4;
        }

        public String getSjg5() {
            return sjg5;
        }

        public void setSjg5(String sjg5) {
            this.sjg5 = sjg5;
        }

        public String getZcl() {
            return zcl;
        }

        public void setZcl(String zcl) {
            this.zcl = zcl;
        }
    }

    public static class IsShowEntity {
        /**
         * bianhao :
         * bzhName :
         * chuli :
         * clTime : 1
         * shenhe :
         * sjf1 : 1
         * sjf2 : 1
         * sjg1 : 1
         * sjg2 : 1
         * sjg3 : 1
         * sjg4 : 1
         * sjg5 : 1
         * zcl : 1
         */

        private String bianhao;
        private String bzhName;
        private String chuli;
        private String clTime;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String zcl;

        public String getBianhao() {
            return bianhao;
        }

        public void setBianhao(String bianhao) {
            this.bianhao = bianhao;
        }

        public String getBzhName() {
            return bzhName;
        }

        public void setBzhName(String bzhName) {
            this.bzhName = bzhName;
        }

        public String getChuli() {
            return chuli;
        }

        public void setChuli(String chuli) {
            this.chuli = chuli;
        }

        public String getClTime() {
            return clTime;
        }

        public void setClTime(String clTime) {
            this.clTime = clTime;
        }

        public String getShenhe() {
            return shenhe;
        }

        public void setShenhe(String shenhe) {
            this.shenhe = shenhe;
        }

        public String getSjf1() {
            return sjf1;
        }

        public void setSjf1(String sjf1) {
            this.sjf1 = sjf1;
        }

        public String getSjf2() {
            return sjf2;
        }

        public void setSjf2(String sjf2) {
            this.sjf2 = sjf2;
        }

        public String getSjg1() {
            return sjg1;
        }

        public void setSjg1(String sjg1) {
            this.sjg1 = sjg1;
        }

        public String getSjg2() {
            return sjg2;
        }

        public void setSjg2(String sjg2) {
            this.sjg2 = sjg2;
        }

        public String getSjg3() {
            return sjg3;
        }

        public void setSjg3(String sjg3) {
            this.sjg3 = sjg3;
        }

        public String getSjg4() {
            return sjg4;
        }

        public void setSjg4(String sjg4) {
            this.sjg4 = sjg4;
        }

        public String getSjg5() {
            return sjg5;
        }

        public void setSjg5(String sjg5) {
            this.sjg5 = sjg5;
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
         * bianhao : 24965
         * bzhName : LM1标水稳1#机
         * chuli : 1
         * clTime : 2017-02-23 17:27:10
         * shenhe : 1
         * sjf1 : 1803.54
         * sjf2 :
         * sjg1 : 4308.7
         * sjg2 : 11043.8
         * sjg3 : 10902.5
         * sjg4 : 9000.2
         * sjg5 : 8750.9
         * zcl : 44006.15
         */

        private String bianhao;
        private String bzhName;
        private String chuli;
        private String clTime;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String zcl;

        public String getBianhao() {
            return bianhao;
        }

        public void setBianhao(String bianhao) {
            this.bianhao = bianhao;
        }

        public String getBzhName() {
            return bzhName;
        }

        public void setBzhName(String bzhName) {
            this.bzhName = bzhName;
        }

        public String getChuli() {
            return chuli;
        }

        public void setChuli(String chuli) {
            this.chuli = chuli;
        }

        public String getClTime() {
            return clTime;
        }

        public void setClTime(String clTime) {
            this.clTime = clTime;
        }

        public String getShenhe() {
            return shenhe;
        }

        public void setShenhe(String shenhe) {
            this.shenhe = shenhe;
        }

        public String getSjf1() {
            return sjf1;
        }

        public void setSjf1(String sjf1) {
            this.sjf1 = sjf1;
        }

        public String getSjf2() {
            return sjf2;
        }

        public void setSjf2(String sjf2) {
            this.sjf2 = sjf2;
        }

        public String getSjg1() {
            return sjg1;
        }

        public void setSjg1(String sjg1) {
            this.sjg1 = sjg1;
        }

        public String getSjg2() {
            return sjg2;
        }

        public void setSjg2(String sjg2) {
            this.sjg2 = sjg2;
        }

        public String getSjg3() {
            return sjg3;
        }

        public void setSjg3(String sjg3) {
            this.sjg3 = sjg3;
        }

        public String getSjg4() {
            return sjg4;
        }

        public void setSjg4(String sjg4) {
            this.sjg4 = sjg4;
        }

        public String getSjg5() {
            return sjg5;
        }

        public void setSjg5(String sjg5) {
            this.sjg5 = sjg5;
        }

        public String getZcl() {
            return zcl;
        }

        public void setZcl(String zcl) {
            this.zcl = zcl;
        }
    }
}
