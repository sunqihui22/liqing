package com.shtoone.liqing.mvp.presenter.others;


import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.shtoone.liqing.mvp.contract.others.OrganizationContract;
import com.shtoone.liqing.mvp.model.HttpHelper;

import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationNode;
import com.shtoone.liqing.mvp.presenter.base.BasePresenter;
import com.socks.library.KLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by gesangdianzi on 2016/11/30.
 */
public class OrganizationPresenter extends BasePresenter<OrganizationContract.View> implements OrganizationContract.Presenter {
    private List<OrganizationNode> treeNodes = new ArrayList<OrganizationNode>();
    private List<OrganizationBean.BiaoduanEntity> treeNodes0 = new ArrayList<OrganizationBean.BiaoduanEntity>();
    private List<OrganizationBean.XmbEntity> treeNodes1 = new ArrayList<OrganizationBean.XmbEntity>();
    private List<OrganizationBean.BhzEntity> treeNodes2 = new ArrayList<OrganizationBean.BhzEntity>();

    private Gson gson = new Gson();

    public OrganizationPresenter(OrganizationContract.View mView) {
        super(mView);
    }


    @Override
    public void requestOrganization(final DepartmentBean departmentBean) {

        mRxManager.add(Observable.create(new Observable.OnSubscribe<ResponseBody>() {
            @Override
            public void call(Subscriber<? super ResponseBody> subscriber) {

                Call<ResponseBody> call = HttpHelper.getInstance().initService().requestOrganization(departmentBean.departmentID, departmentBean.departtype,departmentBean.funtype);
                retrofit2.Response<ResponseBody> response = null;
                try {
                    response = call.execute();
                } catch (IOException e) {
                    subscriber.onError(e);
                    e.printStackTrace();
                }
                if (response.isSuccessful()) {
                    subscriber.onNext(response.body());
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new IOException());
                }

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                        getView().showContent();
                    }
                    @Override
                    public void onError(Throwable e) {

                        getView().showError(e);
                    }
                    @Override
                    public void onStart() {
                        super.onStart();
                        getView().showLoading();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            KLog.e(string);
                            OrganizationBean organizationBean = gson.fromJson(string, OrganizationBean.class);
                            treeNodes0 = organizationBean.getBiaoduan();
                            treeNodes1 = organizationBean.getXmb();
                            treeNodes2 = organizationBean.getBhz();
                            treeNodes.clear();
                            object2Node(treeNodes0, treeNodes1,treeNodes2);
                            getView().responseOrganization(treeNodes);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }));

    }

    @Override
    public void start() {

    }

    private void object2Node(@Nullable List<OrganizationBean.BiaoduanEntity> list1, @Nullable List<OrganizationBean.XmbEntity> list2, @Nullable List<OrganizationBean.BhzEntity> list3) {
        String id;
        String pId = "";
        String name;

        for (OrganizationBean.BiaoduanEntity entity : list1) {
            id = entity.getId()+",biaoduan";
            name = entity.getBiaoduanminchen();
            pId = "";
            treeNodes.add(new OrganizationNode(id, pId, name));
        }

        for (OrganizationBean.XmbEntity entity : list2) {
            id = entity.getId()+",xmb";
            name = entity.getXiangmubuminchen();
            pId =entity.getBiaoduanid()+",biaoduan";
            treeNodes.add(new OrganizationNode(id, pId, name));
        }

        for (OrganizationBean.BhzEntity entity : list3) {
            id = entity.getId()+",bhz";
            name = entity.getBanhezhanminchen();
            pId = entity.getXiangmubuid()+",xmb";
            OrganizationNode organizationNode=new OrganizationNode(id, pId, name);
            organizationNode.setShebeibianhao(entity.getGprsbianhao());
            treeNodes.add(organizationNode);
        }
    }
}
