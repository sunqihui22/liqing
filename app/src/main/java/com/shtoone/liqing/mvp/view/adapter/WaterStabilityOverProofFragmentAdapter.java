package com.shtoone.liqing.mvp.view.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;
import com.shtoone.liqing.widget.SlantedTextView;

import java.util.List;

/**
 * Author： hengzwd on 2017/3/14.
 * Email：hengzwdhengzwd@qq.com
 */

public class WaterStabilityOverProofFragmentAdapter extends BaseQuickAdapter<WaterStabilityOverProofBean.DataEntity, BaseViewHolder> {

    private WaterStabilityOverProofBean.IsShowEntity isShowEntity;
    private WaterStabilityOverProofBean.FieldEntity fieldEntity;
    private OnItemClickListener onItemClickListener;

    public WaterStabilityOverProofFragmentAdapter() {
        super(R.layout.item_recyclerview_waterstabilityoverproof, null);
    }


    @Override
    protected void convert(final BaseViewHolder holder, WaterStabilityOverProofBean.DataEntity item) {
        holder.setText(R.id.chaobiaochaxun_shijian, fieldEntity.getClTime() + ":" + item.getClTime())
                .setText(R.id.chaobiaochaxun_bhzname, fieldEntity.getBzhName() + ":" + item.getBzhName())
                .setText(R.id.chaobiaochaxun_bianhao, fieldEntity.getBianhao() + ":" + item.getBianhao())
                .setText(R.id.chaobiaochaxun_item_sj1_z1, fieldEntity.getSjf1() + ":" + item.getSjf1())
                .setText(R.id.chaobiaochaxun_item_sj2_z2, fieldEntity.getSjf2() + ":" + item.getSjf2())
                .setText(R.id.chaobiaochaxun_item_sj3_z3, fieldEntity.getSjg1() + ":" + item.getSjg1())
                .setText(R.id.chaobiaochaxun_item_sj4_z4, fieldEntity.getSjg2() + ":" + item.getSjg2())
                .setText(R.id.chaobiaochaxun_item_sj5_z5, fieldEntity.getSjg3() + ":" + item.getSjg3())
                .setText(R.id.chaobiaochaxun_item_sj7_z7, fieldEntity.getSjg4() + ":" + item.getSjg4())
                .setText(R.id.chaobiaochaxun_item_sj8_z8, fieldEntity.getSjg5() + ":" + item.getSjg5())
                .setText(R.id.chaobiaochaxun_item_sj9_z9, fieldEntity.getZcl() + ":" + item.getZcl())
                .setOnClickListener(R.id.cv_item_recyclerview_pitchoverproof_fragment, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v, holder.getLayoutPosition());
                    }
                });

        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj1_z1)).setVisibility(isShowEntity.getSjf1().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj2_z2)).setVisibility(isShowEntity.getSjf2().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj3_z3)).setVisibility(isShowEntity.getSjg1().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj4_z4)).setVisibility(isShowEntity.getSjg2().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj5_z5)).setVisibility(isShowEntity.getSjg3().equals("1")?View.VISIBLE:View.GONE);
//        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj6_z6)).setVisibility(isShowEntity.getSjg4().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj7_z7)).setVisibility(isShowEntity.getSjg4().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj8_z8)).setVisibility(isShowEntity.getSjg5().equals("1")?View.VISIBLE:View.GONE);

        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj9_z9)).setVisibility(isShowEntity.getZcl().equals("1")?View.VISIBLE:View.GONE);

        ((SlantedTextView) holder.getView(R.id.stv_chuzhi)).setText(item.getChuli().equals("0" )? "未处理" : "已处理")
                .setSlantedBackgroundColor(item.getChuli().equals("0" )? Color.RED : Color.parseColor("#2baf2b"));
        ((SlantedTextView) holder.getView(R.id.stv_hege)).setText(item.getShenhe().equals("0" )? "未审核" : "已审核")
                .setSlantedBackgroundColor(item.getShenhe().equals("0" )? Color.RED : Color.parseColor("#2baf2b"));

    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOverProofData(WaterStabilityOverProofBean waterStabilityOverProofBean) {
        fieldEntity = waterStabilityOverProofBean.getField();
        isShowEntity = waterStabilityOverProofBean.getIsShow();
        setNewData(waterStabilityOverProofBean.getData());
    }

    @Override
    public void setNewData(List<WaterStabilityOverProofBean.DataEntity> data) {
        super.setNewData(data);
    }

}
