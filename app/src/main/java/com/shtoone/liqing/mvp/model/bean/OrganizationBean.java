package com.shtoone.liqing.mvp.model.bean;

import com.shtoone.liqing.mvp.view.treeview.annotation.TreeNodeId;
import com.shtoone.liqing.mvp.view.treeview.annotation.TreeNodeLabel;
import com.shtoone.liqing.mvp.view.treeview.annotation.TreeNodePid;

/**
 * Created by gesangdianzi on 2016/12/12.
 */
public class OrganizationBean {

    @TreeNodeId    //标注之后，方便自己判断，了解
    private String _id;
    @TreeNodePid
    private String parentId;
    @TreeNodeLabel
    private String name;


    public OrganizationBean(String _id, String parentId, String name) {
        this._id = _id;
        this.parentId = parentId;
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
