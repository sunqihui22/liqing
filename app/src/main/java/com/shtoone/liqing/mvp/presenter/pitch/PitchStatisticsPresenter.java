package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.MaterialStatisticsData;
import com.shtoone.liqing.mvp.model.bean.PitchStatisticsData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.pitch.PitchStatisticsContract;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchStatisticsPresenter extends BasePresenter<PitchStatisticsContract.View> implements PitchStatisticsContract.Presenter {
    public PitchStatisticsPresenter(PitchStatisticsContract.View mView) {
        super(mView);
    }

    @Override
    public void requestPitchStatisticsData(final Map<String, String> map) {
        mRxManager.add(Observable.create(new Observable.OnSubscribe<PitchStatisticsData>() {
            @Override
            public void call(final Subscriber<? super PitchStatisticsData> subscriber) {

                HttpHelper.getInstance().initService().requestPitchMaterialStatisticsData(map).enqueue(new Callback<PitchStatisticsData>() {
                    @Override
                    public void onResponse(Call<PitchStatisticsData> call, Response<PitchStatisticsData> response) {
                        if (response.isSuccessful()) {
                            subscriber.onNext(response.body());
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new IOException());
                        }
                    }

                    @Override
                    public void onFailure(Call<PitchStatisticsData> call, Throwable t) {

                        subscriber.onError(t);
                    }
                });

            }
        }).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PitchStatisticsData>() {
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
                    public void onNext(PitchStatisticsData pitchStatisticsData) {

                        getView().responsePitchStatisticsData(pitchStatisticsData);
                    }
                }));

    }

    @Override
    public void start() {

    }
}
