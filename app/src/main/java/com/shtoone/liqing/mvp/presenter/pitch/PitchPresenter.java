package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.PitchContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import java.io.IOException;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchPresenter extends BasePresenter<PitchContract.View> implements PitchContract.Presenter {

    public PitchPresenter(PitchContract.View mView) {
        super(mView);
    }

    @Override
    public void requestTotalProductData(final String departType, final String biaoshiid, final String startTime, final String endTime, final String shebeibianhao) {


        mRxManager.add(Observable.create(new Observable.OnSubscribe<PitchFragmentData>() {
            @Override
            public void call(final Subscriber<? super PitchFragmentData> subscriber) {

                HttpHelper.getInstance().initService().totalCount(departType, biaoshiid, startTime, endTime, shebeibianhao).enqueue(new Callback<PitchFragmentData>() {
                    @Override
                    public void onResponse(Call<PitchFragmentData> call, Response<PitchFragmentData> response) {
                        if (response.isSuccessful()) {
                            subscriber.onNext(response.body());
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new IOException());
                        }
                    }

                    @Override
                    public void onFailure(Call<PitchFragmentData> call, Throwable t) {
                        subscriber.onError(t);
                    }
                });
            }
        }).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PitchFragmentData>() {
                    @Override
                    public void onCompleted() {
                        getView().showContent();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        getView().showLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e);
                    }

                    @Override
                    public void onNext(PitchFragmentData pitchFragmentData) {
                        getView().responseTotalProductData(pitchFragmentData);
                    }
                }));

    }

    @Override
    public void start() {

    }
}
