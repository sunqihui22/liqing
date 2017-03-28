package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityProductionQueryDetailData;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/21.
 * Email：hengzwdhengzwd@qq.com
 */

public interface WaterStabilityProductionQueryDetailContract extends BaseContract {

    interface View extends BaseContract.View {

        void responseProductionQueryDetail(WaterStabilityProductionQueryDetailData waterStabilityProductionQueryDetailData);

    }

    interface Presenter extends BaseContract.Presenter {

        void requestProductionQueryDetail(Map map);
    }
}
