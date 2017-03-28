package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.mvp.contract.WaterStability.MaterialStatisticsContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.MaterialStatisticsData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.view.WaterStability.MaterialStatisticsFragment;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author: Administrator
 * @time 2017-03-15 09:24
 * @email 770164810@qq.com
 */

public class MaterialStatisticsPresenter extends BasePresenter<MaterialStatisticsFragment> implements MaterialStatisticsContract.Presenter{

    public MaterialStatisticsPresenter(MaterialStatisticsFragment mView) {
        super(mView);
    }

    @Override
    public void detachView() {

    }

    @Override
    public void start() {

    }

    @Override
    public void requestMaterialStatisticsData(final String departType, final String biaoshiid, final String startTime, final String endTime, final String shebeibianhao) {
        mRxManager.add(Observable.create(new Observable.OnSubscribe<MaterialStatisticsData>() {
            @Override
            public void call(final Subscriber<? super MaterialStatisticsData> subscriber) {

                HttpHelper.getInstance().initService().requestMaterialStatisticsData(departType, biaoshiid, startTime, endTime, shebeibianhao).enqueue(new Callback<MaterialStatisticsData>() {
                    @Override
                    public void onResponse(Call<MaterialStatisticsData> call, Response<MaterialStatisticsData> response) {
                        if (response.isSuccessful()) {
                            subscriber.onNext(response.body());
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new IOException());
                        }
                    }

                    @Override
                    public void onFailure(Call<MaterialStatisticsData> call, Throwable t) {

                        subscriber.onError(t);
                    }
                });

            }
        }).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MaterialStatisticsData>() {
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
                    public void onNext(MaterialStatisticsData waterStabilityData) {

                        getView().responseMaterialStatisticsData(waterStabilityData);
                    }
                }));

    }
}
