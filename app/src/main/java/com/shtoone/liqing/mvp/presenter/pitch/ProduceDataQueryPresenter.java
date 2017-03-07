package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.ProduceDataQueryContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryRes;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryResData;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/7.
 */
public class ProduceDataQueryPresenter extends BasePresenter<ProduceDataQueryContract.View> implements ProduceDataQueryContract.Presenter{


    private static final String TAG = ProduceDataQueryPresenter.class.getSimpleName();
    private ProduceDataQueryRes produceDataQueryRes;

    public ProduceDataQueryPresenter(ProduceDataQueryContract.View mView) {
        super(mView);
    }


    public void requestProduceData(Map<String, String> options){

        HttpHelper.getInstance().initService().producrDataQuery(options).enqueue(new Callback<ProduceDataQueryRes>() {
            @Override
            public void onResponse(Call<ProduceDataQueryRes> call, Response<ProduceDataQueryRes> response) {
                if(response.isSuccessful()){
                    produceDataQueryRes = response.body();
                    if(produceDataQueryRes.isSuccess()){
                        if(null!=getView()){
                            KLog.e(TAG,produceDataQueryRes.toString());
                            List<ProduceDataQueryResData> produceDataQueryResData = produceDataQueryRes.getData();
                            getView().responseProduceData(produceDataQueryResData);
                            getView().showContent();
                        }
                    }else{
                        getView().showEmpty();
                    }
                }

            }

            @Override
            public void onFailure(Call<ProduceDataQueryRes> call, Throwable t) {
                if(isViewAttached()){
                    getView().showError(t);
                }

            }
        });

    }

    @Override
    public void start() {

    }
}
