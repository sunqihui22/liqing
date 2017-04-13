package com.shtoone.liqing.mvp.view.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PitchProductQueryData;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityHistoryData;

import java.util.List;

/**
 * Author： hengzwd on 2017/3/22.
 * Email：hengzwdhengzwd@qq.com
 */

public class PitchProductionqueryFragmentAdapter extends BaseQuickAdapter<PitchProductQueryData.DataEntity, BaseViewHolder> {


    private PitchProductQueryData.LqisshowEntity isShowEntity;
    private PitchProductQueryData.FieldEntity fieldEntity;
    private OnItemClickListener onItemClickListener;

    public PitchProductionqueryFragmentAdapter() {
        super(R.layout.item_recyclerview_pitchproducquery, null);
    }


    @Override
    protected void convert(final BaseViewHolder holder, PitchProductQueryData.DataEntity item) {

        holder.setText(R.id.chaobiaochaxun_shijian, fieldEntity.getClTime() + ":" + item.getClTime())
                .setText(R.id.chaobiaochaxun_bzhName, fieldEntity.getBhzName() + ":" + item.getBhzName())
                .setText(R.id.chaobiaochaxun_chuliaowendu, fieldEntity.getClwd() + ":" + item.getClwd())
                .setText(R.id.chaobiaochaxun_shiliaowendu, fieldEntity.getGlwd() + ":" + item.getGlwd())
                .setText(R.id.chaobiaochaxun_liqingwendu, fieldEntity.getLqwd() + ":" + item.getLqwd())
//                .setText(R.id.chaobiaochaxun_bianhao, fieldEntity.getBianhao() + ":" + item.getBianhao())
//                .setText(R.id.chaobiaochaxun_userPosition, fieldEntity.getUsePosition()+":" + item.getUsePosition())
//                .setText(R.id.chaobiaochaxun_sjshui, fieldEntity.getSjshui() + ":" + item.getSjshui())
//                .setText(R.id.chaobiaochaxun_zcl, fieldEntity.getZcl() + ":" + item.getZcl())
//                .setText(R.id.chaobiaochaxun_item_sj1_z1, fieldEntity.getSjf1() + ":" + item.getSjf1())
//                .setText(R.id.chaobiaochaxun_item_sj2_z2, fieldEntity.getSjf2() + ":" + item.getSjf2())
//                .setText(R.id.chaobiaochaxun_item_sj1, fieldEntity.getSjg1() + ":" + item.getSjg1())
//                .setText(R.id.chaobiaochaxun_item_sj2, fieldEntity.getSjg2() + ":" + item.getSjg2())
//                .setText(R.id.chaobiaochaxun_item_sj3, fieldEntity.getSjg3() + ":" + item.getSjg3())
//                .setText(R.id.chaobiaochaxun_item_sj4, fieldEntity.getSjg4() + ":" + item.getSjg4())
//                .setText(R.id.chaobiaochaxun_item_sj5, fieldEntity.getSjg5() + ":" + item.getSjg5())
//                .setText(R.id.chaobiaochaxun_item_sj6, fieldEntity.getSjg6() + ":" + item.getSjg6())
//                .setText(R.id.chaobiaochaxun_item_sj7, fieldEntity.getSjg7() + ":" + item.getSjg7())
                .setText(R.id.chaobiaochaxun_item_sjlq, fieldEntity.getSjlq() + ":" + item.getSjlq())
                .setText(R.id.chaobiaochaxun_item_sjysb, fieldEntity.getSjysb() + ":" + item.getSjysb())
                .setText(R.id.chaobiaochaxun_item_sjtjj, fieldEntity.getSjtjj() + ":" + item.getSjtjj())
                .setOnClickListener(R.id.cv_item_recyclerview_waterstabilityproductionquery_fragment, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v, holder.getLayoutPosition());
                    }
                });

//        ((TextView) holder.getView(R.id.chaobiaochaxun_chuliaowendu)).setVisibility(isShowEntity.getClwd().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_shiliaowendu)).setVisibility(isShowEntity.getGlwd().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_liqingwendu)).setVisibility(isShowEntity.getLqwd().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj1_z1)).setVisibility(isShowEntity.getSjf1().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj2_z2)).setVisibility(isShowEntity.getSjf2().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj1)).setVisibility(isShowEntity.getSjg1().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj2)).setVisibility(isShowEntity.getSjg2().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj3)).setVisibility(isShowEntity.getSjg3().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj4)).setVisibility(isShowEntity.getSjg4().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj5)).setVisibility(isShowEntity.getSjg5().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj6)).setVisibility(isShowEntity.getSjg6().equals("1") ? View.VISIBLE : View.GONE);
//        ((TextView) holder.getView(R.id.chaobiaochaxun_item_sj7)).setVisibility(isShowEntity.getSjg7().equals("1") ? View.VISIBLE : View.GONE);

    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOverProofData(PitchProductQueryData pitchProductQueryData) {
        fieldEntity = pitchProductQueryData.getField();
        isShowEntity = pitchProductQueryData.getLqisshow();
        setNewData(pitchProductQueryData.getData());
    }

    @Override
    public void setNewData(List<PitchProductQueryData.DataEntity> data) {
        super.setNewData(data);
    }
}
