package com.shtoone.liqing.mvp.model;

import com.shtoone.liqing.mvp.model.bean.CheckUpdateBean;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountRes;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountResData;
import com.shtoone.liqing.mvp.model.bean.EquipmentData;
import com.shtoone.liqing.mvp.model.bean.LaboratoryData;
import com.shtoone.liqing.mvp.model.bean.MarshallWhenDingDuData;
import com.shtoone.liqing.mvp.model.bean.MarshallWhenDingDuXqData;
import com.shtoone.liqing.mvp.model.bean.MaterialUsageRes;
import com.shtoone.liqing.mvp.model.bean.OrganizationFragmentBean;
import com.shtoone.liqing.mvp.model.bean.PendingTreatDetailRes;
import com.shtoone.liqing.mvp.model.bean.PendingTreatResBean;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentResponse;
import com.shtoone.liqing.mvp.model.bean.ProduceDataDetailRes;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryRes;
import com.shtoone.liqing.mvp.model.bean.RegisterBean;
import com.shtoone.liqing.mvp.model.bean.RuanHuaDianData;
import com.shtoone.liqing.mvp.model.bean.RuanHuaDianXqData;
import com.shtoone.liqing.mvp.model.bean.TotalAmountRes;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.shtoone.liqing.mvp.model.bean.ZhenRuDuData;
import com.shtoone.liqing.mvp.model.bean.ZhenRuDuXqData;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
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
    @GET("app.do?AppLogin")
    Call<UserInfoBean> login(@Query("userName") String userName, @Query("userPwd") String userPwd, @Query("OSType") String OSType);


    //注册
    @GET("app.do?appRegister")
    Observable<RegisterBean> register(@Query("machineCode") String machineCode, @Query("phoneBrand") String phoneBrand, @Query("phoneSysVersion") String phoneSysVersion, @Query("phoneModel") String phoneModel);

    //更新检测
    @GET("app.do?checkUpdate")
    Call<CheckUpdateBean> checkUpdate();

    //马歇尔
    @GET("maxieerChaXun?")
    Call<MarshallWhenDingDuData> requestMarshall(@Query("biaoduanid") String biaoduanid, @Query("F_SBBH") String F_SBBH, @Query("pageNo") String pageNo, @Query("tartTime") String tartTime, @Query("endTime") String endTime, @Query("isQualified") String isQualified);


    //马歇尔详情
    @GET("maxieerXX?")
    Call<MarshallWhenDingDuXqData> reuesetMarshallXq(@Query("F_GUID") String F_GUID);


    //软化点
    @GET("ruanhuadianChaXun?")
    Call<RuanHuaDianData> requestRuanHuaDian(@Query("biaoduanid") String biaoduanid, @Query("F_SBBH") String F_SBBH, @Query("pageNo") String pageNo, @Query("tartTime") String tartTime, @Query("endTime") String endTime, @Query("isQualified") String isQualified);


    //软化点详情
    @GET("ruanhuadianXX?")
    Call<RuanHuaDianXqData> reuesetRuanHuaDianXq(@Query("F_GUID") String F_GUID);


    //针入度
    @GET("zhenruduChaXun?")
    Call<ZhenRuDuData> requestZhenRuDu(@Query("biaoduanid") String biaoduanid, @Query("F_SBBH") String F_SBBH, @Query("pageNo") String pageNo, @Query("tartTime") String tartTime, @Query("endTime") String endTime, @Query("isQualified") String isQualified);


    //针入度详情
    @GET("zhenruduXX?")
    Call<ZhenRuDuXqData> reuesetZhenRuDuXq(@Query("F_GUID") String F_GUID);


    //延度
    @GET("yanduChaXun?")
    Call<ZhenRuDuData> requestYanDu(@Query("biaoduanid") String biaoduanid, @Query("F_SBBH") String F_SBBH, @Query("pageNo") String pageNo, @Query("tartTime") String tartTime, @Query("endTime") String endTime, @Query("isQualified") String isQualified);

    @GET("shiyanshiMenu?")
    Call<LaboratoryData> requestLaboratory(@Query("biaoduanid") String biaoduanid);

    //注册
    @GET("app.do?AppDepartTree")
    Observable<OrganizationFragmentBean> requestOrganization(@Query("updateDepartTime") String updateDepartTime, @Query("funtype") String funtype, @Query("userGroupId") String userGroupId, @Query("type") String type);


    //获取设备列表
    @GET("lqSysController.do?getLqShebeiList")
    Call<EquipmentData> requestEquipment(@Query("userGroupId") String userGroupId);


    //待处置报警
    @GET("lqChaoBiaoChuZhiController.do?appLqChaobiaoList")
    Call<PendingTreatResBean> treatAlarm(@QueryMap Map<String,String> options);

    //沥青超标统计
    @GET("lqChaoBiaoController.do?lqChaoBiaoCount")
    Call<PitchFragmentResponse> totalCount(@Query("userGroupId") String userGroupId, @Query("startTime") String startTime,@Query("startTime") String endTime);

    //生产数据查询
    @GET("lqScsjcxController.do?getScsjcxList")
//    Call<ProduceDataQueryRes> producrDataQuery(@Query("userGroupId") String userGroupId,@Query("shebeibianhao") String shebeibianhao,@Query("startTime") String startTime,@Query("startTime") String endTime,@Query("pageNo") String pageNo,@Query("maxPageItems") String maxPageItems);
    Call<ProduceDataQueryRes> producrDataQuery(@QueryMap Map<String,String> options);

    //生产数据详情
    @GET("lqScsjcxController.do?getScsjcxDetail")
    Call<ProduceDataDetailRes> getProduceDataDetail(@Query("shebeibianhao") String shebeibianhao,@Query("bianhao") String bianhao);

    //日产量查询
    @GET("lqclDailyController.do?dayproducecount")
    Call<DayProduceAmountRes> getDayProduceAmount(@QueryMap Map<String,String> options);

    //待处置报警详情
    @GET("lqChaoBiaoChuZhiController.do?appLqChaobiaoDetail")
    Call<PendingTreatDetailRes> getPendingtreatDetail(@Query("shebeibianhao") String shebeibianhao,@Query("xxid") String xxid);

    //总产量统计
    @GET("lqSCcounController.do?allchangliangcount")
    Call<TotalAmountRes> getTotalAmount(@QueryMap Map<String,String> options);

    //材料用量查询
    @GET("lqSCcounController.do?materialcount")
    Call<MaterialUsageRes> getMaterialUsage(@QueryMap Map<String,String> options);

    //超标处置提交
    @Multipart
    @POST("lqChaoBiaoChuZhiController.do?appLqChaobiaoChuzhi")
    Observable<Object> uploadPendingTreatResult(@QueryMap Map<String,String> options,@Part MultipartBody.Part params);

    //日生产量详情
    @POST("lqclDailyController.do?dayproducecountadd")
    Call<Object> uploadDayAmountqueryDetail(@Query("data") String s);


}
