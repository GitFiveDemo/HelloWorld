package com.jinou.app.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * author: ShiChenguang
 * date : 2018/5/11 13:27
 */
public class CGApplication extends Application {

    private static final int DESIGN_WIDTH = 280;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        resetDensity();
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();//这个方法重写也是很有必要的
    }

    public void resetDensity(){
        Point size = new Point();
        ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(size);
        getResources().getDisplayMetrics().xdpi = size.x/DESIGN_WIDTH*72f;
    }
}
