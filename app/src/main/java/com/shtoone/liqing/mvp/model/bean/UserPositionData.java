package com.shtoone.liqing.mvp.model.bean;

/**
 * Author： hengzwd on 2017/3/21.
 * Email：hengzwdhengzwd@qq.com
 */

public class UserPositionData {

    /**
     * data : {"a0":"基层","a1":"垫层1","a2":"底基层1","a3":"底基层","a4":"垫层"}
     * success : true
     */
    private DataEntity data;
    private boolean success;
    public DataEntity getData() {
        return data;
    }
    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataEntity {
        /**
         * a0 : 基层
         * a1 : 垫层1
         * a2 : 底基层1
         * a3 : 底基层
         * a4 : 垫层
         */

        private String a0;
        private String a1;
        private String a2;
        private String a3;
        private String a4;

        public String getA0() {
            return a0;
        }

        public void setA0(String a0) {
            this.a0 = a0;
        }

        public String getA1() {
            return a1;
        }

        public void setA1(String a1) {
            this.a1 = a1;
        }

        public String getA2() {
            return a2;
        }

        public void setA2(String a2) {
            this.a2 = a2;
        }

        public String getA3() {
            return a3;
        }

        public void setA3(String a3) {
            this.a3 = a3;
        }

        public String getA4() {
            return a4;
        }

        public void setA4(String a4) {
            this.a4 = a4;
        }
    }
}
