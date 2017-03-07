package com.shtoone.liqing.mvp.contract.laboratory;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.LaboratoryData;

/**
 * Created by Administrator on 2016/11/17.
 */
public interface LaboratoryContract  {

        interface View extends BaseContract.View {
            void responseLaboratoryData(LaboratoryData mLaboratoryData);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestLaboratoryData(String biaoduanid);
    }
}
