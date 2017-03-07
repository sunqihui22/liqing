package com.shtoone.liqing.mvp.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.PendingTreatRVItemData;
import com.shtoone.liqing.mvp.model.bean.PendingTreatRVListData;
import com.shtoone.liqing.widget.SlantedTextView;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Administrator on 2016/11/29.
 */
public class PendingTreatmentFragmentRVAdapter extends RecyclerView.Adapter {

    private List<PendingTreatRVListData> lists;
    PendingTreatRVListData  mlistdata;
    private Resources mResources;
    private Context context;
    private OnItemClickListener mOnItemClickListener;


    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }



    public PendingTreatmentFragmentRVAdapter(SupportActivity mActivity, List<PendingTreatRVListData> pendingTreatDataList) {
        super();
        context=mActivity;
        lists=pendingTreatDataList;
        mResources = context.getResources();
        KLog.e("---PendingTreatmentFragmentRVAdapter---");
//        KLog.e("---lists="+lists.size());

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
//        KLog.e("------onBindViewHolder------");
        if (holder instanceof ItemViewHolder && null!=lists&&lists.size()>0) {
            KLog.e("--onBindViewHolder--");
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            mlistdata = lists.get(position);
            mItemViewHolder.t_date.setText(mlistdata.getShijian());
            mItemViewHolder.tv_bianhao.setText("编号："+mlistdata.getBianhao());
            if ("0".equals(mlistdata.getChuli())) {
                KLog.e("--------未处置-------");
                mItemViewHolder.stv_examine.setText("未处置");
                mItemViewHolder.stv_examine.setTextColor(Color.RED);
                mItemViewHolder.stv_examine.setVisibility(View.VISIBLE);
            } else if ("1".equals(mlistdata.getChuli())){
                KLog.e("-------已处置-------");
                mItemViewHolder.stv_examine.setText("已处置");
                mItemViewHolder.stv_examine.setVisibility(View.VISIBLE);
                mItemViewHolder.stv_examine.setTextColor(Color.GREEN);
            }
            List<PendingTreatRVItemData> lists2 = mlistdata.getLists();
//            KLog.e("size="+lists2.size());
            for (int i = 0; i < lists2.size(); i++) {
                PendingTreatRVItemData item = lists2.get(i);
                if (i == 0) {
//                    KLog.e("--00000000000000000000--");
                    mItemViewHolder.tv_n1.setText(item.getName()+":");
                    mItemViewHolder.tv_z1.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z1.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z1.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z1.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 1) {
//                    KLog.e("--1111111111111111111--");
                    mItemViewHolder.tv_n2.setText(item.getName()+":");
                    mItemViewHolder.tv_z2.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z2.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z2.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z2.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 2) {
//                    KLog.e("--2222222222222222222--");
                    mItemViewHolder.tv_n3.setText(item.getName()+":");
                    mItemViewHolder.tv_z3.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z3.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z4.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z3.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 3) {
//                    KLog.e("--3333333333333333333--");
                    mItemViewHolder.tv_n4.setText(item.getName()+":");
                    mItemViewHolder.tv_z4.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z4.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z4.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z4.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 4) {
//                    KLog.e("--4444444444444444444--");
                    mItemViewHolder.tv_n5.setText(item.getName()+":");
                    mItemViewHolder.tv_z5.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z5.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z5.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z5.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 5) {
//                    KLog.e("--55555555555555555555--");
                    mItemViewHolder.tv_n6.setText(item.getName()+":");
                    mItemViewHolder.tv_z6.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z6.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z6.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z6.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 6) {
//                    KLog.e("--666666666666666666666--");
                    mItemViewHolder.tv_n7.setText(item.getName()+":");
                    mItemViewHolder.tv_z7.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z7.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z7.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z7.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 7) {
//                    KLog.e("--77777777777777777777--");
                    mItemViewHolder.tv_n8.setText(item.getName()+":");
                    mItemViewHolder.tv_z8.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z8.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z8.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z8.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 8) {
//                    KLog.e("--8888888888888888888888--");
                    mItemViewHolder.tv_n9.setText(item.getName()+":");
                    mItemViewHolder.tv_z9.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z9.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z9.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z9.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 9) {
//                    KLog.e("--99999999999999999999999--");
                    mItemViewHolder.tv_n10.setText(item.getName()+":");
                    mItemViewHolder.tv_z10.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z10.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z10.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z10.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 10) {
//                    KLog.e("--101010101010110--");
                    mItemViewHolder.tv_n11.setText(item.getName()+":");
                    mItemViewHolder.tv_z11.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z11.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z11.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z11.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
                if (i == 11) {
//                    KLog.e("--1-1-1-1-1-1-1-1-1-1--");
                    mItemViewHolder.tv_n12.setText(item.getName()+":");
                    mItemViewHolder.tv_z12.setText(item.getData()+"%");
                    if ("".equals(item.getCb())) {
                    } else if ("1".equals(item.getCb()) || "4".equals(item.getCb())) {
                        mItemViewHolder.tv_z1.setTextColor(context.getResources().getColor(R.color.blue));
                    } else if ("2".equals(item.getCb()) || "5".equals(item.getCb())) {
                        mItemViewHolder.tv_z1.setTextColor(context.getResources().getColor(R.color.green));
                    } else if ("3".equals(item.getCb()) || "6".equals(item.getCb())) {
                        mItemViewHolder.tv_z1.setTextColor(context.getResources().getColor(R.color.red));
                    }
                }
            }

            if (mOnItemClickListener != null) {
                mItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder.itemView, position);
                    }
                });
            }

        }

    }


    @Override
    public int getItemCount() {
        if (lists != null && lists.size() > 0) {
            //这里的10是根据分页查询，一页该显示的条数
            if (lists.size() > 9) {
//                KLog.e("----getItemCount-----");
                return lists.size() + 1;
            } else {
                return lists.size();
            }
        }
        return 0;
    }


