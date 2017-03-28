package com.shtoone.liqing.mvp.view.WaterStability;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.view.adapter.OnItemClickListener;
import com.shtoone.liqing.mvp.view.base.BaseActivity;
import com.shtoone.liqing.mvp.view.others.DetailActivity;
import com.shtoone.liqing.mvp.view.others.DrawerActivity;
import com.socks.library.KLog;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2016/11/24.
 */
public class TestActivity extends Activity {

    private  Button button;
    private myinterface myinterface ;
    private Handler mHandler;
    private DepartmentBean departmentBean = new DepartmentBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
       button=((Button) findViewById(R.id.bt));
         button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        KLog.e("333333333获取网络数据");
                        myinterface.getAstring("zheshi shuju ");
                        departmentBean.setBiaoshi("biaoshi");
                        mHandler.sendEmptyMessage(1);
                        KLog.e("当前线程是：：" + Thread.currentThread().getName());
                        KLog.e("44444444");
                    }
                }).start();
            }
        });


        myinterface=new myinterface() {
            @Override
            public void getAstring(String s) {

                KLog.e("当前线程是：：" + Thread.currentThread().getName());
                setstring(s);
            }
        };


        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                KLog.e("1111");


                KLog.e("当前线程是：：" + Thread.currentThread().getName());

                KLog.e("22222");
                KLog.e("biaoshi", departmentBean.getBiaoshi());

            }
        };


    }


   private  interface  myinterface
   {
       void   getAstring(String s);
   }


    public void  setstring (String s)
    {
        KLog.e("当前线程是：：" + Thread.currentThread().getName());

        button.setText(s);
    }

}
