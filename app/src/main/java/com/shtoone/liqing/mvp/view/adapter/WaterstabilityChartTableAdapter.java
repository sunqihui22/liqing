package com.shtoone.liqing.mvp.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofDetailsBean;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityProductionQueryDetailData;

import java.util.List;

/**
 * Author： hengzwd on 2017/3/21.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterstabilityChartTableAdapter extends BaseQuickAdapter<WaterStabilityProductionQueryDetailData.SwChartDataListEntity, BaseViewHolder> {

    private OnItemClickListener onItemClickListener;

    public WaterstabilityChartTableAdapter() {
        super(R.layout.item_recyclerview_waterstabilityproductiondetail, null);
    }


    @Override
    protected void convert(BaseViewHolder holder, WaterStabilityProductionQueryDetailData.SwChartDataListEntity item) {

        holder.setText(R.id.tv_name_item_recyclerview__fragment, item.getName())
                .setText(R.id.tv_biaozhun_item_recyclerview__fragment, item.getStandPassper())
                .setText(R.id.tv_shiji_item_recyclerview_fragment, item.getPassper())
                .setText(R.id.tv_wucha_item_recyclerview_fragment, item.getWcz())
                .setText(R.id.tv_yujing_item_recyclerview_fragment, item.getYjz());


    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public void setOverProofData(WaterStabilityProductionQueryDetailData waterStabilityProductionQueryDetailData) {
        setNewData(waterStabilityProductionQueryDetailData.getSwChartDataList());
    }

    @Override
    public void setNewData(List<WaterStabilityProductionQueryDetailData.SwChartDataListEntity> data) {
        super.setNewData(data);
    }

}
