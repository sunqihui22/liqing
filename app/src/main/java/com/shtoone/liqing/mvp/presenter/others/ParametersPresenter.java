package com.shtoone.liqing.mvp.presenter.others;

import com.shtoone.liqing.mvp.contract.others.ParametersContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.EquipmentData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gesangdianzi on 2016/12/7.
 */
public class ParametersPresenter extends BasePresenter<ParametersContract.View> implements ParametersContract.Presenter {
    public ParametersPresenter(ParametersContract.View mView) {
        super(mView);
    }

    @Override
    public void requestEquipment(String userGroupId) {

        HttpHelper.getInstance().initService().requestEquipment(userGroupId).enqueue(new Callback<EquipmentData>() {
            @Override
            public void onResponse(Call<EquipmentData> call, Response<EquipmentData> response) {

                if (response.isSuccessful()) {
                    if(null!=getView()){
                        getView().responseEquipment(response.body());
                    }

                }
            }

            @Override
            public void onFailure(Call<EquipmentData> call, Throwable t) {

//                getView().showError(t);
            }
        });


    }

    @Override
    public void start() {

    }
}
