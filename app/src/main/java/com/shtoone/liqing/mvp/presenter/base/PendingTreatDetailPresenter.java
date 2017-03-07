package com.shtoone.liqing.mvp.presenter.base;

import com.shtoone.liqing.mvp.contract.base.PendingTreatDetailContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PendingTreatDetailRes;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq_data;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/16.
 */
public class PendingTreatDetailPresenter extends BasePresenter<PendingTreatDetailContract.View> implements PendingTreatDetailContract.Presenter{

    private static final String TAG = PendingTreatDetailPresenter.class.getSimpleName();
    private List<SC_chaxunItem_xq_data> lists = null;
    SC_chaxunItem_xq xqData = null;
    PendingTreatDetailRes pendingTreatDetailRes;

    public PendingTreatDetailPresenter(PendingTreatDetailContract.View mView) {
        super(mView);
    }

    public void requestPendingtreatDetailData(String shebeibianhao,String xxid){

        HttpHelper.getInstance().initService().getPendingtreatDetail(shebeibianhao,xxid).enqueue(new Callback<PendingTreatDetailRes>() {
            @Override
            public void onResponse(Call<PendingTreatDetailRes> call, Response<PendingTreatDetailRes> response) {
                if(response.isSuccessful()){
                    lists = new ArrayList<SC_chaxunItem_xq_data>();
                    xqData=new SC_chaxunItem_xq();
                    pendingTreatDetailRes = response.body();
                    PendingTreatDetailRes.FieldsBean fields = pendingTreatDetailRes.getFields();
                    PendingTreatDetailRes.IsshowBean isshow = pendingTreatDetailRes.getIsshow();
                    PendingTreatDetailRes.DataBean pendingTreatDetailResData = pendingTreatDetailRes.getData();
                    if(pendingTreatDetailRes.isSuccess()){
                        xqData.setBanhezhanmingchen(pendingTreatDetailResData.getBanhezhanminchen());
                        xqData.setChuliaoshijian(pendingTreatDetailResData.getShijian());
                        xqData.setShijiyoushibi(pendingTreatDetailResData.getSjysb());
                        xqData.setLilunyoushibi(pendingTreatDetailResData.getLlysb());
                        xqData.setYoushibiwucha(pendingTreatDetailResData.getWsjysb());
                        xqData.setLiqingwendu(pendingTreatDetailResData.getLqwd());
                        xqData.setShiliaowend(pendingTreatDetailResData.getGlwd());
                        xqData.setChuliaowendu(pendingTreatDetailResData.getClwd());
                        xqData.setUsername(pendingTreatDetailResData.getChuzhiren());
                        xqData.setReason(pendingTreatDetailResData.getChaobiaoyuanyin());
                        xqData.setResult(pendingTreatDetailResData.getChulijieguo());
                        xqData.setType(pendingTreatDetailResData.getChulifangshi());
                        xqData.setTime(pendingTreatDetailResData.getChuzhishijian());


                        if ("1".equals(isshow.getSjf1())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjf1());
                            row.setYongliang(pendingTreatDetailResData.getSjf1());
                            row.setShiji(pendingTreatDetailResData.getPersjf1());
                            row.setPeibi(pendingTreatDetailResData.getLlf1());
                            row.setWucha(pendingTreatDetailResData.getWsjf1());
                            row.setCb(pendingTreatDetailResData.getCbsjf1());
                            lists.add(row);
                        }
                        if ("1".equals(isshow.getSjf2())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjf2());
                            row.setYongliang(pendingTreatDetailResData.getSjf2());
                            row.setShiji(pendingTreatDetailResData.getPersjf2());
                            row.setPeibi(pendingTreatDetailResData.getLlf2());
                            row.setWucha(pendingTreatDetailResData.getWsjf2());
                            row.setCb(pendingTreatDetailResData.getCbsjf2());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjg1())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjg1());
                            row.setYongliang(pendingTreatDetailResData.getSjg1());
                            row.setShiji(pendingTreatDetailResData.getPersjg1());
                            row.setPeibi(pendingTreatDetailResData.getLlg1());
                            row.setWucha(pendingTreatDetailResData.getWsjg1());
                            row.setCb(pendingTreatDetailResData.getCbsjg1());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjg2())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjg2());
                            row.setYongliang(pendingTreatDetailResData.getSjg2());
                            row.setShiji(pendingTreatDetailResData.getPersjg2());
                            row.setPeibi(pendingTreatDetailResData.getLlg2());
                            row.setWucha(pendingTreatDetailResData.getWsjg2());
                            row.setCb(pendingTreatDetailResData.getCbsjg2());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjg3())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjg3());
                            row.setYongliang(pendingTreatDetailResData.getSjg3());
                            row.setShiji(pendingTreatDetailResData.getPersjg3());
                            row.setPeibi(pendingTreatDetailResData.getLlg3());
                            row.setWucha(pendingTreatDetailResData.getWsjg3());
                            row.setCb(pendingTreatDetailResData.getCbsjg3());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjg4())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjg4());
                            row.setYongliang(pendingTreatDetailResData.getSjg4());
                            row.setShiji(pendingTreatDetailResData.getPersjg4());
                            row.setPeibi(pendingTreatDetailResData.getLlg4());
                            row.setWucha(pendingTreatDetailResData.getWsjg4());
                            row.setCb(pendingTreatDetailResData.getCbsjg4());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjg5())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjg5());
                            row.setYongliang(pendingTreatDetailResData.getSjg5());
                            row.setShiji(pendingTreatDetailResData.getPersjg5());
                            row.setPeibi(pendingTreatDetailResData.getLlg5());
                            row.setWucha(pendingTreatDetailResData.getWsjg5());
                            row.setCb(pendingTreatDetailResData.getCbsjg5());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjg6())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjg6());
                            row.setYongliang(pendingTreatDetailResData.getSjg6());
                            row.setShiji(pendingTreatDetailResData.getPersjg6());
                            row.setPeibi(pendingTreatDetailResData.getLlg6());
                            row.setWucha(pendingTreatDetailResData.getWsjg6());
                            row.setCb(pendingTreatDetailResData.getCbsjg6());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjg7())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjg7());
                            row.setYongliang(pendingTreatDetailResData.getSjg7());
                            row.setShiji(pendingTreatDetailResData.getPersjg7());
                            row.setPeibi(pendingTreatDetailResData.getLlg7());
                            row.setWucha(pendingTreatDetailResData.getWsjg7());
                            row.setCb(pendingTreatDetailResData.getCbsjg7());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjlq())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjlq());
                            row.setYongliang(pendingTreatDetailResData.getSjlq());
                            row.setShiji(pendingTreatDetailResData.getPersjlq());
                            row.setPeibi(pendingTreatDetailResData.getLllq());
                            row.setWucha(pendingTreatDetailResData.getWsjlq());
                            row.setCb(pendingTreatDetailResData.getCbsjlq());
                            lists.add(row);
                        }

                        if ("1".equals(isshow.getSjtjj())) {
                            SC_chaxunItem_xq_data row = new SC_chaxunItem_xq_data();
                            row.setName(fields.getSjtjj());
                            row.setYongliang(pendingTreatDetailResData.getSjtjj());
                            row.setShiji(pendingTreatDetailResData.getPersjtjj());
                            row.setPeibi(pendingTreatDetailResData.getLltjj());
                            row.setWucha(pendingTreatDetailResData.getWsjtjj());
                            row.setCb(pendingTreatDetailResData.getCbsjtjj());
                            lists.add(row);
                        }


                        xqData.setLists(lists);
                        KLog.e(TAG,xqData.toString());
                        getView().responsePendingtreatDetail(xqData,pendingTreatDetailRes);
                    }else{

                        getView().showEmpty();
                    }

                }


            }

            @Override
            public void onFailure(Call<PendingTreatDetailRes> call, Throwable t) {
                if(null!=getView()){
                    getView().showError(t);
                }

            }
        });

    }


    public void uploadTreatData(Map<String,String> options, MultipartBody.Part body){

        HttpHelper.getInstance().initService().uploadPendingTreatResult(options,body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                        KLog.e(TAG,"---onCompleted---");
                    }

                    @Override
                    public void onError(Throwable e) {

                        KLog.e(TAG,e.toString());
                    }

                    @Override
                    public void onNext(Object o) {

                        getView().uploaded("上传成功");
                    }
                });



    }

    @Override
    public void start() {

    }
}
