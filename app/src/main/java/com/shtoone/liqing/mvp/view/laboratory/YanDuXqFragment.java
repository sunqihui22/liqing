package com.shtoone.liqing.mvp.view.laboratory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.laboratory.YanDuXqContract;
import com.shtoone.liqing.mvp.model.bean.YanDuXqData;
import com.shtoone.liqing.mvp.presenter.laboratory.YanDuXqPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class YanDuXqFragment extends BaseFragment<YanDuXqContract.Presenter> implements YanDuXqContract.View {
    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;
    @BindView(R.id.fl_yanduxq_fragment)
    FrameLayout flYanduxqFragment;

    @NonNull
    @Override
    protected YanDuXqContract.Presenter createPresenter() {
        return new YanDuXqPresenter(this);
    }


    public static YanDuXqFragment newInstance() {
        return new YanDuXqFragment();
    }

    @Override
    public void responseYanDuXqData(List<YanDuXqData> mYanDuXqData) {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yanduxq, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();

        return view;
    }

    private void initData() {

    }

    private void initView() {
        initToolbarBackNavigation(toolbarToolbar);
        initStateBar(toolbarToolbar);

    }

}
