package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.PitchProductMonitorContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by Administrator on 2016/11/24.
 */
public class PitchProductMonitorPresenter extends BasePresenter<PitchProductMonitorContract.View> implements PitchProductMonitorContract.Presenter {


    public PitchProductMonitorPresenter(PitchProductMonitorContract.View mView) {
        super(mView);
    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable t) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void start() {

    }
}