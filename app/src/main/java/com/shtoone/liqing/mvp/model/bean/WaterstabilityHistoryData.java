package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/20.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterstabilityHistoryData implements Serializable {


    /**
     * data : [{"bianhao":"28827","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 09:31:40","sbbh":"nhgssw0101","sjf1":"2231.68","sjf2":"","sjg1":"4929.93","sjg2":"11782.63","sjg3":"11933.12","sjg4":"7637.49","sjg5":"7897.15","sjshui":"2225.27","usePosition":"基层","zcl":"44180.32"},{"bianhao":"28825","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 09:26:40","sbbh":"nhgssw0101","sjf1":"2210.33","sjf2":"","sjg1":"5003.97","sjg2":"11882.17","sjg3":"11860.77","sjg4":"7556.78","sjg5":"7957.37","sjshui":"2207.27","usePosition":"基层","zcl":"44261.06"},{"bianhao":"28823","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 09:21:40","sbbh":"nhgssw0101","sjf1":"2191.80","sjf2":"","sjg1":"4731.27","sjg2":"11893.30","sjg3":"12007.97","sjg4":"7476.24","sjg5":"7945.41","sjshui":"2216.41","usePosition":"基层","zcl":"44054.19"},{"bianhao":"28819","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 09:16:40","sbbh":"nhgssw0101","sjf1":"2231.16","sjf2":"","sjg1":"4907.59","sjg2":"11950.67","sjg3":"12103.45","sjg4":"7600.77","sjg5":"7889.51","sjshui":"2218.61","usePosition":"基层","zcl":"44451.99"},{"bianhao":"28816","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 09:11:40","sbbh":"nhgssw0101","sjf1":"2196.02","sjf2":"","sjg1":"4815.68","sjg2":"12038.29","sjg3":"12075.90","sjg4":"7575.22","sjg5":"7850.69","sjshui":"2201.90","usePosition":"基层","zcl":"44355.78"},{"bianhao":"28813","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 09:06:40","sbbh":"nhgssw0101","sjf1":"2209.13","sjf2":"","sjg1":"4902.38","sjg2":"11916.32","sjg3":"11758.59","sjg4":"7607.52","sjg5":"8087.57","sjshui":"2233.09","usePosition":"基层","zcl":"44272.38"},{"bianhao":"28806","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 09:01:40","sbbh":"nhgssw0101","sjf1":"2198.99","sjf2":"","sjg1":"4825.45","sjg2":"11957.57","sjg3":"11960.45","sjg4":"7514.85","sjg5":"7940.14","sjshui":"2199.21","usePosition":"基层","zcl":"44198.46"},{"bianhao":"28804","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:56:40","sbbh":"nhgssw0101","sjf1":"2198.27","sjf2":"","sjg1":"4790.06","sjg2":"11863.22","sjg3":"11578.82","sjg4":"7412.47","sjg5":"7866.46","sjshui":"2208.63","usePosition":"基层","zcl":"43511.03"},{"bianhao":"28803","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:51:40","sbbh":"nhgssw0101","sjf1":"2212.19","sjf2":"","sjg1":"4847.54","sjg2":"11827.27","sjg3":"12099.21","sjg4":"7644.22","sjg5":"7872.11","sjshui":"2226.08","usePosition":"基层","zcl":"44290.35"},{"bianhao":"28802","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:46:40","sbbh":"nhgssw0101","sjf1":"2190.64","sjf2":"","sjg1":"4946.29","sjg2":"12064.67","sjg3":"11967.00","sjg4":"7589.97","sjg5":"7915.19","sjshui":"2189.52","usePosition":"基层","zcl":"44483.12"},{"bianhao":"28801","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:41:40","sbbh":"nhgssw0101","sjf1":"2192.60","sjf2":"","sjg1":"4899.65","sjg2":"12042.74","sjg3":"11978.22","sjg4":"7396.08","sjg5":"7991.90","sjshui":"2221.04","usePosition":"基层","zcl":"44308.59"},{"bianhao":"28799","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:36:40","sbbh":"nhgssw0101","sjf1":"2213.05","sjf2":"","sjg1":"4820.52","sjg2":"11881.08","sjg3":"11639.47","sjg4":"7617.21","sjg5":"7885.61","sjshui":"2185.11","usePosition":"基层","zcl":"43843.89"},{"bianhao":"28797","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:31:40","sbbh":"nhgssw0101","sjf1":"2202.09","sjf2":"","sjg1":"4870.81","sjg2":"12007.17","sjg3":"11933.78","sjg4":"7505.92","sjg5":"7942.92","sjshui":"2204.53","usePosition":"基层","zcl":"44260.60"},{"bianhao":"28793","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:26:40","sbbh":"nhgssw0101","sjf1":"2150.21","sjf2":"","sjg1":"4967.21","sjg2":"11738.82","sjg3":"11861.58","sjg4":"7604.40","sjg5":"7973.64","sjshui":"2195.84","usePosition":"基层","zcl":"44145.65"},{"bianhao":"28790","bzhName":"LM1标水稳1#机","clTime":"2017-03-06 08:21:40","sbbh":"nhgssw0101","sjf1":"2202.56","sjf2":"","sjg1":"4851.49","sjg2":"12132.27","sjg3":"11949.90","sjg4":"7510.04","sjg5":"7993.62","sjshui":"2223.43","usePosition":"基层","zcl":"44437.32"}]
     * description : 超标处置成功！
     * field : {"bianhao":"","bzhName":"拌合站名称","chuli":"","clTime":"出料时间","sbbh":"","shenhe":"","sjf1":"水泥1","sjf2":"水泥2","sjg1":"5-10mm","sjg2":"10-20mm","sjg3":"10-30mm","sjg4":"石粉1","sjg5":"石粉2","sjshui":"实际水","usePosition":"使用部位","zcl":"总产量"}
     * isShow : {"bianhao":"","bzhName":"1","chuli":"","clTime":"1","sbbh":"","shenhe":"","sjf1":"1","sjf2":"1","sjg1":"1","sjg2":"1","sjg3":"1","sjg4":"1","sjg5":"1","sjshui":"1","usePosition":"1","zcl":"1"}
     * success : true
     */

    private String description;
    private FieldEntity field;
    private IsShowEntity isShow;
    private boolean success;
    private List<DataEntity> data;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
         * bianhao :
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
         * sjshui : 实际水
         * usePosition : 使用部位
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
         * sjshui : 1
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
         * bianhao : 28827
         * bzhName : LM1标水稳1#机
         * clTime : 2017-03-06 09:31:40
         * sbbh : nhgssw0101
         * sjf1 : 2231.68
         * sjf2 :
         * sjg1 : 4929.93
         * sjg2 : 11782.63
         * sjg3 : 11933.12
         * sjg4 : 7637.49
         * sjg5 : 7897.15
         * sjshui : 2225.27
         * usePosition : 基层
         * zcl : 44180.32
         */

        private String bianhao;
        private String bzhName;
        private String clTime;
        private String sbbh;
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
