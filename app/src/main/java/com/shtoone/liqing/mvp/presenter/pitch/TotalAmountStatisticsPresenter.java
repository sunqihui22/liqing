package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.TotalAmountStatisticsContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by Administrator on 2017/1/13.
 */
public class TotalAmountStatisticsPresenter extends BasePresenter<TotalAmountStatisticsContract.View> implements TotalAmountStatisticsContract.Presenter{



    public TotalAmountStatisticsPresenter(TotalAmountStatisticsContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {

    }
}
