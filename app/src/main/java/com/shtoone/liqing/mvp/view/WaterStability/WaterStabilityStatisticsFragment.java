package com.shtoone.liqing.mvp.view.WaterStability;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.WaterStability.StatisticsContract;
import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityStatisticsBean;
import com.shtoone.liqing.mvp.presenter.WaterStability.WaterStabilityStatisticsPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityStatisticsFragment extends BaseFragment<StatisticsContract.Presenter> implements StatisticsContract.View {


    public static WaterStabilityStatisticsFragment newInstance() {
        return new WaterStabilityStatisticsFragment();
    }

    @NonNull
    @Override
    protected StatisticsContract.Presenter createPresenter() {
        return new WaterStabilityStatisticsPresenter(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_waterstabilitystatistics, container, false);
        return view;
    }

    @Override
    public void responseStatisticData(WaterstabilityStatisticsBean waterstabilityStatisticsBean) {

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
}
