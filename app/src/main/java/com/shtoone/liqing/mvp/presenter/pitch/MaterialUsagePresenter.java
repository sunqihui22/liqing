package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.base.MaterialUsageContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.MaterialUsageRes;
import com.shtoone.liqing.mvp.model.bean.SC_cailiaoyongliang;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/7.
 */
public class MaterialUsagePresenter extends BasePresenter<MaterialUsageContract.View> implements MaterialUsageContract.Presenter {

    private static final String TAG = MaterialUsagePresenter.class.getSimpleName();

    List<SC_cailiaoyongliang> datas;

    public MaterialUsagePresenter(MaterialUsageContract.View mView) {
        super(mView);
    }

    public void requestMaterialUsage(Map<String, String> options){

        HttpHelper.getInstance().initService().getMaterialUsage(options).enqueue(new Callback<MaterialUsageRes>() {
            @Override
            public void onResponse(Call<MaterialUsageRes> call, Response<MaterialUsageRes> response) {
                if(response.isSuccessful()){
                    MaterialUsageRes materialUsageRes = response.body();
                    if(materialUsageRes.isSuccess()){
                        datas = new ArrayList<>();
                        MaterialUsageRes.FieldsBean materialUsageResFields = materialUsageRes.getFields();
                        MaterialUsageRes.DataBean materialUsageResData = materialUsageRes.getData();

                        SC_cailiaoyongliang c1 = new SC_cailiaoyongliang();
                        c1.setCailiaomingcheng(materialUsageResFields.getSjf1());
                        c1.setShijiKg(Double.parseDouble(materialUsageResData.getSjf1()));
                        c1.setpeibiKg(Double.parseDouble(materialUsageResData.getLlf1()));
                        c1.setWuchaKg(c1.getShijiKg() - c1.getpeibiKg());
                        c1.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjf1()));
                        datas.add(c1);

                        SC_cailiaoyongliang c2 = new SC_cailiaoyongliang();
                        c2.setCailiaomingcheng(materialUsageResFields.getSjf2());
                        c2.setShijiKg(Double.parseDouble(materialUsageResData.getSjf2()));
                        c2.setpeibiKg(Double.parseDouble(materialUsageResData.getLlf2()));
                        c2.setWuchaKg(c2.getShijiKg() - c2.getpeibiKg());
                        c2.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjf2()));
                        datas.add(c2);

                        SC_cailiaoyongliang c3 = new SC_cailiaoyongliang();
                        c3.setCailiaomingcheng(materialUsageResFields.getSjg1());
                        c3.setShijiKg(Double.parseDouble(materialUsageResData.getSjg1()));
                        c3.setpeibiKg(Double.parseDouble(materialUsageResData.getLlg1()));
                        c3.setWuchaKg(c3.getShijiKg() - c3.getpeibiKg());
                        c3.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjg1()));
                        datas.add(c3);

                        SC_cailiaoyongliang c4 = new SC_cailiaoyongliang();
                        c4.setCailiaomingcheng(materialUsageResFields.getSjg2());
                        c4.setShijiKg(Double.parseDouble(materialUsageResData.getSjg2()));
                        c4.setpeibiKg(Double.parseDouble(materialUsageResData.getSjg2()));
                        c4.setWuchaKg(c4.getShijiKg() - c4.getpeibiKg());
                        c4.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjg2()));
                        datas.add(c4);

                        SC_cailiaoyongliang c5 = new SC_cailiaoyongliang();
                        c5.setCailiaomingcheng(materialUsageResFields.getSjg3());
                        c5.setShijiKg(Double.parseDouble(materialUsageResData.getSjg3()));
                        c5.setpeibiKg(Double.parseDouble(materialUsageResData.getSjg3()));
                        c5.setWuchaKg(c5.getShijiKg() - c5.getpeibiKg());
                        c5.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjg3()));
                        datas.add(c5);

                        SC_cailiaoyongliang c6 = new SC_cailiaoyongliang();
                        c6.setCailiaomingcheng(materialUsageResFields.getSjg4());
                        c6.setShijiKg(Double.parseDouble(materialUsageResData.getSjg4()));
                        c6.setpeibiKg(Double.parseDouble(materialUsageResData.getSjg4()));
                        c6.setWuchaKg(c6.getShijiKg() - c6.getpeibiKg());
                        c6.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjg4()));
                        datas.add(c6);

                        SC_cailiaoyongliang c7 = new SC_cailiaoyongliang();
                        c7.setCailiaomingcheng(materialUsageResFields.getSjg5());
                        c7.setShijiKg(Double.parseDouble(materialUsageResData.getSjg5()));
                        c7.setpeibiKg(Double.parseDouble(materialUsageResData.getSjg5()));
                        c7.setWuchaKg(c7.getShijiKg() - c7.getpeibiKg());
                        c7.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjg5()));
                        datas.add(c7);

                        SC_cailiaoyongliang c8 = new SC_cailiaoyongliang();
                        c8.setCailiaomingcheng(materialUsageResFields.getSjg6());
                        c8.setShijiKg(Double.parseDouble(materialUsageResData.getSjg6()));
                        c8.setpeibiKg(Double.parseDouble(materialUsageResData.getSjg6()));
                        c8.setWuchaKg(c8.getShijiKg() - c8.getpeibiKg());
                        c8.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjg6()));
                        datas.add(c8);

                        SC_cailiaoyongliang c9 = new SC_cailiaoyongliang();
                        c9.setCailiaomingcheng(materialUsageResFields.getSjg7());
                        c9.setShijiKg(Double.parseDouble(materialUsageResData.getSjg7()));
                        c9.setpeibiKg(Double.parseDouble(materialUsageResData.getSjg7()));
                        c9.setWuchaKg(c9.getShijiKg() - c9.getpeibiKg());
                        c9.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjg7()));
                        datas.add(c9);

                        SC_cailiaoyongliang c10 = new SC_cailiaoyongliang();
                        c10.setCailiaomingcheng(materialUsageResFields.getSjlq());
                        c10.setShijiKg(Double.parseDouble(materialUsageResData.getSjlq()));
                        c10.setpeibiKg(Double.parseDouble(materialUsageResData.getLllq()));
                        c10.setWuchaKg(c10.getShijiKg() - c10.getpeibiKg());
                        c10.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjlq()));
                        datas.add(c10);

                        SC_cailiaoyongliang c11 = new SC_cailiaoyongliang();
                        c11.setCailiaomingcheng(materialUsageResFields.getSjtjj());
                        c11.setShijiKg(Double.parseDouble(materialUsageResData.getSjtjj()));
                        c11.setpeibiKg(Double.parseDouble(materialUsageResData.getLltjj()));
                        c11.setWuchaKg(c11.getShijiKg() - c11.getpeibiKg());
                        c11.setWuchaPst(Double.parseDouble(materialUsageResData.getWsjtjj()));
                        datas.add(c11);
                        getView().showContent();
                        getView().responseMaterialUsage(datas);
                        KLog.e(TAG,datas.toString());
                    }else{
                        getView().showEmpty();
                    }

                }

            }

            @Override
            public void onFailure(Call<MaterialUsageRes> call, Throwable t) {
                KLog.e(t.toString());
                getView().showError(t);
            }
        });
    }

    @Override
    public void detachView() {

    }

    @Override
    public void start() {

    }
}
