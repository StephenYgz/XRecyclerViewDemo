package com.stephen.xrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ygz on 2017/6/23 22:39.
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private Context mContext;
    private List<MainBean> mDatas;

    public MainAdapter(Context context, List<MainBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main_item, parent, false);
        MainViewHolder mainViewHolder = new MainViewHolder(view);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.setData(mDatas.get(holder.getAdapterPosition() - 1));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }
}
