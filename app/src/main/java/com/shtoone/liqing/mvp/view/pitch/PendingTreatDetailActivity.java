package com.shtoone.liqing.mvp.view.pitch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.base.PendingTreatDetailContract;
import com.shtoone.liqing.mvp.model.bean.PendingTreatDetailRes;
import com.shtoone.liqing.mvp.model.bean.PendingTreatRVListData;
import com.shtoone.liqing.mvp.model.bean.SC_chaxunItem_xq;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.shtoone.liqing.mvp.presenter.base.PendingTreatDetailPresenter;
import com.shtoone.liqing.mvp.view.adapter.PendingTreatDetailActivityRecyclerViewAdapter;
import com.shtoone.liqing.mvp.view.base.BaseActivity;
import com.shtoone.liqing.utils.KeyBoardUtils;
import com.shtoone.liqing.utils.ToastUtils;
import com.shtoone.liqing.utils.URL;
import com.shtoone.liqing.widget.PageStateLayout;
import com.socks.library.KLog;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import in.srain.cube.views.ptr.PtrFrameLayout;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Administrator on 2016/12/16.
 */
public class PendingTreatDetailActivity extends BaseActivity<PendingTreatDetailContract.Presenter> implements PendingTreatDetailContract.View{

    private static final String TAG = PendingTreatDetailActivity.class.getSimpleName();
    private PendingTreatRVListData pendingTreatRVListData;

    private Toolbar mToolbar;
    private NestedScrollView mNestedScrollView;
    private PageStateLayout mPageStateLayout;
    private PtrFrameLayout mPtrFrameLayout;
    private TextView tv_date;
    private TextView tv_sjysb ;
    private TextView tv_llysb;
    private TextView tv_wcysb;
    private TextView tv_lqwd;
    private TextView tv_slwd;
    private TextView tv_clwd;
    private RecyclerView mRecyclerView;
    private ImageView iv_photo_select;
    private ImageView iv_camera_select;
    private ImageView iv_album_select;
    private TextInputLayout et_handle_person;
    private TextInputLayout et_handle_time;
    private TextInputLayout et_handle_reason;
    private TextInputLayout et_handle_way;
    private TextInputLayout et_handle_result;
    private Button bt_handle_submit;
    private Button bt_handle_reset;

    private LinearLayout ll_camera_album;
    private UserInfoBean mUserInfoBean;
    private String handlePerson;
    private String handleTime;
    private String handleReason;
    private String handleWay;
    private String handleResult;
    private Bitmap bitmap;

    int xxid;
    private PendingTreatRVListData mlistData;
    SC_chaxunItem_xq xqData = null;
    private PendingTreatDetailActivityRecyclerViewAdapter mAdapter;

    private String photoName;
    private String fileName;
    String shebeibianhao;

    @NonNull
    @Override
    protected PendingTreatDetailContract.Presenter createPresenter() {
        return new PendingTreatDetailPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendingtreat_detail);
        initView();
        initData();
        loadData();
    }

    private void initView() {

        mUserInfoBean = BaseApplication.mUserInfoBean;
        mlistData= (PendingTreatRVListData) getIntent().getSerializableExtra("pendingtreatdetail");
        xxid=mlistData.getBianhao();
        shebeibianhao = mlistData.getShebeibianhao();
        mToolbar = (Toolbar) findViewById(R.id.toolbar_toolbar);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nsv_produce_query_detail_activity);
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptr_produce_query_detail_activity);
        mPageStateLayout = (PageStateLayout) findViewById(R.id.psl_produce_query_detail_activity);
        tv_date = (TextView) this.findViewById(R.id.scchaxun_xq_date);
        tv_sjysb = (TextView) this.findViewById(R.id.scchaxun_xq_sjysb);
        tv_llysb = (TextView) this.findViewById(R.id.scchaxun_xq_llysb);
        tv_wcysb = (TextView) this.findViewById(R.id.scchaxun_xq_wcysb);
        tv_lqwd = (TextView) this.findViewById(R.id.scchaxun_xq_liqinwendu);
        tv_slwd = (TextView) this.findViewById(R.id.scchaxun_xq_shiliaowendu);
        tv_clwd = (TextView) this.findViewById(R.id.scchaxun_xq_chuliaowendu);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_produce_query_detail_activity);
        //处置部分
        iv_photo_select = (ImageView) findViewById(R.id.iv_photo_select_overproof_detail_activity);
        iv_camera_select = (ImageView) findViewById(R.id.iv_camera_select_overproof_detail_activity);
        iv_album_select = (ImageView) findViewById(R.id.iv_album_select_overproof_detail_activity);
        ll_camera_album = (LinearLayout) findViewById(R.id.ll_camera_album_overproof_detail_activity);
        et_handle_person = (TextInputLayout) findViewById(R.id.et_handle_person_overproof_detail_activity);
        et_handle_time = (TextInputLayout) findViewById(R.id.et_handle_time_overproof_detail_activity);
        et_handle_reason = (TextInputLayout) findViewById(R.id.et_handle_reason_overproof_detail_activity);
        et_handle_way = (TextInputLayout) findViewById(R.id.et_handle_way_overproof_detail_activity);
        et_handle_result = (TextInputLayout) findViewById(R.id.et_handle_result_overproof_detail_activity);

