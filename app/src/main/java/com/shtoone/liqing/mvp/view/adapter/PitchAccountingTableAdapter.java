package com.shtoone.liqing.mvp.view.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofDetailsBean;

import java.util.List;

/**
 * Author： hengzwd on 2017/3/17.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchAccountingTableAdapter extends BaseQuickAdapter<PitchOverProofDetailsBean.LqDataEntity,BaseViewHolder> {



    private OnItemClickListener onItemClickListener;
    public PitchAccountingTableAdapter() {
        super(R.layout.item_recyclerview_pitchoverprooffragment, null);
    }

    @Override
    protected void convert(BaseViewHolder holder, PitchOverProofDetailsBean.LqDataEntity item) {

        holder.setText(R.id.tv_name_item_recyclerview__fragment,item.getName())
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

    public void setOverProofData(PitchOverProofDetailsBean pitchOverProofDetailsBean) {
        setNewData(pitchOverProofDetailsBean.getLqData());
    }

    @Override
    public void setNewData(List<PitchOverProofDetailsBean.LqDataEntity> data) {
        super.setNewData(data);
    }
}
