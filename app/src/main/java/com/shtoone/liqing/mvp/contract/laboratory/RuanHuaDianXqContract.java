package com.shtoone.liqing.mvp.contract.laboratory;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.RuanHuaDianXqData;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/12/2.
 */
public interface RuanHuaDianXqContract {

    interface View extends BaseContract.View {
        void responseRuanHuaDianXqData(List<RuanHuaDianXqData> mRuanHuaDianXqData);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestRuanHuaDianXqData(String biaoduanid, String sbbh, String pagej, String startTime, String endTime, String isQualify);

    }
}
