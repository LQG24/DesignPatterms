package com.example.designpatterns.model;





import com.example.designpatterns.bean.Goods;
import com.example.designpatterns.databus.LiveDataBus;

import java.util.ArrayList;
import java.util.List;

public class GoodsModel implements IGoodsModel {
    private String[] IMAGE_ARRAY = {
            "https://pic.616pic.com/bg_w1180/00/16/62/WEanzi7sqo.jpg",
            "https://pic.616pic.com/bg_w1180/00/16/62/WEanzi7sqo.jpg",
            "https://pic.616pic.com/bg_w1180/00/16/62/WEanzi7sqo.jpg",
            "https://www.pngfind.com/pngs/b/515-5159218_branch-with-leaves-png.png",
            "https://www.pngfind.com/pngs/b/515-5159218_branch-with-leaves-png.png",
            "https://www.pngfind.com/pngs/b/515-5159218_branch-with-leaves-png.png",
            "https://www.pngfind.com/pngs/b/515-5159218_branch-with-leaves-png.png",
            "https://www.pngfind.com/pngs/b/515-5159218_branch-with-leaves-png.png",
            "https://www.pngfind.com/pngs/b/515-5159218_branch-with-leaves-png.png"
    };
    @Override
    public void loadGoodsData(OnLoadListener onLoadListener) {
        onLoadListener.onComplete(getData());
    }

    private List<Goods> getData() {
        ArrayList data = new ArrayList<>();
        //这里的数据来源于网络或数据库或其它地方
        for (String url:IMAGE_ARRAY) {
            data.add(new Goods(url, "一星", "****"));
        }
        //发送消息
        LiveDataBus.getInstance().with("list", ArrayList.class).postValue(data);

        return data;
    }

}
