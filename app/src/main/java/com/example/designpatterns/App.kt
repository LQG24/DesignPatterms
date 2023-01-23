package com.example.designpatterns

import android.app.Application
import com.example.designpatterns.image_strategy.GlideLoaderStrategy
import com.example.designpatterns.image_strategy.ImageManager

class App: Application() {
   init {
       gApp = this
   }

    override fun onCreate() {
        super.onCreate()
        ImageManager.setImageLoaderStrategy(GlideLoaderStrategy())
    }

    companion object{
       lateinit var gApp:App
    }
}