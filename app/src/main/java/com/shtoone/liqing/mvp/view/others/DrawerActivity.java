package com.shtoone.liqing.mvp.view.others;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;
import com.shtoone.liqing.mvp.view.base.BaseActivity;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by gesangdianzi on 2016/12/9.
 */
public class DrawerActivity extends BaseActivity {

    @BindView(R.id.fl_container_drawer_activity)
    FrameLayout flContainerDrawerActivity;
    private ParametersData mParametersData;
    private UserInfoBean userInfoBean;
    private DepartmentBean departmentBean;
    private SupportFragment mFragment;

    @Override
    protected BaseContract.Presenter createPresenter() {
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mParametersData = (ParametersData) bundle.getSerializable("mparametersData");
        departmentBean = (DepartmentBean) bundle.getSerializable("departmentBean");
        if (savedInstanceState == null) {
            if (mParametersData != null && departmentBean == null) {
                loadRootFragment(R.id.fl_container_drawer_activity, ParametersFragment.newInstance(mParametersData));
            } else if (mParametersData == null && departmentBean != null) {
                loadRootFragment(R.id.fl_container_drawer_activity, OrganizationFragment.newInstance(departmentBean));
                KLog.e("---loadRootFragment---");
            }
        }
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        //禁止手势，以免用户左滑造成activity退出
        getSwipeBackLayout().setEnableGesture(false);
    }

    @OnClick(R.id.fl_container_drawer_activity)
    public void onClick() {
        onBackPressedSupport();
    }


    @Override
    protected void onResume() {
        super.onResume();
        flContainerDrawerActivity.setAlpha(1.0f);
    }
}
