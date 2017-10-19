package project.run.com.common.canary;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/10/19.
 * 描述：Log 监控器
 */

public class LogMonitor {
    // 卡顿阈值，超过 1s 就认为卡顿
    public static final long TIME_BLOCK = 1000L;
    // 内部有自己的 looper
    private HandlerThread mHandlerThread = new HandlerThread("LogMonitor");
    private Handler mIoHandler;

    private static LogMonitor mLogMonitor;
    public LogMonitor(){
        // start 会调用 run 方法，并创建 looper
        mHandlerThread.start();
        mIoHandler = new Handler(mHandlerThread.getLooper());
    }

    public static LogMonitor  getInstance(){
        if (mLogMonitor == null){
            synchronized(LogMonitor.class){
                if (mLogMonitor == null){
                    mLogMonitor = new LogMonitor();
                }
            }
        }
        return mLogMonitor;
    }

    // 打印出追踪消息的线程（任务）
    private Runnable mPrintStackTask = new Runnable() {
        @Override
        public void run() {
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            sb.append("||-------------------------------------------------------------------------\n");
            for (StackTraceElement traceElement : stackTrace) {
                sb.append("||---------- "+traceElement+ "\n");
            }
            sb.append("||-------------------------------------------------------------------------\n\n");
            Log.e(TAG, sb.toString() );
        }
    };

    /*public boolean isMoniter(){
        return mIoHandler.hasCallbacks(mPrintStackTask);
    }*/

    public void startMoniter(){
        mIoHandler.postDelayed(mPrintStackTask,TIME_BLOCK);
    }

    public void endMoniter(){
        mIoHandler.removeCallbacks(mPrintStackTask);
    }
}
