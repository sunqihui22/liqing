package com.shtoone.liqing.mvp.model.bean;

/**
 * Author： hengzwd on 2017/3/20.
 * Email：hengzwdhengzwd@qq.com
 */

public class UploadResponseBean {


    /**
     * description : 超标处置成功！
     * success : true
     */

    private String description;
    private boolean success;

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
}
