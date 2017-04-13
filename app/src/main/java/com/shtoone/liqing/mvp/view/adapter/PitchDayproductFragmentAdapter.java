package com.shtoone.liqing.mvp.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PitchDayProductQueryData;

import java.util.List;

/**
 * Author： hengzwd on 2017/3/23.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchDayproductFragmentAdapter extends BaseQuickAdapter<PitchDayProductQueryData.DataEntity, BaseViewHolder> {


    private OnItemClickListener onItemClickListener;
    public PitchDayproductFragmentAdapter() {
        super(R.layout.item_recyclerview_pitchdayproduct, null);
    }


    @Override
    protected void convert(BaseViewHolder holder, PitchDayProductQueryData.DataEntity item) {

        holder
//                .setText(R.id.tv_dayproduct_changdu,"长度："+item.getDailycd())
                .setText(R.id.tv_dayproduct_chanliang,"产量:"+item.getDailycl())
//                .setText(R.id.tv_dayproduct_houdu,"厚度:"+item.getDailyhd())
//                .setText(R.id.tv_dayproduct_kuandu,"宽度:"+item.getDailykd())
//                .setText(R.id.tv_dayproduct_midu,"密度:"+item.getDailymd())
                .setText(R.id.tv_dayproduct_name,"拌合站名称:"+item.getBanhezhanminchen())
//                .setText(R.id.tv_dayproduct_panshu,"盘数:"+item.getDailyps())
                .setText(R.id.tv_dayproduct_riqi,"日期:"+item.getDailyrq())
//                .setText(R.id.tv_dayproduct_shejihoudu,"厚度:"+item.getDailysjhd())
                .setText(R.id.tv_dayproduct_shigongzhuanghao,"施工桩号:"+item.getDailybuwei())
                .setText(R.id.tv_dayproduct_xinghao,"型号:"+item.getDailyxh());
//                .setText(R.id.tv_dayproduct_xiuzhengchanliang,"修正产量:"+item.getDailyxzcl());

    }



    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
