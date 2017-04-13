package com.shtoone.liqing.mvp.view.WaterStability;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.widget.ui.MoreIconsTextView;
import com.socks.library.KLog;

/**
 * Created by Administrator on 2016/11/24.
 */
public class TestActivity extends Activity {

    private Button button;
    private MoreIconsTextView moreIconsTextView;
    private myinterface myinterface;
    private Handler mHandler;

    private DepartmentBean departmentBean = new DepartmentBean();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button = ((Button) findViewById(R.id.bt));
        moreIconsTextView = (MoreIconsTextView) findViewById(R.id.mitv_test);
        moreIconsTextView.setText("hahhjahha");
        moreIconsTextView.setBitmapRescource(R.drawable.ic_yellow_arrow_top, 3);
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


        myinterface = new myinterface() {
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


    private interface myinterface {
        void getAstring(String s);
    }


    public void setstring(String s) {
        KLog.e("当前线程是：：" + Thread.currentThread().getName());

        button.setText(s);
    }

}
