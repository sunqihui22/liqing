package com.shtoone.liqing.mvp.contract.base;

import com.shtoone.liqing.mvp.model.bean.PendingTreatDetailRes;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2016/12/16.
 */
public interface PendingTreatDetailContract {

    interface View extends BaseContract.View{
        void responsePendingtreatDetail(SC_chaxunItem_xq xqData,PendingTreatDetailRes pendingTreatDetailRes);
        void uploaded(String text);
    }

    interface Presenter extends BaseContract.Presenter{
        void requestPendingtreatDetailData(String shebeibianhao,String xxid);
        void uploadTreatData(Map<String,String> options, MultipartBody.Part body);
    }
}
