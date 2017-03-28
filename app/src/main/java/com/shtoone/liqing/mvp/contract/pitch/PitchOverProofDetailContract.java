package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/17.
 * Email：hengzwdhengzwd@qq.com
 */

public interface PitchOverProofDetailContract {

    interface View extends BaseContract.View {
        void  responseOverProofData(PitchOverProofDetailsBean pitchOverProofDetailsBean);

    }

    interface Presenter extends BaseContract.Presenter {
        void requestOverProofData(Map<String, String> map);

    }
}
