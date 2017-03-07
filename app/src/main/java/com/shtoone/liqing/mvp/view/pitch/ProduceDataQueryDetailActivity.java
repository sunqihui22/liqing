package com.shtoone.liqing.mvp.view.pitch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.pitch.ProduceDataQueryDetailContract;
import com.shtoone.liqing.mvp.model.bean.ProduceDataDetailRes;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryResData;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq;
import com.shtoone.liqing.mvp.presenter.pitch.ProduceDataQueryDetailPresenter;
import com.shtoone.liqing.mvp.view.adapter.ProduceDataQueryDetailActivityRecyclerViewAdapter;
import com.shtoone.liqing.mvp.view.base.BaseActivity;
import com.shtoone.liqing.widget.PageStateLayout;
import com.socks.library.KLog;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;


/**
 * Created by Administrator on 2016/12/14.
 */
public class ProduceDataQueryDetailActivity extends BaseActivity<ProduceDataQueryDetailContract.Presenter> implements ProduceDataQueryDetailContract.View{

    private static final String TAG = ProduceDataQueryDetailActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private TextView tv_date;
    private TextView tv_sjysb ;
    private TextView tv_llysb;
    private TextView tv_wcysb;
    private TextView tv_lqwd;
    private TextView tv_slwd;
    private TextView tv_clwd;
    private int bianhao;
    private String shebeibianhao;
    private RecyclerView mRecyclerView;
    SC_chaxunItem_xq xqData = null;
    private ProduceDataQueryDetailActivityRecyclerViewAdapter mAdapter;
    private ProduceDataQueryResData produceDataQueryResData;

    @NonNull
    @Override
    protected ProduceDataQueryDetailContract.Presenter createPresenter() {
        return new ProduceDataQueryDetailPresenter(this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pitch_produce_query_detail);
        initView();
        initData();
        loadData();
    }



    private void initView() {
        KLog.e("---initView---");
        mToolbar = (Toolbar)findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_produce_query_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_produce_query_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_produce_query_detail_activity);
        tv_date = (TextView) this.findViewById(R.id.scchaxun_xq_date);
        tv_sjysb = (TextView) this.findViewById(R.id.scchaxun_xq_sjysb);
        tv_llysb = (TextView) this.findViewById(R.id.scchaxun_xq_llysb);
        tv_wcysb = (TextView) this.findViewById(R.id.scchaxun_xq_wcysb);
        tv_lqwd = (TextView) this.findViewById(R.id.scchaxun_xq_liqinwendu);
        tv_slwd = (TextView) this.findViewById(R.id.scchaxun_xq_shiliaowendu);
        tv_clwd = (TextView) this.findViewById(R.id.scchaxun_xq_chuliaowendu);
        mRecyclerView = (RecyclerView)this.findViewById(R.id.rv_produce_query_detail_activity);
    }

    private void initData() {

        produceDataQueryResData = (ProduceDataQueryResData) getIntent().getSerializableExtra("liqingdetail");
        bianhao= produceDataQueryResData.getBianhao();
        shebeibianhao=produceDataQueryResData.getShebeibianhao();
        xqData=new SC_chaxunItem_xq();
        initStateBar(mToolbar);
        initToolbarBackNavigation(mToolbar);
        setToolbarTitle();
//        mToolbar.setTitle(R.string.produce_data_detail);
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
        KLog.e("---initData---");

    }

    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mNestedScrollView.getScrollY() == 0) {
            return true;
        }
        return false;
    }


    public void responseProduceDataDetail(SC_chaxunItem_xq xqData,ProduceDataDetailRes produceDataDetailRes) {
        KLog.e("---responseProduceDataDetail---pre---");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置动画与适配器
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new ProduceDataQueryDetailActivityRecyclerViewAdapter(this, xqData.getLists()));
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
        setViewData(produceDataDetailRes);
        KLog.e("---responseProduceDataDetail---next---");
    }


    public void loadData() {
        KLog.e("---loadData---");
//        String shebeibianhao="G345lq0101";
//        String bianhao="15643";
        mPresenter.getProduceDataDetail(shebeibianhao,bianhao+"");
    }

    private  void setViewData(ProduceDataDetailRes produceDataDetailRes) {
        // 设置显示数据
        tv_date.setText(produceDataDetailRes.getData().getShijian());//
        tv_sjysb.setText(produceDataDetailRes.getData().getSjysb()+"%");//
        tv_llysb.setText(produceDataDetailRes.getData().getLlysb()+"%");//
        tv_wcysb.setText(produceDataDetailRes.getData().getSjysb()+"%");//
        tv_lqwd.setText(produceDataDetailRes.getData().getLqwd()+"℃");//
        tv_slwd.setText(produceDataDetailRes.getData().getGlwd()+"℃");//
        tv_clwd.setText(produceDataDetailRes.getData().getClwd()+"℃");//
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
            sb.append(getString(R.string.produce_data_detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }

}
