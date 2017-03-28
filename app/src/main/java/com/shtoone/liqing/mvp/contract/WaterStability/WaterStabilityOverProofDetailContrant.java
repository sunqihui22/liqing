package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/15.
 * Email：hengzwdhengzwd@qq.com
 */

public interface WaterStabilityOverProofDetailContrant extends BaseContract {

    interface View extends BaseContract.View {

        void  responseOverProofData(WaterStabilityOverProofDetailsBean waterStabilityOverProofDetailsBean);

    }

    interface Presenter extends BaseContract.Presenter {

        void requestOverProofData(Map<String, String> map);
    }
}
