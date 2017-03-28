package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/12/12.
 */
public class OrganizationBean {


    /**
     * bhz : [{"banhezhanminchen":"LM1标水稳1#机","biaoduanid":"1","gprsbianhao":"nhgssw0101","id":"1","jianchen":"1标1#机","shebeileixin":"6","xiangmubuid":"1"},{"banhezhanminchen":"LM1标水稳2#机","biaoduanid":"1","gprsbianhao":"nhgssw0102","id":"2","jianchen":"1标2#机","shebeileixin":"6","xiangmubuid":"1"},{"banhezhanminchen":"LM2标安流水稳1#机","biaoduanid":"2","gprsbianhao":"nhgssw0201","id":"3","jianchen":"安流1#机","shebeileixin":"6","xiangmubuid":"2"},{"banhezhanminchen":"LM2标安流水稳2#机","biaoduanid":"2","gprsbianhao":"nhgssw0202","id":"4","jianchen":"安流2#机","shebeileixin":"6","xiangmubuid":"2"},{"banhezhanminchen":"EPC标水稳1#机","biaoduanid":"3","gprsbianhao":"nhgssw0301","id":"5","jianchen":"EPC标1#机","shebeileixin":"6","xiangmubuid":"3"},{"banhezhanminchen":"EPC标水稳2#机","biaoduanid":"3","gprsbianhao":"nhgssw0302","id":"6","jianchen":"EPC标2#机","shebeileixin":"6","xiangmubuid":"3"},{"banhezhanminchen":"LM2标梅林水稳3#机","biaoduanid":"2","gprsbianhao":"nhgssw0203","id":"7","jianchen":"梅林3#机","shebeileixin":"6","xiangmubuid":"2"},{"banhezhanminchen":"test1","biaoduanid":"1","gprsbianhao":"G345lq0101","id":"8","jianchen":"test1","shebeileixin":"2","xiangmubuid":"1"}]
     * biaoduan : [{"biaoduanminchen":"兴华高速LM1标","id":1,"orderid":1},{"biaoduanminchen":"兴华高速LM2标","id":2,"orderid":2},{"biaoduanminchen":"兴华高速EPC标","id":3,"orderid":3}]
     * success : true
     * xmb : [{"biaoduanid":1,"id":1,"xiangmubuminchen":"LM1标项目部"},{"biaoduanid":2,"id":2,"xiangmubuminchen":"LM2标项目部"},{"biaoduanid":3,"id":3,"xiangmubuminchen":"EPC标项目部"}]
     */

    private boolean success;
    private List<BhzEntity> bhz;
    private List<BiaoduanEntity> biaoduan;
    private List<XmbEntity> xmb;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<BhzEntity> getBhz() {
        return bhz;
    }

    public void setBhz(List<BhzEntity> bhz) {
        this.bhz = bhz;
    }

    public List<BiaoduanEntity> getBiaoduan() {
        return biaoduan;
    }

    public void setBiaoduan(List<BiaoduanEntity> biaoduan) {
        this.biaoduan = biaoduan;
    }

    public List<XmbEntity> getXmb() {
        return xmb;
    }

    public void setXmb(List<XmbEntity> xmb) {
        this.xmb = xmb;
    }

    public static class BhzEntity {
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

    public static class BiaoduanEntity {
        /**
         * biaoduanminchen : 兴华高速LM1标
         * id : 1
         * orderid : 1
         */

        private String biaoduanminchen;
        private int id;
        private int orderid;

        public String getBiaoduanminchen() {
            return biaoduanminchen;
        }

        public void setBiaoduanminchen(String biaoduanminchen) {
            this.biaoduanminchen = biaoduanminchen;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }
    }

    public static class XmbEntity {
        /**
         * biaoduanid : 1
         * id : 1
         * xiangmubuminchen : LM1标项目部
         */

        private int biaoduanid;
        private int id;
        private String xiangmubuminchen;

        public int getBiaoduanid() {
            return biaoduanid;
        }

        public void setBiaoduanid(int biaoduanid) {
            this.biaoduanid = biaoduanid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getXiangmubuminchen() {
            return xiangmubuminchen;
        }

        public void setXiangmubuminchen(String xiangmubuminchen) {
            this.xiangmubuminchen = xiangmubuminchen;
        }
    }
}
