package com.shtoone.liqing.mvp.view.adapter;


import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PitchFragmentData;


/**
 * Author： hengzwd on 2017/3/8.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchFragmentRecyclerViewAdapter extends BaseQuickAdapter<PitchFragmentData.DataEntity, BaseViewHolder> {


    private OnItemClickListener onItemClickListener;

    public PitchFragmentRecyclerViewAdapter() {
        super(R.layout.item_recyclerview_pitch_fragment, null);
    }


    @Override
    protected void convert(final BaseViewHolder holder, PitchFragmentData.DataEntity item) {
        holder.setText(R.id.tv_organization_item_recyclerview_waterstability_fragment, item.getBanhezhanminchen())
                .setText(R.id.chaobiaotongji_panshu, item.getTotalPanshu())
                .setText(R.id.chaobiaotongji_chanliang, item.getTotalFangliang())
//                .setText(R.id.chaobiao_chaobiaopanshu1, item.getCbpanshu())
                .setText(R.id.chaobiao_chaobiaopanshu2, item.getMcbpanshu())
                .setText(R.id.chaobiao_chaobiaopanshu3, item.getHcbpanshu())
//                .setText(R.id.chaobiao_chaobiaolv1, item.getCblv())
                .setText(R.id.chaobiao_chaobiaolv2, item.getMcblv())
                .setText(R.id.chaobiao_chaobiaolv3, item.getHcblv())
//                .setText(R.id.chaobiao_chuzhilv1, item.getCzlv())
                .setText(R.id.chaobiao_chuzhilv2, item.getMczlv())
                .setText(R.id.chaobiao_chuzhilv3, item.getHczlv())
//                .setText(R.id.chaobiao_chuzhipanshu1,item.getCczpanshu())
                .setText(R.id.chaobiao_chuzhipanshu2,item.getMczpanshu())
                .setText(R.id.chaobiao_chuzhipanshu3,item.getHczpanshu())
                .setOnClickListener(R.id.cv_item_recyclerview_waterstability_fragment, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(holder.getConvertView(),holder.getLayoutPosition());
                    }
                });




    }

    public void setonitemclickListener(OnItemClickListener onItemClickListener) {

        this.onItemClickListener = onItemClickListener;
    }

}