//    @Override
//    public int getItemCount() {
//        return lists.size() + 1;
//
//    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount() && getItemCount() > 9) {
            KLog.e("----getItemViewType-----");
            return ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_pendingtreat, parent, false));
        } else if (viewType == ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            KLog.e("--onCreateViewHolder--");
            return new FootViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_footer, parent, false));
        }
        return null;

    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }


    private class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        public TextView t_date;
        public TextView tv_bianhao;
        public TextView tv_n1;
        public TextView tv_n2;
        public TextView tv_n3;
        public TextView tv_n4;
        public TextView tv_n5;
        public TextView tv_n6;
        public TextView tv_n7;
        public TextView tv_n8;
        public TextView tv_n9;
        public TextView tv_n10;
        public TextView tv_n11;
        public TextView tv_n12;
        public TextView tv_z1;
        public TextView tv_z2;
        public TextView tv_z3;
        public TextView tv_z4;
        public TextView tv_z5;
        public TextView tv_z6;
        public TextView tv_z7;
        public TextView tv_z8;
        public TextView tv_z9;
        public TextView tv_z10;
        public TextView tv_z11;
        public TextView tv_z12;
        public SlantedTextView stv_examine;


        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_pitchoverproof_fragment);
            t_date = (TextView) view.findViewById(R.id.chaobiaochaxun_shijian);
            tv_bianhao = (TextView) view.findViewById(R.id.chaobiaochaxun_bianhao);
            tv_n1 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj1);
            tv_n2 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj2);
            tv_n3 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj3);
            tv_n4 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj4);
            tv_n5 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj5);
            tv_n6 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj6);
            tv_n7 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj7);
            tv_n8 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj8);
            tv_n9 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj9);
            tv_n10 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj10);
            tv_n11 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj11);
            tv_n12 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj12);
            tv_z1 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj1_z1);
            tv_z2 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj2_z2);
            tv_z3 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj3_z3);
            tv_z4 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj4_z4);
            tv_z5 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj5_z5);
            tv_z6 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj6_z6);
            tv_z7 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj7_z7);
            tv_z8 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj8_z8);
            tv_z9 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj9_z9);
            tv_z10 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj10_z10);
            tv_z11 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj11_z11);
            tv_z12 = (TextView) view.findViewById(R.id.chaobiaochaxun_item_sj12_z12);
            stv_examine = (SlantedTextView) view.findViewById(R.id.stv_examine_item_recyclerview_produce_query_fragment);
        }
    }
}