//        et_handle_person.getEditText().setInputType(InputType.TYPE_NULL);
//        et_handle_reason.getEditText().setInputType(InputType.TYPE_NULL);
//        et_handle_way.getEditText().setInputType(InputType.TYPE_NULL);
//        et_handle_result.getEditText().setInputType(InputType.TYPE_NULL);
        bt_handle_submit = (Button) findViewById(R.id.bt_handle_submit_overproof_detail_activity);
        bt_handle_reset = (Button) findViewById(R.id.bt_handle_reset_overproof_detail_activity);

    }

    private void initData() {

        SimpleDateFormat sDateFormat   =   new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss");
        String   date   =   sDateFormat.format(new Date());

        initStateBar(mToolbar);
        initToolbarBackNavigation(mToolbar);
//        mToolbar.setTitle(R.string.pendingtreat_detail);
        setToolbarTitle();
        xqData=new SC_chaxunItem_xq();
        //处置时间
        et_handle_time.getEditText().setText(date);
        et_handle_time.setEnabled(false);

        iv_photo_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = (ll_camera_album.getLeft() + view.getRight()) / 2;
                    int cy = (ll_camera_album.getTop() + view.getBottom()) / 2;
                    int radius = Math.max(view.getWidth(), ll_camera_album.getHeight());
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(ll_camera_album, cx, cy, 0, radius);
                    mAnimator.setDuration(500);
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.addListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            ll_camera_album.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            iv_photo_select.setVisibility(View.INVISIBLE);
                        }
                    });
                    mAnimator.start();
                } else {
                    iv_photo_select.setVisibility(View.GONE);
                    ll_camera_album.setVisibility(View.VISIBLE);
                }
            }
        });

        iv_camera_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, Constants.CAMERA);
            }
        });

        iv_album_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");// 相片类型
                startActivityForResult(intent, Constants.ALBUM);
            }
        });

        et_handle_reason.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    et_handle_reason.getEditText().setError("处置原因不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        et_handle_way.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    et_handle_way.getEditText().setError("处置方式不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        et_handle_result.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    et_handle_result.getEditText().setError("处置结果不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        bt_handle_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KeyBoardUtils.hideKeybord(view, PendingTreatDetailActivity.this);
                handlePerson = et_handle_person.getEditText().getText().toString().trim();
                handleTime = et_handle_time.getEditText().getText().toString().trim();
                handleReason = et_handle_reason.getEditText().getText().toString().trim();
                handleWay = et_handle_way.getEditText().getText().toString().trim();
                handleResult = et_handle_result.getEditText().getText().toString().trim();
                if (!TextUtils.isEmpty(handlePerson) && !TextUtils.isEmpty(handleTime) && !TextUtils.isEmpty(handleReason) && !TextUtils.isEmpty(handleWay) && !TextUtils.isEmpty(handleResult)) {
                    //弹出对话框，确定提交
                    new MaterialDialog.Builder(PendingTreatDetailActivity.this)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                    MaterialDialog progressDialog = new MaterialDialog.Builder(PendingTreatDetailActivity.this)
//                                            .title("提交")
//                                            .content("正在提交中，请稍等……")
//                                            .progress(true, 0)
//                                            .progressIndeterminateStyle(true)
//                                            .cancelable(false)
//                                            .show();
                                    handleSubmit();
                                }
                            })
                            .negativeText("放弃")
                            .show();
                } else {
                    if (TextUtils.isEmpty(handlePerson)) {
                        et_handle_person.getEditText().setError("处置人不能为空");
                    } else if (TextUtils.isEmpty(handleTime)) {
                        et_handle_time.getEditText().setError("处置时间不能为空");
                    } else if (TextUtils.isEmpty(handleReason)) {
                        et_handle_reason.getEditText().setError("处置原因不能为空");
                    } else if (TextUtils.isEmpty(handleWay)) {
                        et_handle_way.getEditText().setError("处置方式不能为空");
                    } else if (TextUtils.isEmpty(handleResult)) {
                        et_handle_result.getEditText().setError("处置结果不能为空");
                    }
                }
            }
        });

        bt_handle_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出对话框,确定重置
                new MaterialDialog.Builder(PendingTreatDetailActivity.this)
                        .title("确认")
                        .content("请问您确定要重置吗？那样您就要重新填写哟……")
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                //提交到服务器
                                TastyToast.makeText(getApplicationContext(), "已经重置!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                                et_handle_reason.getEditText().setText("");
                                et_handle_reason.setFocusable(false);
                                et_handle_way.getEditText().setText("");
                                et_handle_result.getEditText().setText("");
                                handleResult = "";
                                handleReason = "";
                                handleWay = "";
                                bitmap = null;
                                iv_photo_select.setImageResource(R.drawable.ic_camera_album);
                            }
                        })
                        .negativeText("放弃")
                        .show();
            }
        });

        initPageStateLayout(mPageStateLayout);
        initPtrFrameLayout(mPtrFrameLayout);
    }


    private void handleSubmit() {
        String person = null, time = null, reason = null, way = null, result = null;
        Map<String, String> options = new HashMap<>();
        Map<String, RequestBody> params=new HashMap<String, RequestBody>();
//            person = URLEncoder.encode(handlePerson, "UTF-8");
//            time = URLEncoder.encode(handleTime, "utf-8");
//            reason = URLEncoder.encode(handleReason, "UTF-8");
//            way = URLEncoder.encode(handleWay, "UTF-8");
//            result = URLEncoder.encode(handleResult, "UTF-8");

        options.put("xxid",xxid+"");
        options.put("chuzhiren",handlePerson);
        options.put("chuzhishijian", handleTime);
        options.put("chaobiaoyuanyin",handleReason);
        options.put("chuzhifangshi",handleWay);
        options.put("chuzhijieguo",handleResult);

        KLog.e(TAG,options.toString());

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if(null!=bitmap){
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);//图片压缩
            RequestBody photo = RequestBody.create(MediaType.parse("multipart/form-data"), os.toByteArray());
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", "1111", photo);
//               params.put("file",  photo);

            KLog.e(TAG,params.toString());
//            params.put("fileName=\""+photoName , RequestBody.create(MediaType.parse("image/png"),fileName));
            mPresenter.uploadTreatData(options,body);
        }

    }

    public void uploaded(String text) {
        KLog.e(TAG, "---uploaded---");
        ToastUtils.showToast(BaseApplication.mContext, text);
//        setResult(tag);
//        finish();
    }

    //响应服务器的数据
    public void responsePendingtreatDetail(SC_chaxunItem_xq xqData,PendingTreatDetailRes pendingTreatDetailRes){

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置动画与适配器
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(mAdapter = new PendingTreatDetailActivityRecyclerViewAdapter(this, xqData.getLists()));
        mSlideInLeftAnimationAdapter.setFirstOnly(true);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter mScaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        mScaleInAnimationAdapter.setFirstOnly(true);
        mRecyclerView.setAdapter(mScaleInAnimationAdapter);
        setViewData(pendingTreatDetailRes);

        //设置处置部分是否显示
        if (mUserInfoBean.getQuanxian().isSyschaobiaoReal()) {
//            bt_handle_submit.setEnabled(false);
//            bt_handle_reset.setEnabled(false);

            KLog.e(TAG,pendingTreatDetailRes.getData().getFilepath());
            if (!TextUtils.isEmpty(pendingTreatDetailRes.getData().getFilepath())) {

                String imageURL = URL.BaseURL + pendingTreatDetailRes.getData().getFilepath();
                Glide.with(getApplicationContext()).load(imageURL).crossFade().into(iv_photo_select);
            }

            if (TextUtils.isEmpty(pendingTreatDetailRes.getData().getChuzhiren())) {
                et_handle_person.getEditText().setText(handlePerson = mUserInfoBean.getUserFullName());
            } else {
                et_handle_person.getEditText().setText(pendingTreatDetailRes.getData().getChuzhiren());
            }
            if (TextUtils.isEmpty(pendingTreatDetailRes.getData().getChuzhishijian())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                et_handle_time.getEditText().setText(sdf.format(Calendar.getInstance().getTime()));
            } else {
                et_handle_time.getEditText().setText(pendingTreatDetailRes.getData().getChuzhishijian());
            }

            if (!TextUtils.isEmpty(pendingTreatDetailRes.getData().getChaobiaoyuanyin())) {
                et_handle_reason.getEditText().setText(pendingTreatDetailRes.getData().getChaobiaoyuanyin());
            }

            if (!TextUtils.isEmpty(pendingTreatDetailRes.getData().getChulifangshi())) {
                et_handle_way.getEditText().setText(pendingTreatDetailRes.getData().getChulifangshi());

            }

            if (!TextUtils.isEmpty(pendingTreatDetailRes.getData().getChulijieguo())) {
                et_handle_result.getEditText().setText(pendingTreatDetailRes.getData().getChulijieguo());
            }
        }else {
            bt_handle_submit.setEnabled(true);
            bt_handle_reset.setEnabled(true);
        }

    }

    public void loadData(){
  //      String shebeibianhao="G345lq0101";
  //      String bianhao="22840";
        mPresenter.requestPendingtreatDetailData(shebeibianhao,xxid+"");
    }

    private  void setViewData(PendingTreatDetailRes pendingTreatDetailRes) {
        // 设置显示数据
        tv_date.setText(pendingTreatDetailRes.getData().getShijian());//
        tv_sjysb.setText(pendingTreatDetailRes.getData().getSjysb()+"%");//
        tv_llysb.setText(pendingTreatDetailRes.getData().getLlysb()+"%");//
        tv_wcysb.setText(pendingTreatDetailRes.getData().getSjysb()+"%");//
        tv_lqwd.setText(pendingTreatDetailRes.getData().getLqwd()+"℃");//
        tv_slwd.setText(pendingTreatDetailRes.getData().getGlwd()+"℃");//
        tv_clwd.setText(pendingTreatDetailRes.getData().getClwd()+"℃");//
    }

    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (mNestedScrollView.getScrollY() == 0) {
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == Constants.CAMERA) { // 表示是从相机拍照页返回
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(getApplicationContext(), "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            //对返回的 bitmap 进行对应的保存操作
            photoName = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
            TastyToast.makeText(getApplicationContext(), photoName, TastyToast.LENGTH_SHORT, TastyToast.INFO);
            Bundle bundle = data.getExtras();
            bitmap = (Bitmap) bundle.get("data");

            FileOutputStream b = null;
            File file = new File("/sdcard/shtw/");
            file.mkdirs();
            fileName = "/sdcard/shtw/" + photoName;

            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (Exception e2) {
                }
            }
        } else if (requestCode == Constants.ALBUM) { // 表示是从相册选择图片返回
            Uri uri = data.getData(); //得到图片 uri
            ContentResolver resolver = getContentResolver(); //处理器
            try {
                bitmap = MediaStore.Images.Media.getBitmap(resolver, uri); //  将对应 uri 通过处理器转化为 bitmap
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (bitmap != null) {
            ll_camera_album.setVisibility(View.GONE);
            iv_photo_select.setVisibility(View.VISIBLE);
            iv_photo_select.setImageBitmap(bitmap);
        }
    }



    public static RequestBody toRequestBody(String vaule){

        RequestBody body=RequestBody.create(MediaType.parse("text/plain"),vaule);
        return body;
    }




    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable t) {

        if (t instanceof ConnectException) {
            //   ToastUtils.showInfoToast(BaseApplication.mContext,"网络异常,请检测网络");
            ToastUtils.showToast(BaseApplication.mContext, "网络异常,请检测网络");
            mPageStateLayout.showNetError();
        } else if (t instanceof HttpException) {
            ToastUtils.showToast(BaseApplication.mContext, "服务器异常");
            mPageStateLayout.showError();
        } else if (t instanceof SocketTimeoutException) {
            ToastUtils.showToast(BaseApplication.mContext, "连接超时");
            mPageStateLayout.showError();
        } else if (t instanceof JSONException) {
            ToastUtils.showToast(BaseApplication.mContext, "解析异常");
            mPageStateLayout.showError();
        } else {
            ToastUtils.showToast(BaseApplication.mContext, "数据异常");
            mPageStateLayout.showError();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

        mPageStateLayout.showEmpty();
    }

    private void setToolbarTitle() {
        if (null != mToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
            StringBuffer sb = new StringBuffer(BaseApplication.mDepartmentData.departmentName + " > ");
            sb.append(getString(R.string.liqing) + " > ");
            sb.append(getString(R.string.pendingtreat_detail)).trimToSize();
            mToolbar.setTitle(sb.toString());
        }
    }
}
