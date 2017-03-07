package com.shtoone.liqing.mvp.contract.laboratory;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.MarshallWhenDingDuXqData;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public interface MarshallWhenDingDuXqContract {

    interface View extends BaseContract.View {
        void responseMarshallWhenDingDuXqData(List<MarshallWhenDingDuXqData> mMarshallWhenDingDuXqData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestMarshallWhenDingDuXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }
}
