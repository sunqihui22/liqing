package com.shtoone.liqing.mvp.view.others;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dd.CircularProgressButton;
import com.google.gson.Gson;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.others.ParametersContract;
import com.shtoone.liqing.mvp.model.bean.EquipmentData;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.UserPositionData;
import com.shtoone.liqing.mvp.presenter.others.ParametersPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.DateUtils;
import com.shtoone.liqing.utils.ToastUtils;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.ganfra.materialspinner.MaterialSpinner;
import retrofit2.adapter.rxjava.HttpException;


/**
 * Created by gesangdianzi on 2016/12/6.
 */
public class ParametersFragment extends BaseFragment<ParametersContract.Presenter> implements ParametersContract.View, OnDateSetListener {

    private static final String TAG = ParametersFragment.class.getSimpleName();

    public ParametersFragment mParametersFragment;
    @BindView(R.id.rb_all_handle_dialog)
    RadioButton rbAllHandleDialog;
    @BindView(R.id.rb_not_handle_dialog)
    RadioButton rbNotHandleDialog;
    @BindView(R.id.rb_handled_dialog)
    RadioButton rbHandledDialog;
    @BindView(R.id.rg_handle_dialog)
    RadioGroup rgHandleDialog;
    @BindView(R.id.rb_all_examine_dialog)
    RadioButton rbAllExamineDialog;
    @BindView(R.id.rb_not_examine_dialog)
    RadioButton rbNotExamineDialog;
    @BindView(R.id.rb_examined_dialog)
    RadioButton rbExaminedDialog;
    @BindView(R.id.rg_examine_dialog)
    RadioGroup rgExamineDialog;
    @BindView(R.id.bt_search_dialog)
    CircularProgressButton btSearchDialog;
    @BindView(R.id.fl_container_dialog)
    FrameLayout flContainerDialog;
    @BindView(R.id.rg_qualify_dialog)
    RadioGroup rgQualifyDialog;
    @BindView(R.id.et_starttime_login_fragment)
    TextInputLayout etStarttimeLoginFragment;
    @BindView(R.id.et_endtime_login_fragment)
    TextInputLayout etEndtimeLoginFragment;
    @BindView(R.id.rg_level_dialog)
    RadioGroup rgLevelDialog;
    @BindView(R.id.ms_select_equipment_dialog)
    MaterialSpinner msSelectEquipmentDialog;
    @BindView(R.id.rg_time_type_dialog)
    RadioGroup rgTimeTypeDialog;
    @BindView(R.id.ms_select_luserposition_dialog)
    MaterialSpinner msSelectLuserpositionDialog;
    @BindView(R.id.rb_all_level_dialog)
    RadioButton rbAllLevelDialog;
    @BindView(R.id.rb_low_level_dialog)
    RadioButton rbLowLevelDialog;
    @BindView(R.id.rb_middle_level_dialog)
    RadioButton rbMiddleLevelDialog;
    @BindView(R.id.rb_high_level_dialog)
    RadioButton rbHighLevelDialog;
    @BindView(R.id.rb_ji_dialog)
    RadioButton rbJiDialog;
    @BindView(R.id.rb_month_dialog)
    RadioButton rbMonthDialog;
    @BindView(R.id.rb_week_dialog)
    RadioButton rbWeekDialog;
    @BindView(R.id.rb_day_dialog)
    RadioButton rbDayDialog;

    private String startDateTime;
    private String endDateTime;
    private ParametersData mparameterData;
    private List<String> equipmentNames;
    private List<String> equipmentIDs;
    private List<String> testTypeNames;
    private List<String> testTypeIDs;
    private List<String> userpositons;
    private TimePickerDialog StartTimePickerDialog;
    private TimePickerDialog EndTimePickerDialog;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static ParametersFragment newInstance(ParametersData mparameterData) {

        Bundle args = new Bundle();
        args.putSerializable(Constants.PARAMETERS, mparameterData);
        ParametersFragment fragment = new ParametersFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mparameterData = (ParametersData) args.getSerializable(Constants.PARAMETERS);
//            mparameterData = (ParametersData) args.getSerializable("mparametersData");
        }

        KLog.e(TAG, mparameterData.toString());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parameters, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        etStarttimeLoginFragment.getEditText().setText(startDateTime = mparameterData.startDateTime);
        etEndtimeLoginFragment.getEditText().setText(endDateTime = mparameterData.endDateTime);


