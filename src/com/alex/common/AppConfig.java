package com.alex.common;

import android.content.Context;

/**
 * 一些配置信息
 * @author caisenchuan
 */
public class AppConfig {
    /*--------------------------
     * 常量
     *-------------------------*/
    /**保存成jpeg时的质量设置*/
    public static final int JPEG_QUALITY = 50;
    
    /*--------------------------
     * 自定义类型
     *-------------------------*/

    /*--------------------------
     * 成员变量
     *-------------------------*/
    /**调试开关*/
    private static boolean mDebug = false;
    
    /**基础路径*/
    private static String mDirBase = "com.alex";
    
    /*--------------------------
     * public方法
     *-------------------------*/
    /**
     * 使用包名作为基础路径
     * @param context
     */
    public static void configPackageNameAsBaseDir(Context context) {
        mDirBase = context.getApplicationInfo().packageName;
    }
    
    /**
     * 设置调试开关
     */
    public static void setDebug(boolean debug) {
        mDebug = debug;
    }
    
    /**
     * 判断是否是调试状态
     */
    public static boolean isDebug() {
        return mDebug;
    }
    
    /**
     * 设置路径后缀
     */
    public static void setDirPostfix(String fix) {
        mDirBase = String.format("com.alex.%s", fix);
    }
    
    /**
     * 获取APP自定义存储路径
     */
    public static String getDirApp() {
        String str = String.format("/%s/", mDirBase);
        return str;
    }

    /**
     * 获取APP照片存储路径
     */
    public static String getDirPhoto() {
        String str = String.format("/%s/photo/", mDirBase);
        return str;
    }
    
    /**
     * 获取APP下载存储路径
     */
    public static String getDirDownload() {
        String str = String.format("/%s/download/", mDirBase);
        return str;
    }
    
    /**
     * 获取APP分享路径
     */
    public static String getDirShare() {
        String str = String.format("/%s/share/", mDirBase);
        return str;
    }
    /*--------------------------
     * protected、packet方法
     *-------------------------*/

    /*--------------------------
     * private方法
     *-------------------------*/

}
