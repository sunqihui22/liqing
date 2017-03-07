package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.ProductQueryContract;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

/**
 * Created by Administrator on 2016/11/24.
 */
public class ProductQueryPresenter extends BasePresenter<ProductQueryContract.View> implements ProductQueryContract.Presenter{


    public ProductQueryPresenter(ProductQueryContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {

    }
}
