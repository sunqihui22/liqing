package com.shtoone.liqing.mvp.view.pitch;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.pitch.TotalAmountContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.SC_zongchanliang;
import com.shtoone.liqing.mvp.model.bean.TotalAmountItemData;
import com.shtoone.liqing.mvp.presenter.pitch.TotalAmountPresenter;
import com.shtoone.liqing.mvp.view.adapter.shengchanchaobiaolvAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.DateUtils;
import com.shtoone.liqing.utils.DensityUtils;
import com.shtoone.liqing.utils.ToastUtils;
import com.shtoone.liqing.widget.PageStateLayout;
import com.shtoone.liqing.widget.ui.MyMarkerView;
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
public class ChaoBiaoLvFragment extends BaseFragment<TotalAmountContract.Presenter> implements TotalAmountContract.View{


    private static final String TAG = ChaoBiaoLvFragment.class.getSimpleName();
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
    private LineChart chart_wc;
    private shengchanchaobiaolvAdapter xAdapter;



    @NonNull
    @Override
    protected TotalAmountContract.Presenter createPresenter() {
        return new TotalAmountPresenter(this);
    }


    public static ChaoBiaoLvFragment newInstance(ParametersData mParametersData) {
        Bundle args = new Bundle();
        args.putSerializable(Constants.PARAMETERS, mParametersData);
        ChaoBiaoLvFragment fragment = new ChaoBiaoLvFragment();
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

        recyclerview1_mpchart.removeAllViews();
        chart_wc = new LineChart(getContext());
        chart_wc.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dp2px(_mActivity, 300)));
        setChart();
        setChartData();
        recyclerview1_mpchart.addView(chart_wc);
        LinearLayout.LayoutParams lll = new LinearLayout.LayoutParams(ViewPager.LayoutParams.WRAP_CONTENT, 45);
        lll.weight = (float) 0.5; //设置宽度
        recyclerview1_title.removeAllViews();
        addViews(mParametersData.timeType, lll);
        addViews("低超标(%)", lll);
        addViews("中超标(%)", lll);
        addViews("高超标(%)", lll);

        mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(xAdapter = new shengchanchaobiaolvAdapter(_mActivity, Datas));

        mLinearLayoutManager = new LinearLayoutManager(_mActivity);
        mRecyclerView1.setLayoutManager(mLinearLayoutManager);
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
//                mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView1.setAdapter(mScaleInAnimationAdapter);
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

        KLog.e(TAG,options.toString());
        totalAmountStatisticListData.clear();
        mPresenter.requestTotalAmount(options);

        KLog.e(TAG,"-----loadData-----");
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


    private void setChart() {

        chart_wc.setDescription("");
        chart_wc.setDrawGridBackground(true);
        chart_wc.setNoDataTextDescription("暂无数据表……");
        chart_wc.setTouchEnabled(true);
        chart_wc.setDragEnabled(true);
        chart_wc.setScaleEnabled(true);
        chart_wc.setPinchZoom(true);
        chart_wc.animateX(1500);
        chart_wc.getAxisRight().setEnabled(false);

        MyMarkerView mv = new MyMarkerView(_mActivity, R.layout.custom_marker_view);
        chart_wc.setMarkerView(mv);

        Typeface tf = Typeface.createFromAsset(_mActivity.getAssets(), "OpenSans-Light.ttf");
        Legend l = chart_wc.getLegend();
        l.setTypeface(tf);
        YAxis leftAxis = chart_wc.getAxisLeft();
        leftAxis.setTypeface(tf);
        leftAxis.setAxisMinValue(0f);
        leftAxis.removeAllLimitLines();
        leftAxis.setTypeface(tf);
        leftAxis.setTextColor(Color.RED);

        XAxis xAxis = chart_wc.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setTypeface(tf);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLUE);
    }

    private void setChartData() {
        ArrayList<String> xVals = new ArrayList<String>();
        //   String[] x = data.getX();
        for (int i = 0; i < Datas.size(); i++) {
            xVals.add(Datas.get(i).getDate());
        }

        ArrayList<Entry> yVals0 = new ArrayList<Entry>();

        for (int i = 0; i < Datas.size(); i++) {

            yVals0.add(new Entry(Float.parseFloat(Datas.get(i).getPrimarylv().toString()), i));
        }

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < Datas.size(); i++) {

            yVals1.add(new Entry(Float.parseFloat(Datas.get(i).getMiddlelv().toString()), i));
        }

        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        for (int i = 0; i < Datas.size(); i++) {

            yVals2.add(new Entry(Float.parseFloat(Datas.get(i).getHighlv().toString()), i));
        }

        LineDataSet mLineDataSet0 = new LineDataSet(yVals0, "低");
        LineDataSet mLineDataSet1 = new LineDataSet(yVals1, "中");
        LineDataSet mLineDataSet2 = new LineDataSet(yVals2, "高");

        if (Utils.getSDKInt() >= 18) {
            Drawable drawable0 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_red);
            Drawable drawable1 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_blue);
            Drawable drawable2 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_green);
            mLineDataSet0.setFillDrawable(drawable0);
            mLineDataSet1.setFillDrawable(drawable1);
            mLineDataSet2.setFillDrawable(drawable2);
        }
        //设置样式
        mLineDataSet0.enableDashedLine(10f, 5f, 0f);
        mLineDataSet0.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet0.setColor(Color.BLACK);
        mLineDataSet0.setCircleColor(Color.BLUE);
        mLineDataSet0.setLineWidth(1f);
        mLineDataSet0.setCircleRadius(0f);
        mLineDataSet0.setHighLightColor(Color.BLACK);
        mLineDataSet0.setDrawCircleHole(true);
        mLineDataSet0.setValueTextSize(7f);
        mLineDataSet0.setDrawFilled(true);

        mLineDataSet1.enableDashedLine(10f, 5f, 0f);
        mLineDataSet1.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet1.setColor(Color.YELLOW);
        mLineDataSet1.setCircleColor(Color.BLUE);
        mLineDataSet1.setLineWidth(1f);
        mLineDataSet1.setCircleRadius(0f);
        mLineDataSet1.setHighLightColor(Color.YELLOW);
        mLineDataSet1.setDrawCircleHole(true);
        mLineDataSet1.setValueTextSize(7f);
        mLineDataSet1.setDrawFilled(true);

        mLineDataSet2.enableDashedLine(10f, 5f, 0f);
        mLineDataSet2.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet2.setColor(Color.RED);
        mLineDataSet2.setCircleColor(Color.BLUE);
        mLineDataSet2.setLineWidth(1f);
        mLineDataSet2.setCircleRadius(0f);
        mLineDataSet2.setHighLightColor(Color.RED);
        mLineDataSet2.setDrawCircleHole(true);
        mLineDataSet2.setValueTextSize(7f);
        mLineDataSet2.setDrawFilled(true);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(mLineDataSet0);
        dataSets.add(mLineDataSet1);
        dataSets.add(mLineDataSet2);
        LineData data = new LineData(xVals, dataSets);
        chart_wc.setData(data);
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
