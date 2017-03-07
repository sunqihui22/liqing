package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountResData;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface DayProduceAmountQueryContract {

    interface View extends BaseContract.View{
        void responseDayProduceAmount(List<DayProduceAmountResData> dayProduceAmountResData);
    }

    interface Presenter extends BaseContract.Presenter{
        void requestDayProduceAmount(Map<String, String> options);
    }
}
