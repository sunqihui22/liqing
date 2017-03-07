package com.shtoone.liqing.mvp.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.view.pitch.ChaoBiaoLvFragment;
import com.shtoone.liqing.mvp.view.pitch.ShenchanliangFragment;
import com.socks.library.KLog;
import com.squareup.otto.Subscribe;

/**
 * Created by Administrator on 2017/1/13.
 */
public class TotalAmountStatisticsVpAdapter extends FragmentPagerAdapter {

    private boolean isRegistered = false;
    private ParametersData mParametersData;
    private String[] titleType = {"生产量", "超标率"};

    public TotalAmountStatisticsVpAdapter(FragmentManager fm, ParametersData mParametersData) {
        super(fm);
        this.mParametersData = mParametersData;
        if (!isRegistered) {
            BaseApplication.bus.register(this);
            isRegistered = true;
        }
    }

    @Override
    public Fragment getItem(int position) {
        ParametersData mParametersData = (ParametersData) this.mParametersData.clone();
        Fragment fragment=null;
        switch (position){
            case  0:
                fragment= ShenchanliangFragment.newInstance(mParametersData);
                break;
            case 1:
                fragment= ChaoBiaoLvFragment.newInstance(mParametersData);
                break;

        }
        return  fragment;
    }


    @Override
    public int getCount() {
        if (null != titleType) {
            return titleType.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null != titleType) {
            return titleType[position];
        }
        return null;
    }

    @Subscribe
    public void updateSearch(ParametersData mParametersData) {
        if (mParametersData != null) {
            if (mParametersData.fromTo == Constants.TOTALAMOUNTSTATISTICFRAGMENT) {
                this.mParametersData.startDateTime = mParametersData.startDateTime;
                this.mParametersData.endDateTime = mParametersData.endDateTime;
                this.mParametersData.equipmentID = mParametersData.equipmentID;
                this.mParametersData.timeType=mParametersData.timeType;
                KLog.e("mParametersData:" + mParametersData.startDateTime);
                KLog.e("mParametersData:" + mParametersData.endDateTime);
                KLog.e("mParametersData:" + mParametersData.equipmentID);
                KLog.e("mParametersData:" + mParametersData.timeType);

            }
        }
    }


    public void unRegister() {
        BaseApplication.bus.unregister(this);
    }
}

