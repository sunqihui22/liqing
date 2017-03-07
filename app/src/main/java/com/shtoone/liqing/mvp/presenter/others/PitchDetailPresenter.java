package com.shtoone.liqing.mvp.presenter.others;

import com.shtoone.liqing.mvp.contract.others.PitchDetailContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by Administrator on 2016/11/24.
 */
public class PitchDetailPresenter extends BasePresenter<PitchDetailContract.View> implements PitchDetailContract.Presenter{

    public PitchDetailPresenter(PitchDetailContract.View mView) {
        super(mView);
    }

    @Override
    public void detachView() {

    }

    @Override
    public void start() {

    }
}
