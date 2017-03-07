package com.shtoone.liqing.mvp.contract.laboratory;


import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.YanDuData;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public interface YanDuContract {

    interface View extends BaseContract.View {
        void responseYanDuData(List<YanDuData> mYanDuData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestYanDuData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }
}
