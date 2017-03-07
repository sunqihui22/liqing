package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.RuanHuaDianXqContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class RuanHuaDianXqPresenter extends BasePresenter<RuanHuaDianXqContract.View> implements RuanHuaDianXqContract.Presenter {
    public RuanHuaDianXqPresenter(RuanHuaDianXqContract.View mView) {
        super(mView);
    }

    @Override
    public void requestRuanHuaDianXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify) {

    }

    @Override
    public void start() {

    }
}
