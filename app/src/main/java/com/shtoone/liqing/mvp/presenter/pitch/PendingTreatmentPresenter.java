package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.PendingTreatmenContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PendingTreatDataBean;
import com.shtoone.liqing.mvp.model.bean.PendingTreatFieldsBean;
import com.shtoone.liqing.mvp.model.bean.PendingTreatIsshowBean;
import com.shtoone.liqing.mvp.model.bean.PendingTreatRVItemData;
import com.shtoone.liqing.mvp.model.bean.PendingTreatRVListData;
import com.shtoone.liqing.mvp.model.bean.PendingTreatResBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Created by Administrator on 2016/11/24.
 */
public class PendingTreatmentPresenter extends BasePresenter<PendingTreatmenContract.View> implements PendingTreatmenContract.Presenter{

    private static final String TAG = PendingTreatmentPresenter.class.getSimpleName();
    PendingTreatResBean pendingTreatBean;

    private List<PendingTreatRVListData> lists;
    private List<PendingTreatRVListData> moreLists=new ArrayList<>();

    public PendingTreatmentPresenter(PendingTreatmenContract.View mView) {
        super(mView);
    }


    public void getPendingTreatData(Map<String, String> options){
        HttpHelper.getInstance().initService().treatAlarm(options).enqueue(new Callback<PendingTreatResBean>() {
            @Override
            public void onResponse(Call<PendingTreatResBean> call, Response<PendingTreatResBean> response) {
                if (response.isSuccessful()) {
                    KLog.e("---isSuccessful---");
                    pendingTreatBean = response.body();
                    KLog.e(TAG,pendingTreatBean.toString());
                    if(pendingTreatBean.isSuccess()){
                        lists= new ArrayList<>();
                        PendingTreatFieldsBean pendingTreatBeanFields = pendingTreatBean.getFields();
                        PendingTreatIsshowBean pendingTreatBeanIsshow = pendingTreatBean.getIsshow();
                        List<PendingTreatDataBean> listData = pendingTreatBean.getData();
//                        KLog.e("listData="+listData.size());
//                        KLog.e("---pendingTreatBean---");
                        KLog.e(TAG,listData.toString());
                        for (int i = 0; i < listData.size(); i++) {
                            KLog.e("---for--next--");
                            PendingTreatRVListData pendingTreatListData = new PendingTreatRVListData();
                            PendingTreatDataBean pendingTreatDataBean = listData.get(i);
                            pendingTreatListData.setShijian(pendingTreatDataBean.getShijian());
                            pendingTreatListData.setBianhao(pendingTreatDataBean.getBianhao());
                            pendingTreatListData.setShebeibianhao(pendingTreatDataBean.getShebeibianhao());
                            pendingTreatListData.setChuli(pendingTreatDataBean.getChuli());
                            KLog.e("沥青超标列表页：", pendingTreatListData.getBianhao() + "***" + pendingTreatListData.getShebeibianhao());
                            List<PendingTreatRVItemData> itemDataList = new ArrayList<PendingTreatRVItemData>();
                            if ("1".equals(pendingTreatBeanIsshow.getSjf1())){
//                                KLog.e("---getSjf1---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjf1());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjf1());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjf1());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjf2())) {
//                                KLog.e("---getSjf2---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjf2());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjf2());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjf2());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjg1())) {
//                                KLog.e("---getSjg1---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjg1());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjg1());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjg1());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjg2())) {
//                                KLog.e("---getSjg2---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjg2());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjg2());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjg2());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjg3())) {
//                                KLog.e("---getSjg3---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjg3());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjg3());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjg3());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjg4())) {
//                                KLog.e("---getSjg4---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjg4());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjg4());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjg4());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjg5())) {
//                                KLog.e("---getSjg5---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjg5());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjg5());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjg5());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjg6())) {
//                                KLog.e("---getSjg6---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjg6());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjg6());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjg6());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjg7())) {
//                                KLog.e("---getSjg7---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjg7());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjg7());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjg7());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjlq())) {
//                                KLog.e("---getSjlq---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjlq());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjlq());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjlq());
                                itemDataList.add(pendingTreatItemData);
                            }
                            if ("1".equals(pendingTreatBeanIsshow.getSjtjj())) {
//                                KLog.e("---getSjtjj---");
                                PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                                pendingTreatItemData.setName(pendingTreatBeanFields.getSjtjj());
                                pendingTreatItemData.setData(pendingTreatDataBean.getWsjtjj());
                                pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjtjj());
                                itemDataList.add(pendingTreatItemData);
                            }
                        if ("1".equals(pendingTreatBeanIsshow.getSjysb())) {
//                                KLog.e("---getSjysb---");
                            PendingTreatRVItemData pendingTreatItemData = new PendingTreatRVItemData();
                            pendingTreatItemData.setName(pendingTreatBeanFields.getSjysb());
                            pendingTreatItemData.setData(pendingTreatDataBean.getWsjysb());
                            pendingTreatItemData.setCb(pendingTreatDataBean.getCbsjysb());
                            itemDataList.add(pendingTreatItemData);
                        }

                            KLog.e(TAG,itemDataList.toString());
                            pendingTreatListData.setLists(itemDataList);
                            KLog.e(TAG,pendingTreatListData.toString());
//                            lists.remove(i);
                            lists.add(pendingTreatListData);
                            KLog.e(TAG,lists.size());
                            KLog.e(TAG,lists.toString());
                        }
                        if(isViewAttached()){
                            getView().showContent();
                            KLog.e(TAG,response.body().toString());
//                        moreLists.addAll(lists);
                            getView().responsePendingTreatData(lists);

                        }

                    }else{
                        getView().showEmpty();
                    }

                }
            }


            @Override
            public void onFailure(Call<PendingTreatResBean> call, Throwable t) {
                if(isViewAttached()){
                    KLog.e("t="+t.toString());
                    KLog.e("---onFailure---");
                    getView().showError(t);
                }
            }
        });

    }


    @Override
    public void start() {

    }
}
