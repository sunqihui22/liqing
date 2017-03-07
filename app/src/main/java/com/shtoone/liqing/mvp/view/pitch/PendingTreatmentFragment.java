package com.shtoone.liqing.mvp.view.pitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.pitch.PendingTreatmenContract;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.PendingTreatRVListData;
import com.shtoone.liqing.mvp.model.bean.PendingTreatResBean;
import com.shtoone.liqing.mvp.presenter.pitch.PendingTreatmentPresenter;
import com.shtoone.liqing.mvp.view.adapter.OnItemClickListener;
import com.shtoone.liqing.mvp.view.adapter.PendingTreatmentFragmentRVAdapter;
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
import me.yokeyword.fragmentation.SupportFragment;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Administrator on 2016/11/24.
 */
public class PendingTreatmentFragment extends BaseFragment<PendingTreatmenContract.Presenter> implements PendingTreatmenContract.View{

    private static final String TAG = PendingTreatmentFragment.class.getSimpleName();
    private RecyclerView recyclerview;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout ptrframelayout;
    private LinearLayoutManager mLinearLayoutManager;
    private Toolbar mToolbar;



    private int lastVisibleItemPosition;
    private boolean isLoading=false;

    private PendingTreatmentFragmentRVAdapter mAdapter;
    private ScaleInAnimationAdapter mScaleInAnimationAdapter;

    final Map<String, String> options = new HashMap<>();

    private String dengji;
    private String chuzhileixing;
    private int current_PageNo;
    private String current_shebeiNo;
    private String userGroupId;

    private PendingTreatResBean mPendingTreatBean;
    private FloatingActionButton fab;
    private ParametersData mParametersData;
    private boolean isRegistered = false;
    private RecyclerExceptionManager mRecyclerExceptionManager;
    private List<PendingTreatRVListData> pendingTreatLoadMoreList=new ArrayList<>();

    public static SupportFragment newInstance() {

        return new PendingTreatmentFragment();
    }

    @NonNull
    @Override
    protected PendingTreatmenContract.Presenter createPresenter() {
        return new PendingTreatmentPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
        View view=inflater.inflate(R.layout.fragment_pendingtreat,container,false);
        initView(view);
        initStateBar(mToolbar);
        initToolbarBackNavigation(mToolbar);
        setToolbarTitle();
//        mToolbar.setTitle(R.string.PendingTreatment);
        initData();
        KLog.e("---onCreateView---");
//        loadData(retPageNo());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //返回到看见此fragment时，fab显示
        fab.show();
    }

    private void initView(View view) {

        mPendingTreatBean=new PendingTreatResBean();
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.pagestatelayout);
        ptrframelayout = (PtrFrameLayout) view.findViewById(R.id.ptrframelayout);
        mToolbar= (Toolbar) view.findViewById(R.id.toolbar_toolbar);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        mLinearLayoutManager = new LinearLayoutManager(_mActivity);
//        recyclerview.setLayoutManager(mLinearLayoutManager);
        mRecyclerExceptionManager=new RecyclerExceptionManager(_mActivity, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(mRecyclerExceptionManager);
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(ptrframelayout);
    }


    private void initData() {

        mParametersData = (ParametersData) BaseApplication.parametersData.clone();
        mParametersData.userGroupID = BaseApplication.parametersData.userGroupID;
        mParametersData.fromTo = Constants.PENDINGTREATMENTFRAGMENT;
        KLog.e(TAG,mParametersData.toString());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KLog.e(TAG,mParametersData.toString());
                ((PitchDetailActivity) _mActivity).startDrawerActivity(mParametersData,null);
            }
        });

        KLog.e(TAG,mParametersData.handleType);
        mAdapter = new PendingTreatmentFragmentRVAdapter(_mActivity, pendingTreatLoadMoreList);
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter);
        mSlideInLeftAnimationAdapter.setDuration(500);

        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(0.5f));
        mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        recyclerview.setAdapter(mScaleInAnimationAdapter);
        KLog.e("---initData---");

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                KLog.e(TAG,"onitemclick000000000");
                // 实现局部界面刷新, 这个view就是被点击的item布局对象
