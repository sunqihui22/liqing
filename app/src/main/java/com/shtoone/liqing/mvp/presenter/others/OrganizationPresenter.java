package com.shtoone.liqing.mvp.presenter.others;

import com.shtoone.liqing.mvp.contract.others.OrganizationContract;
import com.shtoone.liqing.mvp.model.HttpHelper;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.DepartmentData;
import com.shtoone.liqing.mvp.model.bean.OrganizationBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationFragmentBean;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by gesangdianzi on 2016/11/30.
 */
public class OrganizationPresenter extends BasePresenter<OrganizationContract.View> implements OrganizationContract.Presenter {
    private List<OrganizationBean> treeNodes= new ArrayList<OrganizationBean>();

    public OrganizationPresenter(OrganizationContract.View mView) {
        super(mView);
    }



    @Override
    public void requestOrganization(DepartmentBean mdepartmentData) {


        mRxManager.add(
                HttpHelper.getInstance().initService().requestOrganization(mdepartmentData.updateDepartTime, mdepartmentData.funtype, mdepartmentData.departmentID, mdepartmentData.type)
                        .flatMap(new Func1<OrganizationFragmentBean, Observable<OrganizationFragmentBean.DataEntity>>() {
                            @Override
                            public Observable<OrganizationFragmentBean.DataEntity> call(OrganizationFragmentBean organizationFragmentBean) {

                                return Observable.from(organizationFragmentBean.getData());
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<OrganizationFragmentBean.DataEntity>() {
                            @Override
                            public void onCompleted() {
                                getView().responseOrganization(treeNodes);
                            }

                            @Override
                            public void onError(Throwable e) {
                                getView().showError(e);
                            }

                            @Override
                            public void onNext(OrganizationFragmentBean.DataEntity dataEntity) {

                                treeNodes.add(new OrganizationBean(dataEntity.getID(),dataEntity.getParentdepartid(),dataEntity.getDepartname()));
                            }
                        })
        );
    }

    @Override
    public void start() {

    }
}
