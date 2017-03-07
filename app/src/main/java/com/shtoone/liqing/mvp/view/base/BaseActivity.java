package com.shtoone.liqing.mvp.view.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.utils.ActivityManagerUtils;
import com.shtoone.liqing.utils.DisplayUtils;
import com.shtoone.liqing.utils.NetworkUtils;
import com.shtoone.liqing.utils.ScreenUtils;
import com.shtoone.liqing.widget.PageStateLayout;
import com.socks.library.KLog;
import com.umeng.analytics.MobclickAgent;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public abstract class BaseActivity<P extends BaseContract.Presenter> extends SwipeBackActivity {

    public P mPresenter;

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
        netWorkTips();
        mPresenter=createPresenter();
    }

    protected abstract P createPresenter();

    private void initActivity() {
        //把每一个Activity加入栈中
        ActivityManagerUtils.getInstance().addActivity(this);

        //一旦启动某个Activity就打印Log，方便找到该类
//        KLog.e(getClass().getName());

        //左侧滑动退出设置
        getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_LEFT);
    }

    private void netWorkTips() {
        if (!NetworkUtils.isConnected(getApplicationContext())) {
            View view = getWindow().getDecorView();
            Snackbar mSnackbar = Snackbar.make(view, "当前网络已断开！", Snackbar.LENGTH_LONG)
                    .setAction("设置网络", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // 跳转到系统的网络设置界面
                            NetworkUtils.openSetting(BaseActivity.this);
                        }
                    });
            View v = mSnackbar.getView();
            v.setBackgroundColor(Color.parseColor("#FFCC00"));
            mSnackbar.show();
        }
        if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    //侧滑退出activity
    @Override
    public boolean swipeBackPriority() {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {

            mPresenter.detachView();
            mPresenter = null;
        }
        //把每一个Activity弹出栈
        ActivityManagerUtils.getInstance().removeActivity(this);
        super.onDestroy();
    }

    @Override
    protected FragmentAnimator onCreateFragmentAnimator() {
//        return new FragmentAnimator(0, 0, 0, 0);
        return new FragmentAnimator(android.R.anim.fade_in, android.R.anim.fade_out, 0, 0);
    }

    public void initPageStateLayout(final PageStateLayout mPageStateLayout) {
        if (null == mPageStateLayout) return;

        mPageStateLayout.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPageStateLayout.showLoading();
                //刷新
 //               refresh();
            }
        });

        mPageStateLayout.setOnNetErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPageStateLayout.showEmpty();
                NetworkUtils.openSetting(BaseActivity.this);
            }
        });
    }

    public void initPtrFrameLayout(final PtrFrameLayout mPtrFrameLayout) {
        if (null == mPtrFrameLayout) return;

        // 下拉刷新头部
        final StoreHouseHeader ptrHeader = new StoreHouseHeader(this);
        final String[] mStringList = {Constants.DOMAIN_1, Constants.DOMAIN_2};
        ptrHeader.setTextColor(Color.BLACK);
        ptrHeader.setPadding(0, DisplayUtils.dp2px(15), 0, 0);
        ptrHeader.initWithString(mStringList[0]);
        mPtrFrameLayout.addPtrUIHandler(new PtrUIHandler() {
            private int mLoadTime = 0;

            @Override
            public void onUIReset(PtrFrameLayout frame) {
                mLoadTime++;
                String string = mStringList[mLoadTime % mStringList.length];
                ptrHeader.initWithString(string);
            }

            @Override
            public void onUIRefreshPrepare(PtrFrameLayout frame) {
                String string = mStringList[mLoadTime % mStringList.length];
            }

            @Override
            public void onUIRefreshBegin(PtrFrameLayout frame) {

            }

            @Override
            public void onUIRefreshComplete(PtrFrameLayout frame) {

            }

            @Override
            public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

            }
        });
        mPtrFrameLayout.setHeaderView(ptrHeader);
        mPtrFrameLayout.addPtrUIHandler(ptrHeader);
        mPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrameLayout.autoRefresh(true);
            }
        }, 100);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return isCanDoRefresh();

            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                //刷新
 //               refresh();
                frame.refreshComplete();
            }
        });
    }

    public void initStateBar(View view) {
        KLog.e(ScreenUtils.getStatusBarHeight(BaseApplication.mContext));
        view.setPadding(view.getPaddingLeft(),
                view.getPaddingTop() + ScreenUtils.getStatusBarHeight(BaseApplication.mContext),
                view.getPaddingRight(), view.getPaddingBottom());
    }

    protected void initToolbarBackNavigation(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();

            }
        });
    }


    public boolean isCanDoRefresh() {
        return true;
    }
}
