package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.TotalAmountItemData;
import com.shtoone.liqing.mvp.model.bean.TotalAmountRes;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/24.
 */
public interface TotalAmountContract {

    interface View extends BaseContract.View{
        void responseTotalAmount(List<TotalAmountItemData> totalAmountListData);
    }

    interface Presenter extends BaseContract.Presenter{
        void requestTotalAmount(Map<String, String> options);
    }
}