        switch (mparameterData.fromTo) {
            case Constants.PITCHFRAGMENT:
            case Constants.WATERSTABILITYFRAGMENT:

                break;

            case Constants.MaterialStatisticsFragment:
            case Constants.PITCHDAYPROCTFRAGMENT:
                msSelectEquipmentDialog.setVisibility(View.VISIBLE);
                break;

            case Constants.PENDINGTREATMENTFRAGMENT:
            case Constants.WATERSTABILITYOVERPROOFFRAGMENT:
            case Constants.PITCHOVERPROOFFRAGMENT:
                msSelectEquipmentDialog.setVisibility(View.VISIBLE);
                rgHandleDialog.setVisibility(View.VISIBLE);
                rgLevelDialog.setVisibility(View.VISIBLE);
                break;

            case Constants.WATERSTABILITYPRODUCTIONQUERYFRAGMENT:
            case Constants.PITCHPRODUCTQUERYFRAGMENT:
                msSelectLuserpositionDialog.setVisibility(View.VISIBLE);
                msSelectEquipmentDialog.setVisibility(View.VISIBLE);
                break;

            case Constants.TOTALAMOUNTFRAGMENT:
                msSelectEquipmentDialog.setVisibility(View.VISIBLE);
                break;

            case Constants.PRODUCTQUERYFRAGMENT:
                msSelectEquipmentDialog.setVisibility(View.VISIBLE);
                break;

            case Constants.TOTALAMOUNTSTATISTICFRAGMENT:
                rgTimeTypeDialog.setVisibility(View.VISIBLE);
                break;
        }

//        etStarttimeLoginFragment.getEditText().setFocusable(false);
//        etEndtimeLoginFragment.getEditText().setFocusable(false);
        etStarttimeLoginFragment.getEditText().setInputType(InputType.TYPE_NULL);
        etEndtimeLoginFragment.getEditText().setInputType(InputType.TYPE_NULL);

