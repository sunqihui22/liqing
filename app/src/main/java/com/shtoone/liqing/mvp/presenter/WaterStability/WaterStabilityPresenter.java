package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.WaterStability.WaterStabilityContract;
import com.socks.library.KLog;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityPresenter extends BasePresenter<WaterStabilityContract.View> implements WaterStabilityContract.Presenter {

    public WaterStabilityPresenter(WaterStabilityContract.View mView) {
        super(mView);
    }

    @Override
    public void requestWaterStabilityData(final String departType, final String biaoduan, final String startTime, final String endTime, final String shebeibianhao) {


        mRxManager.add(Observable.create(new Observable.OnSubscribe<WaterStabilityData>() {
            @Override
            public void call(final Subscriber<? super WaterStabilityData> subscriber) {

                HttpHelper.getInstance().initService().requestWaterstabilityData(departType, biaoduan, startTime, endTime, shebeibianhao).enqueue(new Callback<WaterStabilityData>() {
                    @Override
                    public void onResponse(Call<WaterStabilityData> call, Response<WaterStabilityData> response) {
                        if (response.isSuccessful()) {
                            WaterStabilityData waterStabilityData = response.body();
                            if (waterStabilityData.isSuccess()) {
                                if (waterStabilityData.getData().size() > 0) {
                                    subscriber.onNext(waterStabilityData);
                                    subscriber.onCompleted();
                                } else {
                                    getView().showEmpty();
                                }
                            } else {
                                subscriber.onError(new IOException());
                            }
                        } else {
                            subscriber.onError(new IOException());
                        }
                    }

                    @Override
                    public void onFailure(Call<WaterStabilityData> call, Throwable t) {

                        subscriber.onError(t);
                    }
                });

            }
        }).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WaterStabilityData>() {
                    @Override
                    public void onCompleted() {

                        getView().showContent();
                    }

                    @Override
                    public void onError(Throwable e) {

                        getView().showError(e);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        getView().showLoading();
                    }

                    @Override
                    public void onNext(WaterStabilityData waterStabilityData) {

                        getView().responseWaterStabilityData(waterStabilityData);
                    }
                }));

    }

    @Override
    public void start() {

    }
}
