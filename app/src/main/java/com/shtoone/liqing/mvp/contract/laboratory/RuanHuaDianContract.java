package com.shtoone.liqing.mvp.contract.laboratory;


import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.RuanHuaDianData;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/11/24.
 */
public interface RuanHuaDianContract {
    interface View extends BaseContract.View {
        void responseRuanHuaDianData(List<RuanHuaDianData> mRuanHuaDianData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestRuanHuaDianData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }
}
