package com.lz.alcollector.presenter;

import android.util.Log;

import com.lz.alcollector.config.Constaint;
import com.lz.alcollector.crash.CrashConfig;
import com.lz.alcollector.log.LogUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by LZ on 2016/12/10.
 */

public class ALCollector {

    private static ALCollector instance;
    /**是否开启收集日志*/
    private static boolean enable=true;
    /**是否打印日志*/
     static private boolean log_print=true;

    /**外部接口类*/
    private static ALogController alController;
    public static ALCollector getInstance(){
        if(null==instance){
            instance=new ALCollector();
        }
        return instance;
    }
    public static void init(ALogController ac){
        alController=ac;
        File file=new File(Constaint.ALOG_FILE_NAME);
        if(!file.exists()){
            try {
                file.createNewFile();
                enable=true;
            } catch (IOException e) {
                e.printStackTrace();
                enable=false;
                LogUtils.e("日志初始化失败");
                return;
            }
            //检查是否有日志待提交
            if(file.exists()) {
                if (file.length() > 0) {
                    if(null!=alController){
                        alController.onODNeedUpload();
                        LogUtils.d("-->there is alog need to upload");
                    }
                }
            }
        }
    }


    /**是否收集日志*/
    public void setEnable(boolean flag){
        enable=flag;
    }
    /**获取是否收集日志*/
    public boolean getEnable(){
        return enable;
    }
    /**是否打印日志*/
    public void setLogPrint(boolean flag){
        log_print=flag;
    }
    /**获取是否打印日志*/
    public boolean getLogPrint(){
        return log_print;
    }

    /**添加app事件*/
    public void addEvent(String log){
        if(!enable){
            return;
        }
        //String logStr=EventController.getEventLogStringByType(type,log);
        addLog(log);
        LogUtils.d("-->add event log:"+log);
    }

    /**添加app异常信息*/
    public void addCrash(String log){
        if(!enable){
            return;
        }
        //String logStr=EventController.getEventLogStringByType(type,log);
        addLog(log);
        LogUtils.d("-->add crash log:"+log);
    }
    /**添加app异常信息*/
    public void addLog(String log){
        if(!enable){
            return;
        }
        //String logStr=EventController.getOSLogStringByType(CrashConfig.EVENT_FLAG_CRASH,log);
        addLog(log);
        LogUtils.d("-->add os log:"+log);
    }

    /**获取日志内容*/
    public static String getSaveLog(){
        return FileController.getALog();
    }

    /**清空日志信息*/
    public void clearALog(){
        clearALog();
        LogUtils.d("-->clear alog:");
    }

    /**添加日志*/
    private void addALog(String log){
        if(null!=log&&!"".equals(log));{
            FileController.addDatas(log);
        }
    }
}
