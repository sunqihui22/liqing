package com.shtoone.liqing.mvp.presenter.others;


import android.text.TextUtils;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.others.LoginContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.shtoone.liqing.utils.AESCryptUtils;
import com.shtoone.liqing.utils.SharedPreferencesUtils;
import com.socks.library.KLog;

import java.security.GeneralSecurityException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author：leguang on 2016/10/14 0014 13:17
 * Email：langmanleguang@qq.com
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

        private static final String TAG = LoginPresenter.class.getSimpleName();
        private UserInfoBean mUserInfoBean;

        public LoginPresenter(LoginContract.View mView) {
            super(mView);
        }

        @Override
        public void login(String username, String password) {
            String encryptRegisterCode = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.REGISTER_CODE, "");

            //进行解密
//            if (TextUtils.isEmpty(encryptRegisterCode)) {
//                getView().setErrorMessage("注册码丢失，请重新注册");
//                return;
//            }
//
//            String registerCode = "";
//            try {
//                registerCode = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, encryptRegisterCode);
//            } catch (GeneralSecurityException e) {
//                e.printStackTrace();
//            }


            HttpHelper.getInstance().initService().login(username, password, Constants.OSTYPE).enqueue(new Callback<UserInfoBean>() {
                @Override
                public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
                    if (response.isSuccessful()) {
                        if (response.body().isSuccess()) {
                            BaseApplication.mUserInfoBean = mUserInfoBean = response.body();
                            KLog.e(TAG+mUserInfoBean);
                            BaseApplication.parametersData.biaoshiid=BaseApplication.mUserInfoBean.getBiaoshi();
                            BaseApplication.parametersData.userType=BaseApplication.mUserInfoBean.getUserType();

                            BaseApplication.mDepartmentData.departmentID=BaseApplication.mUserInfoBean.getBiaoshi();
                            BaseApplication.mDepartmentData.departtype=BaseApplication.mUserInfoBean.getUserType();

//                            BaseApplication.mDepartmentData.departmentName = mUserInfoBean.get();
//                            BaseApplication.mDepartmentData.departmentID=mUserInfoBean.getDepartId();
//                            KLog.e(TAG+":"+BaseApplication.mDepartmentData.departmentName );
                            getView().savaData(mUserInfoBean);
                            getView().setSuccessMessage();
                            getView().go2Main();
                        } else {
                            getView().setErrorMessage("用户名或密码错误");
                        }
                    } else {
                        getView().setErrorMessage("服务器异常");
                    }
                }

                @Override
                public void onFailure(Call<UserInfoBean> call, Throwable t) {
                    if (getView() != null) {
                        getView().showError(t);

                    }
                }
            });
        }

        @Override
        public void start() {

        }
}


