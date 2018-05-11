package com.jinou.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.production.kjbd.view.application.CGApplication;

/**
 * author: ShiChenguang
 * date : 2018/5/8 19:33
 */
public class SharedUtil {

    private static SharedUtil sharedUtil;
    private SharedPreferences sp;

    public static SharedUtil getInstance() {
        if (sharedUtil == null) {
            synchronized (SharedUtil.class) {
                if (sharedUtil == null) {
                    sharedUtil = new SharedUtil();
                }
            }
        }
        return sharedUtil;
    }

    private SharedUtil() {
        sp = CGApplication.getContext().getSharedPreferences("sharedFile", Context.MODE_PRIVATE);
    }

    public boolean saveBooleanValue(String name, boolean value) {
        return sp.edit().putBoolean(name, value).commit();
    }

    public boolean saveIntegerValue(String name, int value) {
        return sp.edit().putInt(name,value).commit();
    }

    public boolean saveStringValue(String name, String value) {
        return sp.edit().putString(name,value).commit();
    }

    public boolean obtainBooleanValue(String name) {
       return sp.getBoolean(name,false);
    }

    public int obtainIntValue(String name){
        return sp.getInt(name,-1);
    }

    public String obtainStringValue(String name){
        return sp.getString(name,"");
    }

    public boolean clearAll(){
        return sp.edit().clear().commit();
    }

    public boolean remove(String name){
        return sp.edit().remove(name).commit();
    }

}
