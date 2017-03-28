package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofData;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.pitch.PitchOverProofContract;
import com.shtoone.liqing.mvp.view.pitch.PitchOverProofFragment;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchOverProofPresenter extends BasePresenter<PitchOverProofContract.View> implements PitchOverProofContract.Presenter {

  PitchOverProofFragment mfragment=new PitchOverProofFragment();

    public PitchOverProofPresenter(PitchOverProofContract.View mView) {
        super(mView);
    }

    @Override
    public void requestPitchOverProofData(Map<String, String> map) {
        getView().showLoading();
        HttpHelper.getInstance().initService().requestPitchOverProofData(map).enqueue(new Callback<PitchOverProofData>() {
            @Override
            public void onResponse(Call<PitchOverProofData> call, Response<PitchOverProofData> response) {
                if (response.isSuccessful()) {
                    getView().responsePitchOverProofData(response.body());
                    getView().showContent();
                }else {
                    getView().showError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<PitchOverProofData> call, Throwable t) {
                getView().showError(t);
            }
        });

    }

    @Override
    public void loadMoreData(Map<String, String> map) {
        getView().showloadingMore();
        HttpHelper.getInstance().initService().requestPitchOverProofData(map).enqueue(new Callback<PitchOverProofData>() {
            @Override
            public void onResponse(Call<PitchOverProofData> call, Response<PitchOverProofData> response) {
                if (response.isSuccessful()){
                    PitchOverProofData pitchOverProofData=response.body();
                    if (pitchOverProofData != null) {
                        if (pitchOverProofData.getData().size()>0) {
                            getView().responseLoadMore(pitchOverProofData);
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
            public void onFailure(Call<PitchOverProofData> call, Throwable t) {

                getView().showLoadMoreError(t);
            }
        });
    }

    @Override
    public void start() {

    }
}
