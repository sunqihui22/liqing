package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PitchProductqueryDetailDatas;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.mvp.contract.pitch.PitchProductQueryDetailContract;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author： hengzwd on 2017/3/22.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchProductQueryDetailPresenter extends BasePresenter<PitchProductQueryDetailContract.View> implements PitchProductQueryDetailContract.Presenter {
    public PitchProductQueryDetailPresenter(PitchProductQueryDetailContract.View mView) {
        super(mView);
    }

    @Override
    public void requestProductionQueryDetail(Map map) {


        HttpHelper.getInstance().initService().requestProductQueryDetails(map).enqueue(new Callback<PitchProductqueryDetailDatas>() {

            @Override
            public void onResponse(Call<PitchProductqueryDetailDatas> call, Response<PitchProductqueryDetailDatas> response) {
                if (response.isSuccessful()) {
                    PitchProductqueryDetailDatas pitchProductqueryDetailDatas=response.body();
                    if (pitchProductqueryDetailDatas.isSuccess()) {
                        getView().responseProductionQueryDetail(response.body());
                        getView().showContent();
                    }else {
                        getView().showError(new IOException());
                    }
                }else {
                    getView().showError(new IOException());
                }

            }


            @Override
            public void onFailure(Call<PitchProductqueryDetailDatas> call, Throwable t) {
                getView().showError(t);
            }
        });
    }

    @Override
    public void start() {

    }
}
