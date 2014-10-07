/**
 * <p>Title: OnHttpRequestReturnListener.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: </p>
 * @author caisenchuan
 * @date 2013-9-19
 * @version 1.0
 */
package com.alex.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.alex.common.activities.BaseActivity;
import com.alex.common.utils.KLog;
import com.weibo.sdk.android.WeiboException;
import com.weibo.sdk.android.net.RequestListener;

/**
 * HttpClient网络请求返回时的处理类，对出错情况做了简单报错处理
 * @author caisenchuan
 *
 */
public abstract class OnHttpRequestReturnListener implements RequestListener{
    /*--------------------------
     * 自定义类型
     *-------------------------*/

    /*--------------------------
     * 常量
     *-------------------------*/
    private static final String TAG = "OnHttpRequestReturnListener";
    
    /*--------------------------
     * 成员变量
     *-------------------------*/
    protected BaseActivity mBaseActivity = null;
    
    /*--------------------------
     * public方法
     *-------------------------*/
    /**
     * HttpClient网络请求返回时的处理类，对出错情况做了简单报错处理
     * @param base 用于显示Toast的Activity对象
     */
    public OnHttpRequestReturnListener(BaseActivity base) {
        this.mBaseActivity = base;
    }
    
    //onComplete()由其子类实现

    /**
     * 其他事件回调完成后的统一回调
     */
    public void onOtherFinish() {
        //...
    }
    
    /* (non-Javadoc)
     * @see com.weibo.sdk.android.net.RequestListener#onComplete4binary(java.io.ByteArrayOutputStream)
     */
    @Override
    public void onComplete4binary(ByteArrayOutputStream arg0) {
        mBaseActivity.showToastOnUIThread(mBaseActivity.getString(R.string.hint_binary_stream) + arg0.toString());
        
        onOtherFinish();
    }

    /* (non-Javadoc)
     * @see com.weibo.sdk.android.net.RequestListener#onError(com.weibo.sdk.android.WeiboException)
     */
    @Override
    public void onError(WeiboException e) {
        KLog.w(TAG, "onError", e);
        
        Throwable cause = e.getCause();
        
        String str = "";
        if(cause instanceof IOException) {
            str = mBaseActivity.getString(R.string.hint_check_network);
        } else {
            str = mBaseActivity.getString(R.string.hint_error) + e.toString();
        }
        
        mBaseActivity.showToastOnUIThread(str);
        
        onOtherFinish();
    }

    /* (non-Javadoc)
     * @see com.weibo.sdk.android.net.RequestListener#onIOException(java.io.IOException)
     */
    @Override
    public void onIOException(IOException e) {
        KLog.w(TAG, "onIOException", e);

        mBaseActivity.showToastOnUIThread(mBaseActivity.getString(R.string.hint_network_error) + e.toString());
        
        onOtherFinish();
    }
    
    /*--------------------------
     * protected、packet方法
     *-------------------------*/

    /*--------------------------
     * private方法
     *-------------------------*/

}
