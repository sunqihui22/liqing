package com.shtoone.liqing.mvp.presenter.others;

import com.shtoone.liqing.mvp.contract.others.SubmitScannedDataContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

public class SubmitScannedDataPresenter extends BasePresenter<SubmitScannedDataContract.View> implements SubmitScannedDataContract.Presenter {


    public SubmitScannedDataPresenter(SubmitScannedDataContract.View mView) {
        super(mView);
    }

    @Override
    public void submit(String shebeibianhao, String pitchType, String lay) {
        KLog.d("设备编号" + shebeibianhao + "  " + pitchType + "  " + lay);
    }

    @Override
    public void start() {

    }
}
