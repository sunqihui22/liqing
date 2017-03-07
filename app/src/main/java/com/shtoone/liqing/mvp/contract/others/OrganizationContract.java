package com.shtoone.liqing.mvp.contract.others;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationBean;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/11/30.
 */
public interface OrganizationContract {
    interface View extends BaseContract.View {

      void   responseOrganization(List<OrganizationBean> treeNodes);
    }

    interface Presenter extends BaseContract.Presenter {
       void requestOrganization(DepartmentBean mdepartmentData);

    }

}
