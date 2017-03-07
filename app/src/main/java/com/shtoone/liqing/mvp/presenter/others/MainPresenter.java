package com.shtoone.liqing.mvp.presenter.others;

import com.shtoone.liqing.mvp.contract.others.MainContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;


/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();


    public MainPresenter(MainContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {

    }



}
