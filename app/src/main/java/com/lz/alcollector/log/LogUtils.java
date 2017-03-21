package com.lz.alcollector.log;

import android.util.Log;

import com.lz.alcollector.config.Constaint;
import com.lz.alcollector.presenter.ALCollector;

/**
 * Created by LZ on 2016/12/10.
 */

public class LogUtils {

    public static void d(String log){
        if(ALCollector.getInstance().getLogPrint()){
            Log.d(Constaint.ALOG_TAG,"-->"+log);
        }
    }
    public static void e(String log){
        if(ALCollector.getInstance().getLogPrint()){
            Log.e(Constaint.ALOG_TAG,"-->"+log);
        }
    }
    public static void i(String log){
        if(ALCollector.getInstance().getLogPrint()){
            Log.i(Constaint.ALOG_TAG,"-->"+log);
        }
    }
}
