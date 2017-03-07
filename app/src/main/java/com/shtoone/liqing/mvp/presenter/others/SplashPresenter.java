package com.shtoone.liqing.mvp.presenter.others;

import android.text.TextUtils;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.others.SplashContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.CheckUpdateBean;
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
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    private static final String TAG = SplashPresenter.class.getSimpleName();
    private UserInfoBean mUserInfoBean;


    public SplashPresenter(SplashContract.View mView) {
        super(mView);
    }

//    @Override
//    public void checkLogin() {
//        //调试的时候用
////        getView().go2Main();
//
//        String usernameEncrypted = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.USERNAME, "");
//        String passwordEncrypted = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.PASSWORD, "");
//        //String registerCodeEncrypted = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.REGISTER_CODE, "");
//        String userInfoEncrypted = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.USER_INFO_BEAN, "");
//
//        KLog.e("username加密从sp中:" + usernameEncrypted);
//        KLog.e("password加密从sp中:" + passwordEncrypted);
//       // KLog.e("registerCode加密从sp中:" + registerCodeEncrypted);
//
//        if (TextUtils.isEmpty(usernameEncrypted) || TextUtils.isEmpty(passwordEncrypted) || TextUtils.isEmpty(userInfoEncrypted)) {
//
//            getView().go2LoginOrGuide();
//            return;
//
//        } else {
//            //进行解密
//            String userInfo = "";
//            try {
//                userInfo = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, userInfoEncrypted);
//            } catch (GeneralSecurityException e) {
//                e.printStackTrace();
//                getView().go2LoginOrGuide();
//                return;
//            }
//
//            //后面下载会用到这个种的信息作为参数，所以提前加载到内存中。
//            BaseApplication.mUserInfoBean = new Gson().fromJson(userInfo, UserInfoBean.class);
//            getView().go2Main();
//        }
//
//        String username = "";
//        String password = "";
//
//        /**
//         * 不需要进行网络验证，所以只需判断本地是否存有用户名和密码即可。
//         */
////        try {
////            username = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, usernameEncrypted);
////            password = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, passwordEncrypted);
//////            registerCode = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, registerCodeEncrypted);
////        } catch (GeneralSecurityException e) {
////            e.printStackTrace();
////            getView().go2LoginOrGuide();
////            return;
////        }
////        KLog.e("username解密:" + username);
////        KLog.e("password解密:" + password);
//////        KLog.e("registerCode解密:" + registerCode);
////
////        HttpHelper.getInstance().initService().login(username, password, Constants.OSTYPE).enqueue(new Callback<UserInfoBean>() {
////            @Override
////            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
////                if (response.isSuccessful()) {
////                    if (response.body().getStatus() == 0) {
////                        BaseApplication.mUserInfoBean = mUserInfoBean = response.body();
////                        //进入管理层界面
////                        getView().go2Main();
////                    } else {
////                        getView().go2LoginOrGuide();
////                    }
////                }
////            }
////
////            @Override
////            public void onFailure(Call<UserInfoBean> call, Throwable t) {
////                getView().go2LoginOrGuide();
////            }
////        });
//    }



    @Override
    public void checkLogin() {
        //调试的时候用
//        getView().go2Main();

        String usernameEncrypted = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.USERNAME, "");
        String passwordEncrypted = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.PASSWORD, "");
//        String registerCodeEncrypted = (String) SharedPreferencesUtils.get(BaseApplication.mContext, Constants.REGISTER_CODE, "");

        KLog.e("username加密从sp中:" + usernameEncrypted);
        KLog.e("password加密从sp中:" + passwordEncrypted);
//        KLog.e("registerCode加密从sp中:" + registerCodeEncrypted);
        //进行解密
        String username = "";
        String password = "";
        String registerCode = "";
        if (TextUtils.isEmpty(usernameEncrypted) || TextUtils.isEmpty(passwordEncrypted)) {
            getView().go2LoginOrGuide();
            KLog.e("1111111111");
            return;
        }
        KLog.e("2222222222222");

        try {
            username = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, usernameEncrypted);
            password = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, passwordEncrypted);
//            registerCode = AESCryptUtils.decrypt(Constants.ENCRYPT_KEY, registerCodeEncrypted);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            getView().go2LoginOrGuide();
            return;
        }
        KLog.e("username解密:" + username);
        KLog.e("password解密:" + password);
        KLog.e("registerCode解密:" + registerCode);

        HttpHelper.getInstance().initService().login(username, password, Constants.OSTYPE).enqueue(new Callback<UserInfoBean>() {
            @Override
            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {

                        BaseApplication.mUserInfoBean = mUserInfoBean = response.body();
                        BaseApplication.parametersData.userGroupID=BaseApplication.mUserInfoBean.getDepartId();
                        BaseApplication.mDepartmentData.departmentName=mUserInfoBean.getDepartName();
                        BaseApplication.mDepartmentData.departmentID=mUserInfoBean.getDepartId();
                        //进入管理层界面
                        getView().go2Main();
                    } else {
                        getView().go2LoginOrGuide();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserInfoBean> call, Throwable t) {
                getView().go2LoginOrGuide();
            }
        });
    }



    @Override
    public void checkUpdate() {
        HttpHelper.getInstance().initService().checkUpdate().enqueue(new Callback<CheckUpdateBean>() {
            @Override
            public void onResponse(Call<CheckUpdateBean> call, Response<CheckUpdateBean> response) {
                if (getView() == null) {
                    return;
                }
                if (response.isSuccessful()) {
                    CheckUpdateBean mCheckUpdateBean = response.body();
                    if (mCheckUpdateBean.isSuccess()) {
//                        EventBus.getDefault().postSticky(mCheckUpdateBean.getUpdateInfo());
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckUpdateBean> call, Throwable t) {
                if (getView() == null) {
                    return;
                }
            }
        });
    }


    @Override
    public void start() {

    }

}
