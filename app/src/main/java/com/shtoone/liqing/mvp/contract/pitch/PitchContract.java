package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentResponse;
import com.shtoone.liqing.mvp.model.bean.PitchfragmentResDataBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */
public interface PitchContract {

    interface View extends BaseContract.View{

        void responseTotalProductData(List<List<PitchfragmentResDataBean>> pitchFragmentResponseList);

    }

    interface Presenter extends BaseContract.Presenter{

        void requestTotalProductData(String userGroupId, String startTime, String endTime);
    }
}
