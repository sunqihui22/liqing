package com.shtoone.liqing.mvp.view.pitch;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.pitch.PitchStatisticsContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.PitchStatisticsData;
import com.shtoone.liqing.mvp.presenter.pitch.PitchStatisticsPresenter;
import com.shtoone.liqing.mvp.view.adapter.PitchMaterialStatisticsRecycleViewAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.others.MainActivity;
import com.shtoone.liqing.utils.DateUtils;
import com.shtoone.liqing.utils.DensityUtils;
import com.shtoone.liqing.utils.ToastUtils;
import com.shtoone.liqing.widget.PageStateLayout;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public  class PitchStatisticsFragment extends BaseFragment<PitchStatisticsContract.Presenter> implements  PitchStatisticsContract.View {

    private static final String TAG = PitchStatisticsFragment.class.getSimpleName();
    private TextView tittle;

    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private Typeface mTf;
    private FloatingActionButton fab;
    private RecyclerView mRecyclerView;
    private BarChart mBarChart0, mBarChart1;
    private PitchStatisticsData data;
    private PitchMaterialStatisticsRecycleViewAdapter mMsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private DepartmentBean mDepartmentBean;
    private ParametersData mParametersData;
    private ScaleInAnimationAdapter mScaleInAnimationAdapter;

    public static PitchStatisticsFragment newInstance(DepartmentBean departmentBean) {

        PitchStatisticsFragment fragment = new PitchStatisticsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("depatmentdate", departmentBean);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void responsePitchStatisticsData(PitchStatisticsData pitchStatisticsData) {
        data = pitchStatisticsData;
        tittle.setText(pitchStatisticsData.getTableName());
        mMsAdapter.removeAllHeaderView();
        mMsAdapter.setNewData(pitchStatisticsData.getData());
        //通知adapter数据已更改
        mMsAdapter.notifyDataSetChanged();
        setViewData();
    }

    @NonNull
    @Override
    protected PitchStatisticsContract.Presenter createPresenter() {
        return new PitchStatisticsPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lq_material_statistics, container, false);
        EventBus.getDefault().register(this);
        if (savedInstanceState == null) {
            Bundle bundle=getArguments();
            mDepartmentBean= (DepartmentBean) bundle.getSerializable("depatmentdate");
        } else {
            mDepartmentBean = (DepartmentBean) savedInstanceState.getSerializable("departmentData");
        }

        initView(view);
        initData();
        return view;
    }

    private void initData() {

        mLinearLayoutManager = new LinearLayoutManager(BaseApplication.mContext);

        if (null != BaseApplication.parametersData) {
            mParametersData = (ParametersData) BaseApplication.parametersData.clone();
            KLog.e(TAG, mParametersData.toString());
            mParametersData.fromTo = Constants.PitchMaterialStatisticsFragment;
            mParametersData.deviceType = Constants.TYPE_PITCH;
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KLog.e(TAG, mParametersData.toString());
                mParametersData.getTo = Constants.PitchMaterialStatisticsFragment;
                mParametersData.departType = mDepartmentBean.departtype;
                mParametersData.biaoshiid = mDepartmentBean.departmentID;
                mParametersData.deviceType = Constants.TYPE_PITCH;
                ((PitchActivity) _mActivity).startDrawerActivity(mParametersData, null);
            }
        });

        mPageStateLayout.setPadding(0, 0, 0, DensityUtils.dp2px(_mActivity, 56));
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
        initToolbarBackNavigation(mToolbar);
        setToolbarTitle();


        //mAdapter的实例化要放到最开始，因为在没有数据的时候，滑动会空指针异常，因为  if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == mAdapter.getItemCount()) {
        mMsAdapter = new PitchMaterialStatisticsRecycleViewAdapter();
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mMsAdapter);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(0.5f));
        mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void loadData() {
        //scrollview滑动到顶部
        mNestedScrollView.fullScroll(ScrollView.FOCUS_UP);
        String startTime = DateUtils.ChangeTimeToLong(mParametersData.startDateTime);
        String endTime = DateUtils.ChangeTimeToLong(mParametersData.endDateTime);

        Map<String,String> map = new HashMap<>();
        map.put("departType",mDepartmentBean.departtype);
        map.put("biaoshiid",mDepartmentBean.departmentID);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        map.put("shebeibianhao",mParametersData.equipmentID);

        mPresenter.requestPitchStatisticsData(map);
    }

    private void setViewData() {
        ArrayList<String> x = new ArrayList<String>();
        ArrayList<BarEntry> y0 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> y1 = new ArrayList<BarEntry>();
        List<PitchStatisticsData.DataBean> mList = data.getData();
        for (int i = 0; i < mList.size(); i++) {
            String name = mList.get(i).getName();
            if(name.indexOf("实际") != -1){
                name = name.substring(2,name.length());
            }
            x.add(name);
            y0.add(new BarEntry(Float.parseFloat(mList.get(i).getYongliang()), i));
            y1.add(new BarEntry(Float.parseFloat(mList.get(i).getMbpeibi()), i));
        }

        setChart(mBarChart0);
        setChart(mBarChart1);

        setChartData(mBarChart0, x, y0);
        setChartData(mBarChart1, x, y1);
    }

    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_toolbar);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        tittle= (TextView) view.findViewById( R.id.tv_title);
        mNestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_material_statistic_fragment);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptr_material_statistic_fragment);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.psl_material_statistic_fragment);
        mBarChart0 = (BarChart) view.findViewById(R.id.barchart0_material_statistic_fragment);
        mBarChart1 = (BarChart) view.findViewById(R.id.barchart1_material_statistic_fragment);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_material_statistic_fragment);
    }

    private void setChartData(BarChart mBarChart, ArrayList<String> x, ArrayList<BarEntry> y) {
        BarDataSet mBarDataSet;
        mBarDataSet = new BarDataSet(y, "材料类型");
        mBarDataSet.setBarSpacePercent(35f);
        mBarDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(mBarDataSet);
        BarData data = new BarData(x, dataSets);
        data.setValueTextSize(10f);
        data.setValueTypeface(mTf);
        mBarChart.setData(data);
    }

    private void setChart(BarChart mBarChart) {
        //设置背景色，此背景表示最大值
        mBarChart.setDrawBarShadow(false);
        //柱状图所对应的值显示在什么位置   true：柱状图顶部    false：柱状图内部的顶部
        mBarChart.setDrawValueAboveBar(true);
        //mChart.getDescription().setEnabled(false);      图右下角的描述信息
        mBarChart.setDescription("");     //设置描述信息
        //当条数大于设置的值时，柱子顶部的值就不再显示
        mBarChart.setMaxVisibleValueCount(60);
        //手势...   true：同时放大    false：只放大一单轴
        mBarChart.setPinchZoom(false);
        //x,y的动画延时效果
        mBarChart.animateXY(2000, 2000);
        //设置网格背景   如果有控件带网格的话。。。
        mBarChart.setDrawGridBackground(false);

        //设置字体
        mTf = Typeface.createFromAsset(_mActivity.getAssets(), "OpenSans-Regular.ttf");

        //对X轴操作的一个对象
        XAxis xAxis = mBarChart.getXAxis();
        //设置位置为底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //字体
        xAxis.setTypeface(mTf);
        //为x轴绘制网格线
        xAxis.setDrawGridLines(false);
        //待测
        xAxis.setSpaceBetweenLabels(0);


        YAxis leftAxis = mBarChart.getAxisLeft();
        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        //设置顶部空余空间
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinValue(0f);

        YAxis rightAxis = mBarChart.getAxisRight();
        rightAxis.setEnabled(false);

        Legend l = mBarChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
    }

    private void setToolbarTitle() {
//        if (null != toolbarToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
        String toolBarName = getResources().getString(R.string.toolbar_name);
        StringBuffer sb = new StringBuffer( toolBarName+ " > ");
        sb.append(getString(R.string.liqing) + " > ");
        mToolbar.setTitle(sb.toString());
//        }
    }

    protected void initToolbarMenu(final Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.menu_hierarchy);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                KLog.e("---onMenuItemClick---");
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:
//                        KLog.e(TAG,mDepartmentBean.toString());
                        BaseApplication.mDepartmentData.fromto = Constants.PitchMaterialStatisticsFragment;
                        ((MainActivity) _mActivity).startDrawerActivity(null, BaseApplication.mDepartmentData);
                        KLog.e("---initToolbar---");
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void showContent() {
        mPageStateLayout.showContent();
    }

    @Override
    public void showError(Throwable t) {
        t.printStackTrace();
        if (t instanceof ConnectException) {
            //   ToastUtils.showInfoToast(BaseApplication.mContext,"网络异常,请检测网络");
            ToastUtils.showToast(BaseApplication.mContext, "网络异常,请检测网络");
            mPageStateLayout.showNetError();
        } else if (t instanceof HttpException) {
            ToastUtils.showToast(BaseApplication.mContext, "服务器异常");
            mPageStateLayout.showError();
        } else if (t instanceof SocketTimeoutException) {
            ToastUtils.showToast(BaseApplication.mContext, "连接超时");
            mPageStateLayout.showError();
        } else if (t instanceof JSONException) {
            ToastUtils.showToast(BaseApplication.mContext, "解析异常");
            mPageStateLayout.showError();
        } else {
            KLog.e("updateDepartment:Subscribe","333333333333");
            ToastUtils.showToast(BaseApplication.mContext, "数据异常");
            mPageStateLayout.showError();
        }
    }

    @Override
    public void showLoading() {
        mPageStateLayout.showLoading();
    }

    @Override
    public void showEmpty() {
        mPageStateLayout.showEmpty();
    }

    @Override
    public boolean isCanDoRefresh() {
        if(mPageStateLayout.isShowLoading){
            return false;
        }
        return mNestedScrollView.getScrollY() == 0;
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void updateDepartment(EventData eventData) {
        KLog.e("updateDepartment:Subscribe");
        if (null != eventData.departmentData && null != this.mDepartmentBean) {
            if (eventData.departmentData.fromto == Constants.PitchMaterialStatisticsFragment) {
                this.mDepartmentBean.departmentName = eventData.departmentData.departmentName;
                this.mDepartmentBean.departmentID = eventData.departmentData.departmentID;
                this.mDepartmentBean.departtype = eventData.departmentData.departtype;
                this.mDepartmentBean.equipmentID = eventData.departmentData.equipmentID;
                mPtrFrameLayout.autoRefresh(true);
            }
        }
        if (eventData.parametersBean != null && null != this.mParametersData) {
            if (eventData.parametersBean.fromTo == Constants.PitchMaterialStatisticsFragment) {
                this.mParametersData.startDateTime = eventData.parametersBean.startDateTime;
                this.mParametersData.endDateTime = eventData.parametersBean.endDateTime;
                this.mParametersData.equipmentID = eventData.parametersBean.equipmentID;
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
