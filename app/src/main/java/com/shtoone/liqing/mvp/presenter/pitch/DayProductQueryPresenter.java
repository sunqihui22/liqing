package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PitchDayProductQueryData;
import com.shtoone.liqing.mvp.model.bean.PitchProductQueryData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.pitch.DayProductQueryContract;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/23.
 * Email：hengzwdhengzwd@qq.com
 */

public class DayProductQueryPresenter extends BasePresenter<DayProductQueryContract.View> implements DayProductQueryContract.Presenter {
    public DayProductQueryPresenter(DayProductQueryContract.View mView) {
        super(mView);
    }

    @Override
    public void requestDayProductQueryData(Map<String, String> map) {

        HttpHelper.getInstance().initService().requestDayProductQuery(map).enqueue(new Callback<PitchDayProductQueryData>() {
            @Override
            public void onResponse(Call<PitchDayProductQueryData> call, Response<PitchDayProductQueryData> response) {
                if (response.isSuccessful()) {
                    getView().responseDayProductQueryData(response.body());
                    getView().showContent();
                }else {
                    getView().showError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<PitchDayProductQueryData> call, Throwable t) {
                getView().showError(t);
            }
        });


    }

    @Override
    public void loadMoreData(Map<String, String> map) {


        HttpHelper.getInstance().initService().requestDayProductQuery(map).enqueue(new Callback<PitchDayProductQueryData>() {
            @Override
            public void onResponse(Call<PitchDayProductQueryData> call, Response<PitchDayProductQueryData> response) {
                if (response.isSuccessful()){
                    PitchDayProductQueryData pitchProductQueryData=response.body();
                    if (pitchProductQueryData != null) {
                        if (pitchProductQueryData.getData().size()>0) {
                            getView().responseLoadMore(pitchProductQueryData);
                        }else {
                            getView().lodingMorecompleted();
                        }
                    }else {
                        getView().showLoadMoreError(new IOException());
                    }

                }else {
                    getView().showLoadMoreError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<PitchDayProductQueryData> call, Throwable t) {

                getView().showLoadMoreError(t);
            }
        });
    }

    @Override
    public void start() {

    }
}
