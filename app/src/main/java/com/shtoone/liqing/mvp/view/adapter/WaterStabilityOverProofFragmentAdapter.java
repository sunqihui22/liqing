package com.shtoone.liqing.mvp.view.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;
import com.shtoone.liqing.widget.SlantedTextView;
import com.shtoone.liqing.widget.ui.MoreIconsTextView;

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
                .setText(R.id.chaobiaochaxun_item_sj9_z9, fieldEntity.getZcl() + ":" + item.getZcl())
                .setText(R.id.chaobiaochaxun_item_sj1_z1, fieldEntity.getSjf1())
                .setText(R.id.chaobiaochaxun_item_sj2_z2, fieldEntity.getSjf2())
                .setText(R.id.chaobiaochaxun_item_sj3_z3, fieldEntity.getSjg1())
                .setText(R.id.chaobiaochaxun_item_sj4_z4, fieldEntity.getSjg2())
                .setText(R.id.chaobiaochaxun_item_sj5_z5, fieldEntity.getSjg3())
                .setText(R.id.chaobiaochaxun_item_sj7_z7, fieldEntity.getSjg4())
                .setText(R.id.chaobiaochaxun_item_sj8_z8, fieldEntity.getSjg5())

//               .setText(R.id.chaobiaochaxun_item_sj1_z1, fieldEntity.getSjf1() + ":" + (item.getSjf1().equals("1") ? "上线低级超标" : item.getSjf1().equals("2") ? "上线中级超标" : item.getSjf1().equals("3") ? "上线高级超标" : item.getSjf1().equals("4") ? "下线低级超标" : item.getSjf1().equals("5") ? "下线中级超标" : item.getSjf1().equals("6") ? "下线高级超标" : ""))
//                .setBackgroundColor(R.id.chaobiaochaxun_item_sj1_z1, TextUtils.isEmpty(item.getSjf1()) ? Color.WHITE : item.getSjf1().compareTo("3") > 0 ? Color.parseColor("#ffa726") : Color.parseColor("#e84e40"))
//                .setText(R.id.chaobiaochaxun_item_sj2_z2, fieldEntity.getSjf2() + ":" + (item.getSjf2().equals("1") ? "上线低级超标" : item.getSjf2().equals("2") ? "上线中级超标" : item.getSjf2().equals("3") ? "上线高级超标" : item.getSjf2().equals("4") ? "下线低级超标" : item.getSjf2().equals("5") ? "下线中级超标" : item.getSjf2().equals("6") ? "下线高级超标" : ""))
//                .setBackgroundColor(R.id.chaobiaochaxun_item_sj2_z2, TextUtils.isEmpty(item.getSjf2()) ? Color.WHITE : item.getSjf2().compareTo("3") > 0 ? Color.parseColor("#ffa726") : Color.parseColor("#e84e40"))
//
//                .setText(R.id.chaobiaochaxun_item_sj3_z3, fieldEntity.getSjg1() + ":" + (item.getSjg1().equals("1") ? "上线低级超标" : item.getSjg1().equals("2") ? "上线中级超标" : item.getSjg1().equals("3") ? "上线高级超标" : item.getSjg1().equals("4") ? "下线低级超标" : item.getSjg1().equals("5") ? "下线中级超标" : item.getSjg1().equals("6") ? "下线高级超标" : ""))
//                .setBackgroundColor(R.id.chaobiaochaxun_item_sj3_z3, TextUtils.isEmpty(item.getSjg1()) ? Color.WHITE : item.getSjg1().compareTo("3") > 0 ? Color.parseColor("#ffa726") : Color.parseColor("#e84e40"))
//
//                .setText(R.id.chaobiaochaxun_item_sj4_z4, fieldEntity.getSjg2() + ":" + (item.getSjg2().equals("1") ? "上线低级超标" : item.getSjg2().equals("2") ? "上线中级超标" : item.getSjg2().equals("3") ? "上线高级超标" : item.getSjg2().equals("4") ? "下线低级超标" : item.getSjg2().equals("5") ? "下线中级超标" : item.getSjg2().equals("6") ? "下线高级超标" : ""))
//                .setBackgroundColor(R.id.chaobiaochaxun_item_sj4_z4, TextUtils.isEmpty(item.getSjg2()) ? Color.WHITE : item.getSjg2().compareTo("3") > 0 ? Color.parseColor("#ffa726") : Color.parseColor("#e84e40"))
//
//                .setText(R.id.chaobiaochaxun_item_sj5_z5, fieldEntity.getSjg3() + ":" + (item.getSjg3().equals("1") ? "上线低级超标" : item.getSjg3().equals("2") ? "上线中级超标" : item.getSjg3().equals("3") ? "上线高级超标" : item.getSjg3().equals("4") ? "下线低级超标" : item.getSjg3().equals("5") ? "下线中级超标" : item.getSjg3().equals("6") ? "下线高级超标" : ""))
//                .setBackgroundColor(R.id.chaobiaochaxun_item_sj5_z5, TextUtils.isEmpty(item.getSjg3()) ? Color.WHITE : item.getSjg3().compareTo("3") > 0 ? Color.parseColor("#ffa726") : Color.parseColor("#e84e40"))
//
//                .setText(R.id.chaobiaochaxun_item_sj7_z7, fieldEntity.getSjg4() + ":" + (item.getSjg4().equals("1") ? "上线低级超标" : item.getSjg4().equals("2") ? "上线中级超标" : item.getSjg4().equals("3") ? "上线高级超标" : item.getSjg4().equals("4") ? "下线低级超标" : item.getSjg4().equals("5") ? "下线中级超标" : item.getSjg4().equals("6") ? "下线高级超标" : ""))
//                .setBackgroundColor(R.id.chaobiaochaxun_item_sj7_z7, TextUtils.isEmpty(item.getSjg4()) ? Color.WHITE : item.getSjg4().compareTo("3") > 0 ? Color.parseColor("#ffa726") : Color.parseColor("#e84e40"))
//
//                .setText(R.id.chaobiaochaxun_item_sj8_z8, fieldEntity.getSjg5() + ":" + (item.getSjg5().equals("1") ? "上线低级超标" : item.getSjg5().equals("2") ? "上线中级超标" : item.getSjg5().equals("3") ? "上线高级超标" : item.getSjg5().equals("4") ? "下线低级超标" : item.getSjg5().equals("5") ? "下线中级超标" : item.getSjg5().equals("6") ? "下线高级超标" : ""))
//                .setBackgroundColor(R.id.chaobiaochaxun_item_sj8_z8, TextUtils.isEmpty(item.getSjg5()) ? Color.WHITE : item.getSjg5().compareTo("3") > 0 ? Color.parseColor("#ffa726") : Color.parseColor("#e84e40"))
//

                .setTextColor(R.id.chaobiaochaxun_item_sj1_z1, item.getSjf1().equals("1") ? Color.GREEN : item.getSjf1().equals("2") ?Color.GREEN : item.getSjf1().equals("3") ? Color.RED : item.getSjf1().equals("4") ? Color.GREEN : item.getSjf1().equals("5") ?Color.GREEN : item.getSjf1().equals("6") ? Color.RED : 0)
                .setTextColor(R.id.chaobiaochaxun_item_sj2_z2, item.getSjf2().equals("1") ? Color.GREEN : item.getSjf2().equals("2") ?Color.GREEN : item.getSjf2().equals("3") ? Color.RED : item.getSjf1().equals("4") ? Color.GREEN : item.getSjf1().equals("5") ?Color.GREEN : item.getSjf1().equals("6") ? Color.RED : 0)

                .setTextColor(R.id.chaobiaochaxun_item_sj3_z3, item.getSjg1().equals("1") ? Color.GREEN : item.getSjg1().equals("2") ?Color.GREEN : item.getSjg1().equals("3") ? Color.RED : item.getSjg1().equals("4") ? Color.GREEN : item.getSjg1().equals("5") ?Color.GREEN : item.getSjg1().equals("6") ? Color.RED : 0)

                .setTextColor(R.id.chaobiaochaxun_item_sj4_z4, item.getSjg2().equals("1") ? Color.GREEN : item.getSjg2().equals("2") ?Color.GREEN : item.getSjg2().equals("3") ? Color.RED : item.getSjg2().equals("4") ? Color.GREEN : item.getSjg2().equals("5") ?Color.GREEN : item.getSjg2().equals("6") ? Color.RED : 0)

                .setTextColor(R.id.chaobiaochaxun_item_sj5_z5, item.getSjg3().equals("1") ? Color.GREEN : item.getSjg3().equals("2") ?Color.GREEN : item.getSjg3().equals("3") ? Color.RED : item.getSjg3().equals("4") ? Color.GREEN : item.getSjg3().equals("5") ?Color.GREEN : item.getSjg3().equals("6") ? Color.RED : 0)

                .setTextColor(R.id.chaobiaochaxun_item_sj7_z7, item.getSjg4().equals("1") ? Color.GREEN : item.getSjg4().equals("2") ?Color.GREEN : item.getSjg4().equals("3") ? Color.RED : item.getSjg4().equals("4") ? Color.GREEN : item.getSjg4().equals("5") ?Color.GREEN : item.getSjg4().equals("6") ? Color.RED : 0)

                .setTextColor(R.id.chaobiaochaxun_item_sj8_z8, item.getSjg5().equals("1") ? Color.GREEN : item.getSjg5().equals("2") ?Color.GREEN : item.getSjg5().equals("3") ? Color.RED : item.getSjg5().equals("4") ? Color.GREEN : item.getSjg5().equals("5") ?Color.GREEN : item.getSjg5().equals("6") ? Color.RED : 0)


                .setOnClickListener(R.id.cv_item_recyclerview_pitchoverproof_fragment, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v, holder.getLayoutPosition());
                    }
                });
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj1_z1)).setVisibility(TextUtils.isEmpty(item.getSjf1()) ? View.GONE : View.VISIBLE);
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj2_z2)).setVisibility(TextUtils.isEmpty(item.getSjf2()) ? View.GONE : View.VISIBLE);
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj3_z3)).setVisibility(TextUtils.isEmpty(item.getSjg1()) ? View.GONE : View.VISIBLE);
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj4_z4)).setVisibility(TextUtils.isEmpty(item.getSjg2()) ? View.GONE : View.VISIBLE);
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj5_z5)).setVisibility(TextUtils.isEmpty(item.getSjg3()) ? View.GONE : View.VISIBLE);
//        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj6_z6)).setVisibility(isShowEntity.getSjg4().equals("1")?View.VISIBLE:View.GONE);
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj7_z7)).setVisibility(TextUtils.isEmpty(item.getSjg4()) ? View.GONE : View.VISIBLE);
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj8_z8)).setVisibility(TextUtils.isEmpty(item.getSjg5()) ? View.GONE : View.VISIBLE);

        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj1_z1)).setBitmapRescource(item.getSjf1().compareTo("3") > 0 ? R.drawable.ic_yellow_arrow_top : R.drawable.ic_blue_arrow_down, getlevel(item.getSjf1()));
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj2_z2)).setBitmapRescource(item.getSjf2().compareTo("3") > 0 ? R.drawable.ic_yellow_arrow_top : R.drawable.ic_blue_arrow_down, getlevel(item.getSjf2()));
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj3_z3)).setBitmapRescource(item.getSjg1().compareTo("3") > 0 ? R.drawable.ic_yellow_arrow_top : R.drawable.ic_blue_arrow_down, getlevel(item.getSjg1()));
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj4_z4)).setBitmapRescource(item.getSjg2().compareTo("3") > 0 ? R.drawable.ic_yellow_arrow_top : R.drawable.ic_blue_arrow_down, getlevel(item.getSjg2()));
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj5_z5)).setBitmapRescource(item.getSjg3().compareTo("3") > 0 ? R.drawable.ic_yellow_arrow_top : R.drawable.ic_blue_arrow_down, getlevel(item.getSjg3()));
//        ((TextView)holder.getView(R.id.chaobiaochaxun_item_sj6_z6)).setVisibility(isShowEntity.getSjg4().equals("1")?View.VISIBLE:View.GONE);
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj7_z7)).setBitmapRescource(item.getSjg4().compareTo("3") > 0 ? R.drawable.ic_yellow_arrow_top : R.drawable.ic_blue_arrow_down, getlevel(item.getSjg4()));
        ((MoreIconsTextView) holder.getView(R.id.chaobiaochaxun_item_sj8_z8)).setBitmapRescource(item.getSjg5().compareTo("3") > 0 ? R.drawable.ic_yellow_arrow_top : R.drawable.ic_blue_arrow_down, getlevel(item.getSjg5()));

        ((SlantedTextView) holder.getView(R.id.stv_chuzhi)).setText(item.getChuli().equals("0") ? "未处理" : "已处理")
                .setSlantedBackgroundColor(item.getChuli().equals("0") ? Color.RED : Color.parseColor("#2baf2b"));
        ((SlantedTextView) holder.getView(R.id.stv_hege)).setText(item.getShenhe().equals("0") ? "未审核" : "已审核")
                .setSlantedBackgroundColor(item.getShenhe().equals("0") ? Color.RED : Color.parseColor("#2baf2b"));

    }

    private int getlevel(String s) {
        int i = 0;
        if (s != null) {
            if (s.equals("1") || s.equals("4")) {
                i = 1;
            } else if (s.equals("2") || s.equals("5")) {
//                i = 2;
                i=1;
            } else if (s.equals("3") || s.equals("6")) {
                i = 3;
            }
        }
        return i;
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
