package com.shtoone.liqing.mvp.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */
public class ProduceDataQueryRes {


    /**
     * data : [{"clwd":"164","sjlq":"123.599998474121","sjysb":"4.61","bianhao":15643,"shijian":"2016-10-23 20:15:07","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"167","sjlq":"121.699996948242","sjysb":"4.62","bianhao":15642,"shijian":"2016-10-23 20:14:18","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"164","sjlq":"122.199996948242","sjysb":"4.58","bianhao":15641,"shijian":"2016-10-23 20:13:29","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"163","sjlq":"123.800003051758","sjysb":"4.62","bianhao":15640,"shijian":"2016-10-23 20:11:50","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"163","sjlq":"121","sjysb":"4.62","bianhao":15639,"shijian":"2016-10-23 20:10:27","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"164","sjlq":"124.099998474121","sjysb":"4.62","bianhao":15638,"shijian":"2016-10-23 20:09:02","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"164","sjlq":"122.800003051758","sjysb":"4.59","bianhao":15637,"shijian":"2016-10-23 20:07:50","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"163","sjlq":"123.300003051758","sjysb":"4.63","bianhao":15636,"shijian":"2016-10-23 20:06:26","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"165","sjlq":"123.099998474121","sjysb":"4.61","bianhao":15635,"shijian":"2016-10-23 20:05:22","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"164","sjlq":"124.099998474121","sjysb":"4.61","bianhao":15634,"shijian":"2016-10-23 20:04:10","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"167","sjlq":"122.5","sjysb":"4.6","bianhao":15633,"shijian":"2016-10-23 20:03:15","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"166","sjlq":"121.800003051758","sjysb":"4.62","bianhao":15632,"shijian":"2016-10-23 20:02:18","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"168","sjlq":"124.699996948242","sjysb":"4.66","bianhao":15631,"shijian":"2016-10-23 20:01:20","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"168","sjlq":"121.699996948242","sjysb":"4.58","bianhao":15630,"shijian":"2016-10-23 20:00:29","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"},{"clwd":"166","sjlq":"121.400001525879","sjysb":"4.58","bianhao":15629,"shijian":"2016-10-23 19:59:33","deptId":"f89b12c25636af3701563c5cc34e0019","shebeibianhao":"G345lq0101"}]
     * success : true
     */

    private boolean success;
    /**
     * clwd : 164
     * sjlq : 123.599998474121
     * sjysb : 4.61
     * bianhao : 15643
     * shijian : 2016-10-23 20:15:07
     * deptId : f89b12c25636af3701563c5cc34e0019
     * shebeibianhao : G345lq0101
     */

    private List<ProduceDataQueryResData> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ProduceDataQueryResData> getData() {
        return data;
    }

    public void setData(List<ProduceDataQueryResData> data) {
        this.data = data;
    }

}
