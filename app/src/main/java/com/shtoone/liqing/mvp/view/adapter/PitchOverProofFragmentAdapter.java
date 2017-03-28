package com.shtoone.liqing.mvp.view.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofData;
import com.shtoone.liqing.widget.SlantedTextView;

import java.io.File;
import java.util.List;


/**
 * Author： hengzwd on 2017/3/17.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchOverProofFragmentAdapter extends BaseQuickAdapter<PitchOverProofData.DataEntity, BaseViewHolder> {
    private PitchOverProofData.FieldEntity fieldEntity;
    private PitchOverProofData.LqisshowEntity lqisshowEntity;

    private OnItemClickListener onItemClickListener;

    public PitchOverProofFragmentAdapter() {
        super(R.layout.item_recyclerview_pitchoverproof, null);
    }


    @Override
    protected void convert(final BaseViewHolder holder, PitchOverProofData.DataEntity item) {
        holder.setText(R.id.chaobiaochaxun_shijian, fieldEntity.getClTime() + ":" + item.getClTime())
                .setText(R.id.chaobiaochaxun_bianhao, fieldEntity.getBianhao() + ":" + item.getBianhao())
                .setText(R.id.chaobiaochaxun_bhjname, fieldEntity.getBhzName() + ":" + item.getBhzName())
                .setText(R.id.chaobiaochaxun_clwd, fieldEntity.getClwd() + ":" + item.getClwd())
                .setText(R.id.chaobiaochaxun_glwd, fieldEntity.getGlwd() + ":" + item.getGlwd())
                .setText(R.id.chaobiaochaxun_lqwd, fieldEntity.getLqwd() + ":" + item.getLqwd())
                .setText(R.id.chaobiaochaxun_item_sj1_z1, fieldEntity.getSjf1() + ":" + item.getSjf1())
                .setText(R.id.chaobiaochaxun_item_sj2_z2, fieldEntity.getSjf2() + ":" + item.getSjf2())
                .setText(R.id.chaobiaochaxun_item_sj3_z3, fieldEntity.getSjg1() + ":" + item.getSjg1())
                .setText(R.id.chaobiaochaxun_item_sj4_z4, fieldEntity.getSjg2() + ":" + item.getSjg2())
                .setText(R.id.chaobiaochaxun_item_sj5_z5, fieldEntity.getSjg3() + ":" + item.getSjg3())
                .setText(R.id.chaobiaochaxun_item_sj6_z6, fieldEntity.getSjg4() + ":" + item.getSjg4())
                .setText(R.id.chaobiaochaxun_item_sj7_z7, fieldEntity.getSjg5() + ":" + item.getSjg5())
                .setText(R.id.chaobiaochaxun_item_sj8_z8, fieldEntity.getSjg6() + ":" + item.getSjg6())
                .setText(R.id.chaobiaochaxun_item_sj9_z9, fieldEntity.getSjg7() + ":" + item.getSjg7())
                .setText(R.id.chaobiaochaxun_item_sj10_z10, fieldEntity.getSjlq() + ":" + item.getSjlq())
                .setText(R.id.chaobiaochaxun_item_sj11_z11, fieldEntity.getSjtjj() + ":" + item.getSjtjj())
                .setText(R.id.chaobiaochaxun_item_sj12_z12, fieldEntity.getSjysb() + ":" + item.getSjysb())
                .setOnClickListener(R.id.cv_item_recyclerview_pitchoverproof_fragment, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v, holder.getLayoutPosition());
                    }
                });
        ((TextView)holder.getView(R.id.chaobiaochaxun_clwd)).setVisibility(lqisshowEntity.getClwd().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_glwd)).setVisibility(lqisshowEntity.getGlwd().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_lqwd)).setVisibility(lqisshowEntity.getLqwd().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj1_z1)).setVisibility(lqisshowEntity.getSjf1().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj2_z2)).setVisibility(lqisshowEntity.getSjf2().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj3_z3)).setVisibility(lqisshowEntity.getSjg1().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj4_z4)).setVisibility(lqisshowEntity.getSjg2().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj5_z5)).setVisibility(lqisshowEntity.getSjg3().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj6_z6)).setVisibility(lqisshowEntity.getSjg4().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj7_z7)).setVisibility(lqisshowEntity.getSjg5().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj8_z8)).setVisibility(lqisshowEntity.getSjg6().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj9_z9)).setVisibility(lqisshowEntity.getSjg7().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj10_z10)).setVisibility(lqisshowEntity.getSjlq().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj11_z11)).setVisibility(lqisshowEntity.getSjtjj().equals("1")?View.VISIBLE:View.GONE);
        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj12_z12)).setVisibility(lqisshowEntity.getSjysb().equals("1")?View.VISIBLE:View.GONE);

        ((SlantedTextView) holder.getView(R.id.stv_chuzhi)).setText(item.getChuli().equals("0" )? "未处理" : "已处理")
                .setSlantedBackgroundColor(item.getChuli().equals("0" )? Color.RED : Color.parseColor("#2baf2b"));
        ((SlantedTextView) holder.getView(R.id.stv_shenhe)).setText(item.getShenhe().equals("0" )? "未审核" : "已审核")
                .setSlantedBackgroundColor(item.getShenhe().equals("0" )? Color.RED : Color.parseColor("#2baf2b"));


    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOverProofData(PitchOverProofData pitchOverProofData) {
        fieldEntity = pitchOverProofData.getField();
        lqisshowEntity = pitchOverProofData.getLqisshow();
        setNewData(pitchOverProofData.getData());
    }

    @Override
    public void setNewData(List<PitchOverProofData.DataEntity> data) {
        super.setNewData(data);
    }


}
