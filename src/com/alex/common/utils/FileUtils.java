package com.alex.common.utils;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.alex.common.AppConfig;

import android.os.Environment;
import android.text.TextUtils;

/**
 * 文件相关工具类
 * @author caisenchuan
 */
public class FileUtils {

    /*--------------------------
     * 常量
     *-------------------------*/
    private static final String TAG = FileUtils.class.getSimpleName();
    
    /*--------------------------
     * 自定义类型
     *-------------------------*/
    /**
     * 文件路径类型
     */
    public enum PathType {
        /**photo目录*/
        PHOTO,
        /**download目录*/
        DOWNLOAD,
        /**分享图片存放目录*/
        SHARE
    }

    /*--------------------------
     * 成员变量
     *-------------------------*/

    /*--------------------------
     * public方法
     *-------------------------*/
    /**
     * 删除某个目录习啊的所有文件
     */
    public static void deleteAllFiles(String path) {
        if(!TextUtils.isEmpty(path)) {
            File f = new File(path);
            deleteAllFiles(f);
        }
    }
    
    /**
     * 删除某个目录下的所有文件
     * @param root
     */
    public static void deleteAllFiles(File root) {
        File files[] = root.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) { // 判断是否为文件夹
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e) {
                        KLog.e(TAG, "Exception", e);
                    }
                } else {
                    if (f.exists()) { // 判断是否存在
                        deleteAllFiles(f);
                        try {
                            f.delete();
                        } catch (Exception e) {
                            KLog.e(TAG, "Exception", e);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 删除本地照片
     */
    public static void deleteFile(String picPath) {
        if(picPath != null) {
            File file = new File(picPath);
            if(file != null && file.exists()) {
                file.delete();
            }
            picPath = null;
        }
    }

    /**
     * 判断SD卡是否挂载
     */
    public static boolean isSDMount() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取基础路径
     * @param type 文件路径类型
     */
    public static String getDir(PathType type) {
        String dir = "";
        if(type == PathType.PHOTO) {
            dir = AppConfig.getDirPhoto();
        } else if(type == PathType.DOWNLOAD) {
            dir = AppConfig.getDirDownload();
        } else if(type == PathType.SHARE) {
        	dir = AppConfig.getDirShare();
    	} else {
            dir = AppConfig.getDirApp();
        }

        File sd = Environment.getExternalStorageDirectory();
        File file = new File(sd.getPath() + dir);
        if (!file.exists()) {
            file.mkdirs();
        }
    
        return file.getAbsolutePath();
    }

    /**
     * 获取唯一路径，文件名以 时间 + 后缀名 的方式命名
     * @param type 文件路径类型
     * @param ext 文件后缀名
     */
    public static String getUniqPath(PathType type, String ext) {
        String picDir = getDir(type);
    
        GregorianCalendar calendar = new GregorianCalendar();
        String date_s = String.format("%d%02d%02d_%02d%02d%02d",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR), 
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        
        String filename = String.format("%s/%s%s", picDir, date_s, ext);
        File file = new File(filename);
        int i = 1;
    
        // 构造不重名的文件名
        while (file.exists() && i < 10000) {
            filename = String.format("%s/%s(%s)%s", picDir, date_s, i, ext);
            file = new File(filename);
            i++;
        }
    
        KLog.d(TAG, "filename : " + filename);
    
        return filename;
    }
    
    /*--------------------------
     * protected、packet方法
     *-------------------------*/

    /*--------------------------
     * private方法
     *-------------------------*/

}
