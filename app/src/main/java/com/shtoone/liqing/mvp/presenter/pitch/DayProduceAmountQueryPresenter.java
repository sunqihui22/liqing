package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.DayProduceAmountQueryContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountRes;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountResData;
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
public class DayProduceAmountQueryPresenter extends BasePresenter<DayProduceAmountQueryContract.View> implements DayProduceAmountQueryContract.Presenter {

    private static final String TAG = DayProduceAmountQueryPresenter.class.getSimpleName();

    public DayProduceAmountQueryPresenter(DayProduceAmountQueryContract.View mView) {
        super(mView);
    }

    public void requestDayProduceAmount(Map<String, String> options){

        String pageNo = options.get("pageNo");
        final Integer page = Integer.valueOf(pageNo);

        HttpHelper.getInstance().initService().getDayProduceAmount(options).enqueue(new Callback<DayProduceAmountRes>() {
            @Override
            public void onResponse(Call<DayProduceAmountRes> call, Response<DayProduceAmountRes> response) {

                if(response.isSuccessful()){
                    DayProduceAmountRes dayProduceAmountRes = response.body();
                    List<DayProduceAmountResData> dayProduceAmountResData = dayProduceAmountRes.getData();

                    if(dayProduceAmountResData.size()>0){
                        getView().showContent();
                        KLog.e(TAG,dayProduceAmountResData.toString());
                        getView().responseDayProduceAmount(dayProduceAmountResData);
                    }else {
                        if(page==1){
                            getView().showEmpty();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<DayProduceAmountRes> call, Throwable t) {
                if(isViewAttached()){
                    KLog.e(TAG,t.toString());
                    getView().showError(t);
                }
            }
        });

    }

    @Override
    public void start() {

    }
}
