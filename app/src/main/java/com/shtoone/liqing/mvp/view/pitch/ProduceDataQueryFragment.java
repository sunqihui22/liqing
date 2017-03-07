package com.shtoone.liqing.mvp.view.pitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.pitch.ProduceDataQueryContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryResData;
import com.shtoone.liqing.mvp.presenter.pitch.ProduceDataQueryPresenter;
import com.shtoone.liqing.mvp.view.adapter.OnItemClickListener;
import com.shtoone.liqing.mvp.view.adapter.ProduceDataQueryFragmentRVAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.DateUtils;
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
public class ProduceDataQueryFragment extends BaseFragment<ProduceDataQueryContract.Presenter> implements ProduceDataQueryContract.View{


    private static final String TAG = ProduceDataQueryFragment.class.getSimpleName();
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private RecyclerView mRecyclerView;
    private ParametersData mParametersData;
    private boolean isRegistered = false;
//    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerExceptionManager mRecyclerExceptionManager;
    private ScaleInAnimationAdapter mScaleInAnimationAdapter;
    private SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter;

    private ProduceDataQueryFragmentRVAdapter mAdapter;
    private List<ProduceDataQueryResData> listData;

    private int lastVisibleItemPosition;
    private boolean isLoading;
    private int pageNo;
    String userGroupId;
    String equipmentID;

    int maxPageItems=15;

    final Map<String, String> options = new HashMap<>();
    private List<ProduceDataQueryResData> produceDataQueryResListData=new ArrayList<>();

    @NonNull
    @Override
    protected ProduceDataQueryContract.Presenter createPresenter() {
        return new ProduceDataQueryPresenter(this);
    }


    public static ProduceDataQueryFragment newInstance(ParametersData mParametersData) {
        Bundle args = new Bundle();
        args.putSerializable(Constants.PARAMETERS, mParametersData);
        ProduceDataQueryFragment fragment = new ProduceDataQueryFragment();
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

        View view = inflater.inflate(R.layout.recyclerview, container, false);
        initView(view);
        initData();
//        loadData();
        return view;
    }


    private void initView(View view) {
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptrframelayout);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.pagestatelayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
    }


    private void initData() {

        listData = new ArrayList<>();
//        mLinearLayoutManager = new LinearLayoutManager(_mActivity);
//        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        mRecyclerExceptionManager=new RecyclerExceptionManager(_mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mRecyclerExceptionManager);
        //设置动画与适配器
        mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new ProduceDataQueryFragmentRVAdapter(_mActivity, produceDataQueryResListData));
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // 实现局部界面刷新, 这个view就是被点击的item布局对象

                //  跳转到生产数据详情页
//                jumpToLiQingDetailActivity(position);
                Intent intent = new Intent(_mActivity, ProduceDataQueryDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("liqingdetail", produceDataQueryResListData.get(position));
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //还有一个不完美的地方就是当规定的item个数时，最后一个item在屏幕外滑到可见时，其底部没有footview，这点以后再解决。
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == mAdapter.getItemCount()) {

                   // 用于加载更多
                    if (!isLoading) {
                        isLoading = true;
                        mRecyclerView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                KLog.e("第" + mParametersData.currentPage + "页");
                                //用于加载更多
                                ++pageNo;
                                mParametersData.currentPage=pageNo+"";
                                loadMoreData(pageNo);
                                KLog.e("上拉加载更多下一页=" + mParametersData.currentPage);
                                isLoading = false;
                            }
                        }, 500);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = mRecyclerExceptionManager.findLastVisibleItemPosition();

                if (dy > 5) {
                    BaseApplication.bus.post(new EventData(Constants.PRODUCTQUERYHIDE));
                } else if (dy < -5) {
                    BaseApplication.bus.post(new EventData(Constants.PRODUCTQUERYSHOW));
                }
            }
        });

        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }


    public void responseProduceData(List<ProduceDataQueryResData> produceDataQueryResData) {

        produceDataQueryResListData.addAll(produceDataQueryResData);
        mAdapter.notifyDataSetChanged();
    }

    public void loadMoreData(int pageNo){
        String startTime= DateUtils.ChangeTimeToLong(mParametersData.startDateTime);
        String endTime= DateUtils.ChangeTimeToLong(mParametersData.endDateTime);

        userGroupId = mParametersData.userGroupID;
        this.pageNo = pageNo;
        equipmentID = mParametersData.equipmentID;


        options.put("pageNo",pageNo+"");
        options.put("userGroupId",userGroupId);
        options.put("shebeibianhao",equipmentID);
        options.put("startTime",startTime);
        options.put("endTime",endTime);
        options.put("maxPageItems",maxPageItems+"");

        KLog.e(TAG,"---loadData---pre---");
//        produceDataQueryResListData.clear();
        mPresenter.requestProduceData(options);

        KLog.e(TAG,"---loadData---next---");
    }


    @Override
    public void loadData(){

        String startTime= DateUtils.ChangeTimeToLong(mParametersData.startDateTime);
        String endTime= DateUtils.ChangeTimeToLong(mParametersData.endDateTime);

        userGroupId = mParametersData.userGroupID;
        pageNo = Constants.PAGE_SIZE;
        equipmentID = mParametersData.equipmentID;


        options.put("pageNo",pageNo+"");
        options.put("userGroupId",userGroupId);
        options.put("shebeibianhao",equipmentID);
        options.put("startTime",startTime);
        options.put("endTime",endTime);
        options.put("maxPageItems",maxPageItems+"");

        KLog.e(TAG,options.toString());
        produceDataQueryResListData.clear();
        mPresenter.requestProduceData(options);



    }


    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mPageStateLayout.isShowContent) {
            //判断RecyclerView是否在在顶部，在顶部则允许滑动下拉刷新
            if (null != mRecyclerView) {
                if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager lm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    int position = lm.findFirstVisibleItemPosition();
                    if (position >= 0) {
                        if (lm.findViewByPosition(position).getTop() > 0 && position == 0 && BaseApplication.isExpand) {
                            return true;
                        }
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
                produceDataQueryResListData.clear();
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }

    @Subscribe
    public void go2TopOrRefresh(EventData event) {
        if (event.position == 0) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }

    @Subscribe
    public void handleRefresh(EventData event) {
        if (event.position == Constants.REFRESH) {
            mPtrFrameLayout.autoRefresh(true);
        }
    }



    private int retPageNo(){
        pageNo = 1;
        return pageNo;
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
        mPageStateLayout.showEmpty();;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.bus.unregister(this);
    }
}
