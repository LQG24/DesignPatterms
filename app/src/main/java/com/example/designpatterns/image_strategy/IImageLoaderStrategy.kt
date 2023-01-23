package com.example.designpatterns.image_strategy

/**
 * 图片策略接口
 */
interface IImageLoaderStrategy {

    fun loadImage(options: ConfigOptions)

    /**
     * 清理内存缓存
     */
    fun clearMemoryCache()

    /**
     * 清理磁盘缓存
     */
    fun clearDiskCache()

}