package com.stephen.xrecyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ygz on 2017/6/23 22:39.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    private final TextView mTv;

    public MainViewHolder(View itemView) {
        super(itemView);
        mTv = (TextView) itemView.findViewById(R.id.tv_main);
    }


    public void setData(MainBean bean) {
        mTv.setText(bean.getTitle());
    }
}
