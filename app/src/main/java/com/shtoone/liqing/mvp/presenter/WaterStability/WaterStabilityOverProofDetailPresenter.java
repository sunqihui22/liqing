package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.mvp.contract.WaterStability.WaterStabilityOverProofDetailContrant;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/15.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityOverProofDetailPresenter extends BasePresenter<WaterStabilityOverProofDetailContrant.View> implements WaterStabilityOverProofDetailContrant.Presenter {
    public WaterStabilityOverProofDetailPresenter(WaterStabilityOverProofDetailContrant.View mView) {
        super(mView);
    }

    @Override
    public void requestOverProofData(Map<String, String> map) {


        HttpHelper.getInstance().initService().requestOverProofDetail(map).enqueue(new Callback<WaterStabilityOverProofDetailsBean>() {
            @Override
            public void onResponse(Call<WaterStabilityOverProofDetailsBean> call, Response<WaterStabilityOverProofDetailsBean> response) {

                if (response.isSuccessful()) {
                    WaterStabilityOverProofDetailsBean waterStabilityOverProofDetailsBean=response.body();
                    if (waterStabilityOverProofDetailsBean != null) {
                        getView().responseOverProofData(waterStabilityOverProofDetailsBean);
                        getView().showContent();
                    }else {
                        getView().showError(new IOException());
                    }
                }else {
                    getView().showError(new IOException());
                }

            }

            @Override
            public void onFailure(Call<WaterStabilityOverProofDetailsBean> call, Throwable t) {

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
