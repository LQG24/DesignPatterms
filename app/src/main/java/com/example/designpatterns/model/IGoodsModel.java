package com.example.designpatterns.model;




import com.example.designpatterns.bean.Goods;

import java.util.List;

public interface IGoodsModel {
    void loadGoodsData(OnLoadListener onLoadListener);
    interface OnLoadListener{
        void onComplete(List<Goods> goods);
        void onError(String msg);
    }
}









