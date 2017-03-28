package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchProductqueryDetailDatas;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityProductionQueryDetailData;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/22.
 * Email：hengzwdhengzwd@qq.com
 */

public interface PitchProductQueryDetailContract {

    interface View extends BaseContract.View {

        void responseProductionQueryDetail(PitchProductqueryDetailDatas pitchProductqueryDetailData);

    }

    interface Presenter extends BaseContract.Presenter {

        void requestProductionQueryDetail(Map map);
    }

}
