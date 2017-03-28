package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityData;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public interface WaterStabilityContract {

    interface View extends BaseContract.View {

        void  responseWaterStabilityData(WaterStabilityData waterStabilityData);
    }

    interface Presenter extends BaseContract.Presenter {


        void requestWaterStabilityData(String userType,String biaoduan,String startTime,String endTime,String shebeibianhao);
    }


}
