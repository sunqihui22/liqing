package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PitchProductQueryData;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityHistoryData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.pitch.PitchProductQueryContract;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchProductQueryPresenter extends BasePresenter<PitchProductQueryContract.View> implements PitchProductQueryContract.Presenter {
    public PitchProductQueryPresenter(PitchProductQueryContract.View mView) {
        super(mView);
    }

    @Override
    public void requestPitchProductQueryData(Map<String, String> map) {

        HttpHelper.getInstance().initService().requestPitchProductQueryData(map).enqueue(new Callback<PitchProductQueryData>() {
            @Override
            public void onResponse(Call<PitchProductQueryData> call, Response<PitchProductQueryData> response) {
                if (response.isSuccessful()) {
                    getView().responsePitchProductQueryData(response.body());
                    getView().showContent();
                }else {
                    getView().showError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<PitchProductQueryData> call, Throwable t) {
                getView().showError(t);

            }
        });
    }

    @Override
    public void loadMoreData(Map<String, String> map) {
        getView().showloadingMore();
        HttpHelper.getInstance().initService().requestPitchProductQueryData(map).enqueue(new Callback<PitchProductQueryData>() {
            @Override
            public void onResponse(Call<PitchProductQueryData> call, Response<PitchProductQueryData> response) {
                if (response.isSuccessful()){
                    PitchProductQueryData pitchProductQueryData=response.body();
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
            public void onFailure(Call<PitchProductQueryData> call, Throwable t) {

                getView().showLoadMoreError(t);
            }
        });
    }

    @Override
    public void start() {

    }
}
