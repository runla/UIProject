package project.run.com.uihelper;

import android.widget.Toast;

/**
 * Created by chenjianrun on 2017/9/18.
 * 描述：显示 Toast
 */

public class MyToast {
    private static Toast mToast;

    /**
     * 内部获取 Toast 的实例
     * @param content
     * @param duration
     * @return
     */
    private static Toast getToast(String content,int duration){
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getContext(),
                    content,duration);
        }else{
            mToast.setText(content);
        }
        return mToast;
    }

    /**
     * 显示长 Toast
     * @param content   显示内容
     */
    public static void showLong(String content){
        getToast(content,Toast.LENGTH_LONG).show();
    }

    /**
     * 显示短 Toast
     * @param content   显示内容
     */
    public static void showShort(String content){
        getToast(content,Toast.LENGTH_SHORT).show();
    }
}
