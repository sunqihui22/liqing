package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.mvp.contract.WaterStability.OverProofContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityOverProofPresenter extends BasePresenter<OverProofContract.View> implements OverProofContract.Presenter {
    public WaterStabilityOverProofPresenter(OverProofContract.View mView) {
        super(mView);
    }

    @Override
    public void requestWaterStabilityOverProofBean(Map<String, String> map) {

        getView().showLoading();
        HttpHelper.getInstance().initService().requestOverProofData(map).enqueue(new Callback<WaterStabilityOverProofBean>() {
            @Override
            public void onResponse(Call<WaterStabilityOverProofBean> call, Response<WaterStabilityOverProofBean> response) {
                if (response.isSuccessful()) {
                    getView().responseWaterStabilityOverProofBean(response.body());
                    getView().showContent();
                }else {
                    getView().showError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<WaterStabilityOverProofBean> call, Throwable t) {
                if (getView() != null) {
                    getView().showError(t);
                }
            }
        });
    }

    @Override
    public void loadMoreData(Map<String, String> map) {
        getView().showloadingMore();
        HttpHelper.getInstance().initService().requestOverProofData(map).enqueue(new Callback<WaterStabilityOverProofBean>() {
            @Override
            public void onResponse(Call<WaterStabilityOverProofBean> call, Response<WaterStabilityOverProofBean> response) {
                if (response.isSuccessful()){
                    WaterStabilityOverProofBean waterStabilityOverProofBean=response.body();
                    if (waterStabilityOverProofBean != null) {
                        if (waterStabilityOverProofBean.getData().size()>0) {
                            getView().responseLoadMore(waterStabilityOverProofBean);
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
            public void onFailure(Call<WaterStabilityOverProofBean> call, Throwable t) {

                getView().showLoadMoreError(t);
            }
        });
    }

    @Override
    public void start() {

    }
}
