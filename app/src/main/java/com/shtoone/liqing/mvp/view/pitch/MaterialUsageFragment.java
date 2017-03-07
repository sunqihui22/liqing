package com.shtoone.liqing.mvp.view.pitch;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;

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
import com.shtoone.liqing.mvp.contract.base.MaterialUsageContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.SC_cailiaoyongliang;
import com.shtoone.liqing.mvp.presenter.pitch.MaterialUsagePresenter;
import com.shtoone.liqing.mvp.view.adapter.MaterialUsageFragmentRecyclerViewAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.DateUtils;
import com.shtoone.liqing.utils.DensityUtils;
import com.shtoone.liqing.utils.RecyclerExceptionManager;
import com.shtoone.liqing.utils.ToastUtils;
import com.shtoone.liqing.widget.PageStateLayout;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

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
 * Created by Administrator on 2016/12/7.
 */
public class MaterialUsageFragment extends BaseFragment<MaterialUsageContract.Presenter> implements MaterialUsageContract.View {

    private static final String TAG = MaterialUsageFragment.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private ParametersData mParametersData;
    private RecyclerView mRecyclerView0;
    private BarChart mBarChart0, mBarChart1;
    private boolean isRegistered = false;
//    private LinearLayoutManager mLinearLayoutManager;
    private MaterialUsageFragmentRecyclerViewAdapter mAdapter;
    private Typeface mTf;
    private String userGroupID = "";
    private String startDateTime = "";
    private String endDateTime = "";
    private String equipmentID= "";
    final Map<String, String> options = new HashMap<>();
    String userGroupId=" ";
    private int pageNo=1;
    private int height=0;

    private RecyclerExceptionManager mRecyclerExceptionManager;
    private List<SC_cailiaoyongliang> listData=new ArrayList<>();


    @NonNull
    @Override
    protected MaterialUsageContract.Presenter createPresenter() {
        return new MaterialUsagePresenter(this);
    }

    public static MaterialUsageFragment newInstance(ParametersData mParametersData) {
        Bundle args = new Bundle();
        args.putSerializable(Constants.PARAMETERS, mParametersData);
        MaterialUsageFragment fragment = new MaterialUsageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mParametersData = (ParametersData) args.getSerializable(Constants.PARAMETERS);//得到参数bean
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

        height = wm.getDefaultDisplay().getHeight();
        View view=inflater.inflate(R.layout.fragment_material_usage,container,false);
        initView(view);
        initData();
//        loadData();
        return view;
    }


