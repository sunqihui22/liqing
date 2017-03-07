package com.shtoone.liqing.mvp.view.pitch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.pitch.OutletTemperatureContract;
import com.shtoone.liqing.mvp.presenter.pitch.OutletTemperaturePresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2016/11/24.
 */
public class OutletTemperatureFragment extends BaseFragment<OutletTemperatureContract.Presenter> implements OutletTemperatureContract.View {

    private static final String TAG = "OutletTemperatureFragment";
    private Toolbar mToolbar;
    private FloatingActionButton fab;

    public static SupportFragment newInstance() {

        return new OutletTemperatureFragment();
    }

    @NonNull
    @Override
    protected OutletTemperatureContract.Presenter createPresenter() {
        return new OutletTemperaturePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_outlettemperature,container,false);
        initView(view);
        initStateBar(mToolbar);
        initToolbarBackNavigation(mToolbar);
//        mToolbar.setTitle(R.string.OutletTemperature);
        setToolbarTitle();
        return view;
    }

    private void initView(View view){
        mToolbar= (Toolbar) view.findViewById(R.id.toolbar_toolbar);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
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

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.liqing) + " > ");
            sb.append(getString(R.string.OutletTemperature)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}
