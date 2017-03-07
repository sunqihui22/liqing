package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.OutletTemperatureContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by Administrator on 2016/11/24.
 */
public class OutletTemperaturePresenter extends BasePresenter<OutletTemperatureContract.View> implements OutletTemperatureContract.Presenter {


    public OutletTemperaturePresenter(OutletTemperatureContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {

    }
}
