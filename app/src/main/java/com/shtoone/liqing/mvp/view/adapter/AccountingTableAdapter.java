package com.shtoone.liqing.mvp.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;

import java.util.List;

/**
 * Author： hengzwd on 2017/3/15.
 * Email：hengzwdhengzwd@qq.com
 */

public class AccountingTableAdapter extends BaseQuickAdapter<WaterStabilityOverProofDetailsBean.SwDataEntity,BaseViewHolder> {

    private OnItemClickListener onItemClickListener;
    public AccountingTableAdapter() {
        super(R.layout.item_recyclerview_waterstabilityoverprooffragment, null);
    }


    @Override
    protected void convert(BaseViewHolder holder, WaterStabilityOverProofDetailsBean.SwDataEntity item) {

        holder.setText(R.id.tv_name_item_recyclerview__fragment,item.getName())
                .setText(R.id.tv_mubiaopeibi_item_recyclerview_fragment,item.getMbpeibi())
                .setText(R.id.tv_scpeibi_item_recyclerview_fragment,item.getScpeibi())
                .setText(R.id.tv_sgpeibi_item_recyclerview_fragment,item.getSgpeibi())
                .setText(R.id.tv_shengchanyongliang_item_recyclerview__fragment,item.getYongliang())
                .setText(R.id.tv_wucha_item_recyclerview_fragment,item.getWucha())
        .setTextColor(R.id.tv_wucha_item_recyclerview_fragment, TextUtils.isEmpty(item.getCblx()) ? Color.GRAY : item.getCblx().equals("2")||item.getCblx().equals("5") ? Color.GREEN :item.getCblx().equals("3")||item.getCblx().equals("6")? Color.RED:Color.GREEN);
        ((TextView)holder.getView(R.id.tv_wucha_item_recyclerview_fragment)).setCompoundDrawablesWithIntrinsicBounds(0,0,TextUtils.isEmpty(item.getCblx())?0: item.getCblx().compareTo("3") > 0 ? R.drawable.ic_arrow_upward_black_24dp :R.drawable.ic_arrow_downward_black_24dp,0);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public void setOverProofData(WaterStabilityOverProofDetailsBean WaterStabilityOverProofDetailsBean) {
        setNewData(WaterStabilityOverProofDetailsBean.getSwData());
    }

    @Override
    public void setNewData(List<WaterStabilityOverProofDetailsBean.SwDataEntity> data) {
        super.setNewData(data);
    }
}
