package com.shtoone.liqing.mvp.contract.others;

import com.shtoone.liqing.mvp.contract.base.BaseContract;

public interface SubmitScannedDataContract {
    interface View extends BaseContract.View {
        void submitSuccessfully();
        void submitFailed(String message);

    }

    interface Presenter extends BaseContract.Presenter {
        void submit(String shebeibianhao, String pitchType, String lay);
    }

}
