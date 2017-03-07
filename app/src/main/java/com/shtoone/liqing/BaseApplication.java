package com.shtoone.liqing;

import android.app.Application;
import android.content.Context;

import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.squareup.otto.Bus;


/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class BaseApplication extends Application {

    private static final String TAG = BaseApplication.class.getSimpleName();
    public static Context mContext;
    public static UserInfoBean mUserInfoBean;
    public static final Bus bus = new Bus();
    public static ParametersData parametersData = new ParametersData();
    public static DepartmentBean mDepartmentData = new DepartmentBean();

    public static boolean isExpand;

    @Override
    public void onCreate() {
        super.onCreate();
        //日志的开关和全局标签初始化
    //    KLog.init(false, "SHTW沥青");
        mContext = this;
        // 程序异常交由AppExceptionHandler来处理
//        Thread.setDefaultUncaughtExceptionHandler(AppExceptionHandler.getInstance(this));
    }
}
