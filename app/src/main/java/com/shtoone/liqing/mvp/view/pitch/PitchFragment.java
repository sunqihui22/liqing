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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.pitch.PitchContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentResponse;
import com.shtoone.liqing.mvp.model.bean.PitchfragmentResDataBean;
import com.shtoone.liqing.mvp.presenter.pitch.PitchPresenter;
import com.shtoone.liqing.mvp.view.adapter.OnItemClickListener;
import com.shtoone.liqing.mvp.view.adapter.PitchFragmentRecyclerViewAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.others.MainActivity;
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
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Administrator on 2016/11/17.
 */
public class PitchFragment extends BaseFragment<PitchContract.Presenter> implements PitchContract.View{

    private static final String TAG = "PitchFragment";

    private Toolbar mToolbar;
    private PtrFrameLayout mPtrFrameLayout;
    private PageStateLayout mPageStateLayout;

    private RecyclerView mRecyclerView;
//    private LinearLayoutManager mLinearLayoutManager;
    private int lastVisibleItemPosition;
    private boolean isLoading;
    private PitchFragmentRecyclerViewAdapter mAdapter;

    private ScaleInAnimationAdapter mScaleInAnimationAdapter;

    private FloatingActionButton fab;
    private ParametersData mParametersData;
    private DepartmentBean mDepartmentBean;
    private boolean isRegistered = false;

    private List<PitchFragmentResponse> pitchLoadList=new ArrayList<>();

    private RecyclerExceptionManager mRecyclerExceptionManager;

    private List<List<PitchfragmentResDataBean>> pitchFragmentResList=new ArrayList<>();



    @NonNull
    @Override
    protected PitchContract.Presenter createPresenter() {
        return new PitchPresenter(this);
    }

    public static PitchFragment newInstance() {
        return new PitchFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        KLog.e(TAG,"oncreateview");
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
        View view = inflater.inflate(R.layout.fragment_pitch, container, false);
        initView(view);
        initData();
//        loadData();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }


    private void initView(View view) {
        Log.d(TAG,"--initView--");
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_toolbar);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        mPageStateLayout = (PageStateLayout) view.findViewById(R.id.pagestatelayout);
        mPtrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptrframelayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        mRecyclerExceptionManager=new RecyclerExceptionManager(_mActivity, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mRecyclerExceptionManager);


//        mLinearLayoutManager = new LinearLayoutManager(_mActivity);
//        mRecyclerView.setLayoutManager(mLinearLayoutManager);


    }

    private void initData() {

        // 调用presenter中的方法获取数据
//        mPresenter.responseTotalProductData();

        if (null != BaseApplication.parametersData) {
            mParametersData = (ParametersData) BaseApplication.parametersData.clone();
            KLog.e(TAG,mParametersData.toString());
            mParametersData.fromTo = Constants.PITCHFRAGMENT;
        }
        if (null != BaseApplication.mUserInfoBean) {
            //mDepartmentBean = new DepartmentBean(BaseApplication.mUserInfoBean.getDepartId(), BaseApplication.mUserInfoBean.getDepartName(), Constants.PITCHFRAGMENT);
            mDepartmentBean = new DepartmentBean(BaseApplication.mUserInfoBean.getDepartId(), BaseApplication.mUserInfoBean.getUpdateDepartTime(),
                    Constants.PITCHFRAGMENT+"", BaseApplication.mUserInfoBean.getUserRole(), BaseApplication.mUserInfoBean.getDepartName());
            KLog.e(TAG,mDepartmentBean.toString());
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KLog.e(TAG,mParametersData.toString());
                mParametersData.getTo= Constants.PARAMETERSFRAGMENT;
                ((MainActivity) _mActivity).startDrawerActivity(mParametersData,null);
            }
        });

        mPageStateLayout.setPadding(0, 0, 0, DensityUtils.dp2px(_mActivity, 56));
        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);

        initToolbarMenu(mToolbar);
        initToolbarNavigationMenu(mToolbar);
        setToolbarTitle();

        Log.d(TAG,"--initData--");

        Log.d(TAG, "--responseTotalProductData--");

        KLog.e(TAG,pitchLoadList.toString());
        //mAdapter的实例化要放到最开始，因为在没有数据的时候，滑动会空指针异常，因为  if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == mAdapter.getItemCount()) {
        mAdapter = new PitchFragmentRecyclerViewAdapter(_mActivity, pitchFragmentResList);
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(0.5f));
        mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(_mActivity, PitchDetailActivity.class));
            }
        });
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


    public void responseTotalProductData(List<List<PitchfragmentResDataBean>> pitchFragmentResponseList) {

        KLog.e(TAG,pitchFragmentResList.toString());
        pitchFragmentResList.addAll(pitchFragmentResponseList);
        mAdapter.notifyDataSetChanged();
        KLog.e("--------",pitchFragmentResList.toString());


    }


    @Subscribe
    public void updateSearch(ParametersData mParametersData) {

        if (mParametersData != null) {
            if (mParametersData.fromTo == Constants.PITCHFRAGMENT) {
                fab.show();
                this.mParametersData = mParametersData;
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }

    @Subscribe
    public void updateDepartment(DepartmentBean mDepartmentBean) {
        if (null != mDepartmentBean && null != mParametersData && null != this.mDepartmentBean) {
            if (mDepartmentBean.fromto == Constants.PITCHFRAGMENT) {
                this.mParametersData.userGroupID = mDepartmentBean.departmentID;
                this.mDepartmentBean.departmentID = mDepartmentBean.departmentID;
                this.mDepartmentBean.departmentName = mDepartmentBean.departmentName;
                pitchFragmentResList.clear();
                mPtrFrameLayout.autoRefresh(true);
            }
        }
    }




    public void loadData(){
        String userGroupId=mParametersData.userGroupID;
        String startTime=DateUtils.ChangeTimeToLong(mParametersData.startDateTime);
        String endTime= DateUtils.ChangeTimeToLong(mParametersData.endDateTime);
        pitchFragmentResList.clear();
        mPresenter.requestTotalProductData(userGroupId,startTime,endTime);
        KLog.e(TAG,"---loadData---");

//

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
                        ((MainActivity) _mActivity).startDrawerActivity(null,mDepartmentBean);
                        KLog.e("---initToolbar---");
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        //返回到看见此fragment时，fab显示
        fab.show();
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


    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.liqing) + " > ");
            mToolbar.setTitle(sb.toString());
        }
    }
}
