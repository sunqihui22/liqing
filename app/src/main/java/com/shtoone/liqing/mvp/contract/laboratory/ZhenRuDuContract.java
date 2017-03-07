package com.shtoone.liqing.mvp.contract.laboratory;


import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.ZhenRuDuData;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public interface ZhenRuDuContract {

    interface View extends BaseContract.View {
        void responseZhenRuDuData(List<ZhenRuDuData> mZhenRuDuData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestZhenRuDuData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }
}
