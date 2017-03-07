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
import com.shtoone.liqing.mvp.contract.laboratory.MarshallWhenDingDuXqContract;
import com.shtoone.liqing.mvp.model.bean.MarshallWhenDingDuXqData;
import com.shtoone.liqing.mvp.presenter.laboratory.MarshallWhenDingDuXqPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public class MarshallWhenDingDuXqFragment extends BaseFragment<MarshallWhenDingDuXqContract.Presenter> implements MarshallWhenDingDuXqContract.View {
    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;
    @BindView(R.id.fl_marshallwhendingduxq_fragment)
    FrameLayout flMarshallwhendingduxqFragment;

    @NonNull
    @Override
    protected MarshallWhenDingDuXqContract.Presenter createPresenter() {
        return new MarshallWhenDingDuXqPresenter(this);
    }

    public static MarshallWhenDingDuXqFragment newInstance() {
        return new MarshallWhenDingDuXqFragment();
    }

    @Override
    public void responseMarshallWhenDingDuXqData(List<MarshallWhenDingDuXqData> mMarshallWhenDingDuXqData) {

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
        View view = inflater.inflate(R.layout.fragment_marshallxq, container, false);
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
