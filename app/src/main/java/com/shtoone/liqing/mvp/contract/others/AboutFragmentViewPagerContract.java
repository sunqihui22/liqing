package com.shtoone.liqing.mvp.contract.others;

import android.webkit.WebView;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.widget.PageStateLayout;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/11/22.
 */
public interface AboutFragmentViewPagerContract  {

    interface View extends BaseContract.View{
        boolean isCanDoRefresh();
        void refresh();
        boolean shouldOverrideUrlLoading(WebView view, String url);
        void initPageStateLayout(final PageStateLayout mPageStateLayout);
        void initPtrFrameLayout(final PtrFrameLayout mPtrFrameLayout);
    }

    interface Presenter extends BaseContract.Presenter{

        void refresh();
        String createRefreshULR();
    }
}
