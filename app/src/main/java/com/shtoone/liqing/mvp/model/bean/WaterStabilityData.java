package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityData implements Serializable {


    /**
     * data : [{"banhezhanminchen":"兴华高速LM1标","bhjCount":"","bhzCount":"","bsId":"1","cblv":"0.46","cbpanshu":"35","cczpanshu":"35","czlv":"100.00","hcblv":"0.30","hcbpanshu":"23","hczlv":"100.00","hczpanshu":"23","mcblv":"0.44","mcbpanshu":"34","mczlv":"100.00","mczpanshu":"34","remark":"正高级","totalFangliang":"332720.8","totalPanshu":"7665"},{"banhezhanminchen":"兴华高速LM2标","bhjCount":"","bhzCount":"","bsId":"2","cblv":"0.54","cbpanshu":"113","cczpanshu":"113","czlv":"100.00","hcblv":"0.21","hcbpanshu":"45","hczlv":"100.00","hczpanshu":"45","mcblv":"0.41","mcbpanshu":"86","mczlv":"100.00","mczpanshu":"86","remark":"正高级","totalFangliang":"793094.4","totalPanshu":"20955"},{"banhezhanminchen":"兴华高速EPC标","bhjCount":"","bhzCount":"","bsId":"3","cblv":"0.00","cbpanshu":"0","cczpanshu":"0","czlv":"0.00","hcblv":"0.00","hcbpanshu":"0","hczlv":"0.00","hczpanshu":"0","mcblv":"0.00","mcbpanshu":"0","mczlv":"0.00","mczpanshu":"0","remark":"","totalFangliang":"0","totalPanshu":"0"}]
     * success : true
     */

    private boolean success;
    private List<DataEntity> data;

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

    public static class DataEntity {
        /**
         * banhezhanminchen : 兴华高速LM1标
         * bhjCount :
         * bhzCount :
         * bsId : 1
         * cblv : 0.46
         * cbpanshu : 35
         * cczpanshu : 35
         * czlv : 100.00
         * hcblv : 0.30
         * hcbpanshu : 23
         * hczlv : 100.00
         * hczpanshu : 23
         * mcblv : 0.44
         * mcbpanshu : 34
         * mczlv : 100.00
         * mczpanshu : 34
         * remark : 正高级
         * totalFangliang : 332720.8
         * totalPanshu : 7665
         */

        private String banhezhanminchen;
        private String bhjCount;
        private String bhzCount;
        private String bsId;
        private String cblv;
        private String cbpanshu;
        private String cczpanshu;
        private String czlv;
        private String hcblv;
        private String hcbpanshu;
        private String hczlv;
        private String hczpanshu;
        private String mcblv;
        private String mcbpanshu;
        private String mczlv;
        private String mczpanshu;
        private String remark;
        private String totalFangliang;
        private String totalPanshu;

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public String getBhjCount() {
            return bhjCount;
        }

        public void setBhjCount(String bhjCount) {
            this.bhjCount = bhjCount;
        }

        public String getBhzCount() {
            return bhzCount;
        }

        public void setBhzCount(String bhzCount) {
            this.bhzCount = bhzCount;
        }

        public String getBsId() {
            return bsId;
        }

        public void setBsId(String bsId) {
            this.bsId = bsId;
        }

        public String getCblv() {
            return cblv;
        }

        public void setCblv(String cblv) {
            this.cblv = cblv;
        }

        public String getCbpanshu() {
            return cbpanshu;
        }

        public void setCbpanshu(String cbpanshu) {
            this.cbpanshu = cbpanshu;
        }

        public String getCczpanshu() {
            return cczpanshu;
        }

        public void setCczpanshu(String cczpanshu) {
            this.cczpanshu = cczpanshu;
        }

        public String getCzlv() {
            return czlv;
        }

        public void setCzlv(String czlv) {
            this.czlv = czlv;
        }

        public String getHcblv() {
            return hcblv;
        }

        public void setHcblv(String hcblv) {
            this.hcblv = hcblv;
        }

        public String getHcbpanshu() {
            return hcbpanshu;
        }

        public void setHcbpanshu(String hcbpanshu) {
            this.hcbpanshu = hcbpanshu;
        }

        public String getHczlv() {
            return hczlv;
        }

        public void setHczlv(String hczlv) {
            this.hczlv = hczlv;
        }

        public String getHczpanshu() {
            return hczpanshu;
        }

        public void setHczpanshu(String hczpanshu) {
            this.hczpanshu = hczpanshu;
        }

        public String getMcblv() {
            return mcblv;
        }

        public void setMcblv(String mcblv) {
            this.mcblv = mcblv;
        }

        public String getMcbpanshu() {
            return mcbpanshu;
        }

        public void setMcbpanshu(String mcbpanshu) {
            this.mcbpanshu = mcbpanshu;
        }

        public String getMczlv() {
            return mczlv;
        }

        public void setMczlv(String mczlv) {
            this.mczlv = mczlv;
        }

        public String getMczpanshu() {
            return mczpanshu;
        }

        public void setMczpanshu(String mczpanshu) {
            this.mczpanshu = mczpanshu;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTotalFangliang() {
            return totalFangliang;
        }

        public void setTotalFangliang(String totalFangliang) {
            this.totalFangliang = totalFangliang;
        }

        public String getTotalPanshu() {
            return totalPanshu;
        }

        public void setTotalPanshu(String totalPanshu) {
            this.totalPanshu = totalPanshu;
        }
    }
}
