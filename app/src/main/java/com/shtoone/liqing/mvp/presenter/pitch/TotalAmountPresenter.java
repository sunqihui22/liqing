package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.TotalAmountContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.TotalAmountItemData;
import com.shtoone.liqing.mvp.model.bean.TotalAmountRes;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/11/24.
 */
public class TotalAmountPresenter extends BasePresenter<TotalAmountContract.View> implements TotalAmountContract.Presenter {

    private static final String TAG = TotalAmountPresenter.class.getSimpleName();

    private TotalAmountRes totalAmountRes;
    private List<TotalAmountItemData> TotalAmountListData;

    public TotalAmountPresenter(TotalAmountContract.View mView) {
        super(mView);
    }

    public void requestTotalAmount(Map<String, String> options){

        HttpHelper.getInstance().initService().getTotalAmount(options).enqueue(new Callback<TotalAmountRes>() {
            @Override
            public void onResponse(Call<TotalAmountRes> call, Response<TotalAmountRes> response) {
                if(response.isSuccessful()){
                    TotalAmountRes totalAmountRes = response.body();
                    if(totalAmountRes.isSuccess()){
                        if(null!=totalAmountRes && isViewAttached()){
                            List<TotalAmountItemData> totalAmountListData=totalAmountRes.getData();
                            KLog.e(TAG,response.body().toString());
                            KLog.e(TAG,totalAmountListData);
                            getView().showContent();
                            getView().responseTotalAmount(totalAmountListData);

                        }else{
                            getView().showEmpty();
                        }
                    }else {
                        getView().showEmpty();
                    }

                }
            }

            @Override
            public void onFailure(Call<TotalAmountRes> call, Throwable t) {
                if(isViewAttached()){
                    getView().showError(t);
                    KLog.e(TAG,t.toString());
                }

            }
        });
    }


    @Override
    public void start() {

    }
}
