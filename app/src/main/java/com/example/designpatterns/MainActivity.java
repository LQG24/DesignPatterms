package com.example.designpatterns;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.lifecycle.Observer;


import com.example.designpatterns.adapter.GoodsAdapter;
import com.example.designpatterns.bean.Goods;
import com.example.designpatterns.databus.LiveDataBus;
import com.example.designpatterns.presenter.GoodsPresenter;
import com.example.designpatterns.view.BaseActivity;
import com.example.designpatterns.view.IGoodsView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity<GoodsPresenter, IGoodsView> implements IGoodsView {



    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        presenter.fetch();

        LiveDataBus.getInstance().with("list", ArrayList.class)
                .observe(this, new Observer<ArrayList>() {
                    @Override
                    public void onChanged(ArrayList arrayList) {
                        if(arrayList!=null){
                            Log.i("jett","收到了数据"+arrayList.toString());
                        }
                    }
                });

    }
    @Override
    protected GoodsPresenter createPresenter() {
        return new GoodsPresenter();
    }
    @Override
    public void showGoodsView(List<Goods> goods) {
        listView.setAdapter(new GoodsAdapter(this,goods));
    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    protected void init() {
        super.init();
        getLifecycle().addObserver(presenter);
    }
}