        etStarttimeLoginFragment.getEditText().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setStartDateTime();
                        break;
                }
                return true;
            }
        });

        etEndtimeLoginFragment.getEditText().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        etEndtimeLoginFragment.setError("");
                        etEndtimeLoginFragment.setErrorEnabled(false);
                        setEndDateTime();
                        break;
                }
                return true;
            }
        });
        rgQualifyDialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_not_qualify_dialog:
                        mparameterData.level = "1";
                        break;
                    case R.id.rb_qualify_dialog:
                        mparameterData.level = "2";
                        break;
                    case R.id.rg_qualify_dialog:
                        mparameterData.level = "0";
                        break;
                }
            }
        });

        rgLevelDialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_high_level_dialog:
                        mparameterData.alarmLevel = "3";
                        break;
                    case R.id.rb_middle_level_dialog:
                        mparameterData.alarmLevel = "2";
                        break;
                    case R.id.rb_low_level_dialog:
                        mparameterData.alarmLevel = "1";
                        break;
                    case R.id.rb_all_level_dialog:
                        mparameterData.alarmLevel = "0";
                        break;
                }
            }
        });
        rgHandleDialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.rb_all_handle_dialog) {
                    rgExamineDialog.setVisibility(View.INVISIBLE);
                    mparameterData.handleType = "0";
                } else if (i == R.id.rb_not_handle_dialog) {
                    rgExamineDialog.setVisibility(View.INVISIBLE);
                    mparameterData.handleType = "1";
                } else if (i == R.id.rb_handled_dialog) {
                    mparameterData.handleType = "2";
                    rgExamineDialog.check(R.id.rb_all_examine_dialog);
                    rgExamineDialog.setVisibility(View.VISIBLE);

                }
            }
        });

        rgExamineDialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_all_examine_dialog) {
                    mparameterData.handleType = "2";
                } else if (i == R.id.rb_not_examine_dialog) {
                    mparameterData.handleType = "3";
                } else if (i == R.id.rb_examined_dialog) {
                    mparameterData.handleType = "4";
                }
            }
        });

        rgTimeTypeDialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_ji_dialog) {
                    mparameterData.timeType = "1";
                } else if (i == R.id.rb_month_dialog) {
                    mparameterData.timeType = "2";
                } else if (i == R.id.rb_week_dialog) {
                    mparameterData.timeType = "3";
                } else if (i == R.id.rb_day_dialog) {
                    mparameterData.timeType = "4";
                }
            }
        });


        initTimePickerDialog();
        mPresenter.requestEquipment(mparameterData.departType, mparameterData.biaoshiid, mparameterData.deviceType);

        if (mparameterData.fromTo == Constants.PITCHPRODUCTQUERYFRAGMENT) {

            mPresenter.requestModel();
        } else if (mparameterData.fromTo == Constants.WATERSTABILITYPRODUCTIONQUERYFRAGMENT) {
            Map map = new HashMap();
            map.put("departType", mparameterData.departType);
            map.put("biaoshiid", mparameterData.biaoshiid);
            mPresenter.requesstPositions(map);
        }
        if (mparameterData.handleType.equals("")) {
            rgHandleDialog.check(R.id.rb_all_handle_dialog);
            rgExamineDialog.setVisibility(View.INVISIBLE);
        } else if (mparameterData.handleType.equals("0")) {
            rgHandleDialog.check(R.id.rb_all_handle_dialog);
            rgExamineDialog.setVisibility(View.INVISIBLE);
        } else if (mparameterData.handleType.equals("1")) {
            rgHandleDialog.check(R.id.rb_not_handle_dialog);
            rgExamineDialog.setVisibility(View.INVISIBLE);
            // rg_examine.check(R.id.rb_all_examine_dialog);

        } else if (mparameterData.handleType.equals("2")) {

            rgHandleDialog.check(R.id.rb_handled_dialog);
            rgExamineDialog.check(R.id.rb_all_examine_dialog);
            rgExamineDialog.setVisibility(View.VISIBLE);

        } else if (mparameterData.handleType.equals("3")) {
            rgHandleDialog.check(R.id.rb_handled_dialog);
            rgExamineDialog.check(R.id.rb_not_examine_dialog);
            rgExamineDialog.setVisibility(View.VISIBLE);
        } else if (mparameterData.handleType.equals("4")) {
            rgHandleDialog.check(R.id.rb_handled_dialog);
            rgExamineDialog.check(R.id.rb_examined_dialog);
            rgExamineDialog.setVisibility(View.VISIBLE);
        }

        if (mparameterData.alarmLevel.equals("0")) {
            rgLevelDialog.check(R.id.rb_all_level_dialog);
        } else if (mparameterData.alarmLevel.equals("1")) {
            rgLevelDialog.check(R.id.rb_low_level_dialog);
        } else if (mparameterData.alarmLevel.equals("2")) {
            rgLevelDialog.check(R.id.rb_middle_level_dialog);
        } else if (mparameterData.alarmLevel.equals("3")) {
            rgLevelDialog.check(R.id.rb_high_level_dialog);
        }

        if (mparameterData.timeType.equals("1")) {
            rgTimeTypeDialog.check(R.id.rb_ji_dialog);
        } else if (mparameterData.timeType.equals("2")) {
            rgTimeTypeDialog.check(R.id.rb_month_dialog);
        } else if (mparameterData.timeType.equals("3")) {
            rgTimeTypeDialog.check(R.id.rb_week_dialog);
        } else if (mparameterData.timeType.equals("4")) {
            rgTimeTypeDialog.check(R.id.rb_day_dialog);
        }

    }

    private void setEndDateTime() {
        EndTimePickerDialog.show(getFragmentManager(), "开始时间");
    }

    private void setStartDateTime() {
        KLog.e(TAG, "---setStartDateTime---pre---");
        StartTimePickerDialog.show(getFragmentManager(), "结束时间");
        KLog.e(TAG, "---setStartDateTime---next---");
    }


    @Override
    public void responseEquipment(EquipmentData equipmentData) {
        setBHZQueryView(equipmentData);


    }

    @Override
    public void responsePositons(List<String> responses) {
        setUserpositons(responses);
    }

    @Override
    public void responseModels(List<String> responses) {
        setModels(responses);
    }

    private void setModels(final List<String> responses) {

        msSelectLuserpositionDialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mparameterData.userposition = responses.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> userpositionsAdapter = new ArrayAdapter<String>(_mActivity, android.R.layout.simple_spinner_item, responses);
        userpositionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msSelectLuserpositionDialog.setAdapter(userpositionsAdapter);
        for (int i = 0; i < responses.size(); i++) {
            if (mparameterData.models.equals(responses.get(i))) {
                msSelectLuserpositionDialog.setSelection(i);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }

    }

    private void setUserpositons(final List<String> userpositons) {

        msSelectLuserpositionDialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mparameterData.userposition = userpositons.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> userpositionsAdapter = new ArrayAdapter<String>(_mActivity, android.R.layout.simple_spinner_item, userpositons);
        userpositionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msSelectLuserpositionDialog.setAdapter(userpositionsAdapter);
        for (int i = 0; i < userpositons.size(); i++) {
            if (mparameterData.userposition.equals(userpositons.get(i))) {
                msSelectLuserpositionDialog.setSelection(i);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }
    }

    private void setBHZQueryView(EquipmentData equipmentData) {
        equipmentNames = new ArrayList<>();
        equipmentIDs = new ArrayList<>();
        for (EquipmentData.DataEntity temp : equipmentData.getData()) {
            equipmentNames.add(temp.getBanhezhanminchen());
            equipmentIDs.add(temp.getGprsbianhao());
        }


//        msSelectEquipmentDialog.setItems(equipmentNames);
//        msSelectEquipmentDialog.setOnItemSelectedListener(new OnItemSelectedListener<String>() {
//
//            @Override
//            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
//
//                mparameterData.equipmentID=equipmentIDs.get(position);
//
//            }
//        });

//        msSelectEquipmentDialog.setItems(equipmentNames);
        msSelectEquipmentDialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mparameterData.equipmentID = equipmentIDs.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> equipmentsAdapter = new ArrayAdapter<String>(_mActivity, android.R.layout.simple_spinner_item, equipmentNames);
        equipmentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msSelectEquipmentDialog.setAdapter(equipmentsAdapter);

        for (int i = 0; i < equipmentIDs.size(); i++) {
            if (mparameterData.equipmentID.equals(equipmentIDs.get(i))) {
                msSelectEquipmentDialog.setSelection(i);
                KLog.e("默认：" + (i + 1) + "个");
            }
        }
    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable t) {

        if (t instanceof ConnectException) {
            //   ToastUtils.showInfoToast(BaseApplication.mContext,"网络异常,请检测网络");
            ToastUtils.showToast(BaseApplication.mContext, "网络异常,请检测网络");
        } else if (t instanceof HttpException) {
            ToastUtils.showToast(BaseApplication.mContext, "服务器异常");
        } else if (t instanceof SocketTimeoutException) {
            ToastUtils.showToast(BaseApplication.mContext, "连接超时");
        } else if (t instanceof JSONException) {
            ToastUtils.showToast(BaseApplication.mContext, "解析异常");
        } else {
            ToastUtils.showToast(BaseApplication.mContext, "数据异常");
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @NonNull
    @Override
    protected ParametersContract.Presenter createPresenter() {
        return new ParametersPresenter(this);
    }

    @OnClick(R.id.bt_search_dialog)
    public void onClick() {
//        EventBus.getDefault().post(new EventData(mparameterData));
        String startTime = DateUtils.ChangeTimeToLong(etStarttimeLoginFragment.getEditText().getText().toString());
        String endTime = DateUtils.ChangeTimeToLong(etEndtimeLoginFragment.getEditText().getText().toString());
        if (Integer.valueOf(startTime) <= Integer.valueOf(endTime)) {
            if (mparameterData.timeType == "4") {
                if (Math.abs(DateUtils.getDaySub(startTime, endTime)) > 7) {
                    Toast.makeText(getContext(), "按日统计时请统计周期小于1周", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    EventBus.getDefault().postSticky(new EventData(mparameterData));
                    _mActivity.onBackPressedSupport();
                }
            } else {
                EventBus.getDefault().post(new EventData(mparameterData));
                _mActivity.onBackPressedSupport();
            }

        } else {
            etStarttimeLoginFragment.setError("结束时间不能小于开始时间");
            etEndtimeLoginFragment.setErrorEnabled(true);
        }


        KLog.e(TAG, mparameterData);
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void initTimePickerDialog() {
        KLog.e(TAG, "---initTimePickerDialog---pre---");
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        StartTimePickerDialog = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("开始时间")
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

        EndTimePickerDialog = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("结束时间")
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
        if (timePickerView == StartTimePickerDialog) {
            etStarttimeLoginFragment.getEditText().setText(text);
            mparameterData.startDateTime = text;
        } else if (timePickerView == EndTimePickerDialog) {
            etEndtimeLoginFragment.getEditText().setText(text);
            mparameterData.endDateTime = text;
        }
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }


}
