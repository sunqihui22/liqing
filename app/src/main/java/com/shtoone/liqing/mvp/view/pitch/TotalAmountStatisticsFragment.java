package com.shtoone.liqing.mvp.view.pitch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.pitch.ProductQueryContract;
import com.shtoone.liqing.mvp.contract.pitch.TotalAmountStatisticsContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.presenter.pitch.TotalAmountStatisticsPresenter;
import com.shtoone.liqing.mvp.view.adapter.PitchDataProductQueryAdapter;
import com.shtoone.liqing.mvp.view.adapter.TotalAmountStatisticsVpAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

/**
 * Created by Administrator on 2017/1/13.
 */
public class TotalAmountStatisticsFragment extends BaseFragment<TotalAmountStatisticsContract.Presenter> implements TotalAmountStatisticsContract.View{


    private static final String TAG = TotalAmountStatisticsFragment.class.getSimpleName();
    private boolean isRegistered = false;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FloatingActionButton fab;
    private ParametersData mParametersData;
    private TotalAmountStatisticsVpAdapter mAdapter;


    @NonNull
    @Override
    protected TotalAmountStatisticsContract.Presenter createPresenter() {
        return new TotalAmountStatisticsPresenter(this);
    }

    public static TotalAmountStatisticsFragment newInstance() {
        return new TotalAmountStatisticsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
        View  view=inflater.inflate(R.layout.fragment_total_amount_statistic,container,false);
        mToolbar= (Toolbar) view.findViewById(R.id.toolbar_toolbar_tablayout);
        initStateBar(mToolbar);
        initToolbarBackNavigation(mToolbar);
//        mToolbar.setTitle(R.string.total_product);
        setToolbarTitle();
        initView(view);
        initData();
        return view;
    }


    private void initView(View view) {
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.appbar_toolbar_tablayout);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_toolbar_tablayout);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout_toolbar_tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_total_amount_fragment);
        //       initToolbarMenu(mToolbar);
//        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initData() {

        mParametersData = (ParametersData) BaseApplication.parametersData.clone();
        mParametersData.userGroupID = BaseApplication.parametersData.userGroupID;
        mParametersData.fromTo = Constants.TOTALAMOUNTSTATISTICFRAGMENT;

        KLog.e(TAG,mParametersData.userGroupID);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((PitchDetailActivity) _mActivity).startDrawerActivity(mParametersData,null);
            }
        });

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (0 == verticalOffset) {
                    BaseApplication.isExpand = true;
                } else {
                    BaseApplication.isExpand = false;
                }
            }
        });

        setAdapter();
    }

    private void setAdapter() {
        mViewPager.setAdapter(mAdapter = new TotalAmountStatisticsVpAdapter(getChildFragmentManager(),mParametersData));
        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == Constants.TOTALAMOUNTSTATISTICFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.timeType=mParametersData.timeType;
                KLog.e("mParametersData:" + mParametersData.startDateTime);
                KLog.e("mParametersData:" + mParametersData.endDateTime);
                KLog.e("mParametersData:" + mParametersData.equipmentID);
                KLog.e("mParametersData:" + mParametersData.timeType);

            }
        }
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
            sb.append(getString(R.string.total_Statistics)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}