    public void initView(View view){

        mNestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_material_statistic_fragment);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptr_material_statistic_fragment);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.psl_material_statistic_fragment);
        mBarChart0 = (BarChart) view.findViewById(R.id.barchart0_material_statistic_fragment);
        mBarChart1 = (BarChart) view.findViewById(R.id.barchart1_material_statistic_fragment);
        mRecyclerView0 = (RecyclerView) view.findViewById(R.id.rv0_material_statistic_fragment);

        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if(scrollY - oldScrollY > height/3){
                    BaseApplication.bus.post(new EventData(Constants.PRODUCTQUERYHIDE));
                }else if(scrollY - oldScrollY < -height/3){
                    BaseApplication.bus.post(new EventData(Constants.PRODUCTQUERYSHOW));
                }
            }
        });

    }


    private void initData() {

        mParametersData = (ParametersData) BaseApplication.parametersData.clone();
        mParametersData.userGroupID = BaseApplication.parametersData.userGroupID;
        mParametersData.fromTo = Constants.TOTALAMOUNTFRAGMENT;
        if (null != mParametersData) {
            userGroupID = mParametersData.userGroupID;
            startDateTime = mParametersData.startDateTime;
            endDateTime = mParametersData.endDateTime;
            equipmentID = mParametersData.equipmentID;
        }

        mPageStateLayout.setPadding(0, 0, 0, DensityUtils.dp2px(_mActivity, 56));
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);

    }


    @Override
    public void loadData(){
        String startTime = DateUtils.ChangeTimeToLong(mParametersData.startDateTime);
        String endTime = DateUtils.ChangeTimeToLong(mParametersData.endDateTime);
        equipmentID= mParametersData.equipmentID;
        userGroupId=mParametersData.userGroupID;

        options.put("shebeibianhao",equipmentID);
        options.put("userGroupId",userGroupId);
        options.put("startTime",startTime);
        options.put("endTime",endTime);
        KLog.e(TAG,options.toString());
        listData.clear();
        mPresenter.requestMaterialUsage(options);

        KLog.e(TAG,"----loadData----");
    }

    public void responseMaterialUsage(List<SC_cailiaoyongliang> datas){

        listData.clear();
        listData.addAll(datas);
        KLog.e(TAG,datas.toString());
        if(null!=listData){
            ArrayList<String> x = new ArrayList<String>();
            ArrayList<BarEntry> y0 = new ArrayList<BarEntry>();
            ArrayList<BarEntry> y1 = new ArrayList<BarEntry>();
            ArrayList<BarEntry> y2 = new ArrayList<BarEntry>();


            for (int i = 0; i < listData.size(); i++) {
//                KLog.e("--------for--------");
                x.add(listData.get(i).getCailiaomingcheng());
                y0.add(new BarEntry(Float.parseFloat(String.valueOf(listData.get(i).getShijiKg())), i));
                y1.add(new BarEntry(Float.parseFloat(String.valueOf(listData.get(i).getpeibiKg())), i));
                y2.add(new BarEntry(Float.parseFloat(String.valueOf(listData.get(i).getWuchaPst())), i));
            }

            setChart(mBarChart0);
            setChart(mBarChart1);

            setChartData(mBarChart0, x, y0);
            setChartData(mBarChart1, x, y2);

//            mLinearLayoutManager = new LinearLayoutManager(_mActivity);
//            mRecyclerView0.setLayoutManager(mLinearLayoutManager);

            mRecyclerExceptionManager=new RecyclerExceptionManager(_mActivity, LinearLayoutManager.VERTICAL, false);
            mRecyclerView0.setLayoutManager(mRecyclerExceptionManager);

            //设置动画与适配器
            SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new MaterialUsageFragmentRecyclerViewAdapter(_mActivity, listData));
            mSlideInLeftAnimationAdapter.setFirstOnly(true);
            mSlideInLeftAnimationAdapter.setDuration(500);
            mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
            ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
            mScaleInAnimationAdapter.setFirstOnly(true);
            mRecyclerView0.setAdapter(mScaleInAnimationAdapter);
        }

    }


    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == Constants.PRODUCTQUERYFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.testTypeID = mParametersData.testTypeID;
                KLog.e("mParametersData:" + mParametersData.startDateTime);
                KLog.e("mParametersData:" + mParametersData.endDateTime);
                KLog.e("mParametersData:" + mParametersData.equipmentID);
                KLog.e("mParametersData:" + mParametersData.testTypeID);
                listData.clear();
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }



    private void setChart(BarChart mBarChart) {
        mBarChart.setDrawBarShadow(false);
        mBarChart.setDrawValueAboveBar(true);
        mBarChart.setDescription("");
        mBarChart.setMaxVisibleValueCount(60);
        mBarChart.setPinchZoom(false);
        mBarChart.animateXY(2000, 2000);
        mBarChart.setDrawGridBackground(false);
        mTf = Typeface.createFromAsset(_mActivity.getAssets(), "OpenSans-Regular.ttf");

        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(mTf);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(0);

        YAxis leftAxis = mBarChart.getAxisLeft();
        leftAxis.setStartAtZero(false);
        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        //  leftAxis.setAxisMinValue(-20f);  //设置y轴最小值，设置之后，超出范围的不显示，不设置，则根据值得范围自动生成


        YAxis rightAxis = mBarChart.getAxisRight();
        rightAxis.setEnabled(false);

        Legend l = mBarChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
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


    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mNestedScrollView.getScrollY() == 0) {
            return true;
        }
        return false;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.bus.unregister(this);
    }

    @Override
    public void showContent() {

        mPageStateLayout.showContent();
    }

    @Override
    public void showError(Throwable t) {

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
            ToastUtils.showToast(BaseApplication.mContext, "数据异常");
            mPageStateLayout.showError();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

        mPageStateLayout.showEmpty();
    }

    @Subscribe
    public void go2TopOrRefresh(EventData event) {
        if (event.position == 0) {
            mRecyclerView0.smoothScrollToPosition(0);
        }
    }

    @Subscribe
    public void handleRefresh(EventData event) {
        if (event.position == Constants.REFRESH) {
            mPtrFrameLayout.autoRefresh(true);
        }
    }


}
