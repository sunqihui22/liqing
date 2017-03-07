package com.shtoone.liqing.mvp.view.pitch;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.shtoone.liqing.mvp.contract.pitch.TotalAmountContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.SC_zongchanliang;
import com.shtoone.liqing.mvp.model.bean.TotalAmountItemData;
import com.shtoone.liqing.mvp.presenter.pitch.TotalAmountPresenter;
import com.shtoone.liqing.mvp.view.adapter.zongchanliangRecyclerviewAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.DateUtils;
import com.shtoone.liqing.utils.DensityUtils;
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
 * Created by Administrator on 2017/1/13.
 */
public class ShenchanliangFragment extends BaseFragment<TotalAmountContract.Presenter> implements TotalAmountContract.View {


    private static final String TAG = ShenchanliangFragment.class.getSimpleName();
    private ParametersData mParametersData;
    private boolean isRegistered = false;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private LinearLayout recyclerview1_title, recyclerview1_mpchart;
    private RecyclerView mRecyclerView1;
    String userGroupId;
    String equipmentID;
    String timeType;
    final Map<String, String> options = new HashMap<>();
    private List<TotalAmountItemData> totalAmountStatisticListData=new ArrayList<>();
    private LinearLayoutManager mLinearLayoutManager;
    List<SC_zongchanliang> Datas;
    private SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter;
    private BarChart chart_cl;
    private Typeface mTf;
    private zongchanliangRecyclerviewAdapter nAdapter;


    public static ShenchanliangFragment newInstance(ParametersData mParametersData) {
        Bundle args = new Bundle();
        args.putSerializable(Constants.PARAMETERS, mParametersData);
        ShenchanliangFragment fragment = new ShenchanliangFragment();
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

    @NonNull
    @Override
    protected TotalAmountContract.Presenter createPresenter() {
        return new TotalAmountPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }

        View view = inflater.inflate(R.layout.fragment_total_amount, container, false);
        initView(view);
        initData();
//        loadData();
        return view;
    }

