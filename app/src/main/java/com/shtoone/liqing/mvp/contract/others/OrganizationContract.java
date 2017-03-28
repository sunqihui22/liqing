package com.shtoone.liqing.mvp.contract.others;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationNode;
import com.shtoone.liqing.mvp.model.bean.UserInfoBean;

import java.util.List;

/**
 * Created by gesangdianzi on 2016/11/30.
 */
public interface OrganizationContract {
    interface View extends BaseContract.View {

        void responseOrganization(List<OrganizationNode> list);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestOrganization(DepartmentBean departmentBean);

    }

}
