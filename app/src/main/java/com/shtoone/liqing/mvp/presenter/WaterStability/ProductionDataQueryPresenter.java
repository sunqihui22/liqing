package com.shtoone.liqing.mvp.presenter.WaterStability;

import com.shtoone.liqing.mvp.contract.WaterStability.ProductionDataQueryContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityHistoryData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class ProductionDataQueryPresenter extends BasePresenter<ProductionDataQueryContract.View> implements ProductionDataQueryContract.Presenter{
    public ProductionDataQueryPresenter(ProductionDataQueryContract.View mView) {
        super(mView);
    }

    @Override
    public void requestProductionDataQueryBean(Map<String, String> map) {

        getView().showLoading();
        HttpHelper.getInstance().initService().requestWaterstabilityHistory(map).enqueue(new Callback<WaterstabilityHistoryData>() {
            @Override
            public void onResponse(Call<WaterstabilityHistoryData> call, Response<WaterstabilityHistoryData> response) {
                if (response.isSuccessful()) {
                    getView().responseProductionDataQueryBean(response.body());
                    getView().showContent();
                }else {
                    getView().showError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<WaterstabilityHistoryData> call, Throwable t) {
                getView().showError(t);
            }
        });
    }

    @Override
    public void loadMoreData(Map<String, String> map) {
        getView().showloadingMore();
        HttpHelper.getInstance().initService().requestWaterstabilityHistory(map).enqueue(new Callback<WaterstabilityHistoryData>() {
            @Override
            public void onResponse(Call<WaterstabilityHistoryData> call, Response<WaterstabilityHistoryData> response) {
                if (response.isSuccessful()){
                    WaterstabilityHistoryData waterstabilityHistoryData=response.body();
                    if (waterstabilityHistoryData != null) {
                        if (waterstabilityHistoryData.getData().size()>0) {
                            getView().responseLoadMore(waterstabilityHistoryData);
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
            public void onFailure(Call<WaterstabilityHistoryData> call, Throwable t) {

                getView().showLoadMoreError(t);
            }
        });
    }

    @Override
    public void start() {

    }
}
