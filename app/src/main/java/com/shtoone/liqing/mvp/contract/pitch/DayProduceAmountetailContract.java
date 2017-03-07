package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountResData;

/**
 * Created by Administrator on 2016/12/23.
 */
public interface DayProduceAmountetailContract {

    interface View extends BaseContract.View{

        void uploaded(String text,int tag);
    }

    interface Presenter extends BaseContract.Presenter{

        void uploadDayAmountDetail(String s);
    }
}
