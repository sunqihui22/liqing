package com.shtoone.liqing.mvp.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.MaterialStatisticsData;
import com.shtoone.liqing.mvp.model.bean.PitchStatisticsData;

/**
 * @author: Administrator
 * @time 2017-03-15 16:43
 * @email 770164810@qq.com
 */

public class PitchMaterialStatisticsRecycleViewAdapter extends BaseQuickAdapter<PitchStatisticsData.DataBean, BaseViewHolder> {
//    private OnItemClickListener onItemClickListener;

    public PitchMaterialStatisticsRecycleViewAdapter() {
        super(R.layout.item_pitch_recyclerview_material_statistic_fragment, null);
    }

    @Override
    protected void convert(final BaseViewHolder holder, PitchStatisticsData.DataBean item) {
        String name = item.getName();
        if(name.indexOf("实际") != -1){
            name = name.substring(2,name.length());
        }
        holder.setText(R.id.tv_lq_name_item_recyclerview_material_statistic_fragment, name)
                .setText(R.id.tv_lq_dosage_item_recyclerview_material_statistic_fragment, item.getYongliang())
                .setText(R.id.tv_lq_peibi_item_recyclerview_material_statistic_fragment, item.getMbpeibi())
                .setText(R.id.tv_lq_wucha_item_recyclerview_material_statistic_fragment, item.getWucha());


    }

//    public void setonitemclickListener(OnItemClickListener onItemClickListener) {
//
//        this.onItemClickListener = onItemClickListener;
//    }

}
