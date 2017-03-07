package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.MarshallWhenDingDuXqContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class MarshallWhenDingDuXqPresenter extends BasePresenter<MarshallWhenDingDuXqContract.View> implements MarshallWhenDingDuXqContract.Presenter {
    public MarshallWhenDingDuXqPresenter(MarshallWhenDingDuXqContract.View mView) {
        super(mView);
    }

    @Override
    public void requestMarshallWhenDingDuXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify) {

    }

    @Override
    public void start() {

    }
}
