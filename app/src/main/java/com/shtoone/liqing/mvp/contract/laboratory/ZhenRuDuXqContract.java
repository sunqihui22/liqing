package com.shtoone.liqing.mvp.contract.laboratory;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.ZhenRuDuXqData;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public interface ZhenRuDuXqContract {


    interface View extends BaseContract.View {
        void responseZhenRuDuXqData(List<ZhenRuDuXqData> mZhenRuDuXqData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestZhenRuDuXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }
}


