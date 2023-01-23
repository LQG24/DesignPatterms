package com.example.designpatterns.image_strategy

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.designpatterns.App

class GlideLoaderStrategy : IImageLoaderStrategy {
    @SuppressLint("CheckResult")
    override fun loadImage(options: ConfigOptions) {
        var builder: RequestBuilder<Drawable>? = null

        if(options.url != null){
             builder = getRequestManager().load(options.url)
        }


        val requestOptions = RequestOptions()

        if (options.transformation != null && options.transformation is Transformation<*>) {
            requestOptions.transform(options.transformation as Transformation<Bitmap>)
        }

        if(options.isCircle){
            requestOptions.transform(CircleCrop())
        }



        if (options.placeholderResId > 0) {
            requestOptions.placeholder(options.placeholderResId)
        }

        if (options.errorResId > 0) {
            requestOptions.error(options.errorResId)
        }

        when (options.priority) {
            Priority.NORMAL -> requestOptions.priority(com.bumptech.glide.Priority.NORMAL)
            Priority.LOW -> requestOptions.priority(com.bumptech.glide.Priority.LOW)
            Priority.HIGH -> requestOptions.priority(com.bumptech.glide.Priority.HIGH)
            Priority.IMMEDIATE -> requestOptions.priority(com.bumptech.glide.Priority.IMMEDIATE)
        }

        if (!options.needAnim) {
            requestOptions.dontAnimate()
        }
        builder?.apply(requestOptions)

        if (options.targetView != null && options.targetView is ImageView) {
            builder?.into(options.targetView as ImageView)
        }

    }

    private fun getRequestManager(): RequestManager {
       return Glide.with(App.gApp)
    }

    override fun clearMemoryCache() {
        Glide.get(App.gApp).clearMemory()
    }

    override fun clearDiskCache() {
        Glide.get(App.gApp).clearDiskCache()
    }
}