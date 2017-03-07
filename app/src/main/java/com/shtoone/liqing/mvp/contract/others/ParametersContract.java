package com.shtoone.liqing.mvp.contract.others;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.EquipmentData;

/**
 * Created by gesangdianzi on 2016/12/7.
 */
public interface ParametersContract  {
    interface View extends BaseContract.View {

        void   responseEquipment(EquipmentData EquipmentData);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestEquipment(String userGroupId);

    }

}
