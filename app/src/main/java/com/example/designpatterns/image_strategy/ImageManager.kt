package com.example.designpatterns.image_strategy

import android.net.Uri
import java.io.File
import java.lang.NullPointerException

/**
 *
 */
object ImageManager {
    private var iImageLoaderStrategy: IImageLoaderStrategy

    init {
        iImageLoaderStrategy = PicassoLoaderStrategy()
    }

    fun setImageLoaderStrategy(imageLoaderStrategy: IImageLoaderStrategy) {
        iImageLoaderStrategy = imageLoaderStrategy
    }

    fun load(url: String): ConfigOptions {
        return ConfigOptions(url = url)
    }

    fun load(drawable: Int): ConfigOptions {
        return ConfigOptions(drawableResId = drawable)
    }

    fun load(file: File): ConfigOptions {
        return ConfigOptions(file = file)
    }

    fun load(uri: Uri): ConfigOptions {
        return ConfigOptions(uri = uri)
    }

//    fun load(url: String): LoaderOptions {
//        return LoaderOptions(url = url)
//    }
//
//    fun load(drawable: Int): LoaderOptions {
//        return LoaderOptions(drawableResId =drawable)
//    }
//
//    fun load(file: File): LoaderOptions {
//        return LoaderOptions(file =file)
//    }
//
//    fun load(uri: Uri): LoaderOptions {
//        return LoaderOptions(uri = uri)
//    }

    /**
     * 优先使用实时设置的图片loader，其次使用全局设置的图片loader
     * @param options
     */
    fun loadOptions(options: ConfigOptions) {
        if (options.iImageLoaderStrategy != null) {
            options.iImageLoaderStrategy?.loadImage(options)
        } else {
            checkNotNull()
            iImageLoaderStrategy.loadImage(options)
        }
    }
//    fun loadOptions(options: LoaderOptions) {
//        if (options.iImageLoaderStrategy != null) {
//            options.iImageLoaderStrategy?.loadImage(options)
//        } else {
//            checkNotNull()
//            iImageLoaderStrategy.loadImage(options)
//        }
//    }


    fun clearMemoryCache() {
        checkNotNull()
        iImageLoaderStrategy.clearMemoryCache()
    }

    fun clearDiskCache() {
        checkNotNull()
        iImageLoaderStrategy.clearDiskCache()
    }

    private fun checkNotNull() {
        if (iImageLoaderStrategy == null) {
            throw NullPointerException("you must be set your imageLoader at first!")
        }
    }
}