package com.shtoone.liqing.mvp.view.laboratory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.laboratory.ZhenRuDuContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.ZhenRuDuData;
import com.shtoone.liqing.mvp.presenter.laboratory.ZhenRuDuPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.others.MainActivity;
import com.shtoone.liqing.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public class ZhenRuDuFragment extends BaseFragment<ZhenRuDuContract.Presenter> implements ZhenRuDuContract.View {

    private String TAG=ZhenRuDuFragment.class.getSimpleName();
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;

    private ParametersData mparametersData;
    public static ZhenRuDuFragment newInstance() {
        return new ZhenRuDuFragment();
    }

    @NonNull
    @Override
    protected ZhenRuDuContract.Presenter createPresenter() {
        return new ZhenRuDuPresenter(this);
    }

    @Override
    public void responseZhenRuDuData(List<ZhenRuDuData> mZhenRuDuData) {

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
        View view = inflater.inflate(R.layout.fragment_zhenrudu, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        mparametersData= (ParametersData) BaseApplication.parametersData.clone();
        mparametersData.fromTo= Constants.ZHENRUDUFRAGMENT;

    }

    private void initView() {
        initToolbarBackNavigation(toolbarToolbar);
        initStateBar(toolbarToolbar);
    }


    @OnClick( R.id.fab)
    public void onClick() {
        mparametersData.getTo= Constants.PARAMETERSFRAGMENT;
        ((MainActivity) _mActivity).startDrawerActivity(mparametersData,null);
       // ((MainActivity) _mActivity).showPopuwindow(fab,new ParametersController(BaseApplication.mContext,mparametersData));
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEquipment(EventData event)
    {
        if (event.position== Constants.ZHENRUDUFRAGMENT)
        {

            ((MainActivity)_mActivity).closePopuindow();
            ToastUtils.showToast(BaseApplication.mContext,TAG);

        }

    }

    @Override
    public void onStart() {
        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
