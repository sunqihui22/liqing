package com.shtoone.liqing.common;

import android.app.NotificationManager;
import android.telephony.TelephonyManager;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.mvp.view.pitch.PitchProductQueryFragment;
import com.shtoone.liqing.utils.DirectoryUtils;

import java.io.File;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class Constants {

    /**
     * 不允许new
     */
    private Constants() {
        throw new Error("Do not need instantiate!");
    }

    //SD卡路径
    public static final String PATH_DATA = DirectoryUtils.getDiskCacheDirectory(BaseApplication.mContext, "data").getAbsolutePath();
    public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";
    public static final String PATH_NET_CACHE = PATH_DATA + File.separator + "NetCache";
    public static final String PATH_APK_CACHE = PATH_DATA + File.separator + "ApkCache";



    //基地址
    public static final String BASE_URL = "http://192.168.11.123:8080/jbgsmss/";


    //登录地址
    public static final String LOGIN_URL = BASE_URL + "app.do?AppLogin&userName=%1&userPwd=%2&OSType=3";

    public static final String DOMAIN_1 = "shtoone.com";
    public static final String DOMAIN_2 = "sh-toone";
    public static final String ISFIRSTENTRY = "is_first_entry";
    public static final String ISFIRSTGUIDE = "is_first_guide";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static final String USER_INFO_BEAN = "user_info_bean";
    public static final int DEFAULT_TIMEOUT = 5;

    public static final String USER_ID = "user_id";

    public static final String REGISTER_CODE = "register_code";


    //作为登录的参数，固定这个写法
    public static final String OSTYPE = "2";
    public static final String PRESS_AGAIN = "再按一次退出";
    public static final String ENCRYPT_KEY = "leguang";

    public static final String PARAMETERS = "parameters";
    public static final String USERGROUPID = "usergroupid";
    public static final String DEPARTMENT = "department";


    public static final String ABOUTAPP = "http://note.youdao.com/share/?id=37e5d8602c49af15d7589d7f91bd548b&type=note";
    public static final String ABOUTCOMPANY = "http://en.ccccltd.cn/ccccltd/";

    //检测App升级
    public static final int CHECKUPDATE = 0;


    public static final int FROM_SPLASH = 0;
    public static final int FROM_MAIN = 1;
    public static final int FROM_GUIDE = 2;

    //paramentData 的fromto


    public static final int PITCHFRAGMENT = 9;
    public static final int PENDINGTREATMENTFRAGMENT = 12;
    public static final int  PITCHDAYPROCTFRAGMENT=13;
    public static final int PRODUCTQUERYFRAGMENT = 14;
    public static final int TOTALAMOUNTFRAGMENT = 15;
    public static final int PITCHPRODUCTQUERYFRAGMENT = 16;

    public static final int TOTALAMOUNTSTATISTICFRAGMENT = 23;


    public static final int  WATERSTABILITYFRAGMENT=24;
    public static final int  WATERSTABILITYOVERPROOFFRAGMENT=25;
    public static final int  PITCHOVERPROOFFRAGMENT=26;

    public static final int  MaterialStatisticsFragment=27;
    public static final int PitchMaterialStatisticsFragment=29;
    public static final int  WATERSTABILITYPRODUCTIONQUERYFRAGMENT=28;





    public static final String ABOUTWHAT = "aboutwhat";
    public static final String FROM_TO = "from_to";

    //departmentData的funtype
    public static final String SHIYANSHI = "3";
    public static final String LIQINGBHZ = "2";


    public static final int CAMERA = 1;
    public static final int ALBUM = 2;


    public static final int REFRESH = 11;

    //EventBus系列,值是随便取，只要不相同即可
    public static final int EVENT_FINISH_LAUNCH = 10;

    public static final int VISIBLE_THRESHOLD = 3;

    public static final int PAGE_SIZE = 1;

    public static final int PEND_SIZE = 10;

    //类型模块
    public  static final String  TYPE_WATERSTABILITY = "6";
    public  static final String  TYPE_PITCH="2";



   // 组织机构类型
    public  static final  String  DEPARTTYPE_OWNER="1";
    public  static final  String  DEPARTTYPE_SECTION="2";

    public  static final  String  DEPARTTYPE_PROJECT="3";

    public  static final  String  DEPARTTYPE_BHZ="5";


}
