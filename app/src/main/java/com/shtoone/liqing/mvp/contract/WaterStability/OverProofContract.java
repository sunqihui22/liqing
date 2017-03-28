package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public interface OverProofContract {

     interface  View extends BaseContract.View
     {
         void  showloadingMore();
         void  lodingMorecompleted();
         void showLoadMoreError(Throwable throwable);
         void  responseLoadMore(WaterStabilityOverProofBean mWaterStabilityOverProofBean);
         void responseWaterStabilityOverProofBean(WaterStabilityOverProofBean mWaterStabilityOverProofBean);
     }

    interface  Presenter extends  BaseContract.Presenter
    {
        void requestWaterStabilityOverProofBean(Map<String, String> map);

        void loadMoreData(Map<String, String> map);
    }
}
