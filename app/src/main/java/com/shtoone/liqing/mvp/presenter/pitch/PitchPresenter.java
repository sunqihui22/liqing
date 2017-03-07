package com.shtoone.liqing.mvp.presenter.pitch;

import com.shtoone.liqing.mvp.contract.pitch.PitchContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentResponse;
import com.shtoone.liqing.mvp.model.bean.PitchfragmentResDataBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/11/23.
 */
public class PitchPresenter extends BasePresenter<PitchContract.View>implements PitchContract.Presenter {

    private static final String TAG = PitchPresenter.class.getSimpleName();

//    private List<PitchFragmentResponse> pitchFragmentResList=new ArrayList<>();
    private List<PitchfragmentResDataBean> pitchFragmentResDataList=new ArrayList<>();
    private PitchFragmentResponse pitchFragmentResponse;
    private PitchFragmentResponse pitchFragmentRes=new PitchFragmentResponse();
    private List<List<PitchfragmentResDataBean>> pitchFragmentResponseList;

    public PitchPresenter(PitchContract.View mView) {
        super(mView);
    }


    public void requestTotalProductData(String userGroupId, String startTime, String endTime) {

        HttpHelper.getInstance().initService().totalCount(userGroupId,startTime,endTime).enqueue(new Callback<PitchFragmentResponse>() {
            @Override
            public void onResponse(Call<PitchFragmentResponse> call, Response<PitchFragmentResponse> response) {
                if(response.isSuccessful()){
                    KLog.e("---isSuccessful---");
                    if(response.body().isSuccess()){
                        KLog.e("---isSuccess---");
                        pitchFragmentResponseList=new ArrayList<>();
                        pitchFragmentResponse = response.body();
                        List<List<PitchfragmentResDataBean>> pitchFragmentResponseData = pitchFragmentResponse.getData();
                        KLog.e("pitchFragmentResponseData=:"+pitchFragmentResponseData.toString());
                        for(int i=0;i<pitchFragmentResponseData.size();i++){
                            List<PitchfragmentResDataBean> pitchfragmentResDataBeanList = pitchFragmentResponseData.get(i);
                            for(int j=0;j<pitchfragmentResDataBeanList.size();j++){
                                PitchfragmentResDataBean pitchfragmentResDataBean = pitchfragmentResDataBeanList.get(j);
                                pitchfragmentResDataBean.setChangliang(pitchfragmentResDataBean.getChangliang());
                                pitchfragmentResDataBean.setBanhezhanminchen(pitchfragmentResDataBean.getBanhezhanminchen());
                                pitchfragmentResDataBean.setCblv(pitchfragmentResDataBean.getCblv());
                                pitchfragmentResDataBean.setCbps(pitchfragmentResDataBean.getCbps());
                                pitchfragmentResDataBean.setDengji(pitchfragmentResDataBean.getDengji());
                                pitchfragmentResDataBean.setDeptId(pitchfragmentResDataBean.getDeptName());
                                pitchfragmentResDataBean.setPanshu(pitchfragmentResDataBean.getPanshu());
                                pitchfragmentResDataBean.setReallv(pitchfragmentResDataBean.getReallv());
                                pitchfragmentResDataBean.setShebeibianhao(pitchfragmentResDataBean.getShebeibianhao());
                                pitchfragmentResDataBean.setBhzCount(pitchfragmentResDataBean.getBhzCount());
                                pitchfragmentResDataBean.setBhjCount(pitchfragmentResDataBean.getBhjCount());
                                pitchFragmentResDataList.add(pitchfragmentResDataBean);
                                KLog.e(TAG,pitchFragmentResDataList.toString());
                                KLog.e("---pitchfragmentResDataBeanList---");

                            }
                            if(isViewAttached()){
                                pitchFragmentResponseList.add(pitchFragmentResDataList);
                                KLog.e(TAG,pitchFragmentResponseList.toString());
                                getView().responseTotalProductData(pitchFragmentResponseList);
                            }
                        }
                    }else{
                        if(isViewAttached()){
                            getView().showEmpty();
                        }
                    }




                }
            }

            @Override
            public void onFailure(Call<PitchFragmentResponse> call, Throwable t) {
                if(null!=getView()){
                    KLog.e("---onFailure---");
                    KLog.e("t=:"+t.toString());
                    getView().showError(t);
                }
            }
        });

    }


    @Override
    public void start() {

    }
}
