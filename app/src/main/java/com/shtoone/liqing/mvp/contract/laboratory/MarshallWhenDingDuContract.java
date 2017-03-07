package com.shtoone.liqing.mvp.contract.laboratory;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.MarshallWhenDingDuData;

import java.util.List;


/**
 * Created by gesangdianzi on 2016/11/24.
 */
public interface MarshallWhenDingDuContract {

    interface View extends BaseContract.View {
        void responseMarshallWhenDingDuData(List<MarshallWhenDingDuData> mMarshallWhenDingDuData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestMarshallWhenDingDuData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }

}
