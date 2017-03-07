package com.shtoone.liqing.mvp.view.others;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.shtoone.liqing.BaseApplication;
import com.shtoone.liqing.R;
import com.shtoone.liqing.common.Constants;
import com.shtoone.liqing.event.EventData;
import com.shtoone.liqing.mvp.contract.others.OrganizationContract;
import com.shtoone.liqing.mvp.model.bean.DepartmentBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationBean;
import com.shtoone.liqing.mvp.model.bean.OrganizationFragmentBean;
import com.shtoone.liqing.mvp.model.bean.ParametersData;
import com.shtoone.liqing.mvp.presenter.others.OrganizationPresenter;
import com.shtoone.liqing.mvp.view.adapter.OrganizationTreeListViewAdapter;
import com.shtoone.liqing.mvp.view.base.BaseFragment;
import com.shtoone.liqing.mvp.view.treeview.Node;
import com.shtoone.liqing.mvp.view.treeview.TreeListViewAdapter;
import com.shtoone.liqing.utils.ScreenUtils;
import com.shtoone.liqing.utils.ToastUtils;
import com.shtoone.liqing.widget.PageStateLayout;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrFrameLayout;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by gesangdianzi on 2016/11/30.
 */
public class OrganizationFragment extends BaseFragment<OrganizationContract.Presenter> implements OrganizationContract.View {


    private static final String TAG = OrganizationFragment.class.getSimpleName();

    private static OrganizationFragment mOrganizationFragement;
    @BindView(R.id.lv_tree_organization_fragment)
    ListView treeListView;
    @BindView(R.id.psl_organization_fragment)
    PageStateLayout pslOrganizationFragment;
    @BindView(R.id.ptr_organization_fragment)
    PtrFrameLayout ptrOrganizationFragment;
    @BindView(R.id.ll_container_organization_fragment)
    LinearLayout llContainerOrganizationFragment;

    private ParametersData mParametersData;
    private OrganizationFragmentBean data;
    private List<OrganizationBean> treeNodes;
    private OrganizationTreeListViewAdapter<OrganizationBean> mAdapter;
    private DepartmentBean mDepartmentData;
    public static OrganizationFragment newInstance(DepartmentBean departmentData) {
        Bundle args = new Bundle();
        args.putSerializable(Constants.DEPARTMENT, departmentData);
        OrganizationFragment fragment = new OrganizationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mDepartmentData = (DepartmentBean) args.getSerializable(Constants.DEPARTMENT);
        }

        KLog.e(TAG,mDepartmentData.toString());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        KLog.e("onCreateViewonCreateViewonCreateView");
        View view = inflater.inflate(R.layout.fragment_organization, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        // _mActivity.logFragmentStackHierarchy("111111");
        return view;

    }

    private void initData() {
        mPresenter.requestOrganization(mDepartmentData);
    }

    private void initView() {
        llContainerOrganizationFragment.setPadding(0, ScreenUtils.getStatusBarHeight(BaseApplication.mContext),0,0);
    }

    @NonNull
    @Override
    protected OrganizationContract.Presenter createPresenter() {
        return new OrganizationPresenter(this);
    }


    @Override
    public void showContent() {
    }

    @Override
    public void showError(Throwable t) {
        if (t instanceof ConnectException) {
         //   ToastUtils.showInfoToast(BaseApplication.mContext,"网络异常,请检测网络");
            ToastUtils.showToast(BaseApplication.mContext,"网络异常,请检测网络");
          //  messageTextView.setText("网络异常,请检测网络");
        } else if (t instanceof HttpException) {
            ToastUtils.showToast(BaseApplication.mContext,"服务器异常");
        //    messageTextView.setText("服务器异常，请重新下载");
        } else if (t instanceof SocketTimeoutException) {
            ToastUtils.showToast(BaseApplication.mContext,"连接超时");
           // messageTextView.setText("连接超时，请重新下载");
        } else if (t instanceof JSONException) {
            ToastUtils.showToast(BaseApplication.mContext,"解析异常");
           // messageTextView.setText("解析异常，请重新下载");
        } else {
            ToastUtils.showToast(BaseApplication.mContext,"数据异常");
           // messageTextView.setText("数据异常，请重新下载");
        }



    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }


    @Override
    public void responseOrganization(List<OrganizationBean> treeNodes) {
        try {
            mAdapter = new OrganizationTreeListViewAdapter<OrganizationBean>(treeListView, BaseApplication.mContext,treeNodes, 10);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        treeListView.setAdapter(mAdapter);
        mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                mDepartmentData.departmentName = node.getName();
                mDepartmentData.departmentID = node.getId();
                EventBus.getDefault().postSticky(new EventData(mDepartmentData));
                _mActivity.onBackPressedSupport();
            }
        });
    }


}
