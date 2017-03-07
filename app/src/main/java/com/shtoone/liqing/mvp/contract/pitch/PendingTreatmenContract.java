package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PendingTreatRVListData;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/24.
 */
public interface PendingTreatmenContract {

    interface View extends BaseContract.View{

        void responsePendingTreatData(List<PendingTreatRVListData> pendingTreatDataListn);

    }

    interface Presenter extends BaseContract.Presenter{
        void getPendingTreatData(Map<String, String> options);
    }
}
