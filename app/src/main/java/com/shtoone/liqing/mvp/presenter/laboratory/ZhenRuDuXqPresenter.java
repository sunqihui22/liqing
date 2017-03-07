package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.ZhenRuDuXqContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class ZhenRuDuXqPresenter extends BasePresenter<ZhenRuDuXqContract.View> implements ZhenRuDuXqContract.Presenter {

    public ZhenRuDuXqPresenter(ZhenRuDuXqContract.View mView) {
        super(mView);
    }

    @Override
    public void requestZhenRuDuXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify) {

    }

    @Override
    public void start() {

    }
}
