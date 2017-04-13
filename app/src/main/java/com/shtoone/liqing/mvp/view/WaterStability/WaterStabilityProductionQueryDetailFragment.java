package com.shtoone.liqing.mvp.view.WaterStability;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.WaterStability.WaterStabilityProductionQueryDetailContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityProductionQueryDetailData;
import com.shtoone.liqing.mvp.presenter.WaterStability.WaterStabilityProductionQueryDetailPresenter;
import com.shtoone.liqing.mvp.view.adapter.WaterStabilityAccountingTableAdapter;
import com.shtoone.liqing.mvp.view.adapter.WaterstabilityChartTableAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.DensityUtils;
import com.shtoone.liqing.utils.ToastUtils;
import com.shtoone.liqing.widget.PageStateLayout;
import com.shtoone.liqing.widget.ui.MyMarkerView;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrFrameLayout;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Author： hengzwd on 2017/3/21.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityProductionQueryDetailFragment extends BaseFragment<WaterStabilityProductionQueryDetailContract.Presenter> implements WaterStabilityProductionQueryDetailContract.View {


    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;
    @BindView(R.id.scchaxun_xq_date)
    TextView scchaxunXqDate;
    @BindView(R.id.scchaxun_xq_bhjname)
    TextView scchaxunXqBhjname;
    @BindView(R.id.scchaxun_xq_chuliaoshijian)
    TextView scchaxunXqChuliaoshijian;
    @BindView(R.id.scchaxun_xq_zcl)
    TextView scchaxunXqZcl;
    @BindView(R.id.shengchanchaxun_xq_container)
    LinearLayout shengchanchaxunXqContainer;
    @BindView(R.id.cv_produce_query_detail_fragment)
    CardView cvProduceQuery;
    @BindView(R.id.rv_produce_query_detail_fragment)
    RecyclerView rvProduceQuery;
    @BindView(R.id.nsv_produce_query_detail_fragment)
    NestedScrollView nsvProduceQuery;
    @BindView(R.id.psl_produce_query_detail_fragment)
    PageStateLayout pslProduceQuery;
    @BindView(R.id.ptr_produce_query_detail_fragment)
    PtrFrameLayout ptrProduceQuery;
    @BindView(R.id.rv_production_query_detail_fragment)
    RecyclerView rvProductionQuery;
    @BindView(R.id.lineChart_production_detail)
    LineChart lineChartProductionDetail;
    @BindView(R.id.recyclerview1_mpchart)
    LinearLayout recyclerview1Mpchart;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tv_linchart_head)
    TextView tvLinchartHead;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private WaterStabilityAccountingTableAdapter madapter;
    private WaterstabilityChartTableAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager layoutManager;
    private WaterStabilityProductionQueryDetailData.SwHeadEntity headEntity;
    private List<WaterStabilityProductionQueryDetailData.SwChartDataListEntity> chartDataListEntity;

    private DepartmentBean departmentBean;
    private ParametersData parametersData = new ParametersData();
    private int lastVisibleItemPosition;
    private boolean isLoading;


    public static WaterStabilityProductionQueryDetailFragment newInstance(DepartmentBean departmentBean) {

        WaterStabilityProductionQueryDetailFragment fragment = new WaterStabilityProductionQueryDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("depatmentdate", departmentBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_detail_waterstabilityproduction, container, false);
        ButterKnife.bind(this, view);
//        initStateBar(toolbarToolbar);
        setToolbarTitle();
        initToolbarBackNavigation(toolbarToolbar);
        initDate();
        return view;
    }


    private void initDate() {
        Bundle bundle = getArguments();
        departmentBean = (DepartmentBean) bundle.getSerializable("depatmentdate");
        madapter = new WaterStabilityAccountingTableAdapter();
        adapter = new WaterstabilityChartTableAdapter();
        pslProduceQuery.setPadding(0, 0, 0, DensityUtils.dp2px(_mActivity, 0));
        tvLinchartHead.setText(departmentBean.userpositon + "合成级配曲线图");
        initPageStateLayout(pslProduceQuery);
        initPtrFrameLayout(ptrProduceQuery);
        linearLayoutManager = new LinearLayoutManager(_mActivity);
        layoutManager = new LinearLayoutManager(_mActivity);
        rvProduceQuery.setLayoutManager(linearLayoutManager);
        rvProduceQuery.setAdapter(madapter);
        rvProductionQuery.setLayoutManager(layoutManager);
        rvProductionQuery.setAdapter(adapter);
    }


    @Override
    public void loadData() {
        super.loadData();
        Map<String, String> map = new HashMap<>();
        map.put("bianhao", departmentBean.bianhao);
        map.put("shebeibianhao", departmentBean.equipmentID);
        mPresenter.requestProductionQueryDetail(map);

    }


    private void setData2View(WaterStabilityProductionQueryDetailData.SwHeadEntity headEntity, List<WaterStabilityProductionQueryDetailData.SwChartDataListEntity> swjgEntity) {

        tvTitle.setText(headEntity.getBhjName());
        scchaxunXqBhjname.setText(headEntity.getBhjName());
        scchaxunXqChuliaoshijian.setText(headEntity.getChuliaoshijian());
        scchaxunXqDate.setText(headEntity.getBaocunshijian());
        scchaxunXqZcl.setText(headEntity.getZcl());
    }

    @Override
    public void showContent() {
        pslProduceQuery.showContent();
    }

    @Override
    public void showError(Throwable t) {
        if (t instanceof ConnectException) {
            ToastUtils.showToast(BaseApplication.mContext, "网络异常,请检测网络");
            pslProduceQuery.showNetError();
        } else if (t instanceof HttpException) {
            ToastUtils.showToast(BaseApplication.mContext, "服务器异常");
            pslProduceQuery.showError();
        } else if (t instanceof SocketTimeoutException) {
            ToastUtils.showToast(BaseApplication.mContext, "连接超时");
            pslProduceQuery.showError();
        } else if (t instanceof JSONException) {
            ToastUtils.showToast(BaseApplication.mContext, "解析异常");
            pslProduceQuery.showError();
        } else {
            ToastUtils.showToast(BaseApplication.mContext, "数据异常");
            pslProduceQuery.showError();
        }
    }

    @Override
    public void showLoading() {
        pslProduceQuery.showLoading();
    }

    @Override
    public void showEmpty() {
        pslProduceQuery.showEmpty();
    }


    private void setToolbarTitle() {
//        if (null != toolbarToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
        String toolBarName = getResources().getString(R.string.toolbar_name);
        StringBuffer sb = new StringBuffer( toolBarName+ " > ");
        sb.append(getString(R.string.waterstability) + " > ");
        toolbarToolbar.setTitle(sb.toString());
//        }

    }

    @NonNull
    @Override
    protected WaterStabilityProductionQueryDetailContract.Presenter createPresenter() {
        return new WaterStabilityProductionQueryDetailPresenter(this);
    }

    @Override
    public void responseProductionQueryDetail(WaterStabilityProductionQueryDetailData waterStabilityProductionQueryDetailData) {

        chartDataListEntity = waterStabilityProductionQueryDetailData.getSwChartDataList();
        headEntity = waterStabilityProductionQueryDetailData.getSwHead();
        setData2View(headEntity, chartDataListEntity);
        madapter.removeAllHeaderView();
        madapter.removeAllFooterView();
        madapter.setOverProofData(waterStabilityProductionQueryDetailData);
        madapter.notifyDataSetChanged();
        adapter.setOverProofData(waterStabilityProductionQueryDetailData);
        adapter.notifyDataSetChanged();

        setChart();
        setChartData();
    }


    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (pslProduceQuery.isShowContent) {
            //判断RecyclerView是否在在顶部，在顶部则允许滑动下拉刷新
            if (null != rvProduceQuery) {
                if (rvProduceQuery.getLayoutManager() instanceof LinearLayoutManager) {
                    if (nsvProduceQuery.getScrollY() == 0) {
                        return true;
                    }

                }
            } else {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    private void setChart() {

        lineChartProductionDetail.setDescription("");
        lineChartProductionDetail.setDrawGridBackground(true);
        lineChartProductionDetail.setNoDataTextDescription("暂无数据表……");
        lineChartProductionDetail.setTouchEnabled(true);
        lineChartProductionDetail.setDragEnabled(true);
        lineChartProductionDetail.setScaleEnabled(true);
        lineChartProductionDetail.setPinchZoom(true);
        lineChartProductionDetail.animateX(1500);
        lineChartProductionDetail.getAxisRight().setEnabled(false);
        MyMarkerView mv = new MyMarkerView(_mActivity, R.layout.custom_marker_view);
        lineChartProductionDetail.setMarkerView(mv);
        Typeface tf = Typeface.createFromAsset(_mActivity.getAssets(), "OpenSans-Light.ttf");

        YAxis leftAxis = lineChartProductionDetail.getAxisLeft();
        leftAxis.setTypeface(tf);
        leftAxis.setAxisMinValue(0f);
        leftAxis.removeAllLimitLines();
        leftAxis.setTypeface(tf);
        leftAxis.setTextColor(Color.RED);

        XAxis xAxis = lineChartProductionDetail.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setTypeface(tf);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLUE);
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setLabelRotationAngle(10f);


        Legend l = lineChartProductionDetail.getLegend();
        l.setTypeface(tf);
//        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setXEntrySpace(4f);
        l.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);//设置图例的位置
        l.setTextSize(11f);//设置文字大小
        l.setForm(Legend.LegendForm.CIRCLE);//正方形，圆形或线
        l.setFormSize(9f); // 设置Form的大小
        l.setWordWrapEnabled(true);//是否支持自动换行 目前只支持BelowChartLeft, BelowChartRight, BelowChartCenter
    }


    private void setChartData() {
        ArrayList<String> xVals = new ArrayList<String>();
        //   String[] x = data.getX();
        for (int i = 0; i < chartDataListEntity.size(); i++) {
            xVals.add(chartDataListEntity.get(i).getName());
        }

        ArrayList<Entry> yVals0 = new ArrayList<Entry>();

        for (int i = 0; i < chartDataListEntity.size(); i++) {

            yVals0.add(new Entry(Float.parseFloat(chartDataListEntity.get(i).getMaxPassper()), i));
        }

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < chartDataListEntity.size(); i++) {

            yVals1.add(new Entry(Float.parseFloat(chartDataListEntity.get(i).getMinPassper()), i));
        }

        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        for (int i = 0; i < chartDataListEntity.size(); i++) {

            yVals2.add(new Entry(Float.parseFloat(chartDataListEntity.get(i).getStandPassper()), i));
        }

        ArrayList<Entry> yVals3 = new ArrayList<Entry>();

        for (int i = 0; i < chartDataListEntity.size(); i++) {

            yVals3.add(new Entry(Float.parseFloat(chartDataListEntity.get(i).getPassper()), i));
        }

        ArrayList<Entry> yVals4 = new ArrayList<Entry>();

        for (int i = 0; i < chartDataListEntity.size(); i++) {

            yVals4.add(new Entry(Float.parseFloat(chartDataListEntity.get(i).getYjsx()), i));
        }

        ArrayList<Entry> yVals5 = new ArrayList<Entry>();

        for (int i = 0; i < chartDataListEntity.size(); i++) {

            yVals5.add(new Entry(Float.parseFloat(chartDataListEntity.get(i).getYjxx()), i));
        }

        LineDataSet mLineDataSet0 = new LineDataSet(yVals0, "允许波动上线");
        LineDataSet mLineDataSet1 = new LineDataSet(yVals1, "允许波动下线");
        LineDataSet mLineDataSet2 = new LineDataSet(yVals2, "标准级配");
        LineDataSet mLineDataSet3 = new LineDataSet(yVals3, "实际级配");
        LineDataSet mLineDataSet4 = new LineDataSet(yVals4, "预警上线");
        LineDataSet mLineDataSet5 = new LineDataSet(yVals5, "预警下线");

        if (Utils.getSDKInt() >= 18) {//设置
            Drawable drawable0 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_red);
            Drawable drawable1 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_blue);
            Drawable drawable2 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_green);
            Drawable drawable3 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_brown);
            Drawable drawable4 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_purple);
            Drawable drawable5 = ContextCompat.getDrawable(_mActivity, R.drawable.fade_yellow);
            mLineDataSet0.setFillDrawable(drawable0);
            mLineDataSet1.setFillDrawable(drawable1);
            mLineDataSet2.setFillDrawable(drawable2);
            mLineDataSet3.setFillDrawable(drawable3);
            mLineDataSet4.setFillDrawable(drawable4);
            mLineDataSet5.setFillDrawable(drawable5);

        }
        //设置样式
        mLineDataSet0.enableDashedLine(10f, 5f, 0f);
        mLineDataSet0.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet0.setColor(Color.RED);
        mLineDataSet0.setLineWidth(1f);
        mLineDataSet0.setCircleRadius(0f);
        mLineDataSet0.setDrawCircleHole(true);
        mLineDataSet0.setValueTextSize(7f);

        mLineDataSet1.enableDashedLine(10f, 5f, 0f);
        mLineDataSet1.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet1.setColor(Color.RED);
        mLineDataSet1.setLineWidth(1f);
        mLineDataSet1.setCircleRadius(0f);
        mLineDataSet1.setDrawCircleHole(true);
        mLineDataSet1.setValueTextSize(7f);

        mLineDataSet2.enableDashedLine(10f, 5f, 0f);
        mLineDataSet2.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet2.setColor(Color.GREEN);
        mLineDataSet2.setLineWidth(1f);
        mLineDataSet2.setCircleRadius(0f);
        mLineDataSet2.setDrawCircleHole(true);
        mLineDataSet2.setValueTextSize(7f);

        mLineDataSet3.enableDashedLine(10f, 5f, 0f);
        mLineDataSet3.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet3.setColor(Color.BLUE);
        mLineDataSet3.setLineWidth(1f);
        mLineDataSet3.setCircleRadius(0f);
        mLineDataSet3.setDrawCircleHole(true);
        mLineDataSet3.setValueTextSize(7f);

        mLineDataSet4.enableDashedLine(10f, 5f, 0f);
        mLineDataSet4.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet4.setColor(Color.YELLOW);
        mLineDataSet4.setLineWidth(1f);
        mLineDataSet4.setCircleRadius(0f);
        mLineDataSet4.setDrawCircleHole(true);
        mLineDataSet4.setValueTextSize(7f);

        mLineDataSet5.enableDashedLine(10f, 5f, 0f);
        mLineDataSet5.enableDashedHighlightLine(10f, 5f, 0f);
        mLineDataSet5.setColor(Color.YELLOW);
        mLineDataSet5.setLineWidth(1f);
        mLineDataSet5.setCircleRadius(0f);
        mLineDataSet5.setDrawCircleHole(true);
        mLineDataSet5.setValueTextSize(7f);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(mLineDataSet0);
        dataSets.add(mLineDataSet1);
        dataSets.add(mLineDataSet2);
        dataSets.add(mLineDataSet3);
        dataSets.add(mLineDataSet4);
        dataSets.add(mLineDataSet5);
        LineData data = new LineData(xVals, dataSets);
        lineChartProductionDetail.setData(data);
    }

}
