package com.shtoone.liqing.mvp.view.others;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.others.MainContract;
import com.shtoone.liqing.mvp.presenter.others.MainPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.laboratory.LaboratoryFragment;
import com.shtoone.liqing.mvp.view.pitch.PitchFragment;
import com.shtoone.liqing.utils.ToastUtils;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class MainFragment extends BaseFragment<MainContract.Presenter> implements MainContract.View {

    private static final String TAG = MainFragment.class.getSimpleName();
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    //    @BindView(R.id.tv_startTime)
//    TextView tvStartTime;
//    @BindView(R.id.tv_endTime)
//    TextView tvEndTime;
//    @BindView(R.id.tv_isQualify)
//    TextView tvIsQualify;
    @BindView(R.id.sliding_pane_layout_main_fragment)
    CoordinatorLayout slidingPaneLayoutMainFragment;
    @BindView(R.id.fl_container_main_fragment)
    FrameLayout flContainerMainFragment;
    @BindView(R.id.bottom_navigation_main_fragment)
    AHBottomNavigation bottomNavigationMainFragment;


    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private long TOUCH_TIME = 0;
    private int bottomNavigationPreposition = 0;
    private SupportFragment[] mFragments = new SupportFragment[2];


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @NonNull
    @Override
    protected MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        if (savedInstanceState == null) {
            mFragments[0] = LaboratoryFragment.newInstance();
            mFragments[1] = PitchFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container_main_fragment, 0, mFragments[0], mFragments[1]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[0] = findFragment(LaboratoryFragment.class);
            mFragments[1] = findFragment(PitchFragment.class);
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

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.laboratory, R.drawable.ic_lab, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.liqing, R.drawable.ic_android_black_24dp, R.color.material_yellow_100);
        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationMainFragment.addItems(bottomNavigationItems);
        bottomNavigationMainFragment.setDefaultBackgroundColor(getResources().getColor(R.color.white));
        bottomNavigationMainFragment.setBehaviorTranslationEnabled(true);
        bottomNavigationMainFragment.setColored(true);
        bottomNavigationMainFragment.setForceTint(false);
        bottomNavigationMainFragment.setAccentColor(getResources().getColor(R.color.base_color));
        bottomNavigationMainFragment.setInactiveColor(getResources().getColor(R.color.gray));
        bottomNavigationMainFragment.setForceTitlesDisplay(true);

        bottomNavigationMainFragment.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                showHideFragment(mFragments[position], mFragments[bottomNavigationPreposition]);
                bottomNavigationPreposition = position;
                if (position == 2) {
                    KLog.e(TAG, "22222");
                }
                if (!wasSelected && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//设置动画
                    int cx = (flContainerMainFragment.getLeft() + flContainerMainFragment.getRight()) / 2;
                    int cy = flContainerMainFragment.getBottom();
                    int radius = Math.max(flContainerMainFragment.getWidth(), flContainerMainFragment.getHeight());
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(flContainerMainFragment, cx, cy, 0, radius);
                    mAnimator.setDuration(300);
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.start();
                }
            }
        });
        bottomNavigationMainFragment.setCurrentItem(0);//设置默认显示第1个fragment
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessageEvent(EventData event) {

//        if (event.position == Constants.CHECKUPDATE) {
//
//            mCheckUpdateInfo = new CheckUpdateInfo();
//            mCheckUpdateInfo.setAppName("android检查更新库")
//                    .setIsForceUpdate(1)//设置是否强制更新,该方法的参数只要和服务端商定好什么数字代表强制更新即可
//                    .setNewAppReleaseTime("2016-10-14 12:37")//软件发布时间
//                    .setNewAppSize(12.3f)//单位为M
//                    .setNewAppUrl("http://shouji.360tpcdn.com/160914/c5164dfbbf98a443f72f32da936e1379/com.tencent.mobileqq_410.apk")
//                    .setNewAppVersionCode(20)//新app的VersionCode
//                    .setNewAppVersionName("1.0.2")
//                    .setNewAppUpdateDesc("1,优化下载逻辑\n2,修复一些bug\n3,完全实现强制更新与非强制更新逻辑\n4,非强制更新状态下进行下载,默认在后台进行下载\n5,当下载成功时,会在通知栏显示一个通知,点击该通知,进入安装应用界面\n6,当下载失败时,会在通知栏显示一个通知,点击该通知,会重新下载该应用\n7,当下载中,会在通知栏显示实时下载进度,但前提要dialog.setShowProgress(true).");
//
//            UpdateDialogClick();
//
//        }
    }


//    /**
//     * 强制更新,checkupdatelibrary中提供的默认强制更新Dialog,您完全可以自定义自己的Dialog,
//     */
//    public void forceUpdateDialogClick() {
//        mCheckUpdateInfo.setIsForceUpdate(0);
//        if (mCheckUpdateInfo.getIsForceUpdate() == 0) {
//            ForceUpdateDialog dialog = new ForceUpdateDialog(_mActivity);
//            dialog.setAppSize(mCheckUpdateInfo.getNewAppSize())
//                    .setDownloadUrl(mCheckUpdateInfo.getNewAppUrl())
//                    .setTitle(mCheckUpdateInfo.getAppName() + "有更新啦")
//                    .setReleaseTime(mCheckUpdateInfo.getNewAppReleaseTime())
//                    .setVersionName(mCheckUpdateInfo.getNewAppVersionName())
//                    .setUpdateDesc(mCheckUpdateInfo.getNewAppUpdateDesc())
//                    .setFileName("这是QQ.apk")
//                    .setFilePath(Environment.getExternalStorageDirectory().getPath() + "/checkupdatelib").show();
//        }
//    }
//
//    /**
//     * 非强制更新,checkupdatelibrary中提供的默认非强制更新Dialog,您完全可以自定义自己的Dialog
//     */
//    public void UpdateDialogClick() {
//        mCheckUpdateInfo.setIsForceUpdate(1);
//        if (mCheckUpdateInfo.getIsForceUpdate() == 1) {
//            UpdateDialog dialog = new UpdateDialog(_mActivity);
//            dialog.setAppSize(mCheckUpdateInfo.getNewAppSize())
//                    .setDownloadUrl(mCheckUpdateInfo.getNewAppUrl())
//                    .setTitle(mCheckUpdateInfo.getAppName() + "有更新啦")
//                    .setReleaseTime(mCheckUpdateInfo.getNewAppReleaseTime())
//                    .setVersionName(mCheckUpdateInfo.getNewAppVersionName())
//                    .setUpdateDesc(mCheckUpdateInfo.getNewAppUpdateDesc())
//                    .setFileName("这是QQ.apk")
//                    .setFilePath(Environment.getExternalStorageDirectory().getPath() + "/checkupdatelib")
//                    //该方法需设为true,才会在通知栏显示下载进度,默认为false,即不显示
//                    //该方法只会控制下载进度的展示,当下载完成或下载失败时展示的通知不受该方法影响
//                    //即不管该方法是置为false还是true,当下载完成或下载失败时都会在通知栏展示一个通知
//                    .setShowProgress(true)
//                    .setIconResId(R.mipmap.ic_launcher)
//                    .setAppName(mCheckUpdateInfo.getAppName()).show();
//        }
//    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
        public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            ToastUtils.showInfoToast(BaseApplication.mContext, Constants.PRESS_AGAIN);
        }
        return true;
    }

    public void startFragment(SupportFragment fragment){
        start(fragment);
    }

}
