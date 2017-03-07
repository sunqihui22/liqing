package com.shtoone.liqing.mvp.presenter.laboratory;

import com.shtoone.liqing.mvp.contract.laboratory.LaboratoryContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.LaboratoryData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/11/17.
 * 用于处理实验室界面网络请求以及数据处理
 */
public class LaboratoryPresenter extends BasePresenter<LaboratoryContract.View> implements LaboratoryContract.Presenter {

    public LaboratoryPresenter(LaboratoryContract.View mView) {
        super(mView);
    }

    @Override
    public void start() {

    }

    @Override
    public void requestLaboratoryData(String biaoduanid) {

        HttpHelper.getInstance().initService().requestLaboratory(biaoduanid).enqueue(new Callback<LaboratoryData>() {
            @Override
            public void onResponse(Call<LaboratoryData> call, Response<LaboratoryData> response) {
                if (response.body().isSuccess())
                {
                    getView().responseLaboratoryData(response.body());
                }

            }

            @Override
            public void onFailure(Call<LaboratoryData> call, Throwable t) {

                getView().showError(t);
            }
        });
    }
}
