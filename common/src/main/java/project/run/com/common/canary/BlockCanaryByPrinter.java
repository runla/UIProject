package project.run.com.common.canary;

import android.os.Looper;
import android.util.Printer;

/**
 * Created by Administrator on 2017/10/19.
 * 描述：通过 Looper 中的打印消息来检测程序是否卡顿
 *
 * 原理：在 looper 中的 loop 方法会从消息队列（MessageQueue）中取出任务交给 handler 执行
 *      并在 handler 处理任务前后打印出 log 消息 ">>>>> Dispatching" 和 "<<<<< Finished"
 *      我们只要检测出这两个 log 的执行时间，那么我们可以知道 handler 处理任务的时间（阈值）
 *      也就可以判断程序是否出现卡顿的问题
 */

public class BlockCanaryByPrinter {
    private static final String START = ">>>>> Dispatching";
    private static final String END = "<<<<< Finished";
    public static void start(){

        // 获取主线程中的 Looper 的打印消息，在 Looper.loop() 中的 log
        // 会通过 Printer 回调回来
        Looper.getMainLooper().setMessageLogging(new Printer() {
            @Override
            public void println(String x) {
                // 检测到 >>>>> Dispatching log 消息打印
                if (x.startsWith(START)){
                    LogMonitor.getInstance().startMoniter();
                }

                // 检测到 >>>>> Dispatching log 消息打印
                if (x.startsWith(END)){
                    LogMonitor.getInstance().endMoniter();
                }
            }
        });
    }
}
