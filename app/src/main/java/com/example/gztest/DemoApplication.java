package com.example.gztest;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Eric on 2018/3/27.
 */

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "911f4fe979", false);

    }
}
