package com.example.designpatterns.image_strategy

import android.graphics.drawable.Drawable

import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import java.io.File
import java.lang.IllegalArgumentException

/**
 *
 * 用具名可选参数代替构建者模式
 * 该类为图片加载框架的通用属性封装，不能耦合任何一方的框架
 */
//class LoaderOptions(
//    var placeholderResId: Int = 0,
//    var errorResId: Int = 0,
//    var isCenterCrop: Boolean = false,
//    var isCenterInside: Boolean = false,
//
//    //是否缓存到本地
//    var skipLocalCache: Boolean = false,
//    var skipNetCache: Boolean = false,
//    var config: Bitmap.Config = Bitmap.Config.RGB_565,
//    var targetWidth: Int = 0,
//    var targetHeight: Int = 0,
//    var bitmapAngle: Float = 0f, //圆角角度
//
//    //旋转角度.注意:picasso针对三星等本地图片，默认旋转回0度，即正常位置。此时不需要自己rotate
//    var degrees: Float = 0f,
//    var placeholder: Drawable? = null,
//    var targetView: View? = null, //targetView展示图片
//    var callBack: BitmapCallBack? = null,
//    var url: String? = null,
//    var file: File? = null,
//    var drawableResId: Int = 0,
//    var uri: Uri? = null,
//    var needAnim: Boolean = false,
//    var priority: Priority = Priority.NORMAL,
//    var isCircle: Boolean = false,
//    var iImageLoaderStrategy: IImageLoaderStrategy? = null //实时切换图片加载库
//) {
//    init {
//        require(targetView == null || (url.isNullOrEmpty() && file == null && drawableResId == 0)) {
//            throw  IllegalArgumentException("targetView and load res should be set")
//        }
//    }
//}
//
//enum class Priority {
//    IMMEDIATE, HIGH, NORMAL, LOW
//}