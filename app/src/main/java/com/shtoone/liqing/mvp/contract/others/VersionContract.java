package com.shtoone.liqing.mvp.contract.others;


import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.CheckUpdateBean;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public interface VersionContract {
    interface View extends BaseContract.View {
        void setErrorMessage(String message);

        void showForceUpdateDialog(CheckUpdateBean.UpdateInfoBean mUpdateInfoBean);

        void showUpdateDialog(CheckUpdateBean.UpdateInfoBean mUpdateInfoBean);
    }

    interface Presenter extends BaseContract.Presenter {

        void checkUpdate();
    }


}
