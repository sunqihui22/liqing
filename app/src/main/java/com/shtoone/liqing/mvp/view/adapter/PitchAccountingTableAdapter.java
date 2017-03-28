package com.shtoone.liqing.mvp.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;

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
                .setText(R.id.tv_wucha_item_recyclerview_fragment,item.getWucha());

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
