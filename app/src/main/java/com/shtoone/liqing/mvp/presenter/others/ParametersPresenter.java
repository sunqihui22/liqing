package com.shtoone.liqing.mvp.presenter.others;

import com.shtoone.liqing.mvp.contract.others.ParametersContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.EquipmentData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gesangdianzi on 2016/12/7.
 */
public class ParametersPresenter extends BasePresenter<ParametersContract.View> implements ParametersContract.Presenter {

    private List<String> positions;
    private List<String> models;

    public ParametersPresenter(ParametersContract.View mView) {
        super(mView);
    }

    @Override
    public void requestEquipment(String departType, String biaoshiid, String machineType) {

        HttpHelper.getInstance().initService().requestEquipment(departType, biaoshiid, machineType).enqueue(new Callback<EquipmentData>() {
            @Override
            public void onResponse(Call<EquipmentData> call, Response<EquipmentData> response) {

                if (response.isSuccessful()) {
                    EquipmentData equipmentData = response.body();
                    if (null != getView() && equipmentData.getData().size() > 0) {
                        getView().responseEquipment(response.body());
                    } else {
                        getView().showError(new IOException());
                    }

                } else {
                    getView().showError(new IOException());
                }
            }

            @Override
            public void onFailure(Call<EquipmentData> call, Throwable t) {

                if (getView() != null) {
                    getView().showError(t);
                }
            }
        });


    }

    @Override
    public void requestModel() {
        HttpHelper.getInstance().initService().requestModels().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    models = new ArrayList<String>();
                    try {
                        String string = response.body().string();
                        KLog.e(string);
                        JSONObject jsonObject = new JSONObject(string);
                        String positionstirng = jsonObject.optString("data");
                        JSONObject jsonObject1 = new JSONObject(positionstirng);
                        Iterator iterator = jsonObject1.keys();
                        while (iterator.hasNext()) {
                            models.add(jsonObject1.optString((String) iterator.next()));
                        }
                        getView().responseModels(models);
                        KLog.e(positions);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void requesstPositions(Map<String, String> map) {


        HttpHelper.getInstance().initService().requestPostitions(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    positions = new ArrayList<String>();
                    try {
                        String string = response.body().string();
                        KLog.e(string);
                        JSONObject jsonObject = new JSONObject(string);
                        String positionstirng = jsonObject.optString("data");
                        JSONObject jsonObject1 = new JSONObject(positionstirng);
                        Iterator iterator = jsonObject1.keys();
                        while (iterator.hasNext()) {
                            positions.add(jsonObject1.optString((String) iterator.next()));
                        }
                        getView().responsePositons(positions);
                        KLog.e(positions);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                getView().showEmpty();
            }
        });

    }

    @Override
    public void start() {

    }
}
