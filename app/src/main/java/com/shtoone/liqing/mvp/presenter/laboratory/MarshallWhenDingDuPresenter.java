package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.MarshallWhenDingDuContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.MarshallWhenDingDuData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public class MarshallWhenDingDuPresenter extends BasePresenter<MarshallWhenDingDuContract.View> implements MarshallWhenDingDuContract.Presenter {

    private static final String TAG = MarshallWhenDingDuPresenter.class.getSimpleName();


    public MarshallWhenDingDuPresenter(MarshallWhenDingDuContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {

    }

    @Override
    public void requestMarshallWhenDingDuData(String biaoduanid,String sbbh,String pagej,String startTime,String endTime,String isQualify) {

        HttpHelper.getInstance().initService().requestMarshall(biaoduanid,sbbh,pagej,startTime,endTime,isQualify).enqueue(new Callback<MarshallWhenDingDuData>() {
            @Override
            public void onResponse(Call<MarshallWhenDingDuData> call, Response<MarshallWhenDingDuData> response) {

            }

            @Override
            public void onFailure(Call<MarshallWhenDingDuData> call, Throwable t) {

            }
        });
    }
}