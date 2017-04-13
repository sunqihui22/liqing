package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityProductionQueryDetailData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.WaterStability.WaterStabilityProductionQueryDetailContract;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/21.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityProductionQueryDetailPresenter extends BasePresenter<WaterStabilityProductionQueryDetailContract.View> implements WaterStabilityProductionQueryDetailContract.Presenter {


    public WaterStabilityProductionQueryDetailPresenter(WaterStabilityProductionQueryDetailContract.View mView) {
        super(mView);
    }

    @Override
    public void requestProductionQueryDetail(Map map) {


        HttpHelper.getInstance().initService().requestProductionQueryDetail(map).enqueue(new Callback<WaterStabilityProductionQueryDetailData>() {
            @Override
            public void onResponse(Call<WaterStabilityProductionQueryDetailData> call, Response<WaterStabilityProductionQueryDetailData> response) {

                if (response.isSuccessful()) {
                    WaterStabilityProductionQueryDetailData data=response.body();
                    if (data.isSuccess()) {
                        getView().responseProductionQueryDetail(data);
                        getView().showContent();
                    }else {
                        getView().showError(new IOException());

                    }
                }else {
                    getView().showError(new IOException());
                }

            }

            @Override
            public void onFailure(Call<WaterStabilityProductionQueryDetailData> call, Throwable t) {

                getView().showError(t);
            }
        });


    }

    @Override
    public void start() {

    }
}
