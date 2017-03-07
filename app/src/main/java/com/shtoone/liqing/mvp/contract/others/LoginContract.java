package com.shtoone.liqing.mvp.contract.others;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public interface LoginContract {
    interface View extends BaseContract.View {
        void savaData(UserInfoBean mUserInfoBean);

        void setErrorMessage(String message);

        void setSuccessMessage();

        void go2Main();

    }

    interface Presenter extends BaseContract.Presenter {
        void login(String username, String password);
    }

}
