package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.YanDuXqContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class YanDuXqPresenter extends BasePresenter<YanDuXqContract.View> implements YanDuXqContract.Presenter {
    public YanDuXqPresenter(YanDuXqContract.View mView) {
        super(mView);
    }

    @Override
    public void requestYanDuXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify) {

    }

    @Override
    public void start() {

    }
}