    private void initView(View view) {

        mNestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_material_statistic_fragment);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptr_material_statistic_fragment);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.psl_material_statistic_fragment);
        recyclerview1_title = (LinearLayout) view.findViewById(R.id.recyclerview1_title);

        recyclerview1_mpchart = (LinearLayout) view.findViewById(R.id.recyclerview1_mpchart);
        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.rv1_material_statistic_fragment);

    }

    private void initData() {

        mPageStateLayout.setPadding(0, 0, 0, DensityUtils.dp2px(_mActivity, 56));
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);

    }



    @Override
    public void responseTotalAmount(List<TotalAmountItemData> totalAmountListData) {

        totalAmountStatisticListData.clear();
        totalAmountStatisticListData.addAll(totalAmountListData);

        Datas = new ArrayList<SC_zongchanliang>();
        for (int i = 0; i < totalAmountStatisticListData.size(); i++) {
            TotalAmountItemData totalAmountItemData = totalAmountStatisticListData.get(i);
            SC_zongchanliang data = new SC_zongchanliang();
            data.setDate(totalAmountItemData.getXa() + "-" + totalAmountItemData.getXb());
            data.setPrimarylv(Double.valueOf(totalAmountItemData.getPrimaryPer()) * 100);   //转换为百分比
            data.setMiddlelv(Double.valueOf(totalAmountItemData.getMiddlePer()) * 100);     //转换为百分比
            data.setHighlv(Double.valueOf(totalAmountItemData.getHighPer()) * 100);         //转换为百分比
            data.setChangliang(Double.valueOf(totalAmountItemData.getChangliang()) / 1000); //转换为t
            Datas.add(data);
        }

        ArrayList<String> x = new ArrayList<String>();
        ArrayList<BarEntry> y0 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> y1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> y2 = new ArrayList<BarEntry>();

        for (int i = 0; i < Datas.size(); i++) {
            x.add(Datas.get(i).getDate());
            y0.add(new BarEntry(Float.parseFloat(String.valueOf(Datas.get(i).getChangliang())), i));
        }

        //设置动画与适配器

        recyclerview1_mpchart.removeAllViews();
        chart_cl = new BarChart(getContext());

        chart_cl.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dp2px(_mActivity, 300)));
        setChart(chart_cl);
        setChartData(chart_cl, x, y0);
        recyclerview1_mpchart.addView(chart_cl);
        LinearLayout.LayoutParams lll = new LinearLayout.LayoutParams(ViewPager.LayoutParams.WRAP_CONTENT, 45);
        lll.weight = (float) 0.5; //设置宽度
        recyclerview1_title.removeAllViews();
        addViews(mParametersData.timeType, lll);
        addViews("产量(t)", lll);

        mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(nAdapter = new zongchanliangRecyclerviewAdapter(_mActivity, Datas));
        mLinearLayoutManager = new LinearLayoutManager(_mActivity);
        mRecyclerView1.setLayoutManager(mLinearLayoutManager);
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
//                mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView1.setAdapter(mScaleInAnimationAdapter);

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


    private void addViews(String string, LinearLayout.LayoutParams params) {

        //周期
        TextView txt = new TextView(getContext());
        txt.setText(string);
        txt.setTextColor(Color.rgb(255, 165, 0));
        txt.setTextSize(12);

        txt.setLayoutParams(params);
        recyclerview1_title.addView(txt);

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
    public void loadData(){
        String startTime = DateUtils.ChangeTimeToLong(mParametersData.startDateTime);
        String endTime = DateUtils.ChangeTimeToLong(mParametersData.endDateTime);
        equipmentID = mParametersData.equipmentID;
        userGroupId = mParametersData.userGroupID;
        timeType=mParametersData.timeType;

        options.put("shebeibianhao",equipmentID);
        options.put("userGroupId",userGroupId);
        options.put("startTime",startTime);
        options.put("endTime",endTime);
        options.put("leixing",timeType);

//        totalAmountListMoreData.clear();
        KLog.e(TAG,options.toString());

        totalAmountStatisticListData.clear();
        mPresenter.requestTotalAmount(options);

        KLog.e(TAG,"-----loadData-----");
    }


    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == Constants.TOTALAMOUNTSTATISTICFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.timeType = mParametersData.timeType;
                KLog.e("mParametersData:" + mParametersData.startDateTime);
                KLog.e("mParametersData:" + mParametersData.endDateTime);
                KLog.e("mParametersData:" + mParametersData.equipmentID);
                KLog.e("mParametersData:" + mParametersData.timeType);
                totalAmountStatisticListData.clear();
                if(mParametersData.timeType=="4"){
                    if(Math.abs(DateUtils.getDaySub(mParametersData.startDateTime, mParametersData.endDateTime)) > 7){
                        Toast.makeText(getContext(), "按日统计时请统计周期小于1周", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        mPtrFrameLayout.autoRefresh(true);
                    }
                }else{
                    mPtrFrameLayout.autoRefresh(true);
                }

            }
        }
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
    public void showContent() {

        mPageStateLayout.showContent();
    }

    @Override
    public void showError(Throwable t) {

        if (t instanceof ConnectException) {
            //   ToastUtils.showInfoToast(BaseApplication.mContext,"网络异常,请检测网络");
            ToastUtils.showToast(BaseApplication.mContext,"网络异常,请检测网络");
            //  messageTextView.setText("网络异常,请检测网络");
        } else if (t instanceof HttpException) {
            ToastUtils.showToast(BaseApplication.mContext,"服务器异常");
            //    messageTextView.setText("服务器异常，请重新下载");
        } else if (t instanceof SocketTimeoutException) {
            ToastUtils.showToast(BaseApplication.mContext,"连接超时");
            // messageTextView.setText("连接超时，请重新下载");
        } else if (t instanceof JSONException) {
            ToastUtils.showToast(BaseApplication.mContext,"解析异常");
            // messageTextView.setText("解析异常，请重新下载");
        } else {
            ToastUtils.showToast(BaseApplication.mContext,"数据异常");
            // messageTextView.setText("数据异常，请重新下载");
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

        mPageStateLayout.showEmpty();
    }


}
