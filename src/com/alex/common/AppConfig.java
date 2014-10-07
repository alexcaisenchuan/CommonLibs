package com.alex.common;

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
    
    /**路径后缀*/
    private static String mDirPostfix = "";
    
    /*--------------------------
     * public方法
     *-------------------------*/
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
        mDirPostfix = fix;
    }
    
    /**
     * 获取APP自定义存储路径
     */
    public static String getDirApp() {
        String str = String.format("/com.alex%s/", mDirPostfix);
        return str;
    }

    /**
     * 获取APP照片存储路径
     */
    public static String getDirPhoto() {
        String str = String.format("/com.alex%s/photo/", mDirPostfix);
        return str;
    }
    
    /**
     * 获取APP下载存储路径
     */
    public static String getDirDownload() {
        String str = String.format("/com.alex%s/download/", mDirPostfix);
        return str;
    }
    /*--------------------------
     * protected、packet方法
     *-------------------------*/

    /*--------------------------
     * private方法
     *-------------------------*/

}
