package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.WaterStability.DayYieldQueryContract;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class DayYieldQueryPresenter extends BasePresenter<DayYieldQueryContract.View> implements DayYieldQueryContract.Presenter {
    public DayYieldQueryPresenter(DayYieldQueryContract.View mView) {
        super(mView);
    }

    @Override
    public void requestDayYieldQueryBean(Map<String, String> map) {

    }

    @Override
    public void start() {

    }
}
