package com.shtoone.liqing.mvp.contract.base;

import com.shtoone.liqing.mvp.model.bean.SC_cailiaoyongliang;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface MaterialUsageContract {


    interface View extends BaseContract.View{
        void responseMaterialUsage(List<SC_cailiaoyongliang> datas);
    }

    interface Presenter extends BaseContract.Presenter{
        void requestMaterialUsage(Map<String, String> options);
    }
}
