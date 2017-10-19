package project.run.com.uiproject;

import android.app.Application;

import project.run.com.common.canary.BlockCanaryByPrinter;

/**
 * Created by Administrator on 2017/10/19.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BlockCanaryByPrinter.start();
    }
}
