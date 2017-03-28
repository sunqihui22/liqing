package com.shtoone.liqing.mvp.contract.WaterStability;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.ProductionDataQueryBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityHistoryData;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public interface ProductionDataQueryContract {


    interface View extends BaseContract.View {

        void  showloadingMore();
        void  lodingMorecompleted();
        void showLoadMoreError(Throwable throwable);
        void  responseLoadMore(WaterstabilityHistoryData waterstabilityHistoryData);
        void responseProductionDataQueryBean(WaterstabilityHistoryData waterstabilityHistoryData);
    }

    interface Presenter extends BaseContract.Presenter {


        void requestProductionDataQueryBean(Map<String,String> map);
        void loadMoreData(Map<String, String> map);
    }
}
