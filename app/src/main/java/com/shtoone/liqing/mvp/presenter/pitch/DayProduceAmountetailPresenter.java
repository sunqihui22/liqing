package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.DayProduceAmountetailContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/23.
 */
public class DayProduceAmountetailPresenter extends BasePresenter<DayProduceAmountetailContract.View> implements DayProduceAmountetailContract.Presenter{

    private static final String TAG = DayProduceAmountetailPresenter.class.getSimpleName();

    public DayProduceAmountetailPresenter(DayProduceAmountetailContract.View mView) {
        super(mView);
    }

    public void uploadDayAmountDetail(String s){

//        Gson gson = new Gson();
//        String s = gson.toJson(data);
//        KLog.e(TAG,data.toString());


        HttpHelper.getInstance().initService().uploadDayAmountqueryDetail(s).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                getView().uploaded("上传成功",1);
                KLog.e(11111111);
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                KLog.e(t);
            }
        });



    }

    @Override
    public void start() {

    }
}
