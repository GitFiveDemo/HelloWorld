package com.jinou.app.application;

import android.app.Application;
import android.content.Context;

/**
 * author: ShiChenguang
 * date : 2018/5/11 13:27
 */
public class CGApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
