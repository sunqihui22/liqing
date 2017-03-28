package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchProductQueryData implements Serializable {


    /**
     * field : {"bhzName":"拌合站名称","bianhao":"编号","clTime":"出料时间","clwd":"出料温度(℃)","glwd":"石料温度(℃)","lqwd":"沥青温度(℃)","sbbh":"设备编号","sjf1":"矿粉1","sjf2":"矿粉2","sjg1":"1#仓","sjg2":"2#仓","sjg3":"3#仓","sjg4":"4#仓","sjg5":"5#仓","sjg6":"6#仓","sjg7":"7#仓","sjlq":"沥青","sjtjj":"添加剂","sjysb":"油石比(%)"}
     * lqisshow : {"clwd":"1","glwd":"1","lqwd":"1","sjf1":"1","sjf2":"1","sjg1":"0","sjg2":"1","sjg3":"1","sjg4":"1","sjg5":"1","sjg6":"1","sjg7":"0","sjlq":"1","sjtjj":"0","sjysb":"1"}
     * description : 超标处置成功！
     * data : [{"bhzName":"test1","bianhao":"10","clTime":"2016-07-20 21:34:21","clwd":"187.0","glwd":"","lqwd":"","sbbh":"G345lq0101","sjf1":"187.5","sjf2":"0.0","sjg1":"1311.0","sjg2":"354.0","sjg3":"926.0","sjg4":"675.0","sjg5":"436.0","sjg6":"0.0","sjg7":"0.0","sjlq":"160.8","sjtjj":"","sjysb":"4.13"},{"bhzName":"test1","bianhao":"9","clTime":"2016-07-20 21:34:21","clwd":"183.0","glwd":"","lqwd":"","sbbh":"G345lq0101","sjf1":"197.5","sjf2":"0.0","sjg1":"1304.0","sjg2":"353.0","sjg3":"919.0","sjg4":"673.0","sjg5":"434.0","sjg6":"0.0","sjg7":"0.0","sjlq":"161.1","sjtjj":"","sjysb":"4.15"},{"bhzName":"test1","bianhao":"8","clTime":"2016-07-20 21:34:21","clwd":"184.0","glwd":"","lqwd":"","sbbh":"G345lq0101","sjf1":"187.2","sjf2":"0.0","sjg1":"1304.0","sjg2":"354.0","sjg3":"924.0","sjg4":"695.0","sjg5":"440.0","sjg6":"0.0","sjg7":"0.0","sjlq":"160.5","sjtjj":"","sjysb":"4.11"},{"bhzName":"test1","bianhao":"7","clTime":"2016-07-20 21:34:21","clwd":"185.0","glwd":"","lqwd":"","sbbh":"G345lq0101","sjf1":"199.6","sjf2":"0.0","sjg1":"1254.0","sjg2":"351.0","sjg3":"924.0","sjg4":"664.0","sjg5":"440.0","sjg6":"0.0","sjg7":"0.0","sjlq":"168.3","sjtjj":"","sjysb":"4.39"},{"bhzName":"test1","bianhao":"6","clTime":"2016-07-20 21:34:21","clwd":"189.0","glwd":"","lqwd":"","sbbh":"G345lq0101","sjf1":"187.6","sjf2":"0.0","sjg1":"1301.0","sjg2":"357.0","sjg3":"899.0","sjg4":"643.0","sjg5":"435.0","sjg6":"0.0","sjg7":"0.0","sjlq":"160.5","sjtjj":"","sjysb":"4.20"}]
     * success : true
     */

    private FieldEntity field;
    private LqisshowEntity lqisshow;
    private String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
         * clTime : 出料时间
         * clwd : 出料温度(℃)
         * glwd : 石料温度(℃)
         * lqwd : 沥青温度(℃)
         * sbbh : 设备编号
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
        private String clTime;
        private String clwd;
        private String glwd;
        private String lqwd;
        private String sbbh;
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
         * bianhao : 10
         * clTime : 2016-07-20 21:34:21
         * clwd : 187.0
         * glwd :
         * lqwd :
         * sbbh : G345lq0101
         * sjf1 : 187.5
         * sjf2 : 0.0
         * sjg1 : 1311.0
         * sjg2 : 354.0
         * sjg3 : 926.0
         * sjg4 : 675.0
         * sjg5 : 436.0
         * sjg6 : 0.0
         * sjg7 : 0.0
         * sjlq : 160.8
         * sjtjj :
         * sjysb : 4.13
         */

        private String bhzName;
        private String bianhao;
        private String clTime;
        private String clwd;
        private String glwd;
        private String lqwd;
        private String sbbh;
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
