package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.ProduceDataQueryDetailContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.ProduceDataDetailRes;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq_data;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.utils.DateUtils;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/14.
 */
public class ProduceDataQueryDetailPresenter extends BasePresenter<ProduceDataQueryDetailContract.View> implements ProduceDataQueryDetailContract.Presenter {

    private static final String TAG = ProduceDataQueryDetailPresenter.class.getSimpleName();
    List<SC_chaxunItem_xq_data> lists = null;
    SC_chaxunItem_xq xqData = null;
    ProduceDataDetailRes produceDataDetailRes;

    public ProduceDataQueryDetailPresenter(ProduceDataQueryDetailContract.View mView) {
        super(mView);
    }


    public void getProduceDataDetail(String shebeibianhao,String bianhao){

        HttpHelper.getInstance().initService().getProduceDataDetail(shebeibianhao,bianhao).enqueue(new Callback<ProduceDataDetailRes>() {
            @Override
            public void onResponse(Call<ProduceDataDetailRes> call, Response<ProduceDataDetailRes> response) {

                if(response.isSuccessful()){
                    produceDataDetailRes = response.body();
                    lists = new ArrayList<SC_chaxunItem_xq_data>();
                    xqData=new SC_chaxunItem_xq();
                    if(produceDataDetailRes.isSuccess()){
                        ProduceDataDetailRes.FieldsBean ProduceDataDetailFields = produceDataDetailRes.getFields();
                        ProduceDataDetailRes.IsshowBean ProduceDataDetailIsshow = produceDataDetailRes.getIsshow();
                        ProduceDataDetailRes.DataBean produceDataDetailResData = produceDataDetailRes.getData();

                        if ("1".equals(ProduceDataDetailIsshow.getSjf1())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjf1());
                            data.setPeibi(produceDataDetailResData.getLlf1());
                            data.setShiji(produceDataDetailResData.getPersjf1());
                            data.setWucha(produceDataDetailResData.getWsjf1());
                            data.setYongliang(produceDataDetailResData.getSjf1());
                            KLog.e(TAG,data.toString());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjf2())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjf2());
                            data.setPeibi(produceDataDetailResData.getLlf2());
                            data.setShiji(produceDataDetailResData.getPersjf2());
                            data.setWucha(produceDataDetailResData.getWsjf2());
                            data.setYongliang(produceDataDetailResData.getSjf2());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjg1())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjg1());
                            data.setPeibi((produceDataDetailResData.getLlg1()));
                            data.setShiji(produceDataDetailResData.getPersjg1());
                            data.setWucha(produceDataDetailResData.getWsjg1());
                            data.setYongliang(produceDataDetailResData.getSjg1());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjg2())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjg2());
                            data.setPeibi((produceDataDetailResData.getLlg2()));
                            data.setShiji(produceDataDetailResData.getPersjg2());
                            data.setWucha(produceDataDetailResData.getWsjg2());
                            data.setYongliang(produceDataDetailResData.getSjg2());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjg3())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjg3());
                            data.setPeibi((produceDataDetailResData.getLlg3()));
                            data.setShiji(produceDataDetailResData.getPersjg3());
                            data.setWucha(produceDataDetailResData.getWsjg3());
                            data.setYongliang(produceDataDetailResData.getSjg3());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjg4())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjg4());
                            data.setPeibi((produceDataDetailResData.getLlg4()));
                            data.setShiji(produceDataDetailResData.getPersjg4());
                            data.setWucha(produceDataDetailResData.getWsjg4());
                            data.setYongliang(produceDataDetailResData.getSjg4());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjg5())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjg5());
                            data.setPeibi((produceDataDetailResData.getLlg5()));
                            data.setShiji(produceDataDetailResData.getPersjg5());
                            data.setWucha(produceDataDetailResData.getWsjg5());
                            data.setYongliang(produceDataDetailResData.getSjg5());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjg6())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjg6());
                            data.setPeibi((produceDataDetailResData.getLlg6()));
                            data.setShiji(produceDataDetailResData.getPersjg6());
                            data.setWucha(produceDataDetailResData.getWsjg6());
                            data.setYongliang(produceDataDetailResData.getSjg6());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjg7())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjg7());
                            data.setPeibi((produceDataDetailResData.getLlg7()));
                            data.setShiji(produceDataDetailResData.getPersjg7());
                            data.setWucha(produceDataDetailResData.getWsjg7());
                            data.setYongliang(produceDataDetailResData.getSjg7());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjlq())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjlq());
                            data.setPeibi(produceDataDetailResData.getLllq());
                            data.setShiji(produceDataDetailResData.getPersjlq());
                            data.setWucha(produceDataDetailResData.getWsjlq());
                            data.setYongliang(produceDataDetailResData.getSjlq());
                            lists.add(data);
                        }
                        if ("1".equals(ProduceDataDetailIsshow.getSjtjj())) {
                            SC_chaxunItem_xq_data data = new SC_chaxunItem_xq_data();
                            data.setName(ProduceDataDetailFields.getSjtjj());
                            data.setPeibi(produceDataDetailResData.getLltjj());
                            data.setShiji(produceDataDetailResData.getPersjtjj());
                            data.setWucha(produceDataDetailResData.getWsjtjj());
                            data.setYongliang(produceDataDetailResData.getSjtjj());

                            lists.add(data);
                        }

                        //1. 时间,实际油石比,理论油石比,误差实际油石比,沥青温度,骨料温度,出料温度
                        xqData.setBanhezhanmingchen(produceDataDetailResData.getBanhezhanminchen());
                        xqData.setChuliaoshijian(DateUtils.subTime(produceDataDetailResData.getShijian()));
                        xqData.setShijiyoushibi(produceDataDetailResData.getSjysb());
                        xqData.setLilunyoushibi(produceDataDetailResData.getLlysb());
                        xqData.setYoushibiwucha(produceDataDetailResData.getWsjysb());
                        xqData.setLiqingwendu(produceDataDetailResData.getLqwd());
                        xqData.setShiliaowend(produceDataDetailResData.getGlwd());
                        xqData.setChuliaowendu(produceDataDetailResData.getClwd());
                        KLog.e(TAG,produceDataDetailResData.toString());
                        KLog.e(TAG,xqData.toString());
                        KLog.e(TAG,lists.toString());
                        xqData.setLists(lists);
                        KLog.e(TAG,xqData.toString());

                    }
                }

                getView().responseProduceDataDetail(xqData,produceDataDetailRes);
            }

            @Override
            public void onFailure(Call<ProduceDataDetailRes> call, Throwable t) {
                KLog.e(TAG,t.toString());
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
