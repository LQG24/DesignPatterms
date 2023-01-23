package com.example.designpatterns.bean;

/**
 * 实体
 */
public class Goods {

	public String icon;
	public String like;
	public String style;

	public Goods() {
	}

	public Goods(String icon, String like, String style) {
		super();
		this.icon = icon;
		this.like = like;
		this.style = style;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
