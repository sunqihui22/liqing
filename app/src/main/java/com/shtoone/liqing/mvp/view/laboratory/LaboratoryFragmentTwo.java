package com.shtoone.liqing.mvp.view.laboratory;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.laboratory.LaboratoryTwoContract;
import com.shtoone.liqing.mvp.presenter.laboratory.LaboratoryTwoPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.others.MainActivity;
import com.socks.library.KLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by gesangdianzi on 2016/12/1.
 */
public class LaboratoryFragmentTwo extends BaseFragment<LaboratoryTwoContract.Presenter> implements LaboratoryTwoContract.View {


    private static final String TAG=LaboratoryFragmentTwo.class.getSimpleName();
    @BindView(R.id.fl_container_laboratorytwo_fragment)
    FrameLayout flContainerLaboratorytwoFragment;
    @BindView(R.id.bottom_navigation_laboratorytwo_fragment)
    AHBottomNavigation bottomNavigationLaboratorytwoFragment;
    private int bottomNavigationPreposition = 0;
    private SupportFragment[] mFragments = new SupportFragment[4];
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private long TOUCH_TIME = 0;

    @NonNull
    @Override
    protected LaboratoryTwoContract.Presenter createPresenter() {
        return new LaboratoryTwoPresenter(this);
    }


    public static LaboratoryFragmentTwo newInstance() {
        return new LaboratoryFragmentTwo();
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laboratorytwo, container, false);
        ButterKnife.bind(this, view);

        KLog.e("oncreateview1");
        if (savedInstanceState == null) {
            mFragments[0] = MarshallWhenDingDuFragment.newInstance();
            mFragments[1] = RuanHuaDianFragment.newInstance();
            mFragments[2] = YanDuFragment.newInstance();
            mFragments[3] = ZhenRuDuFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container_laboratorytwo_fragment, 0, mFragments[0], mFragments[1],mFragments[2],mFragments[3]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[0] = MarshallWhenDingDuFragment.newInstance();
            mFragments[1] = RuanHuaDianFragment.newInstance();
            mFragments[2] = YanDuFragment.newInstance();
            mFragments[3] = ZhenRuDuFragment.newInstance();
        }

        initData();
        return view;
    }


    public void initData() {
//        if (null != BaseApplication.mUserInfoData) {
//            if (!TextUtils.isEmpty(BaseApplication.mUserInfoData.getUserFullName())) {
//                tv_username.setText("用户：" + BaseApplication.mUserInfoData.getUserFullName());
//            }
//            if (!TextUtils.isEmpty(BaseApplication.mUserInfoData.getUserPhoneNum())) {
//                tv_phone_number.setText("电话：" + BaseApplication.mUserInfoData.getUserPhoneNum());
//            }
//        }
//        _mActivity.showFragmentStackHierarchyView();
//        _mActivity.logFragmentStackHierarchy("11111");

        ((MainActivity)_mActivity).closeDrawerFunction();
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.marshall, R.drawable.ic_lab, R.color.material_red_50);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.ruanhuadian, R.drawable.ic_add_white_24dp, R.color.material_yellow_50);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.zhenrudu, R.drawable.ic_lab, R.color.material_amber_50);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.yandu, R.drawable.ic_lab, R.color.material_blue_50);

        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigationItems.add(item4);

        bottomNavigationLaboratorytwoFragment.addItems(bottomNavigationItems);
        bottomNavigationLaboratorytwoFragment.setDefaultBackgroundColor(getResources().getColor(R.color.white));
        bottomNavigationLaboratorytwoFragment.setBehaviorTranslationEnabled(true);
        bottomNavigationLaboratorytwoFragment.setColored(true);
        bottomNavigationLaboratorytwoFragment.setForceTint(false);
        bottomNavigationLaboratorytwoFragment.setAccentColor(getResources().getColor(R.color.base_color));
        bottomNavigationLaboratorytwoFragment.setInactiveColor(getResources().getColor(R.color.gray));
        bottomNavigationLaboratorytwoFragment.setForceTitlesDisplay(true);

        bottomNavigationLaboratorytwoFragment.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                showHideFragment(mFragments[position], mFragments[bottomNavigationPreposition]);
                bottomNavigationPreposition = position;
                if (position == 2) {
                    KLog.e(TAG, "22222");
                }
                if (!wasSelected && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//设置动画
                    int cx = (flContainerLaboratorytwoFragment.getLeft() + flContainerLaboratorytwoFragment.getRight()) / 2;
                    int cy = flContainerLaboratorytwoFragment.getBottom();
                    int radius = Math.max(flContainerLaboratorytwoFragment.getWidth(), flContainerLaboratorytwoFragment.getHeight());
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(flContainerLaboratorytwoFragment, cx, cy, 0, radius);
                    mAnimator.setDuration(300);
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.start();
                }
            }
        });
        bottomNavigationLaboratorytwoFragment.setCurrentItem(0);//设置默认显示第1个fragment
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ((MainActivity)_mActivity).openDrawerFunction();

    }
}
