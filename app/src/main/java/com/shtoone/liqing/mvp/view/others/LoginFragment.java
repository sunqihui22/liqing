package com.shtoone.liqing.mvp.view.others;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.others.LoginContract;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.shtoone.liqing.mvp.presenter.others.LoginPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.utils.AESCryptUtils;
import com.shtoone.liqing.utils.KeyBoardUtils;
import com.shtoone.liqing.utils.SharedPreferencesUtils;
import com.shtoone.liqing.widget.processbutton.iml.ActionProcessButton;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.security.GeneralSecurityException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class LoginFragment extends BaseFragment<LoginContract.Presenter> implements LoginContract.View {

    private static final String TAG = LoginFragment.class.getSimpleName();
    @BindView(R.id.et_username_login_fragment)
    TextInputLayout etUsername;
    @BindView(R.id.et_password_login_fragment)
    TextInputLayout etPassword;
    @BindView(R.id.bt_login_fragment)
    ActionProcessButton btLogin;
    @BindView(R.id.cl_login_fragment)
    CoordinatorLayout cl;


    private String username;
    private String password;
    private int fromTo;

    public static LoginFragment newInstance(int fromTo) {
        Bundle args = new Bundle();
        args.putInt(Constants.FROM_TO, fromTo);

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            fromTo = args.getInt(Constants.FROM_TO);
        }
        Log.i("LoginFragment","--LoginFragment--");
    }

    @NonNull
    @Override
    protected LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (fromTo == Constants.FROM_SPLASH) {
            getFragmentManager().beginTransaction()
                    .show(getPreFragment())
                    .commit();
        }
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //进场动画
//        revealShow();
        initData();
    }

    private void initData() {

        etUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btLogin.setProgress(0);
                if (TextUtils.isEmpty(s)) {
                    etUsername.setError("用户名不能为空");
                    etUsername.setErrorEnabled(true);
                } else {
                    etUsername.setError("");
                    etUsername.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        etPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btLogin.setProgress(0);
                if (TextUtils.isEmpty(s)) {
                    etPassword.setError("密码不能为空");
                    etPassword.setErrorEnabled(true);
                } else {
                    etPassword.setError("");
                    etPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick(R.id.bt_login_fragment)
    public void onClick() {
        KeyBoardUtils.hideKeybord(btLogin, _mActivity);
        username = etUsername.getEditText().getText().toString().trim();
        password = etPassword.getEditText().getText().toString().trim();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            btLogin.setProgress(50);
            mPresenter.login(username, password);

        } else if (TextUtils.isEmpty(username)) {
            etUsername.setErrorEnabled(true);
            etUsername.setError("");
            etUsername.setError("用户名不能为空");
        } else if (TextUtils.isEmpty(password)) {
            etUsername.setErrorEnabled(true);
            etUsername.setError("");
            etPassword.setError("密码不能为空");
        }
    }

    @Override
    public void savaData(UserInfoBean mUserInfoBean) {
        try {
            String usernameEncrypted = AESCryptUtils.encrypt(Constants.ENCRYPT_KEY, username);
            String passwordEncrypted = AESCryptUtils.encrypt(Constants.ENCRYPT_KEY, password);
//            String userIdEncrypted = AESCryptUtils.encrypt(Constants.ENCRYPT_KEY, mUserInfoBean.getUserId());

            SharedPreferencesUtils.put(_mActivity, Constants.USERNAME, usernameEncrypted);
            SharedPreferencesUtils.put(_mActivity, Constants.PASSWORD, passwordEncrypted);
//            SharedPreferencesUtils.put(_mActivity, Constants.USER_ID, userIdEncrypted);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setErrorMessage(String message) {
        btLogin.setErrorText(message);
        btLogin.setProgress(-1);
    }

    @Override
    public void setSuccessMessage() {
        //按钮提示成功信息
        btLogin.setProgress(100);
    }

    @Override
    public void go2Main() {
        btLogin.postDelayed(new Runnable() {
            @Override
            public void run() {
                _mActivity.startActivity(new Intent(_mActivity, MainActivity.class));
                _mActivity.finish();
            }
        }, 300);

    }



    @Override
    public void showContent() {

    }


    @Override
    public void showError(Throwable t) {
        if (t instanceof ConnectException) {
            setErrorMessage("网络异常");
        } else if (t instanceof HttpException) {
            setErrorMessage("服务器异常");
        } else if (t instanceof SocketTimeoutException) {
            setErrorMessage("连接超时");
        } else if (t instanceof JSONException) {
            setErrorMessage("解析异常");
        } else {
            setErrorMessage("数据异常");
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public boolean onBackPressedSupport() {
        return true;//消费掉事件
    }
}
