package com.shtoone.liqing.mvp.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.liqing.R;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountRes;
import com.shtoone.liqing.mvp.model.bean.DayProduceAmountResData;
import com.socks.library.KLog;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
public class DayProdeceAmountRecyclerViewAdapter extends RecyclerView.Adapter{

    private static final String TAG = DayProdeceAmountRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private Resources mResources;
    private DayProduceAmountRes dayProduceAmountRes;
    private OnItemClickListener mOnItemClickListener;
    private static final int view_type_item = 0;
    private static final int view_type_footer = 1;
    private List<DayProduceAmountResData> itemData;


    public DayProdeceAmountRecyclerViewAdapter(Context context, List<DayProduceAmountResData> dayProduceAmountResData) {
        super();
        this.context = context;
//        this.dayProduceAmountRes = dayProduceAmountRes;
//        itemData=dayProduceAmountRes.getData();
        itemData=dayProduceAmountResData;
        this.mResources = context.getResources();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {

        if (null != itemData && itemData.size() > 0 ) {
            KLog.e(TAG,"---getItemCount---");
            if (itemData.size() > 4) {
                return itemData.size() + 1;
            } else {
                return itemData.size();

            }
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() > 4 && position + 1 == getItemCount()) {
            return view_type_footer;
        } else {
            return view_type_item;
        }

    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (itemData != null  && itemData.size() > 0) {
            KLog.e("---onBindViewHolder---");
            if(holder instanceof itemViewHolder){

                KLog.e("-----------------");
                itemViewHolder itemViewHolder = (DayProdeceAmountRecyclerViewAdapter.itemViewHolder) holder;
                DayProduceAmountResData data = itemData.get(position);
                KLog.e(TAG,data.toString());
                itemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
                itemViewHolder.tv_txtRichanliangDate.setText(data.getDailyrq());
                itemViewHolder.tv_txtRichanliangShigongzhuanghao.setText(data.getDailybuwei());
                itemViewHolder.tv_txtRichanliangCaijichanliang.setText(data.getDailycl());
                itemViewHolder.tv_txtRichanliangPanshu.setText(data.getDailyps());
                itemViewHolder.tv_txtRichanliangXiuzhengchanliang.setText(data.getDailyxzcl());
                itemViewHolder.tv_txtRichanliangMidu.setText(data.getDailymd());
                itemViewHolder.tv_txtRichanliangChang.setText(data.getDailycd());
                itemViewHolder.tv_txtRichanliangKuan.setText(data.getDailykd());
                itemViewHolder.tv_txtRichanliangHou.setText(data.getDailyhd());
                KLog.e(TAG,itemViewHolder.tv_txtRichanliangDate);
            }
        }

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == view_type_item) {
            return new itemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_day_produce_amount_fragment, parent, false));
        } else if (viewType == view_type_footer) {
            return new footViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_footer, parent, false));

        }
        return null;

    }


    static class itemViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView tv_txtRichanliangDate;
        TextView tv_txtRichanliangShigongzhuanghao;
        TextView tv_txtRichanliangCaijichanliang;
        TextView tv_txtRichanliangPanshu;
        TextView tv_txtRichanliangXiuzhengchanliang;
        TextView tv_txtRichanliangMidu;
        TextView tv_txtRichanliangChang;
        TextView tv_txtRichanliangKuan;
        TextView tv_txtRichanliangHou;

        public itemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_concrete_fragment);
            tv_txtRichanliangDate = (TextView) view.findViewById(R.id.txtRichanliangDate);
            tv_txtRichanliangShigongzhuanghao = (TextView) view.findViewById(R.id.txtRichanliangShigongzhuanghao);
            tv_txtRichanliangCaijichanliang = (TextView) view.findViewById(R.id.txtRichanliangCaijichanliang);
            tv_txtRichanliangPanshu = (TextView) view.findViewById(R.id.txtRichanliangPanshu);
            tv_txtRichanliangXiuzhengchanliang = (TextView) view.findViewById(R.id.txtRichanliangXiuzhengchanliang);
            tv_txtRichanliangMidu = (TextView) view.findViewById(R.id.txtRichanliangMidu);
            tv_txtRichanliangChang = (TextView) view.findViewById(R.id.txtRichanliangChang);
            tv_txtRichanliangKuan = (TextView) view.findViewById(R.id.txtRichanliangKuan);
            tv_txtRichanliangHou = (TextView) view.findViewById(R.id.txtRichanliangHou);
        }
    }
    private class footViewHolder extends RecyclerView.ViewHolder {

        public footViewHolder(View view) {
            super(view);
        }
    }


}
