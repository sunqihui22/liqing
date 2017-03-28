package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentData;

/**
 * Created by Administrator on 2016/11/23.
 */
public interface PitchContract {

    interface View extends BaseContract.View{

        void responseTotalProductData(PitchFragmentData PitchFragmentData);

    }

    interface Presenter extends BaseContract.Presenter{

        void requestTotalProductData(  String departType,  String biaoduan,  String startTime,  String endTime,  String shebeibianhao);
    }
}
