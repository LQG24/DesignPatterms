package com.example.designpatterns.image_strategy

import android.graphics.*
import android.widget.ImageView
import com.squareup.picasso.*

import android.graphics.drawable.Drawable
import com.example.designpatterns.App

import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom
import com.squareup.picasso.Target;
import java.io.File


class PicassoLoaderStrategy : IImageLoaderStrategy {

    @kotlin.jvm.Volatile
    private var sPicassoSingleton: Picasso? = null
    private val PICASSO_CACHE = "picasso-cache"
    private val sLruCache: LruCache = LruCache(App.gApp)

    private fun getPicasso(): Picasso? {
        if (sPicassoSingleton == null) {
            synchronized(PicassoLoaderStrategy::class.java) {
                if (sPicassoSingleton == null) {
                    sPicassoSingleton = Picasso.Builder(App.gApp).memoryCache(sLruCache).build()
                }
            }
        }
        return sPicassoSingleton
    }

    override fun loadImage(options: ConfigOptions) {

        var requestCreator: RequestCreator? = null
        when {
            options.url != null -> {
                requestCreator = getPicasso()?.load(options.url)
            }
            options.file != null -> {
                requestCreator = getPicasso()?.load(options.file!!)
            }
            options.drawableResId != 0 -> {
                requestCreator = getPicasso()?.load(options.drawableResId)
            }
            options.uri != null -> {
                requestCreator = getPicasso()?.load(options.uri)
            }
        }

        if (requestCreator == null) {
            throw NullPointerException("requestCreator must not be null")
        }
        if (options.targetHeight > 0 && options.targetWidth > 0) {
            requestCreator.resize(options.targetWidth, options.targetHeight)
        }
        if (options.isCenterInside) {
            requestCreator.centerInside()
        } else if (options.isCenterCrop) {
            requestCreator.centerCrop()
        }

        requestCreator.config(options.config)

        if (options.errorResId != 0) {
            requestCreator.error(options.errorResId)
        }
        if (options.placeholderResId != 0) {
            requestCreator.placeholder(options.placeholderResId)
        }
        if (options.bitmapAngle != 0f) {
            requestCreator.transform(PicassoTransformation(options.bitmapAngle))
        }
        if (options.skipLocalCache) {
            requestCreator.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
        }
        if (options.skipNetCache) {
            requestCreator.networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
        }
        if (options.degrees != 0f) {
            requestCreator.rotate(options.degrees)
        }

        if (options.targetView is ImageView) {
            requestCreator.into(options.targetView as ImageView?)
        } else if (options.callBack != null) {
            requestCreator.into(PicassoTarget(options.callBack))
        }
    }


    override fun clearMemoryCache() {
        sLruCache.clear()
    }

    override fun clearDiskCache() {
        val diskFile = File(App.gApp.cacheDir, PICASSO_CACHE)
        if (diskFile.exists()) {
            //这边自行写删除代码
//          FileUtil.deleteFile(diskFile);
        }
    }

    open class PicassoTarget(var callBack: BitmapCallBack?) : Target {
        override fun onBitmapLoaded(bitmap: Bitmap?, from: LoadedFrom?) {
            if (callBack != null) {
                callBack!!.onBitmapLoaded(bitmap)
            }
        }

        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
            if (callBack != null) {
                callBack!!.onBitmapFailed(e)
            }
        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}
    }

    internal open class PicassoTransformation(private val bitmapAngle: Float) :
        Transformation {
        override fun transform(source: Bitmap): Bitmap {
            val roundPx = bitmapAngle //圆角的横向半径和纵向半径
            val output = Bitmap.createBitmap(
                source.width,
                source.height, Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(output)
            val color = -0xbdbdbe
            val paint = Paint()
            val rect = Rect(0, 0, source.width, source.height)
            val rectF = RectF(rect)
            paint.isAntiAlias = true
            canvas.drawARGB(0, 0, 0, 0)
            paint.color = color
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(source, rect, rect, paint)
            source.recycle()
            return output
        }

        override fun key(): String {
            return "bitmapAngle()"
        }
    }
}