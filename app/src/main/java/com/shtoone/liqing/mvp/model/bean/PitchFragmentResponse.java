package com.shtoone.liqing.mvp.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */
public class PitchFragmentResponse implements Serializable {


    /**
     * data : [[{"deptName":"G345线玛久项目","reallv":"0.00","dengji":"总","cblv":"0.46","panshu":"4552","cbps":"21","banhezhanminchen":"全线超标总数","changliang":"11883.6","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"deptName":"G345线玛久项目","reallv":"0.00","dengji":"初级","cblv":"0.46","panshu":"4552","cbps":"21","banhezhanminchen":"G345线玛久1标1号沥青拌合机初级","changliang":"11883.6","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"deptName":"G345线玛久项目","reallv":"0.00","dengji":"中级","cblv":"0.33","panshu":"4552","cbps":"15","banhezhanminchen":"G345线玛久1标1号沥青拌合机中级","changliang":"11883.6","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"deptName":"G345线玛久项目","reallv":"","dengji":"高级","cblv":"0.33","panshu":"4552","cbps":"15","banhezhanminchen":"G345线玛久1标1号沥青拌合机高级","changliang":"11883.6","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"}]]
     * success : true
     */

    private boolean success;
    /**
     * deptName : G345线玛久项目
     * reallv : 0.00
     * dengji : 总
     * cblv : 0.46
     * panshu : 4552
     * cbps : 21
     * banhezhanminchen : 全线超标总数
     * changliang : 11883.6
     * deptId : f89b12c25636af3701563c5cc34e0019
     * shebeibianhao : G345lq0101
     */

    private List<List<PitchfragmentResDataBean>> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<List<PitchfragmentResDataBean>> getData() {
        return data;
    }

    public void setData(List<List<PitchfragmentResDataBean>> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "PitchFragmentResponse{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
