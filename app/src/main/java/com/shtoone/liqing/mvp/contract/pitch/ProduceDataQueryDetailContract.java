package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.ProduceDataDetailRes;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq;

/**
 * Created by Administrator on 2016/12/14.
 */
public interface ProduceDataQueryDetailContract {

    interface View extends BaseContract.View{
        void responseProduceDataDetail(SC_chaxunItem_xq xqData,ProduceDataDetailRes produceDataDetailRes);
    }

    interface Presenter extends BaseContract.Presenter{
        void getProduceDataDetail(String shebeibianhao,String bianhao);

    }
}
