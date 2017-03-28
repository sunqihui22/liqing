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
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.sdsmdg.tastytoast.TastyToast;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.pitch.PitchOverProofDetailContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.UploadResponseBean;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.shtoone.liqing.mvp.presenter.pitch.PitchOverProofDetailPresenter;
import com.shtoone.liqing.mvp.view.adapter.PitchAccountingTableAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.DateUtils;
import com.shtoone.liqing.utils.DensityUtils;
import com.shtoone.liqing.utils.KeyBoardUtils;
import com.shtoone.liqing.utils.ToastUtils;
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
import java.util.IllegalFormatCodePointException;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrFrameLayout;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author： hengzwd on 2017/3/17.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchOverProofDetailFragment extends BaseFragment<PitchOverProofDetailContract.Presenter> implements PitchOverProofDetailContract.View, OnDateSetListener {

    private static final String TAG = PitchOverProofDetailFragment.class.getSimpleName();

    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbarToolbar;
    @BindView(R.id.scchaxun_xq_date)
    TextView scchaxunXqDate;
    @BindView(R.id.scchaxun_xq_bhjname)
    TextView scchaxunXqBhjname;
    @BindView(R.id.scchaxun_xq_chuliaoshijian)
    TextView scchaxunXqChuliaoshijian;
    @BindView(R.id.scchaxun_xq_zcl)
    TextView scchaxunXqZcl;
    @BindView(R.id.shengchanchaxun_xq_container)
    LinearLayout shengchanchaxunXqContainer;
    @BindView(R.id.cv_produce_query_detail_fragment)
    CardView cvProduceQueryDetailFragment;
    @BindView(R.id.rv_produce_query_detail_fragment)
    RecyclerView rvProduceQuery;
    @BindView(R.id.iv_photo_select_overproof_detail_fragment)
    ImageView ivPhotoSelect;
    @BindView(R.id.iv_camera_select_overproof_detail_fragment)
    ImageView ivCameraSelect;
    @BindView(R.id.iv_album_select_overproof_detail_fragment)
    ImageView ivAlbumSelect;
    @BindView(R.id.ll_camera_album_overproof_detail_fragment)
    LinearLayout llCameraAlbum;
    @BindView(R.id.et_handle_person_overproof_detail_fragment)
    TextInputLayout etHandlePerson;
    @BindView(R.id.et_handle_time_overproof_detail_fragment)
    TextInputLayout etHandleTime;
    @BindView(R.id.et_handle_reason_overproof_detail_fragment)
    TextInputLayout etHandleReason;
    @BindView(R.id.et_handle_way_overproof_detail_fragment)
    TextInputLayout etHandleWay;
    @BindView(R.id.et_handle_result_overproof_detail_fragment)
    TextInputLayout etHandleResult;
    @BindView(R.id.bt_handle_submit_overproof_detail_fragment)
    Button btHandleSubmit;
    @BindView(R.id.bt_handle_reset_overproof_detail_fragment)
    Button btHandleReset;
    @BindView(R.id.cv_handle_overproof_detail_fragment)
    CardView cvHandle;
    @BindView(R.id.et_examine_person_overproof_detail_fragment)
    TextInputLayout etExaminePerson;
    @BindView(R.id.et_examine_approve_overproof_detail_fragment)
    TextInputLayout etExamineApprove;
    @BindView(R.id.et_confirm_time_overproof_detail_fragment)
    TextInputLayout etConfirmTime;
    @BindView(R.id.bt_examine_submit_overproof_detail_fragment)
    Button btExamineSubmit;
    @BindView(R.id.bt_examine_reset_overproof_detail_fragment)
    Button btExamineReset;
    @BindView(R.id.cv_examine_overproof_detail_fragment)
    CardView cvExamine;
    @BindView(R.id.nsv_produce_query_detail_fragment)
    NestedScrollView nsvProduceQuery;
    @BindView(R.id.psl_produce_query_detail_fragment)
    PageStateLayout pslProduceQuery;
    @BindView(R.id.ptr_produce_query_detail_fragment)
    PtrFrameLayout ptrProduceQuery;


    private UserInfoBean mUserInfoData;
    private String examinePerson;
    private String examineResult;
    private String examineApprove;
    private String confirmTime;
    private String approveTime;
    private Bitmap bitmap;
    private String handlePerson;
    private String handleTime;
    private String handleReason;
    private String handleWay;
    private String handleResult;
    private PitchAccountingTableAdapter madapter;
    private LinearLayoutManager linearLayoutManager;
    private PitchOverProofDetailsBean.LqHeadEntity headEntity;
    private PitchOverProofDetailsBean.LqjgEntity lqjgEntity;

    private DepartmentBean departmentBean;
    private ParametersData parametersData = new ParametersData();
    private int lastVisibleItemPosition;
    private boolean isLoading;

    private TimePickerDialog enSureTimePickerDialog;
    private TimePickerDialog handleTimePickerDialog;
    private TimePickerDialog ExamineTimePickerDialog;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static PitchOverProofDetailFragment newInstance(DepartmentBean departmentBean) {

        PitchOverProofDetailFragment fragment = new PitchOverProofDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("depatmentdate", departmentBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_detail_pitchoverproofdetail, container, false);
        ButterKnife.bind(this, view);
//        initStateBar(toolbarToolbar);
        setToolbarTitle();
        initToolbarBackNavigation(toolbarToolbar);
        initDate();
        return view;
    }

    private void initDate() {
        if (BaseApplication.mUserInfoBean != null) {
            mUserInfoData = (UserInfoBean) BaseApplication.mUserInfoBean.clone();
        }
        Bundle bundle = getArguments();
        departmentBean = (DepartmentBean) bundle.getSerializable("depatmentdate");
        madapter = new PitchAccountingTableAdapter();
        pslProduceQuery.setPadding(0, 0, 0, DensityUtils.dp2px(_mActivity, 0));
        initPageStateLayout(pslProduceQuery);
        initPtrFrameLayout(ptrProduceQuery);
        initTimePickerDialog();
        linearLayoutManager = new LinearLayoutManager(_mActivity);
        rvProduceQuery.setLayoutManager(linearLayoutManager);
        rvProduceQuery.setAdapter(madapter);

        etHandleTime.getEditText().setInputType(InputType.TYPE_NULL);
        etHandlePerson.getEditText().setInputType(InputType.TYPE_NULL);
        etExaminePerson.getEditText().setInputType(InputType.TYPE_NULL);
        etConfirmTime.getEditText().setInputType(InputType.TYPE_NULL);
//        etHandleTime.getEditText().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        handleTimePickerDialog.show(getFragmentManager(), "处置时间");
//                        break;
//                }
//                return true;
//            }
//        });

//        etConfirmTime.getEditText().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        enSureTimePickerDialog.show(getFragmentManager(), "确认时间");
//                        break;
//                }
//                return true;
//            }
//        });
//

        ivPhotoSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = (llCameraAlbum.getLeft() + view.getRight()) / 2;
                    int cy = (llCameraAlbum.getTop() + view.getBottom()) / 2;
                    int radius = Math.max(view.getWidth(), llCameraAlbum.getHeight());
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(llCameraAlbum, cx, cy, 0, radius);
                    mAnimator.setDuration(500);
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.addListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            llCameraAlbum.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            llCameraAlbum.setVisibility(View.INVISIBLE);
                        }
                    });
                    mAnimator.start();
                } else {
                    ivPhotoSelect.setVisibility(View.GONE);
                    llCameraAlbum.setVisibility(View.VISIBLE);
                }
            }
        });

        ivCameraSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, Constants.CAMERA);
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), System.currentTimeMillis() + ".jpg");
//                uri = Uri.fromFile(file);
//                // intent.setDataAndType(Uri.fromFile(file), "image/*");
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//                startActivityForResult(intent, ConstantsUtils.CAMERA);
            }
        });

        ivAlbumSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");// 相片类型
                startActivityForResult(intent, Constants.ALBUM);
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                intent.setType("image/*");
//                startActivityForResult(intent, ConstantsUtils.ALBUM);
            }
        });

        etHandlePerson.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    etHandlePerson.getEditText().setError("处置原因不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        etHandleWay.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    etHandleWay.getEditText().setError("处置方式不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        etHandleResult.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    etHandleResult.getEditText().setError("处置结果不能为空");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        btHandleSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeyBoardUtils.hideKeybord(view, BaseApplication.mContext);
                handlePerson = etHandlePerson.getEditText().getText().toString().trim();
                handleTime = etHandleTime.getEditText().getText().toString().trim();
                handleReason = etHandleReason.getEditText().getText().toString().trim();
                handleWay = etHandleWay.getEditText().getText().toString().trim();
                handleResult = etHandleResult.getEditText().getText().toString().trim();
                if (!TextUtils.isEmpty(handlePerson) && !TextUtils.isEmpty(handleTime) && !TextUtils.isEmpty(handleReason) && !TextUtils.isEmpty(handleWay) && !TextUtils.isEmpty(handleResult)) {
                    //弹出对话框，确定提交
                    new MaterialDialog.Builder(_mActivity)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    MaterialDialog progressDialog = new MaterialDialog.Builder(_mActivity)
                                            .title("提交")
                                            .content("正在提交中，请稍等……")
                                            .progress(true, 0)
                                            .progressIndeterminateStyle(true)
                                            .cancelable(false).build();
                                    handleSubmit1(progressDialog);
                                }
                            })
                            .negativeText("放弃")
                            .show();
                } else {
                    if (TextUtils.isEmpty(handlePerson)) {
                        etHandlePerson.getEditText().setError("处置人不能为空");
                    } else if (TextUtils.isEmpty(handleTime)) {
                        etHandleTime.getEditText().setError("处置时间不能为空");
                    } else if (TextUtils.isEmpty(handleReason)) {
                        etHandleReason.getEditText().setError("处置原因不能为空");
                    } else if (TextUtils.isEmpty(handleWay)) {
                        etHandleWay.getEditText().setError("处置方式不能为空");
                    } else if (TextUtils.isEmpty(handleResult)) {
                        etHandleResult.getEditText().setError("处置结果不能为空");
                    }
                }
            }
        });

        btHandleReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出对话框,确定重置
                new MaterialDialog.Builder(_mActivity)
                        .title("确认")
                        .content("请问您确定要重置吗？那样您就要重新填写哟……")
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                //提交到服务器
                                TastyToast.makeText(BaseApplication.mContext, "已经重置!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                                etHandleReason.getEditText().setText("");
                                etHandleReason.setFocusable(false);
                                etHandleWay.getEditText().setText("");
                                etHandleResult.getEditText().setText("");
                                handleResult = "";
                                handleReason = "";
                                handleWay = "";
                                bitmap = null;
                                ivPhotoSelect.setImageResource(R.drawable.ic_camera_album);
                            }
                        })
                        .negativeText("放弃")
                        .show();
            }
        });


        btExamineSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeyBoardUtils.hideKeybord(view, _mActivity);
                examinePerson = etExaminePerson.getEditText().getText().toString().trim();
                examineApprove = etExamineApprove.getEditText().getText().toString().trim();
                confirmTime = etConfirmTime.getEditText().getText().toString().trim();


                if (!TextUtils.isEmpty(examinePerson) && !TextUtils.isEmpty(examineApprove) && !TextUtils.isEmpty(confirmTime)) {
                    //弹出对话框，确定提交
                    new MaterialDialog.Builder(_mActivity)
                            .title("确认")
                            .content("请问您确定填写无误并提交吗？")
                            .positiveText("确定")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    MaterialDialog progressDialog = new MaterialDialog.Builder(_mActivity)
                                            .title("提交")
                                            .content("正在提交中，请稍等……")
                                            .progress(true, 0)
                                            .progressIndeterminateStyle(true)
                                            .cancelable(false)
                                            .build();
                                    examineSubmit(progressDialog);
                                }
                            })
                            .negativeText("放弃")
                            .show();
                } else {
                    if (TextUtils.isEmpty(examinePerson)) {
                        etExaminePerson.getEditText().setError("审批人不能为空");
                    } else if (TextUtils.isEmpty(examineApprove)) {
                        etExamineApprove.getEditText().setError("监理审批不能为空");
                    } else if (TextUtils.isEmpty(confirmTime)) {
                        etConfirmTime.getEditText().setError("确认时间不能为空");
                    }
                }
            }
        });

        btExamineReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出对话框,确定重置
                new MaterialDialog.Builder(_mActivity)
                        .title("确认")
                        .content("请问您确定要重置吗？那样您就要重新填写哟……")
                        .positiveText("确定")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                etExamineApprove.getEditText().setText("");
                                examineResult = "";
                                examineApprove = "";
                            }
                        })
                        .negativeText("放弃")
                        .show();
            }
        });
    }


    @Override
    public void loadData() {
        super.loadData();
        Map<String, String> map = new HashMap<>();
        map.put("bianhao", departmentBean.bianhao);
        map.put("shebeibianhao", departmentBean.equipmentID);
        mPresenter.requestOverProofData(map);
    }

    @Override
    public void responseOverProofData(PitchOverProofDetailsBean pitchOverProofDetailsBean) {
        lqjgEntity = pitchOverProofDetailsBean.getLqjg();
        headEntity = pitchOverProofDetailsBean.getLqHead();
        setData2View(headEntity, lqjgEntity);
        madapter.removeAllHeaderView();
        madapter.removeAllFooterView();
        madapter.setOverProofData(pitchOverProofDetailsBean);
        madapter.notifyDataSetChanged();
    }


    private void setData2View(PitchOverProofDetailsBean.LqHeadEntity headEntity, PitchOverProofDetailsBean.LqjgEntity swjgEntity) {

        scchaxunXqBhjname.setText(headEntity.getBhjName());
        scchaxunXqChuliaoshijian.setText(headEntity.getChuliaoshijian());
        scchaxunXqDate.setText(headEntity.getCaijishijian());
        scchaxunXqZcl.setText(headEntity.getCl());
        etConfirmTime.getEditText().setText(swjgEntity.getConfirmdate());
        etExamineApprove.getEditText().setText(swjgEntity.getYezhuyijian());
        etExaminePerson.getEditText().setText(swjgEntity.getYezhuren());
        etHandlePerson.getEditText().setText(swjgEntity.getChuliren());
        etHandleResult.getEditText().setText(swjgEntity.getChulijieguo());
        etHandleWay.getEditText().setText(swjgEntity.getChulifangshi());
        etHandleTime.getEditText().setText(swjgEntity.getShenpidate());
        etHandleReason.getEditText().setText(swjgEntity.getWentiyuanyin());

        if (0==mUserInfoData.getChuzhi()) {
            btHandleSubmit.setEnabled(false);
            btHandleReset.setEnabled(false);
        } else if (1==mUserInfoData.getChuzhi()) {
            btHandleSubmit.setEnabled(true);
            btHandleReset.setEnabled(true);
        }

        if (0==mUserInfoData.getShenehe()) {
            btExamineSubmit.setEnabled(false);
            btExamineReset.setEnabled(false);
        } else if (1==mUserInfoData.getShenehe()) {
            btExamineSubmit.setEnabled(true);
            btExamineReset.setEnabled(true);
        }

        if (TextUtils.isEmpty(etHandlePerson.getEditText().getText()))
        {
            etHandlePerson.getEditText().setText(examinePerson = mUserInfoData.getUserFullName());

        }
        if (TextUtils.isEmpty(etExaminePerson.getEditText().getText())) {
            etExaminePerson.getEditText().setText(examinePerson = mUserInfoData.getUserFullName());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        if (TextUtils.isEmpty(etHandleTime.getEditText().getText())) {
            etHandleTime. getEditText().setText(sdf.format(Calendar.getInstance().getTime()));
        }if (TextUtils.isEmpty(etConfirmTime.getEditText().getText()))
        {
            etConfirmTime.getEditText().setText(sdf.format(Calendar.getInstance().getTime()));
        }

        if (!TextUtils.isEmpty(swjgEntity.getFilePath())) {
            String imageURL = Constants.BASE_URL + swjgEntity.getFilePath();
            Glide.with(BaseApplication.mContext).load(imageURL).crossFade().into(ivPhotoSelect);
        }

    }
    @Override
    public void showContent() {
        pslProduceQuery.showContent();
    }

    @Override
    public void showError(Throwable t) {
        if (t instanceof ConnectException) {
            ToastUtils.showToast(BaseApplication.mContext, "网络异常,请检测网络");
            pslProduceQuery.showNetError();
        } else if (t instanceof HttpException) {
            ToastUtils.showToast(BaseApplication.mContext, "服务器异常");
            pslProduceQuery.showError();
        } else if (t instanceof SocketTimeoutException) {
            ToastUtils.showToast(BaseApplication.mContext, "连接超时");
            pslProduceQuery.showError();
        } else if (t instanceof JSONException) {
            ToastUtils.showToast(BaseApplication.mContext, "解析异常");
            pslProduceQuery.showError();
        } else {
            ToastUtils.showToast(BaseApplication.mContext, "数据异常");
            pslProduceQuery.showError();
        }
    }

    @Override
    public void showLoading() {
        pslProduceQuery.showLoading();
    }

    @Override
    public void showEmpty() {
        pslProduceQuery.showEmpty();
    }

    @NonNull
    @Override
    protected PitchOverProofDetailContract.Presenter createPresenter() {
        return new PitchOverProofDetailPresenter(this);
    }


    private void setToolbarTitle() {
//        if (null != toolbarToolbar && null != BaseApplication.mDepartmentData && !TextUtils.isEmpty(BaseApplication.mDepartmentData.departmentName)) {
        StringBuffer sb = new StringBuffer("广东揭博高速公路" + " > ");
        sb.append(getString(R.string.liqing) + " > ");
        toolbarToolbar.setTitle(sb.toString());
//        }

    }


    private void examineSubmit(final MaterialDialog progressDialog) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("jieguobianhao", departmentBean.bianhao);
        paramsMap.put("jianliresult", examineResult);
        paramsMap.put("jianlishenpi", examineApprove);
        paramsMap.put("confirmdate", DateUtils.ChangeTimeToLong(confirmTime));
        paramsMap.put("shenpiren", examinePerson);
        paramsMap.put("shenpidate", DateUtils.ChangeTimeToLong(approveTime));
        progressDialog.show();
        HttpHelper.getInstance().initService().uploadPitchShenHe(paramsMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UploadResponseBean>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
//                        TastyToast.makeText(BaseApplication.mContext, "审核成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);

                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        TastyToast.makeText(BaseApplication.mContext, "提交失败!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }

                    @Override
                    public void onNext(UploadResponseBean o) {

                        if (!o.isSuccess()) {
                            TastyToast.makeText(BaseApplication.mContext, "提交失败!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                        }else {
                            TastyToast.makeText(BaseApplication.mContext, "提交成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                        }

                    }
                });

    }


    private void handleSubmit1(final MaterialDialog progressDialog) {

        Map<String, String> options = new HashMap<>();
        Map<String, RequestBody> params = new HashMap<String, RequestBody>();
//        options.put("xxid",xxid+"");
        options.put("chuzhiren", handlePerson);
        options.put("chuzhishijian", DateUtils.ChangeTimeToLong(handleTime));
        options.put("chaobiaoyuanyin", handleReason);
        options.put("chuzhifangshi", handleWay);
        options.put("chuzhijieguo", handleResult);
        options.put("jieguobianhao", departmentBean.bianhao);

        KLog.e(TAG, options.toString());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if (null != bitmap) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);//图片压缩
            RequestBody photo = RequestBody.create(MediaType.parse("multipart/form-data"), os.toByteArray());
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", "1111", photo);
//               params.put("file",  photo);
            KLog.e(TAG, params.toString());
//            params.put("fileName=\""+photoName , RequestBody.create(MediaType.parse("image/png"),fileName));
            progressDialog.show();
            HttpHelper.getInstance().initService().uploadPitchChuZhi(options, body)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<UploadResponseBean>() {
                        @Override
                        public void onCompleted() {

                            progressDialog.dismiss();
//                            TastyToast.makeText(BaseApplication.mContext, "上传成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                        }

                        @Override
                        public void onStart() {
                            super.onStart();
                        }

                        @Override
                        public void onError(Throwable e) {
                            progressDialog.dismiss();
                            TastyToast.makeText(BaseApplication.mContext, "上传失败!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                            KLog.e(TAG, e.toString());
                        }

                        @Override
                        public void onNext(UploadResponseBean o) {
                            if (!o.isSuccess()) {
                                TastyToast.makeText(BaseApplication.mContext, "上传失败!", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                            }else {
                                TastyToast.makeText(BaseApplication.mContext, "上传成功!", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                            }
                            KLog.e("上传————onnext");
                        }
                    });
        }
    }

    private void initTimePickerDialog() {
        KLog.e(TAG, "---initTimePickerDialog---pre---");
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        handleTimePickerDialog = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("处置时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis() - tenYears)
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();

        enSureTimePickerDialog = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("确认时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis() - tenYears)
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();

        ExamineTimePickerDialog = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("审批时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis() - tenYears)
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();

        KLog.e(TAG, "---initTimePickerDialog---next---");
    }


    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        String text = getDateToString(millseconds);
        if (timePickerView == handleTimePickerDialog) {
            etHandleTime.getEditText().setText(text);
//            mparameterData.startDateTime = text;
        } else if (timePickerView == enSureTimePickerDialog) {
            etConfirmTime.getEditText().setText(text);
//            mparameterData.endDateTime = text;
        }
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == Constants.CAMERA) { // 表示是从相机拍照页返回
            // 判断内存卡是否可用
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
                KLog.e("SD卡不可用");
                TastyToast.makeText(BaseApplication.mContext, "SD卡不可用！", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return;
            }
            //对 返回的 bitmap 进行对应的保存操作
            String photoName = new DateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
            TastyToast.makeText(BaseApplication.mContext, photoName, TastyToast.LENGTH_SHORT, TastyToast.INFO);
            Bundle bundle = data.getExtras();
            bitmap = (Bitmap) bundle.get("data");

            FileOutputStream b = null;
            File file = new File("/sdcard/shtw/");
            file.mkdirs();
            String fileName = "/sdcard/shtw/" + photoName;

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
            ContentResolver resolver = _mActivity.getContentResolver(); //处理器
            try {
                bitmap = MediaStore.Images.Media.getBitmap(resolver, uri); //  将对应 uri 通过处理器转化为 bitmap
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (bitmap != null) {
            llCameraAlbum.setVisibility(View.GONE);
            ivPhotoSelect.setVisibility(View.VISIBLE);
            ivPhotoSelect.setImageBitmap(bitmap);
        }
    }


    @Override
    public boolean isCanDoRefresh() {
        //判断是哪种状态的页面，都让其可下拉
        if (pslProduceQuery.isShowContent) {
            //判断RecyclerView是否在在顶部，在顶部则允许滑动下拉刷新
            if (null != rvProduceQuery) {
                if (rvProduceQuery.getLayoutManager() instanceof LinearLayoutManager) {
                    if (nsvProduceQuery.getScrollY()==0) {
                        return true;
                    }

                }
            } else {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }
}
