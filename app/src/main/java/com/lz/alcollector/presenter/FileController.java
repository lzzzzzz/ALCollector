package com.lz.alcollector.presenter;

import com.lz.alcollector.config.Constaint;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by LZ on 2016/12/10.
 */

public class FileController {

    /**写入日志*/
    public static void addDatas(String logStr){
        if(!ALCollector.getInstance().getEnable()){
            return;
        }
        File file=new File(Constaint.ALOG_FILE_NAME);
        if(file.exists()){
            if(file.length()>0){
                doFileWrite(file,","+logStr,true);
            }else{
                doFileWrite(file,logStr,false);
            }
        }
    }

    /**写入文件
     * @param  file 文件
     * @param  logStr 写入内容
     * @param  logStr 写入模式（true:追加 false:覆盖）
     * */
    private static void doFileWrite(File file,String logStr,boolean flag){
        if(file.exists()){
            FileWriter writer = null;
            try {
                // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
                writer = new FileWriter(file, true);
                writer.write(logStr);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(writer != null){
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**获取保存的日志*/
    public static String getALog(){
        File file=new File(Constaint.ALOG_FILE_NAME);
        String fileStr="";
        if(file.exists()){
            FileReader fr=null;
            try{
                char [] a = new char[50];
                fr.read(a); // 读取数组中的内容
                for(char c : a){
                    fileStr+=c;
                }
                fr.close();
            }catch(Exception e){
                fileStr="";
            }finally {
                if(null!=fr){
                    try {
                        fr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fileStr;
    }
    /**清空日志文件信息*/
    public static void clearALog(){
        if(!ALCollector.getInstance().getEnable()){
            return;
        }
        File file=new File(Constaint.ALOG_FILE_NAME);
        if(file.exists()){
            doFileWrite(file,"",true);
        }

    }
}
