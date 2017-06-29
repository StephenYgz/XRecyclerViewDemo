package com.stephen.xrecyclerviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView mRv;
    private MainAdapter mAdapter;
    private List<MainBean> mDatas = new ArrayList<>();
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mRv = (XRecyclerView) findViewById(R.id.rv_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(linearLayoutManager);
        //mRv.addItemDecoration(new XRecyclerView.DividerItemDecoration(getDrawable(R.drawable.shape_divider)));
        mAdapter = new MainAdapter(this, mDatas);
        mRv.setAdapter(mAdapter);

        mRv.setRefreshProgressStyle(ProgressStyle.SemiCircleSpin);
        mRv.setRefreshProgressStyle(ProgressStyle.SemiCircleSpin);

        mRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainBean mainBean = new MainBean();
                        mainBean.setTitle("新标题");
                        mDatas.add(0, mainBean);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mRv.refreshComplete();
                                mAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }, 3000);
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            MainBean mainBean = new MainBean();
                            mainBean.setTitle("更多标题" + i);
                            mDatas.add(mainBean);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mRv.loadMoreComplete();
                                mAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }, 3000);
            }
        });
    }

    private void initData() {
        mRv.refresh();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    MainBean mainBean = new MainBean();
                    mainBean.setTitle("标题" + i);
                    mDatas.add(mainBean);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRv.refreshComplete();
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        }, 3000);
    }
}
