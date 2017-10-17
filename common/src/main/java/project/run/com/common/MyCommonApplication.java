package project.run.com.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by chenjianrun on 2017/9/18.
 */

public class MyCommonApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
