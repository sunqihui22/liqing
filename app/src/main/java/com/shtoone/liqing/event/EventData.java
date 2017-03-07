package com.shtoone.liqing.event;

import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class EventData {
    public int position;
    public DepartmentBean departmentData;
    public ParametersData parametersBean;

    public EventData(int position) {
        this.position = position;
    }
    public EventData(DepartmentBean mdepartmentData)
    {
        this.departmentData=mdepartmentData;

    }
    public EventData(ParametersData parametersBean)
    {
        this.parametersBean=parametersBean;
    }
}
