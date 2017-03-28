package com.shtoone.liqing.mvp.model;

import com.shtoone.liqing.mvp.model.bean.CheckUpdateBean;
import com.shtoone.liqing.mvp.model.bean.EquipmentData;
import com.shtoone.liqing.mvp.model.bean.MaterialStatisticsData;
import com.shtoone.liqing.mvp.model.bean.MaterialUsageRes;
import com.shtoone.liqing.mvp.model.bean.PitchDayProductQueryData;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentData;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofData;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.PitchProductQueryData;
import com.shtoone.liqing.mvp.model.bean.PitchProductqueryDetailDatas;
import com.shtoone.liqing.mvp.model.bean.PitchStatisticsData;
import com.shtoone.liqing.mvp.model.bean.ProductionDataQueryBean;
import com.shtoone.liqing.mvp.model.bean.RegisterBean;
import com.shtoone.liqing.mvp.model.bean.UploadResponseBean;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityData;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityProductionQueryDetailData;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityHistoryData;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityStatisticsBean;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public interface ApiService {

    //登录
    @GET("app/AppLogin?")
    Call<UserInfoBean> login(@Query("userName") String userName, @Query("userPwd") String userPwd, @Query("OSType") String OSType);


    //注册
    @GET("app.do?appRegister")
    Observable<RegisterBean> register(@Query("machineCode") String machineCode, @Query("phoneBrand") String phoneBrand, @Query("phoneSysVersion") String phoneSysVersion, @Query("phoneModel") String phoneModel);

    //更新检测
    @GET("app.do?checkUpdate")
    Call<CheckUpdateBean> checkUpdate();

    //沥青超标统计
    @GET("appLq/lqWarningStatistics?")
    Call<PitchFragmentData> totalCount(@Query("departType") String departType, @Query("biaoshiid") String biaoshiid, @Query("startTime") String startTime, @Query("endTime") String endTime, @Query("shebeibianhao") String shebeibianhao);

    //沥青超标详情
    @GET("appLq/lqchaoBiaoXQ?")
    Call<PitchOverProofDetailsBean> requestPitchOverProofDetail(@QueryMap Map<String, String> map);


    @GET("appLq/lqgallclList?")
    Call<PitchProductQueryData> requestPitchProductQueryData(@QueryMap Map<String, String> map);

    //材料用量查询
    @GET("lqSCcounController.do?materialcount")
    Call<MaterialUsageRes> getMaterialUsage(@QueryMap Map<String, String> options);

    //沥青超标处置提交
    @Multipart
    @POST("appLq/appLQChaobiaoChuzhi")
    Observable<UploadResponseBean> uploadPitchChuZhi(@QueryMap Map<String, String> options, @Part MultipartBody.Part params);

    //沥青超标审核提交
    @POST("appLq/appLqChaobiaoShenpi")
    Observable<UploadResponseBean> uploadPitchShenHe(@QueryMap Map<String, String> options);

    //沥青历史数据详情

    @GET("appLq/liqingxixx?")
    Call<PitchProductqueryDetailDatas>    requestProductQueryDetails(@QueryMap  Map<String, String> options);
    //沥青日生产查询
    @GET("appLq/lqdailylist?")
    Call<PitchDayProductQueryData> requestDayProductQuery(@QueryMap Map<String, String> map);

    //沥青获取超标查询的数据
    @GET("appLq/lqchaoBiaoList?")
    Call<PitchOverProofData> requestPitchOverProofData(@QueryMap Map<String, String> map);

    //沥青材料统计
    @GET("appLq/lqmaterial?")
    Call<PitchStatisticsData> requestPitchMaterialStatisticsData(@QueryMap Map<String, String> map);

    //水稳材料统计
    @GET("app/swmaterial?")
    Call<MaterialStatisticsData> requestMaterialStatisticsData(@Query("departType") String departType, @Query("biaoshiid") String biaoshiid, @Query("startTime") String startTime, @Query("endTime") String endTime, @Query("shebeibianhao") String shebeibianhao);

    //水稳超标统计
    @GET("app/warningStatistics?")
    Call<WaterStabilityData> requestWaterstabilityData(@Query("departType") String departType, @Query("biaoshiid") String biaoduan, @Query("startTime") String startTime, @Query("endTime") String endTime, @Query("shebeibianhao") String shebeibianhao);


    //组织机构
    @GET("app/departTree?")
    Call<ResponseBody> requestOrganization(@Query("biaoshiid") String userGroupId, @Query("userType") String type, @Query("modelType") String modelType);

    //获取设备列表
    @GET("app/machineList?")
    Call<EquipmentData> requestEquipment(@Query("departType") String departType, @Query("biaoshiid") String biaoshiid, @Query("machineType") String machineType);


    //获取型号列表
    @GET("appLq/usePosition")
    Call<ResponseBody> requestModels();


    //获取设备列表
    @GET(" app/usePosition")
    Call<ResponseBody> requestPostitions(@QueryMap Map<String, String> map);


    //水稳获取数据统计数据
    @GET()
    Call<WaterstabilityStatisticsBean> requestStatisticData(@QueryMap Map<String, String> map);

    //水稳获取超标查询的数据
    @GET("app/chaoBiaoList?")
    Call<WaterStabilityOverProofBean> requestOverProofData(@QueryMap Map<String, String> map);

    @GET("app/chaoBiaoXQ?")
    Call<WaterStabilityOverProofDetailsBean> requestOverProofDetail(@QueryMap Map<String, String> map);


    //水稳超标处置提交
    @Multipart
    @POST("app/appSWChaobiaoChuzhi")
    Observable<UploadResponseBean> uploadWaterstabilityChuZhi(@QueryMap Map<String, String> options, @Part MultipartBody.Part params);


    //水稳超标审核提交
    @POST("app/appHntChaobiaoShenpi")
    Observable<UploadResponseBean> uploadWaterstabilityShenHe(@QueryMap Map<String, String> options);


    @GET("app/appSwcllist?")
    Call<WaterstabilityHistoryData> requestWaterstabilityHistory(@QueryMap Map<String, String> map);


    //水稳历史数据详情
    @GET("app/appSwclXQ?")
    Call<WaterStabilityProductionQueryDetailData> requestProductionQueryDetail(@QueryMap Map<String, String> map);

}
