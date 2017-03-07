package com.shtoone.liqing.mvp.contract.laboratory;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.YanDuXqData;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public interface YanDuXqContract {

    interface View extends BaseContract.View {
        void responseYanDuXqData(List<YanDuXqData> mYanDuXqData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestYanDuXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }
}
