package com.shtoone.liqing.mvp.view.others;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.view.base.BaseActivity;
import com.shtoone.liqing.utils.SharedPreferencesUtils;
import com.socks.library.KLog;

import java.lang.reflect.InvocationTargetException;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    @BindView(R.id.fl_main_activity)
    FrameLayout flMainActivity;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private TextView tv_username;
    private TextView tv_phone_number;
    private LinearLayout llNavHeader;
    private ActionBarDrawerToggle toggle;
    private long TOUCH_TIME = 0;
    private static PopupWindow popupWindow;
    private int xPos;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_main_activity, MainFragment.newInstance());
        }
        initView();
        initData();
    }

    @Override
    protected BaseContract.Presenter createPresenter() {
        return null;
    }


    private void initView() {
        popupWindow = new PopupWindow(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        llNavHeader = (LinearLayout) navView.getHeaderView(0);
        tv_username = (TextView) llNavHeader.findViewById(R.id.tv_username_nav_header_main);
        tv_phone_number = (TextView) llNavHeader.findViewById(R.id.tv_phone_number_nav_header_main);
    }

    private void initData() {
        if (BaseApplication.mUserInfoBean != null) {
            tv_username.setText("姓名：" + BaseApplication.mUserInfoBean.getUserFullName());
            tv_phone_number.setText("电话" + BaseApplication.mUserInfoBean.getUserPhoneNum());
        }
        initPopuwindow(popupWindow);
        fragmentManager = getSupportFragmentManager();

        navView.setNavigationItemSelectedListener(this);
        llNavHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 250);
            }
        });
    }

    private void initPopuwindow(PopupWindow popupWindow) {

        popupWindow.setHeight(getWindowManager().getDefaultDisplay().getHeight());
        popupWindow.setWidth(getWindowManager().getDefaultDisplay().getWidth() * 2 / 3);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(getResources().getColor(R.color.material_blue_600));
        popupWindow.setBackgroundDrawable(dw);

    }

    public void closePopuindow() {
        popupWindow.dismiss();
    }


    @Override
    public boolean swipeBackPriority() {
        return false;
    }


    //处理点击侧滑菜单条目，跳转到相应界面
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.message_drawer_main_activity) {
            closeDrawer();
        } else if (id == R.id.logout_drawer_main_activity) {
           // start(LoginFragment.newInstance(Constants.FROM_MAIN));
//            startActivity(new Intent(this,LaunchActivity.class));
            go2Login();
        } else if (id == R.id.about_drawer_main_activity) {
           // start(AboutFragment.newInstance());
            startFragmentSingleTask(AboutFragment.class);
        } else if (id == R.id.version_drawer_main_activity) {
            startFragmentSingleTask(VersionFragment.class);
        }
        closeDrawer();
        return true;
    }

    private void go2Login() {
        //用户名和密码设为空，这样在点击重新登录后，即使没有登录，下次启动由于闪屏页的验证是需要用户名和密码，所以跳转到登录页面。
        SharedPreferencesUtils.put(BaseApplication.mContext, Constants.USERNAME, "");
        SharedPreferencesUtils.put(BaseApplication.mContext, Constants.PASSWORD, "");

        Intent mIntent = new Intent(this, LaunchActivity.class);
        //目的是为了通知LaunchActivity此时应该启动loginfragment，而不是闪屏页。
        mIntent.putExtra(Constants.FROM_TO, Constants.FROM_MAIN);
        startActivity(mIntent);
        finish();
    }


    private  void  startFragmentSingleTask(Class<? extends SupportFragment> tClass)
    {
        SupportFragment fragment=findFragment(tClass);
        if (fragment == null) {
            try {
                start((SupportFragment) tClass.getMethod("newInstance",new Class[]{}).invoke(null ,new Object[]{}));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {
            // 如果已经在栈内,则以SingleTask模式start
            start(fragment, SupportFragment.SINGLETASK);
        }

    }

    public void initToolBar(Toolbar toolbar) {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void closeDrawer() {
        drawerLayout.closeDrawers();
    }

    public void openDrawerLeft() {
        //左边展开
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    public void openDrawerRight(SupportFragment mfragment) {
        //右边展开
        drawerLayout.openDrawer(Gravity.RIGHT);
        fragmentTransaction = fragmentManager.beginTransaction();
//        if(fragmentTransaction.is)
//        fragmentTransaction.add(R.id.fl_drawright_main_activity,new ParametersFragment()).add(R.id.fl_drawright_main_activity,new OrganizationFragment()).commit();
      //  fragmentTransaction.replace(R.id.fl_drawright_main_activity, mfragment).commit();

    }

    public void closeDrawerFunction() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void openDrawerFunction() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }


    public void startDrawerActivity(@Nullable ParametersData mParametersData, @Nullable DepartmentBean departmentData) {
        Intent intent = new Intent(this, DrawerActivity.class);
        Bundle bundle = new Bundle();
        if (mParametersData != null && departmentData == null) {
            bundle.putSerializable("mparametersData", mParametersData);
        } else if (mParametersData == null && departmentData != null) {
            KLog.e(TAG,"---departmentData---");
            bundle.putSerializable("departmentData", departmentData);
        }
        flMainActivity.setAlpha(0.3f);
        intent.putExtras(bundle);
        startActivity(intent);
//        KLog.e(TAG,departmentData.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        flMainActivity.setAlpha(1.0f);
        logFragmentStackHierarchy("1111111111111");
    }
}
