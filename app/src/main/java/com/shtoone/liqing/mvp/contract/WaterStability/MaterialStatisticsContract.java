package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.MaterialStatisticsData;

/**
 * @author: Administrator
 * @time 2017-03-15 09:19
 * @email 770164810@qq.com
 */

public interface MaterialStatisticsContract {

    interface View extends BaseContract.View {
        void responseMaterialStatisticsData(MaterialStatisticsData waterStabilityData);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestMaterialStatisticsData(String departType, String biaoshiid, String startTime, String endTime, String shebeibianhao);
    }
}
