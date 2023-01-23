package com.example.designpatterns.image_strategy

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import java.io.File
import androidx.annotation.DrawableRes


class ConfigOptions() {
    var placeholderResId: Int = 0
    var errorResId: Int = 0
    var isCenterCrop: Boolean = false
    var isCenterInside: Boolean = false

    //是否缓存到本地
    var skipLocalCache: Boolean = false
    var skipNetCache: Boolean = false
    var config: Bitmap.Config = Bitmap.Config.RGB_565
    var targetWidth: Int = 0
    var targetHeight: Int = 0
    var bitmapAngle: Float = 0f //圆角角度

    //旋转角度.注意:picasso针对三星等本地图片，默认旋转回0度，即正常位置。此时不需要自己rotate
    var degrees: Float = 0f
    var placeholder: Drawable? = null
    var targetView: View? = null //targetView展示图片
    var callBack: BitmapCallBack? = null
    var url: String? = null
    var file: File? = null
    var drawableResId: Int = 0
    var uri: Uri? = null
    var needAnim: Boolean = false
    var priority: Priority = Priority.NORMAL
    var isCircle: Boolean = false
    var transformation: Any? = null
    var iImageLoaderStrategy: IImageLoaderStrategy? = null //实时切换图片加载库

    constructor(url: String?) : this() {
        this.url = url
    }

    constructor(file: File?) : this() {
        this.file = file
    }


    constructor(drawableResId: Int) : this() {
        this.drawableResId = drawableResId
    }

    constructor(uri: Uri) : this() {
        this.uri = uri
    }


    fun into(targetView: View?) {
        this.targetView = targetView
        ImageManager.loadOptions(this)
    }

    fun bitmap(callBack: BitmapCallBack?) {
        this.callBack = callBack
        ImageManager.loadOptions(this)
    }

    fun loader(imageLoader: IImageLoaderStrategy): ConfigOptions {
        this.iImageLoaderStrategy = imageLoader
        return this
    }

    fun placeholder(@DrawableRes placeholderResId: Int): ConfigOptions {
        this.placeholderResId = placeholderResId
        return this
    }

    fun placeholder(placeholder: Drawable?): ConfigOptions {
        this.placeholder = placeholder
        return this
    }

    fun error(@DrawableRes errorResId: Int): ConfigOptions {
        this.errorResId = errorResId
        return this
    }

    fun centerCrop(): ConfigOptions {
        isCenterCrop = true
        return this
    }

    fun centerInside(): ConfigOptions {
        isCenterInside = true
        return this
    }

    fun config(config: Bitmap.Config?): ConfigOptions {
        this.config = config!!
        return this
    }

    fun resize(targetWidth: Int, targetHeight: Int): ConfigOptions {
        this.targetWidth = targetWidth
        this.targetHeight = targetHeight
        return this
    }

    /**
     * 圆角
     * @param bitmapAngle   度数
     * @return
     */
    fun angle(bitmapAngle: Float): ConfigOptions {
        this.bitmapAngle = bitmapAngle
        return this
    }

    fun skipLocalCache(skipLocalCache: Boolean): ConfigOptions {
        this.skipLocalCache = skipLocalCache
        return this
    }

    fun skipNetCache(skipNetCache: Boolean): ConfigOptions {
        this.skipNetCache = skipNetCache
        return this
    }

    fun rotate(degrees: Float): ConfigOptions {
        this.degrees = degrees
        return this
    }

    fun isCircle(isCircle: Boolean): ConfigOptions {
        this.isCircle = isCircle
        return this
    }

    fun transformation(transformation: Any): ConfigOptions {
        this.transformation = transformation
        return this
    }
}

enum class Priority {
    IMMEDIATE, HIGH, NORMAL, LOW
}