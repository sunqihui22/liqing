package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityOverProofBean implements Serializable {


    /**
     * data : [{"bianhao":"24965","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-02-23 17:27:10","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"44006.15"},{"bianhao":"15710","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 22:04:29","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"39229.90"},{"bianhao":"15709","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 21:59:29","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"38667.62"},{"bianhao":"15708","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 21:54:29","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"38930.35"},{"bianhao":"15706","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 21:49:29","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"38650.92"},{"bianhao":"15705","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 21:44:29","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"39305.90"},{"bianhao":"15704","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 21:39:29","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"39255.76"},{"bianhao":"15703","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 21:29:23","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"37612.20"},{"bianhao":"15702","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 21:24:23","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"37184.86"},{"bianhao":"15700","bzhName":"LM1标水稳1#机","chuli":"1","clTime":"2017-01-13 20:57:09","sbbh":"nhgssw0101","shenhe":"0","sjf1":"","sjf2":"","sjg1":"","sjg2":"","sjg3":"","sjg4":"6","sjg5":"","sjshui":"","usePosition":"","zcl":"37430.68"}]
     * field : {"bianhao":"编号","bzhName":"拌合站名称","chuli":"","clTime":"出料时间","sbbh":"","shenhe":"","sjf1":"水泥1","sjf2":"水泥2","sjg1":"5-10mm","sjg2":"10-20mm","sjg3":"10-30mm","sjg4":"石粉1","sjg5":"石粉2","sjshui":"","usePosition":"","zcl":"总产量"}
     * isShow : {"bianhao":"","bzhName":"1","chuli":"","clTime":"1","sbbh":"","shenhe":"","sjf1":"1","sjf2":"1","sjg1":"1","sjg2":"1","sjg3":"1","sjg4":"1","sjg5":"1","sjshui":"","usePosition":"1","zcl":"1"}
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
         * sbbh :
         * shenhe :
         * sjf1 : 水泥1
         * sjf2 : 水泥2
         * sjg1 : 5-10mm
         * sjg2 : 10-20mm
         * sjg3 : 10-30mm
         * sjg4 : 石粉1
         * sjg5 : 石粉2
         * sjshui :
         * usePosition :
         * zcl : 总产量
         */

        private String bianhao;
        private String bzhName;
        private String chuli;
        private String clTime;
        private String sbbh;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String sjshui;
        private String usePosition;
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

        public String getSbbh() {
            return sbbh;
        }

        public void setSbbh(String sbbh) {
            this.sbbh = sbbh;
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

        public String getSjshui() {
            return sjshui;
        }

        public void setSjshui(String sjshui) {
            this.sjshui = sjshui;
        }

        public String getUsePosition() {
            return usePosition;
        }

        public void setUsePosition(String usePosition) {
            this.usePosition = usePosition;
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
         * bzhName : 1
         * chuli :
         * clTime : 1
         * sbbh :
         * shenhe :
         * sjf1 : 1
         * sjf2 : 1
         * sjg1 : 1
         * sjg2 : 1
         * sjg3 : 1
         * sjg4 : 1
         * sjg5 : 1
         * sjshui :
         * usePosition : 1
         * zcl : 1
         */

        private String bianhao;
        private String bzhName;
        private String chuli;
        private String clTime;
        private String sbbh;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String sjshui;
        private String usePosition;
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

        public String getSbbh() {
            return sbbh;
        }

        public void setSbbh(String sbbh) {
            this.sbbh = sbbh;
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

        public String getSjshui() {
            return sjshui;
        }

        public void setSjshui(String sjshui) {
            this.sjshui = sjshui;
        }

        public String getUsePosition() {
            return usePosition;
        }

        public void setUsePosition(String usePosition) {
            this.usePosition = usePosition;
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
         * sbbh : nhgssw0101
         * shenhe : 0
         * sjf1 :
         * sjf2 :
         * sjg1 :
         * sjg2 :
         * sjg3 :
         * sjg4 : 6
         * sjg5 :
         * sjshui :
         * usePosition :
         * zcl : 44006.15
         */

        private String bianhao;
        private String bzhName;
        private String chuli;
        private String clTime;
        private String sbbh;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String sjshui;
        private String usePosition;
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

        public String getSbbh() {
            return sbbh;
        }

        public void setSbbh(String sbbh) {
            this.sbbh = sbbh;
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

        public String getSjshui() {
            return sjshui;
        }

        public void setSjshui(String sjshui) {
            this.sjshui = sjshui;
        }

        public String getUsePosition() {
            return usePosition;
        }

        public void setUsePosition(String usePosition) {
            this.usePosition = usePosition;
        }

        public String getZcl() {
            return zcl;
        }

        public void setZcl(String zcl) {
            this.zcl = zcl;
        }
    }
}
