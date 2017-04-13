package com.shtoone.liqing.mvp.view.others;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.others.SubmitScannedDataContract;
import com.shtoone.liqing.mvp.presenter.others.SubmitScannedDataPresenter;
import com.shtoone.liqing.mvp.view.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubmitScannedDataActivity extends BaseActivity<SubmitScannedDataContract.Presenter> implements SubmitScannedDataContract.View {
    @BindView(R.id.tv_shebeibianhao)
    TextView equipmentNumber;
    @BindViews({R.id.rb_general, R.id.rb_modified, R.id.rb_above, R.id.rb_center, R.id.rb_below})
    List<RadioButton> radioButtonList;
    @BindViews({R.id.rg_pitch_type, R.id.rg_lay})
    List<RadioGroup> radioGroupList;
    @BindView(R.id.btn_submit)
    CircularProgressButton btnSubmit;

    private String sheibeibianhao, pitchType, lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_scanneddata);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected SubmitScannedDataContract.Presenter createPresenter() {
        return new SubmitScannedDataPresenter(this);
    }

    private void initView() {
        //获取默认text文本
        pitchType = radioButtonList.get(0).getText().toString();
        lay = radioButtonList.get(2).getText().toString();

        radioGroupList.get(0).setOnCheckedChangeListener(pitchTypeOnChecked);
        radioGroupList.get(1).setOnCheckedChangeListener(layOnChecked);
    }

    RadioGroup.OnCheckedChangeListener pitchTypeOnChecked = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_general:
                    pitchType = radioButtonList.get(0).getText().toString();
                    break;
                case R.id.rb_modified:
                    pitchType = radioButtonList.get(1).getText().toString();
                    break;
                default:
                    break;
            }
        }
    };

    RadioGroup.OnCheckedChangeListener layOnChecked = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_above:
                    lay = radioButtonList.get(2).getText().toString();
                    break;
                case R.id.rb_center:
                    lay = radioButtonList.get(3).getText().toString();
                    break;
                case R.id.rb_below:
                    lay = radioButtonList.get(4).getText().toString();
                    break;
                default:
                    break;
            }
        }
    };

    @OnClick(R.id.btn_submit)
    protected void btnOnclick(View v) {
        mPresenter.submit(equipmentNumber.getText().toString(), pitchType, lay);
    }

    //region SubmitScannedDataContract中View方法实现
    @Override
    public void submitSuccessfully() {

    }

    @Override
    public void submitFailed(String message) {

    }
    //endregion

    //region BaseContract中View方法实现
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
    //endregion
}
