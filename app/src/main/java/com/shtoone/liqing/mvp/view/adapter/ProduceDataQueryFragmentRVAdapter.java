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
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryRes;
import com.shtoone.liqing.mvp.model.bean.ProduceDataQueryResData;
import com.socks.library.KLog;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9.
 */
public class ProduceDataQueryFragmentRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = ProduceDataQueryFragmentRVAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private ProduceDataQueryRes produceDataQueryRes;
    private Resources mResources;
    private List<ProduceDataQueryResData> itemsData;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public ProduceDataQueryFragmentRVAdapter(Context context,List<ProduceDataQueryResData> produceDataQueryResData ) {
        super();
        this.context = context;
//        this.produceDataQueryRes = produceDataQueryRes;
        itemsData= produceDataQueryResData;
        mResources = context.getResources();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        if (itemsData != null && itemsData.size() > 0) {
            //这里的10是根据分页查询，一页该显示的条数
            if (itemsData.size() > 4) {
                return itemsData.size() + 1;
            } else {
                return itemsData.size();
            }
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() > 4 && position + 1 == getItemCount()) {
            return ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            ProduceDataQueryResData item = itemsData.get(position);
            KLog.e(TAG,item.toString());
            mItemViewHolder.tv_time.setText(item.getShijian());
            mItemViewHolder.tv_tempreture.setText(item.getClwd()+"℃");
            mItemViewHolder.tv_percent.setText(item.getSjysb());
            mItemViewHolder.tv_total.setText(item.getSjlq());
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_produce_data_query_fragment, parent, false));
        } else if (viewType == ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new FootViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_footer, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_time;
        TextView tv_tempreture;
        TextView tv_percent;
        TextView tv_total;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_pitch_produce_query_fragment);
            tv_time= (TextView) view.findViewById(R.id.tv0_item_recyclerview_pitch_produce_query_fragment);
            tv_tempreture= (TextView) view.findViewById(R.id.tv1_item_recyclerview_pitch_produce_query_fragment);
            tv_percent= (TextView) view.findViewById(R.id.tv2_item_recyclerview_produce_pitch_query_fragment);
            tv_total= (TextView) view.findViewById(R.id.tv3_item_recyclerview_produce_pitch_query_fragment);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}
