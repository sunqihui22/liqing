package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.WaterStability.StatisticsContract;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/14.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityStatisticsPresenter extends BasePresenter<StatisticsContract.View> implements StatisticsContract.Presenter {
    public WaterStabilityStatisticsPresenter(StatisticsContract.View mView) {
        super(mView);
    }

    @Override
    public void requestStatisticData(Map map) {

    }

    @Override
    public void start() {

    }
}
