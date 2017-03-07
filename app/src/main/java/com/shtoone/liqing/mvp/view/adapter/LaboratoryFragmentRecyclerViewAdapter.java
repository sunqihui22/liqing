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
import com.shtoone.liqing.mvp.model.bean.LaboratoryData;


public class LaboratoryFragmentRecyclerViewAdapter extends RecyclerView.Adapter<LaboratoryFragmentRecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = LaboratoryFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private LaboratoryData itemData;
    private Resources mResources;

    public LaboratoryFragmentRecyclerViewAdapter(Context context, LaboratoryData itemData) {
        super();
        this.context = context;
        this.itemData = itemData;
        this.mResources = context.getResources();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {
//        if (null != itemData && itemData.getData().size() > 0 && itemData.isSuccess()) {
//            return itemData.getData().size();
//        }
        return 1;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {



        holder.tv_maxieer.setText("7876");
        holder.tv_laboratory_count.setText("7876");
        holder.tv_machine_count.setText("7876");
        holder.tv_ruanhuadian.setText("7876");
        holder.tv_yandu.setText("7876");
        holder.tv_zhenrudu.setText("7876");

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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_laboratory_fragment, parent, false));
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_organization;
        TextView tv_laboratory_count;
        TextView tv_machine_count;
        CardView cv;
        TextView tv_maxieer;
        TextView tv_zhenrudu;
        TextView tv_ruanhuadian;
        TextView tv_yandu;
        public MyViewHolder(View view) {
            super(view);
            tv_organization = (TextView) view.findViewById(R.id.tv_organization_item_recyclerview_laboratory_fragment);
            tv_laboratory_count = (TextView) view.findViewById(R.id.tv_laboratory_count_item);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_laboratory_fragment);
            tv_machine_count = (TextView) view.findViewById(R.id.tv_machine_count_item);
            tv_maxieer = (TextView) view.findViewById(R.id.tv_maxier);
            tv_zhenrudu = (TextView) view.findViewById(R.id.tv_zhenrudu);
            tv_ruanhuadian = (TextView) view.findViewById(R.id.tv_ruanhuadian);
            tv_yandu = (TextView) view.findViewById(R.id.tv_yandu);
        }
    }
}
