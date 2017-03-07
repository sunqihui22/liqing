package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/12/12.
 */
public class OrganizationFragmentBean {


    /**
     * data : [{"ID":"40288ad956d961eb0156da0e2749000a","departname":"测试水泥拌合站","departorderid":"","description":"","lat":"","lft":"3","lng":"","parentdepartid":"f89b12c25636af3701563c5cc34e0019","rgt":"4","type":"1"},{"ID":"f89b12c25636af3701563c5cc34e0019","departname":"G345线玛久项目","departorderid":"","description":"","lat":"","lft":"2","lng":"","parentdepartid":"297ee90c4447f8a4014447fbba1e0015","rgt":"9","type":"4"},{"ID":"297ee90c4447f8a4014447fbba1e0015","departname":"G345线玛曲至青海久治公路","departorderid":"","description":"G345线玛曲至青海久治公路","lat":"","lft":"1","lng":"","parentdepartid":"","rgt":"10","type":"4"}]
     * success : true
     */

    private boolean success;
    /**
     * ID : 40288ad956d961eb0156da0e2749000a
     * departname : 测试水泥拌合站
     * departorderid :
     * description :
     * lat :
     * lft : 3
     * lng :
     * parentdepartid : f89b12c25636af3701563c5cc34e0019
     * rgt : 4
     * type : 1
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
            private String ID;
            private String departname;
            private String departorderid;
            private String description;
            private String lat;
            private String lft;
            private String lng;
            private String parentdepartid;
            private String rgt;
            private String type;

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getDepartname() {
                return departname;
            }

            public void setDepartname(String departname) {
                this.departname = departname;
            }

            public String getDepartorderid() {
                return departorderid;
            }

            public void setDepartorderid(String departorderid) {
                this.departorderid = departorderid;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLft() {
                return lft;
            }

            public void setLft(String lft) {
                this.lft = lft;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getParentdepartid() {
                return parentdepartid;
            }

            public void setParentdepartid(String parentdepartid) {
                this.parentdepartid = parentdepartid;
            }

            public String getRgt() {
                return rgt;
            }

            public void setRgt(String rgt) {
                this.rgt = rgt;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
}
