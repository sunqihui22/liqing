package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchStatisticsData;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public interface PitchStatisticsContract extends BaseContract {

    interface View extends BaseContract.View{
        void  responsePitchStatisticsData(PitchStatisticsData pitchStatisticsData);
    }
    interface  Presenter extends  BaseContract.Presenter
    {
       void requestPitchStatisticsData(Map<String,String> map);
    }
}
