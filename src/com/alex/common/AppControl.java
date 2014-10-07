package com.alex.common;

import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import android.app.Application;
import android.graphics.Bitmap;

/**
 * App的总体控制类
 * @author caisenchuan
 */
public class AppControl extends Application {
    /*--------------------------
     * 常量
     *-------------------------*/

    /*--------------------------
     * 自定义类型
     *-------------------------*/
    
    /*--------------------------
     * 成员变量
     *-------------------------*/
    
    /*--------------------------
     * public方法
     *-------------------------*/
    @Override
    public void onCreate() {
        super.onCreate();
        
        //ImageLoader
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true)
                .cacheInMemory(true)
                .displayer(new FadeInBitmapDisplayer(50))
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .showImageOnLoading(R.drawable.empty_photo)
                .showImageForEmptyUri(R.drawable.empty_photo)
                .showImageOnFail(R.drawable.empty_photo)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCache(new UsingFreqLimitedMemoryCache(16 * 1024 * 1024))
                .defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);
    }
    
    /*--------------------------
     * protected、packet方法
     *-------------------------*/

    /*--------------------------
     * private方法
     *-------------------------*/
    
}
