package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.PitchOverProofDetailContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/17.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchOverProofDetailPresenter extends BasePresenter<PitchOverProofDetailContract.View> implements PitchOverProofDetailContract.Presenter {
    public PitchOverProofDetailPresenter(PitchOverProofDetailContract.View mView) {
        super(mView);
    }

    @Override
    public void requestOverProofData(Map<String, String> map) {

        HttpHelper.getInstance().initService().requestPitchOverProofDetail(map).enqueue(new Callback<PitchOverProofDetailsBean>() {
            @Override
            public void onResponse(Call<PitchOverProofDetailsBean> call, Response<PitchOverProofDetailsBean> response) {

                if (response.isSuccessful()) {
                    PitchOverProofDetailsBean pitchOverProofDetailsBean=response.body();
                    if (getView()!=null&&pitchOverProofDetailsBean != null) {
                        getView().responseOverProofData(pitchOverProofDetailsBean);
                        getView().showContent();
                    }else {
                        getView().showError(new IOException());
                    }
                }else {
                    getView().showError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<PitchOverProofDetailsBean> call, Throwable t) {
                if (getView() != null) {
                    getView().showError(t);

                }
            }
        });


    }

    @Override
    public void start() {

    }
}
