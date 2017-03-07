package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.ZhenRuDuContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.ZhenRuDuData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public class ZhenRuDuPresenter extends BasePresenter<ZhenRuDuContract.View> implements ZhenRuDuContract.Presenter {

    private static final String TAG = ZhenRuDuPresenter.class.getSimpleName();


    public ZhenRuDuPresenter(ZhenRuDuContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {

    }


    @Override
    public void requestZhenRuDuData(String biaoduanid,String sbbh,String pagej,String startTime,String endTime,String isQualify) {

        HttpHelper.getInstance().initService().requestZhenRuDu(biaoduanid, sbbh, pagej, startTime, endTime, isQualify).enqueue(new Callback<ZhenRuDuData>() {
            @Override
            public void onResponse(Call<ZhenRuDuData> call, Response<ZhenRuDuData> response) {

            }
            @Override
            public void onFailure(Call<ZhenRuDuData> call, Throwable t) {

            }
        });
    }
}