package com.shtoone.liqing.mvp.view.others;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.contract.others.PitchDetailContract;
import com.shtoone.liqing.mvp.presenter.others.PitchDetailPresenter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;

/**
 * Created by Administrator on 2016/11/24.
 */
public class PitchDetailFragment extends BaseFragment<PitchDetailContract.Presenter> implements PitchDetailContract.View{


    @NonNull
    @Override
    protected PitchDetailContract.Presenter createPresenter() {
        return new PitchDetailPresenter(this);
    }

    public static PitchDetailFragment newInstance() {
        return new PitchDetailFragment();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_pitch_detail, container, false);
        return view;
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
}
