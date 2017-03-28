package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DayYieldQueryBean;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public interface DayYieldQueryContract {

    interface View extends BaseContract.View
    {
      void   responseDayYieldQueryBean(DayYieldQueryBean dayYieldQueryBean);
    }

    interface Presenter extends BaseContract.Presenter
    {
        void  requestDayYieldQueryBean(Map<String,String> map);
    }
}
