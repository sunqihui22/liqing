package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public class LaboratoryData {


    /**
     * data : [{"MXETongJi":"90","RHDTongJi":"65","ZRDTongJi":"65","YDTongJi":"66"}]
     * success : true
     */

    private boolean success;
    /**
     * MXETongJi : 90
     * RHDTongJi : 65
     * ZRDTongJi : 65
     * YDTongJi : 66
     */

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
        private String MXETongJi;
        private String RHDTongJi;
        private String ZRDTongJi;
        private String YDTongJi;

        public String getMXETongJi() {
            return MXETongJi;
        }

        public void setMXETongJi(String MXETongJi) {
            this.MXETongJi = MXETongJi;
        }

        public String getRHDTongJi() {
            return RHDTongJi;
        }

        public void setRHDTongJi(String RHDTongJi) {
            this.RHDTongJi = RHDTongJi;
        }

        public String getZRDTongJi() {
            return ZRDTongJi;
        }

        public void setZRDTongJi(String ZRDTongJi) {
            this.ZRDTongJi = ZRDTongJi;
        }

        public String getYDTongJi() {
            return YDTongJi;
        }

        public void setYDTongJi(String YDTongJi) {
            this.YDTongJi = YDTongJi;
        }
    }
}


