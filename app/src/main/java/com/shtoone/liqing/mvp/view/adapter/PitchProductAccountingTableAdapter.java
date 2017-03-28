package com.shtoone.liqing.mvp.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.PitchProductqueryDetailDatas;

import java.util.List;

/**
 * Author： hengzwd on 2017/3/23.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchProductAccountingTableAdapter extends BaseQuickAdapter<PitchProductqueryDetailDatas.LqDataEntity,BaseViewHolder> {



    private OnItemClickListener onItemClickListener;
    public PitchProductAccountingTableAdapter() {
        super(R.layout.item_recyclerview_pitchproductquerydetail, null);
    }

    @Override
    protected void convert(BaseViewHolder holder, PitchProductqueryDetailDatas.LqDataEntity item) {

        holder.setText(R.id.tv_name_item_recyclerview__fragment,item.getName())
                .setText(R.id.tv_scpeibi_item_recyclerview_fragment,item.getScpeibi())
                .setText(R.id.tv_mubiaopeibi_item_recyclerview_fragment,item.getSgpeibi())
                .setText(R.id.tv_shengchanyongliang_item_recyclerview__fragment,item.getYongliang())
                .setText(R.id.tv_wucha_item_recyclerview_fragment,item.getWucha());
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOverProofData(PitchProductqueryDetailDatas pitchProductqueryDetailDatas) {
        setNewData(pitchProductqueryDetailDatas.getLqData());
    }

    @Override
    public void setNewData(List<PitchProductqueryDetailDatas.LqDataEntity> data) {
        super.setNewData(data);
    }
}
