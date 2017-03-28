package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/12/19.
 */
public class EquipmentData {


    /**
     * data : [{"banhezhanminchen":"LM1标水稳1#机","biaoduanid":"1","gprsbianhao":"nhgssw0101","id":"1","jianchen":"1标1#机","shebeileixin":"6","xiangmubuid":"1"},{"banhezhanminchen":"LM1标水稳2#机","biaoduanid":"1","gprsbianhao":"nhgssw0102","id":"2","jianchen":"1标2#机","shebeileixin":"6","xiangmubuid":"1"}]
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
         * banhezhanminchen : LM1标水稳1#机
         * biaoduanid : 1
         * gprsbianhao : nhgssw0101
         * id : 1
         * jianchen : 1标1#机
         * shebeileixin : 6
         * xiangmubuid : 1
         */

        private String banhezhanminchen;
        private String biaoduanid;
        private String gprsbianhao;
        private String id;
        private String jianchen;
        private String shebeileixin;
        private String xiangmubuid;

        public String getBanhezhanminchen() {
            return banhezhanminchen;
        }

        public void setBanhezhanminchen(String banhezhanminchen) {
            this.banhezhanminchen = banhezhanminchen;
        }

        public String getBiaoduanid() {
            return biaoduanid;
        }

        public void setBiaoduanid(String biaoduanid) {
            this.biaoduanid = biaoduanid;
        }

        public String getGprsbianhao() {
            return gprsbianhao;
        }

        public void setGprsbianhao(String gprsbianhao) {
            this.gprsbianhao = gprsbianhao;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJianchen() {
            return jianchen;
        }

        public void setJianchen(String jianchen) {
            this.jianchen = jianchen;
        }

        public String getShebeileixin() {
            return shebeileixin;
        }

        public void setShebeileixin(String shebeileixin) {
            this.shebeileixin = shebeileixin;
        }

        public String getXiangmubuid() {
            return xiangmubuid;
        }

        public void setXiangmubuid(String xiangmubuid) {
            this.xiangmubuid = xiangmubuid;
        }
    }
}
