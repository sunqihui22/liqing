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
import com.shtoone.liqing.mvp.contract.laboratory.RuanHuaDianContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.RuanHuaDianData;
import com.shtoone.liqing.mvp.presenter.laboratory.RuanHuaDianPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.others.MainActivity;
import com.shtoone.liqing.utils.ToastUtils;
import com.socks.library.KLog;

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
public class RuanHuaDianFragment extends BaseFragment<RuanHuaDianContract.Presenter> implements RuanHuaDianContract.View {

    private String TAG=RuanHuaDianFragment.class.getSimpleName();
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;

    private ParametersData mparametersData;
    public static RuanHuaDianFragment newInstance() {
        return new RuanHuaDianFragment();
    }

    @NonNull
    @Override
    protected RuanHuaDianContract.Presenter createPresenter() {
        return new RuanHuaDianPresenter(this);
    }

    @Override
    public void responseRuanHuaDianData(List<RuanHuaDianData> mRuanHuaDianData) {

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
        View view = inflater.inflate(R.layout.fragment_ruanhuadian, container, false);
        ButterKnife.bind(this, view);
        KLog.e("000000000000000000000");
        initView();
        initData();
        return view;
    }


    private void initData() {
        mparametersData= (ParametersData) BaseApplication.parametersData.clone();
        mparametersData.fromTo= Constants.RUANHUADIANFRAGMENT ;
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
        if (event.position== Constants.RUANHUADIANFRAGMENT)
        {

            ((MainActivity)_mActivity).closePopuindow();
            ToastUtils.showToast(BaseApplication.mContext,TAG);

        }

    }

    @Override
    public void onStart() {
        super.onStart();

        KLog.e("onstart");
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
