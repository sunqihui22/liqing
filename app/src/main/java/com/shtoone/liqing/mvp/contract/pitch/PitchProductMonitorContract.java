package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;

/**
 * Created by Administrator on 2016/11/24.
 */
public interface PitchProductMonitorContract {

    interface View extends BaseContract.View, BaseContract.Presenter {

    }

    interface Presenter extends BaseContract.Presenter, BaseContract.View {

    }
}
