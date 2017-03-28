package com.shtoone.liqing.mvp.contract.others;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.EquipmentData;

import java.util.List;
import java.util.Map;

/**
 * Created by gesangdianzi on 2016/12/7.
 */
public interface ParametersContract  {
    interface View extends BaseContract.View {

        void   responseEquipment(EquipmentData EquipmentData);
        void responsePositons(List<String> responses);
        void responseModels(List<String> responses);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestEquipment(String biaoshiid,String userType ,String machineType);

        void requestModel();
        void requesstPositions(Map<String,String> map );
    }

}
