package com.dystudio.toyapp.util;


import android.util.Log;

public class LogUtil {
    private static LogUtil sLogUtil;
    private String mTag = "abc";
    private boolean mDebugFlag = true;

    private LogUtil(){ }

    public static LogUtil getLogger( ){
        if (sLogUtil == null) {
            sLogUtil = new LogUtil();
        }
        return sLogUtil;
    }

    public LogUtil setTag(String tag) {
        mTag = tag;
        return this;
    }

    public LogUtil setDebugFlag(boolean debugFlag) {
        mDebugFlag = debugFlag;
        return this;
    }

    public void log(String msg){
        if(mDebugFlag)
            Log.d(mTag,msg);
    }
}
