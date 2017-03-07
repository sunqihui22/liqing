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
import com.shtoone.liqing.mvp.contract.laboratory.RuanHuaDianXqContract;
import com.shtoone.liqing.mvp.model.bean.RuanHuaDianXqData;
import com.shtoone.liqing.mvp.presenter.laboratory.RuanHuaDianXqPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class RuanHuaDianXqFragment extends BaseFragment<RuanHuaDianXqContract.Presenter> implements RuanHuaDianXqContract.View {
    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;
    @BindView(R.id.fl_ruanhuaduxq_fragment)
    FrameLayout flRuanhuaduxqFragment;

    @NonNull
    @Override
    protected RuanHuaDianXqContract.Presenter createPresenter() {
        return new RuanHuaDianXqPresenter(this);
    }

    public static RuanHuaDianXqFragment newInstance() {
        return new RuanHuaDianXqFragment();
    }

    @Override
    public void responseRuanHuaDianXqData(List<RuanHuaDianXqData> mRuanHuaDianXqData) {

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
        View view = inflater.inflate(R.layout.fragment_ruanhuaduxq, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initView() {
        initStateBar(toolbarToolbar);
        initToolbarBackNavigation(toolbarToolbar);

    }

    private void initData() {

    }

}
