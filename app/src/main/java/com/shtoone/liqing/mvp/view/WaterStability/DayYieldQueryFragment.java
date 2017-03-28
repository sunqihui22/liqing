package com.shtoone.liqing.mvp.view.WaterStability;

import android.support.annotation.NonNull;

import com.shtoone.liqing.mvp.model.bean.DayYieldQueryBean;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.contract.WaterStability.DayYieldQueryContract;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class DayYieldQueryFragment extends BaseFragment<DayYieldQueryContract.Presenter> implements DayYieldQueryContract.View {
    @Override
    public void responseDayYieldQueryBean(DayYieldQueryBean dayYieldQueryBean) {

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

    @NonNull
    @Override
    protected DayYieldQueryContract.Presenter createPresenter() {
        return null;
    }
}
