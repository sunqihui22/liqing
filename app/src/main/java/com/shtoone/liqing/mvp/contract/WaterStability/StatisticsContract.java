package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityStatisticsBean;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/14.
 * Email：hengzwdhengzwd@qq.com
 */

public interface StatisticsContract {


    interface View extends BaseContract.View {

        void responseStatisticData(WaterstabilityStatisticsBean waterstabilityStatisticsBean);
    }

    interface Presenter extends BaseContract.Presenter {

        void requestStatisticData(Map map);
    }

}
