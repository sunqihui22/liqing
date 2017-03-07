package com.shtoone.liqing.mvp.view.laboratory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.laboratory.LaboratoryContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.LaboratoryData;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.presenter.laboratory.LaboratoryPresenter;
import com.shtoone.liqing.mvp.view.adapter.LaboratoryFragmentRecyclerViewAdapter;
import com.shtoone.liqing.mvp.view.adapter.OnItemClickListener;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.others.MainActivity;
import com.shtoone.liqing.mvp.view.others.MainFragment;
import com.shtoone.liqing.utils.ToastUtils;
import com.shtoone.liqing.widget.PageStateLayout;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

/**
 * Created by Administrator on 2016/11/17.
 */
public class LaboratoryFragment extends BaseFragment<LaboratoryContract.Presenter> implements LaboratoryContract.View {
    private String TAG = LaboratoryFragment.class.getSimpleName();
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.pagestatelayout)
    PageStateLayout pagestatelayout;
    @BindView(R.id.ptrframelayout)
    PtrFrameLayout ptrframelayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;
    private ParametersData mparametersData;
    private DepartmentBean mdepartmentData;
    private LaboratoryData mData;

    private LinearLayoutManager mlinearLayoutManager;
    private LaboratoryFragmentRecyclerViewAdapter mAdapter;

    @NonNull
    @Override
    protected LaboratoryContract.Presenter createPresenter() {
        return new LaboratoryPresenter(this);
    }

    public static LaboratoryFragment newInstance() {
        return new LaboratoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laboratory, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        setAdapter();
        return view;
    }

    private void initData() {
        mparametersData = (ParametersData) BaseApplication.parametersData.clone();
        mparametersData.fromTo = Constants.LABORATORYFRAGMENT;
        if (BaseApplication.mUserInfoBean!=null) {
            mdepartmentData = new DepartmentBean(BaseApplication.mUserInfoBean.getDepartId(), BaseApplication.mUserInfoBean.getUpdateDepartTime(),
                    Constants.SHIYANSHI, BaseApplication.mUserInfoBean.getUserRole(), BaseApplication.mUserInfoBean.getDepartName());
        }
    }

    private void initView() {
        initToolbarMenu(toolbarToolbar);
        initToolbarNavigationMenu(toolbarToolbar);

    }

    private void setAdapter() {
        // 设置显示形式
        recyclerview.setLayoutManager(new LinearLayoutManager(_mActivity));
        //设置动画
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new LaboratoryFragmentRecyclerViewAdapter(_mActivity, mData));
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        recyclerview.setAdapter(mScaleInAnimationAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                // 实现局部界面刷新, 这个view就是被点击的item布局对象
                ((MainFragment) getParentFragment()).start(LaboratoryFragmentTwo.newInstance());

                _mActivity.logFragmentStackHierarchy("11111");
            }
        });
    }

    @Override
    public void responseLaboratoryData(LaboratoryData mLaboratoryData) {
        List<LaboratoryData.DataEntity> lists = mLaboratoryData.getData();
        String MXETongJi = lists.get(0).getMXETongJi();
        String RHDTongJi = lists.get(0).getRHDTongJi();
        String ZRDTongJi = lists.get(0).getZRDTongJi();
        String YDTongJi = lists.get(0).getYDTongJi();
    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable t) {


//        ViewGroup viewGroup = (ViewGroup) _mActivity.findViewById(android.R.id.content).getRootView();
//        TSnackbar snackBar = TSnackbar.make(viewGroup, "网络访问失败", TSnackbar.LENGTH_SHORT, TSnackbar.APPEAR_FROM_TOP_TO_DOWN);
//        snackBar.show();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }


    @OnClick(R.id.fab)
    public void onClick() {
        KLog.e("11111111111111111111");
      //((MainActivity) _mActivity).showPopuwindow(fab,new ParametersController(BaseApplication.mContext,mparametersData));
        mparametersData.getTo= Constants.PARAMETERSFRAGMENT;
        ((MainActivity) _mActivity).startDrawerActivity(mparametersData,null);
    }

    protected void initToolbarMenu(final Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.menu_hierarchy);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:
                        ((MainActivity) _mActivity).startDrawerActivity(null,mdepartmentData);
                        break;
                }
                return true;
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void subscribeAndRefresh(EventData event) {
        KLog.e(TAG + ";" + "接收eventdata");
        if (event.parametersBean!=null&&event.parametersBean.fromTo == Constants.LABORATORYFRAGMENT) {
            ToastUtils.showToast(BaseApplication.mContext, TAG+":"+"parametersBean");
        }
        if (event.departmentData!=null&&event.departmentData.funtype.equals(Constants.SHIYANSHI)) {
            ToastUtils.showToast(BaseApplication.mContext, TAG+":"+"mdepartmentData");
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