//                changeReadedState(view);
                jump2PendingTreatDetailActivity(pendingTreatLoadMoreList,position);
            }
        });


        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                int totalItemCount = mLinearLayoutManager.getItemCount();
                //还有一个不完美的地方就是当规定的item个数时，最后一个item在屏幕外滑到可见时，其底部没有footview，这点以后再解决。
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition== mAdapter.getItemCount()-1&&mAdapter.getItemCount()>=Constants.PEND_SIZE){

                    if (!isLoading) {
                        isLoading = true;
                        recyclerview.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                KLog.e("第" + mParametersData.currentPage + "页");
                                ++current_PageNo;
                                mParametersData.currentPage=current_PageNo+"";
                                loadMoreData(current_PageNo);
                                KLog.e("上拉加载更多mParametersData.currentPage=" + mParametersData.currentPage);
                                isLoading = false;
                            }
                        }, 500);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();
                lastVisibleItemPosition=mRecyclerExceptionManager.findLastVisibleItemPosition();

                if (dy > 5) {
                    BaseApplication.bus.post(new EventData(Constants.PENDINGTREATMENTHIDE));
                } else if (dy < -5) {
                    BaseApplication.bus.post(new EventData(Constants.PENDINGTREATMENTSHOW));
                }
            }
        });

    }



    @Override
    public void responsePendingTreatData(final List<PendingTreatRVListData> pendingTreatDataList) {

        //mAdapter的实例化要放到最开始，因为在没有数据的时候，滑动会空指针异常，因为  if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == mAdapter.getItemCount()) {
        KLog.e("---responsePendingTreatData--pre--");
        pendingTreatLoadMoreList.addAll(pendingTreatDataList);
        mAdapter.notifyDataSetChanged();

        KLog.e(TAG,pendingTreatLoadMoreList.toString());
        KLog.e(TAG,pendingTreatLoadMoreList.size());

    }


    public void loadMoreData(int current_PageNo){

        String startTime=mParametersData.startDateTime;
        String endTime=mParametersData.endDateTime;
        dengji=mParametersData.alarmLevel;
        chuzhileixing=mParametersData.handleType;
        this.current_PageNo = current_PageNo;
        current_shebeiNo=mParametersData.equipmentID;
        userGroupId=mParametersData.userGroupID;

        options.put("dengji",dengji+"");
        options.put("chuzhileixing",chuzhileixing+"");
        options.put("pageNo",current_PageNo+"");
        options.put("current_shebeiNo",current_shebeiNo+"");
        options.put("userGroupId",userGroupId+"");
        options.put("startTime", DateUtils.ChangeTimeToLong(startTime)+"");
        options.put("endTime", DateUtils.ChangeTimeToLong(endTime)+"");
//        pendingTreatLoadMoreList.clear();
        mPresenter.getPendingTreatData(options);
        KLog.e(TAG,options.toString());

    }



    @Override
    public void loadData(){
        KLog.e("------loadData------");
        String startTime=mParametersData.startDateTime;
        String endTime=mParametersData.endDateTime;
        dengji=mParametersData.alarmLevel;
        chuzhileixing=mParametersData.handleType;
        current_PageNo = Constants.PAGE_SIZE;
        current_shebeiNo=mParametersData.equipmentID;
        userGroupId=mParametersData.userGroupID;

        options.put("dengji",dengji+"");
        options.put("chuzhileixing",chuzhileixing+"");
        options.put("pageNo",current_PageNo+"");
        options.put("current_shebeiNo",current_shebeiNo+"");
        options.put("userGroupId",userGroupId+"");
        options.put("startTime", DateUtils.ChangeTimeToLong(startTime)+"");
        options.put("endTime", DateUtils.ChangeTimeToLong(endTime)+"");
        pendingTreatLoadMoreList.clear();
        mPresenter.getPendingTreatData(options);
        KLog.e(TAG,options.toString());
        //报空指针异常，为空
//                KLog.e("pendingTreatDataList="+pendingTreatDataList.toString());
    }

    @Subscribe
    public void updateSearch(ParametersData mParametersData){
        if (mParametersData != null) {
            if (mParametersData.fromTo == Constants.PENDINGTREATMENTFRAGMENT) {
                //这里不能用克隆，因为会重置掉dengji这个参数
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.handleType = mParametersData.handleType;
                this.mParametersData.alarmLevel=mParametersData.alarmLevel;
                KLog.e("mParametersData:" + mParametersData.startDateTime);
                KLog.e("mParametersData:" + mParametersData.endDateTime);
                KLog.e("mParametersData:" + mParametersData.equipmentID);
                KLog.e("mParametersData:" + mParametersData.handleType);
                KLog.e("mParametersData:" + mParametersData.alarmLevel);
                pendingTreatLoadMoreList.clear();
                ptrframelayout.autoRefresh(true);
            }
        }
    }


    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mPageStateLayout.isShowContent) {
            //判断RecyclerView是否在在顶部，在顶部则允许滑动下拉刷新
            if (null != recyclerview) {
                if (recyclerview.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager lm = (LinearLayoutManager) recyclerview.getLayoutManager();
                    int position = lm.findFirstVisibleItemPosition();
                    if (position >= 0) {
                        if (lm.findViewByPosition(position).getTop() > 0 && position == 0) {
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

    private int retPageNo(){
        current_PageNo = 1;
        return current_PageNo;
    }

    @Override
    public void onPause() {
        super.onPause();
        //防止屏幕旋转后重画时fab显示
        fab.hide();
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

    public void jump2PendingTreatDetailActivity(List<PendingTreatRVListData> pendingTreatDataList,int position){
        PendingTreatRVListData pendingTreatRVListData = pendingTreatDataList.get(position);
        Intent intent = new Intent(_mActivity, PendingTreatDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("pendingtreatdetail", pendingTreatRVListData);
        intent.putExtras(bundle);
        startActivity(intent);

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
            recyclerview.smoothScrollToPosition(0);
        }
    }

    @Subscribe
    public void handleRefresh(EventData event) {
        if (event.position == Constants.REFRESH) {
            ptrframelayout.autoRefresh(true);
        }
    }

    @Subscribe
    public void hideOrShowFab(EventData event) {
        if (event.position == Constants.PENDINGTREATMENTHIDE) {
            fab.hide();
        } else if (event.position == Constants.PENDINGTREATMENTSHOW) {
            fab.show();
        }
    }


    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.liqing) + " > ");
            sb.append(getString(R.string.PendingTreatment)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}
