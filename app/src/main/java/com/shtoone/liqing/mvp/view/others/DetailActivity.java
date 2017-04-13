package com.shtoone.liqing.mvp.view.others;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.view.WaterStability.WaterStabilityOverProofDetailFragment;
import com.shtoone.liqing.mvp.view.WaterStability.WaterStabilityProductionQueryDetailFragment;
import com.shtoone.liqing.mvp.view.WaterStability.WaterStabilityProductionQueryFragemnt;
import com.shtoone.liqing.mvp.view.base.BaseActivity;
import com.shtoone.liqing.mvp.view.pitch.PitchOverProofDetailFragment;
import com.shtoone.liqing.mvp.view.pitch.PitchProductQueryDetailFragement;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author： hengzwd on 2017/3/15.
 * Email：hengzwdhengzwd@qq.com
 */

public class DetailActivity extends BaseActivity {
    @BindView(R.id.framlayout_detailactivity)
    FrameLayout framlayoutDetailactivity;
    private DepartmentBean departmentBean;
    private SupportFragment mFragment;

    @Override
    protected BaseContract.Presenter createPresenter() {
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailactivity);
        ButterKnife.bind(this);

        KLog.e("oncreate++1");
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        departmentBean = (DepartmentBean) bundle.getSerializable("departmentData");
            if (departmentBean.fromto == Constants.WATERSTABILITYOVERPROOFFRAGMENT) {
                loadRootFragment(R.id.framlayout_detailactivity, WaterStabilityOverProofDetailFragment.newInstance(departmentBean));
            }
            if (departmentBean.fromto == Constants.PITCHOVERPROOFFRAGMENT) {
                loadRootFragment(R.id.framlayout_detailactivity, PitchOverProofDetailFragment.newInstance(departmentBean));
            }
            if (departmentBean.fromto == Constants.WATERSTABILITYPRODUCTIONQUERYFRAGMENT) {
                loadRootFragment(R.id.framlayout_detailactivity, WaterStabilityProductionQueryDetailFragment.newInstance(departmentBean));
            }
            if (departmentBean.fromto==Constants.PITCHPRODUCTQUERYFRAGMENT)
            {
                loadRootFragment(R.id.framlayout_detailactivity, PitchProductQueryDetailFragement.newInstance(departmentBean));

            }
        }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KLog.e("ondestroy++1");
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        KLog.e("detailactivity:onBackPressedSupport");
    }
}
