package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchOverProofData implements Serializable {


    /**
     * field : {"bhzName":"拌合站名称","bianhao":"编号","chuli":"","clTime":"出料时间","clwd":"出料温度(℃)","glwd":"石料温度(℃)","lqwd":"沥青温度(℃)","sbbh":"","shenhe":"","sjf1":"矿粉1","sjf2":"矿粉2","sjg1":"1#仓","sjg2":"2#仓","sjg3":"3#仓","sjg4":"4#仓","sjg5":"5#仓","sjg6":"6#仓","sjg7":"7#仓","sjlq":"沥青","sjtjj":"添加剂","sjysb":"油石比(%)"}
     * lqisshow : {"clwd":"1","glwd":"1","lqwd":"1","sjf1":"1","sjf2":"1","sjg1":"0","sjg2":"1","sjg3":"1","sjg4":"1","sjg5":"1","sjg6":"1","sjg7":"0","sjlq":"1","sjtjj":"0","sjysb":"1"}
     * data : [{"bhzName":"test1","bianhao":"67","chuli":"1","clTime":"2016-07-23 10:17:32","clwd":"176.0","glwd":"149.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"1","sjf1":"0.00","sjf2":"78.00","sjg1":"0.00","sjg2":"416.00","sjg3":"610.00","sjg4":"276.00","sjg5":"125.00","sjg6":"511.00","sjg7":"","sjlq":"93.00","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"66","chuli":"0","clTime":"2016-07-23 10:16:45","clwd":"174.0","glwd":"149.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.20","sjg1":"0.00","sjg2":"400.00","sjg3":"630.00","sjg4":"294.00","sjg5":"128.00","sjg6":"506.00","sjg7":"","sjlq":"94.10","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"65","chuli":"0","clTime":"2016-07-23 10:15:34","clwd":"172.0","glwd":"147.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"77.90","sjg1":"0.00","sjg2":"382.00","sjg3":"619.00","sjg4":"279.00","sjg5":"0.00","sjg6":"527.00","sjg7":"","sjlq":"86.80","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"64","chuli":"0","clTime":"2016-07-23 10:14:43","clwd":"173.0","glwd":"147.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.00","sjg1":"0.00","sjg2":"439.00","sjg3":"627.00","sjg4":"283.00","sjg5":"124.00","sjg6":"528.00","sjg7":"","sjlq":"96.50","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"63","chuli":"0","clTime":"2016-07-23 10:13:41","clwd":"177.0","glwd":"147.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.10","sjg1":"0.00","sjg2":"370.00","sjg3":"622.00","sjg4":"283.00","sjg5":"115.00","sjg6":"515.00","sjg7":"","sjlq":"92.20","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"62","chuli":"0","clTime":"2016-07-23 10:12:54","clwd":"176.0","glwd":"146.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.00","sjg1":"0.00","sjg2":"393.00","sjg3":"615.00","sjg4":"281.00","sjg5":"128.00","sjg6":"533.00","sjg7":"","sjlq":"94.00","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"61","chuli":"0","clTime":"2016-07-23 10:11:57","clwd":"178.0","glwd":"146.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.50","sjg1":"0.00","sjg2":"386.00","sjg3":"632.00","sjg4":"282.00","sjg5":"133.00","sjg6":"510.00","sjg7":"","sjlq":"93.30","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"60","chuli":"0","clTime":"2016-07-23 10:11:12","clwd":"178.0","glwd":"145.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"77.60","sjg1":"0.00","sjg2":"401.00","sjg3":"624.00","sjg4":"288.00","sjg5":"0.00","sjg6":"531.00","sjg7":"","sjlq":"89.20","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"59","chuli":"0","clTime":"2016-07-23 10:10:11","clwd":"176.0","glwd":"145.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.00","sjg1":"0.00","sjg2":"399.00","sjg3":"626.00","sjg4":"282.00","sjg5":"124.00","sjg6":"518.00","sjg7":"","sjlq":"94.30","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"58","chuli":"0","clTime":"2016-07-23 10:09:06","clwd":"171.0","glwd":"146.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"77.60","sjg1":"0.00","sjg2":"395.00","sjg3":"610.00","sjg4":"278.00","sjg5":"148.00","sjg6":"526.00","sjg7":"","sjlq":"94.20","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"57","chuli":"0","clTime":"2016-07-23 10:08:16","clwd":"171.0","glwd":"146.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.40","sjg1":"0.00","sjg2":"374.00","sjg3":"633.00","sjg4":"285.00","sjg5":"139.00","sjg6":"520.00","sjg7":"","sjlq":"94.10","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"56","chuli":"0","clTime":"2016-07-23 10:07:27","clwd":"174.0","glwd":"146.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.20","sjg1":"0.00","sjg2":"388.00","sjg3":"617.00","sjg4":"281.00","sjg5":"0.00","sjg6":"526.00","sjg7":"","sjlq":"87.30","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"55","chuli":"0","clTime":"2016-07-23 10:06:24","clwd":"171.0","glwd":"146.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"77.80","sjg1":"0.00","sjg2":"438.00","sjg3":"620.00","sjg4":"255.00","sjg5":"124.00","sjg6":"521.00","sjg7":"","sjlq":"94.10","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"54","chuli":"0","clTime":"2016-07-23 10:05:31","clwd":"169.0","glwd":"145.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"77.60","sjg1":"0.00","sjg2":"391.00","sjg3":"626.00","sjg4":"310.00","sjg5":"110.00","sjg6":"522.00","sjg7":"","sjlq":"94.30","sjtjj":"","sjysb":""},{"bhzName":"test1","bianhao":"53","chuli":"0","clTime":"2016-07-23 10:04:39","clwd":"171.0","glwd":"145.0","lqwd":"134.0","sbbh":"G345lq0101","shenhe":"0","sjf1":"0.00","sjf2":"78.40","sjg1":"0.00","sjg2":"409.00","sjg3":"624.00","sjg4":"287.00","sjg5":"120.00","sjg6":"514.00","sjg7":"","sjlq":"94.30","sjtjj":"","sjysb":""}]
     * success : true
     */

    private FieldEntity field;
    private LqisshowEntity lqisshow;
    private boolean success;
    private List<DataEntity> data;

    public FieldEntity getField() {
        return field;
    }

    public void setField(FieldEntity field) {
        this.field = field;
    }

    public LqisshowEntity getLqisshow() {
        return lqisshow;
    }

    public void setLqisshow(LqisshowEntity lqisshow) {
        this.lqisshow = lqisshow;
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
         * bhzName : 拌合站名称
         * bianhao : 编号
         * chuli :
         * clTime : 出料时间
         * clwd : 出料温度(℃)
         * glwd : 石料温度(℃)
         * lqwd : 沥青温度(℃)
         * sbbh :
         * shenhe :
         * sjf1 : 矿粉1
         * sjf2 : 矿粉2
         * sjg1 : 1#仓
         * sjg2 : 2#仓
         * sjg3 : 3#仓
         * sjg4 : 4#仓
         * sjg5 : 5#仓
         * sjg6 : 6#仓
         * sjg7 : 7#仓
         * sjlq : 沥青
         * sjtjj : 添加剂
         * sjysb : 油石比(%)
         */

        private String bhzName;
        private String bianhao;
        private String chuli;
        private String clTime;
        private String clwd;
        private String glwd;
        private String lqwd;
        private String sbbh;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String sjg6;
        private String sjg7;
        private String sjlq;
        private String sjtjj;
        private String sjysb;

        public String getBhzName() {
            return bhzName;
        }

        public void setBhzName(String bhzName) {
            this.bhzName = bhzName;
        }

        public String getBianhao() {
            return bianhao;
        }

        public void setBianhao(String bianhao) {
            this.bianhao = bianhao;
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

        public String getClwd() {
            return clwd;
        }

        public void setClwd(String clwd) {
            this.clwd = clwd;
        }

        public String getGlwd() {
            return glwd;
        }

        public void setGlwd(String glwd) {
            this.glwd = glwd;
        }

        public String getLqwd() {
            return lqwd;
        }

        public void setLqwd(String lqwd) {
            this.lqwd = lqwd;
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

        public String getSjg6() {
            return sjg6;
        }

        public void setSjg6(String sjg6) {
            this.sjg6 = sjg6;
        }

        public String getSjg7() {
            return sjg7;
        }

        public void setSjg7(String sjg7) {
            this.sjg7 = sjg7;
        }

        public String getSjlq() {
            return sjlq;
        }

        public void setSjlq(String sjlq) {
            this.sjlq = sjlq;
        }

        public String getSjtjj() {
            return sjtjj;
        }

        public void setSjtjj(String sjtjj) {
            this.sjtjj = sjtjj;
        }

        public String getSjysb() {
            return sjysb;
        }

        public void setSjysb(String sjysb) {
            this.sjysb = sjysb;
        }
    }

    public static class LqisshowEntity {
        /**
         * clwd : 1
         * glwd : 1
         * lqwd : 1
         * sjf1 : 1
         * sjf2 : 1
         * sjg1 : 0
         * sjg2 : 1
         * sjg3 : 1
         * sjg4 : 1
         * sjg5 : 1
         * sjg6 : 1
         * sjg7 : 0
         * sjlq : 1
         * sjtjj : 0
         * sjysb : 1
         */

        private String clwd;
        private String glwd;
        private String lqwd;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String sjg6;
        private String sjg7;
        private String sjlq;
        private String sjtjj;
        private String sjysb;

        public String getClwd() {
            return clwd;
        }

        public void setClwd(String clwd) {
            this.clwd = clwd;
        }

        public String getGlwd() {
            return glwd;
        }

        public void setGlwd(String glwd) {
            this.glwd = glwd;
        }

        public String getLqwd() {
            return lqwd;
        }

        public void setLqwd(String lqwd) {
            this.lqwd = lqwd;
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

        public String getSjg6() {
            return sjg6;
        }

        public void setSjg6(String sjg6) {
            this.sjg6 = sjg6;
        }

        public String getSjg7() {
            return sjg7;
        }

        public void setSjg7(String sjg7) {
            this.sjg7 = sjg7;
        }

        public String getSjlq() {
            return sjlq;
        }

        public void setSjlq(String sjlq) {
            this.sjlq = sjlq;
        }

        public String getSjtjj() {
            return sjtjj;
        }

        public void setSjtjj(String sjtjj) {
            this.sjtjj = sjtjj;
        }

        public String getSjysb() {
            return sjysb;
        }

        public void setSjysb(String sjysb) {
            this.sjysb = sjysb;
        }
    }

    public static class DataEntity {
        /**
         * bhzName : test1
         * bianhao : 67
         * chuli : 1
         * clTime : 2016-07-23 10:17:32
         * clwd : 176.0
         * glwd : 149.0
         * lqwd : 134.0
         * sbbh : G345lq0101
         * shenhe : 1
         * sjf1 : 0.00
         * sjf2 : 78.00
         * sjg1 : 0.00
         * sjg2 : 416.00
         * sjg3 : 610.00
         * sjg4 : 276.00
         * sjg5 : 125.00
         * sjg6 : 511.00
         * sjg7 :
         * sjlq : 93.00
         * sjtjj :
         * sjysb :
         */

        private String bhzName;
        private String bianhao;
        private String chuli;
        private String clTime;
        private String clwd;
        private String glwd;
        private String lqwd;
        private String sbbh;
        private String shenhe;
        private String sjf1;
        private String sjf2;
        private String sjg1;
        private String sjg2;
        private String sjg3;
        private String sjg4;
        private String sjg5;
        private String sjg6;
        private String sjg7;
        private String sjlq;
        private String sjtjj;
        private String sjysb;

        public String getBhzName() {
            return bhzName;
        }

        public void setBhzName(String bhzName) {
            this.bhzName = bhzName;
        }

        public String getBianhao() {
            return bianhao;
        }

        public void setBianhao(String bianhao) {
            this.bianhao = bianhao;
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

        public String getClwd() {
            return clwd;
        }

        public void setClwd(String clwd) {
            this.clwd = clwd;
        }

        public String getGlwd() {
            return glwd;
        }

        public void setGlwd(String glwd) {
            this.glwd = glwd;
        }

        public String getLqwd() {
            return lqwd;
        }

        public void setLqwd(String lqwd) {
            this.lqwd = lqwd;
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

        public String getSjg6() {
            return sjg6;
        }

        public void setSjg6(String sjg6) {
            this.sjg6 = sjg6;
        }

        public String getSjg7() {
            return sjg7;
        }

        public void setSjg7(String sjg7) {
            this.sjg7 = sjg7;
        }

        public String getSjlq() {
            return sjlq;
        }

        public void setSjlq(String sjlq) {
            this.sjlq = sjlq;
        }

        public String getSjtjj() {
            return sjtjj;
        }

        public void setSjtjj(String sjtjj) {
            this.sjtjj = sjtjj;
        }

        public String getSjysb() {
            return sjysb;
        }

        public void setSjysb(String sjysb) {
            this.sjysb = sjysb;
        }
    }
}
