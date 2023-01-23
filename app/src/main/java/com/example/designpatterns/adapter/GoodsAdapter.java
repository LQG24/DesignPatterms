package com.example.designpatterns.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.designpatterns.R;
import com.example.designpatterns.bean.Goods;
import com.example.designpatterns.image_strategy.ConfigOptions;
import com.example.designpatterns.image_strategy.ImageManager;

import java.util.List;


public class GoodsAdapter extends BaseAdapter {
	
	private LayoutInflater inflater;
	private List<Goods> goods;

	public GoodsAdapter(Context context, List<Goods> girs) {
		inflater = LayoutInflater.from(context);
		this.goods = girs;
	}

	@Override
	public int getCount() {
		return goods.size();
	}

	@Override
	public Object getItem(int position) {
		return goods.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = inflater.inflate(R.layout.item, null);
		Goods g = goods.get(position);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.iv_icon);

//		LoaderOptions options = new LoaderOptions();
//		options.setUrl(g.icon);
//		options.setCircle(true);
//		options.setTargetView(iv_icon);
//		ImageManager.INSTANCE.loadOptions(options);
		ImageManager.INSTANCE.load(g.icon).transformation(new CircleCrop()).into(iv_icon);


		TextView tv_like = (TextView) view.findViewById(R.id.tv_like);
		tv_like.setText("喜欢程度:"+g.like);
		
		TextView tv_style = (TextView) view.findViewById(R.id.tv_style);
		tv_style.setText(g.style);
		
		return view;
	}

}
