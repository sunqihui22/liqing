package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryRes;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryResData;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface ProduceDataQueryContract {

    interface View extends BaseContract.View{
        void responseProduceData(List<ProduceDataQueryResData> produceDataQueryResData);
    }

    interface Presenter extends BaseContract.Presenter{
        void requestProduceData(Map<String, String> options);
    }
}
