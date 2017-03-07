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
import com.shtoone.liqing.mvp.contract.laboratory.ZhenRuDuXqContract;
import com.shtoone.liqing.mvp.model.bean.ZhenRuDuXqData;
import com.shtoone.liqing.mvp.presenter.laboratory.ZhenRuDuXqPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class ZhenRuDuXqFragment extends BaseFragment<ZhenRuDuXqContract.Presenter> implements ZhenRuDuXqContract.View {
    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;
    @BindView(R.id.fl_zhenruduxq_fragment)
    FrameLayout flZhenruduxqFragment;

    @NonNull
    @Override
    protected ZhenRuDuXqContract.Presenter createPresenter() {
        return new ZhenRuDuXqPresenter(this);
    }

    public static ZhenRuDuXqFragment newInstance() {
        return new ZhenRuDuXqFragment();
    }

    @Override
    public void responseZhenRuDuXqData(List<ZhenRuDuXqData> mZhenRuDuXqData) {

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
        View view = inflater.inflate(R.layout.fragment_zhenruduxq, container, false);
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
