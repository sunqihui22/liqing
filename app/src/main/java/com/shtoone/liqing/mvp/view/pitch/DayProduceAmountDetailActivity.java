package com.shtoone.liqing.mvp.view.pitch;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.pitch.DayProduceAmountetailContract;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountResData;
import com.shtoone.liqing.mvp.presenter.pitch.DayProduceAmountetailPresenter;
import com.shtoone.liqing.mvp.view.base.BaseActivity;
import com.shtoone.liqing.utils.ToastUtils;
import com.socks.library.KLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/23.
 */
public class DayProduceAmountDetailActivity extends BaseActivity<DayProduceAmountetailContract.Presenter> implements DayProduceAmountetailContract.View {

    private static final String TAG = DayProduceAmountDetailActivity.class.getSimpleName();

    @BindView(R.id.til_date)
    TextInputLayout tilDate;
    @BindView(R.id.til_caijichanliang)
    TextInputLayout tilCaijichanliang;
    @BindView(R.id.til_panshu)
    TextInputLayout tilPanshu;
    @BindView(R.id.til_xiuzhengchanliang)
    TextInputLayout tilXiuzhengchanliang;
    @BindView(R.id.til_biaozhunmidu)
    TextInputLayout tilBiaozhunmidu;
    @BindView(R.id.til_shigongzhuanghao)
    TextInputLayout tilShigongzhuanghao;
    @BindView(R.id.til_changdu)
    TextInputLayout tilChangdu;
    @BindView(R.id.til_kuandu)
    TextInputLayout tilKuandu;
    @BindView(R.id.til_houdu)
    TextInputLayout tilHoudu;
    @BindView(R.id.til_shejihoudu)
    TextInputLayout tilShejihoudu;
    @BindView(R.id.til_xinghao)
    TextInputLayout tilXinghao;
    @BindView(R.id.til_beizhu)
    TextInputLayout tilBeizhu;
    @BindView(R.id.bt_Calculation)
    Button btCalculation;
    @BindView(R.id.bt_submit)
    Button btSubmit;
    @BindView(R.id.bt_cancel)
    Button btCancel;
    DayProduceAmountResData dayProduceAmountResData;
    private ProgressDialog mypDialog;
    private Toolbar mToolbar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected DayProduceAmountetailContract.Presenter createPresenter() {
        return new DayProduceAmountetailPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_produce_query_detail);
        ButterKnife.bind(this);
        initView();
        initData();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mypDialog = new ProgressDialog(this);
        tilDate.getEditText().setInputType(InputType.TYPE_NULL);
        tilCaijichanliang.getEditText().setInputType(InputType.TYPE_NULL);
        tilPanshu.getEditText().setInputType(InputType.TYPE_NULL);
        tilHoudu.getEditText().setInputType(InputType.TYPE_NULL);
        tilHoudu.getEditText().setFocusable(false);
    }

    private void initData() {
        initStateBar(mToolbar);
        initToolbarBackNavigation(mToolbar);
//        mToolbar.setTitle(R.string.day_product_query_detail);
        setToolbarTitle();
        //将上体Activity中的DATA传送到This
        dayProduceAmountResData = (DayProduceAmountResData) getIntent().getSerializableExtra("dayamountdetail");
        showView(dayProduceAmountResData);

    }


    private void showView(DayProduceAmountResData data) {
        // 日期
        tilDate.getEditText().setText(data
                .getDailyrq());
        // 施工桩号
        tilShigongzhuanghao.getEditText()
                .setText(data.getDailybuwei());
        // 采集产量
        tilCaijichanliang.getEditText()
                .setText(data.getDailycl());
        // 修正产量
        tilXiuzhengchanliang.getEditText()
                .setText(data.getDailyxzcl());
        // 标准密度
        tilBiaozhunmidu.getEditText()
                .setText(data.getDailymd());
        // 长度
        tilChangdu.getEditText()
                .setText(data.getDailycd());
        // 宽度
        tilKuandu.getEditText()
                .setText(data.getDailykd());
        // 厚度
        tilHoudu.getEditText().setText(data
                .getDailyhd());
        // 设计厚度
        tilShejihoudu.getEditText()
                .setText(data.getDailysjhd());

        // 型号
        tilXinghao.getEditText()
                .setText(data.getDailyxh());
        // 备注
        tilBeizhu.getEditText().setText(data.getDailybeizhu());
        //盘数
        tilPanshu.getEditText().setText(data.getDailyps());
    }

    //定义计算hd的方法
    protected double setText() {

        double kd = Double.parseDouble(tilKuandu.getEditText().getText()
                .toString().trim());
        double chd = Double.parseDouble(tilChangdu.getEditText().getText()
                .toString().trim());
        double md = Double.parseDouble(tilBiaozhunmidu.getEditText().getText()
                .toString().trim());
        double xzcl = Double.parseDouble(tilXiuzhengchanliang.getEditText().getText()
                .toString().trim());
        double cjcl = Double.parseDouble(tilCaijichanliang.getEditText().getText()
                .toString().trim());
        return ((xzcl + cjcl) / (kd * chd * md)) * 100;

    }

    @OnClick({R.id.bt_Calculation, R.id.bt_submit, R.id.bt_cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_Calculation:
                // 宽度必须输入
                KLog.e("按了:" + "jisuan");
                if ("".equals(tilKuandu.getEditText().getText().toString()//判断输入是否为空，若为空则弹出对话框
                        .trim())) {
                    Toast.makeText(this,//对话框
                            "宽度必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 长度必须输入
                if ("".equals(tilChangdu.getEditText().getText().toString()
                        .trim())) {
                    Toast.makeText(this,
                            "长度必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 密度必须输入
                if ("".equals(tilBiaozhunmidu.getEditText().getText()
                        .toString().trim())) {
                    Toast.makeText(this,//对话框
                            "密度必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 修正产量必须输入
                if ("".equals(tilXiuzhengchanliang.getEditText().getText()
                        .toString().trim())) {
                    Toast.makeText(this,
                            "修正产量必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }

                setProgressDialog();

                //调用setText()
                double hd = setText();
                String sc_richanliang_xq_houdu = String
                        .valueOf(new DecimalFormat("0.00").format(hd));//厚度值保留两位小数
                tilHoudu.getEditText().setText(sc_richanliang_xq_houdu);
                mypDialog.dismiss();
                Toast.makeText(this, "计算完成.", Toast.LENGTH_SHORT).show();
                KLog.e(TAG, "---bt_Calculation---");
                break;
            case R.id.bt_submit:
                KLog.e(TAG, "---bt_submit---pre---");
                // 宽度必须输入
                if ("".equals(tilKuandu.getEditText().getText().toString()//判断输入是否为空，若为空则弹出对话框
                        .trim())) {
                    Toast.makeText(this,//对话框
                            "宽度必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 长度必须输入
                if ("".equals(tilChangdu.getEditText().getText().toString()
                        .trim())) {
                    Toast.makeText(this,
                            "长度必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 密度必须输入
                if ("".equals(tilBiaozhunmidu.getEditText().getText()
                        .toString().trim())) {
                    Toast.makeText(this,//对话框
                            "密度必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 修正产量必须输入
                if ("".equals(tilXiuzhengchanliang.getEditText().getText()
                        .toString().trim())) {
                    Toast.makeText(this,
                            "修正产量必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 设计厚度必须输入
                if ("".equals(tilShejihoudu.getEditText().getText().toString()
                        .trim())) {
                    Toast.makeText(this,
                            "设计厚度必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 施工桩号必须输入
                if ("".equals(tilShigongzhuanghao.getEditText().getText()
                        .toString().trim())) {
                    Toast.makeText(this, "施工桩号必须输入", Toast.LENGTH_SHORT).show();
                    return;
                }
                postData();
                Toast.makeText(this, "提交中……", Toast.LENGTH_SHORT).show();
                KLog.e(TAG, "---bt_submit---next---");
                break;
            case R.id.bt_cancel:

                //点击放弃按钮输入项全部清空
                tilKuandu.getEditText().setText("");
                tilBiaozhunmidu.getEditText().setText("");
                tilChangdu.getEditText().setText("");
                tilXiuzhengchanliang.getEditText().setText("");
                tilShejihoudu.getEditText().setText("");
                tilHoudu.getEditText().setText("");
                tilShigongzhuanghao.getEditText().setText("");
                tilXinghao.getEditText().setText("");
                tilBeizhu.getEditText().setText("");
//                setResult(1);//返回上一界面
//                finish();
                break;
        }
    }


    public void postData() {

        KLog.e(TAG, "---postData---pre---");
        double hd = setText();//调用setText()，并对其做小数保留
        String houdu = String.valueOf(new DecimalFormat("#.00").format(hd));
        JSONObject data = new JSONObject();
//        data.setDailybeizhu(tilBeizhu.getEditText().getText().toString().trim());
//        data.setDailybuwei(tilShigongzhuanghao.getEditText().getText().toString().trim());
//        data.setDailycd(tilChangdu.getEditText().getText().toString().trim());
//        data.setDailycl(tilCaijichanliang.getEditText().getText().toString().trim());
//        data.setDailyhd(houdu);
//        data.setDailyid(data.getDailyid());
//        data.setDailykd(tilKuandu.getEditText().getText().toString().trim());
//        data.setDailymd(tilBiaozhunmidu.getEditText().getText().toString().trim());
//        data.setDailyps(tilPanshu.getEditText().getText().toString().trim());
//        data.setDailyrq(tilDate.getEditText().getText().toString().trim());
//        data.setDailysbbh(data.getDailysbbh());
//        data.setDailysjhd(tilShejihoudu.getEditText().getText().toString().trim());
//        data.setDailyxh(tilXinghao.getEditText().getText().toString().trim());
//        data.setDailyxzcl(tilXiuzhengchanliang.getEditText().getText().toString().trim());

        try {
            data.put("dailybeizhu", tilBeizhu.getEditText().getText().toString().trim());
            // obj.put("JSONObject", "");
            data.put("dailybuwei", tilShigongzhuanghao.getEditText().getText().toString().trim());
            // obj.put("dailycd","519" );
            data.put("dailycd", tilChangdu.getEditText().getText().toString().trim());
            data.put("dailycl", tilCaijichanliang.getEditText().getText().toString().trim());
            data.put("dailyhd", houdu);
            data.put("dailyid", dayProduceAmountResData.getDailyid());

            data.put("dailykd", tilKuandu.getEditText().getText().toString().trim());
            // obj.put("dailykd","11.52");
            data.put("dailymd", tilBiaozhunmidu.getEditText().getText().toString().trim());
            // obj.put("dailymd", "2412");
            data.put("dailyps", tilPanshu.getEditText().getText().toString().trim());
            data.put("dailyrq", tilDate.getEditText().getText().toString().trim());
            data.put("dailysbbh", dayProduceAmountResData.getDailysbbh());

            data.put("dailysjhd", tilShejihoudu.getEditText().getText().toString().trim());
            // obj.put("dailysjhd", "7");
            data.put("dailyxh", tilXinghao.getEditText().getText().toString().trim());
            data.put("dailyxzcl", tilXiuzhengchanliang.getEditText().getText().toString().trim());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        String s=data.toString();
        KLog.e("s="+s);
//           String s = options.toString();
//        Gson gson = new Gson();
//
//        KLog.e(TAG, s.toString());//        String s = gson.toJson(data);


        mPresenter.uploadDayAmountDetail(s);

        KLog.e(TAG, "---postData---next---");

    }

    private void setProgressDialog() {
        mypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mypDialog.setMessage("计算中,请稍后...");
        mypDialog.setIndeterminate(false);
        mypDialog.setCancelable(false);
        mypDialog.setCanceledOnTouchOutside(false);
        mypDialog.show();
    }


    public void uploaded(String text, int tag) {
        KLog.e(TAG, "---uploaded---");
        ToastUtils.showToast(BaseApplication.mContext, text);
        setResult(tag);
        finish();
    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable t) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }



    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.liqing) + " > ");
            sb.append(getString(R.string.day_product_query_detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }

}
