package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.RuanHuaDianContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.RuanHuaDianData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public class RuanHuaDianPresenter extends BasePresenter<RuanHuaDianContract.View> implements RuanHuaDianContract.Presenter {

    private static final String TAG = RuanHuaDianPresenter.class.getSimpleName();


    public RuanHuaDianPresenter(RuanHuaDianContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {


    }


    @Override
    public void requestRuanHuaDianData(String biaoduanid,String sbbh,String pagej,String startTime,String endTime,String isQualify) {

        HttpHelper.getInstance().initService().requestRuanHuaDian( biaoduanid, sbbh, pagej, startTime, endTime, isQualify).enqueue(new Callback<RuanHuaDianData>() {
            @Override
            public void onResponse(Call<RuanHuaDianData> call, Response<RuanHuaDianData> response) {

            }

            @Override
            public void onFailure(Call<RuanHuaDianData> call, Throwable t) {

            }
        });
    }
}