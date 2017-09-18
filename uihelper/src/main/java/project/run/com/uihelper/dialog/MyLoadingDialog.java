package project.run.com.uihelper.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;

import project.run.com.uihelper.R;
import project.run.com.uihelper.base.BaseDialogFragment;
import project.run.com.uihelper.base.ViewHolder;

/**
 * Created by Administrator on 2017/9/18.
 * 描述：加载中对话框
 */

public class MyLoadingDialog extends BaseDialogFragment{
    public static final String MESSAGE_PARAM = "message";
    private String loadingText;

    /**
     * 创建对话框实例
     * @param content
     * @return
     */
    public static MyLoadingDialog newInstance(String content){
        Bundle bundle = new Bundle();
        bundle.putString(MESSAGE_PARAM, content);
        MyLoadingDialog dialog = new MyLoadingDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    public static MyLoadingDialog newInstance(){
        MyLoadingDialog dialog = new MyLoadingDialog();
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            loadingText = getArguments().getString(MESSAGE_PARAM);
        }
        if (savedInstanceState != null) {
            loadingText = savedInstanceState.getString(MESSAGE_PARAM);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MESSAGE_PARAM,loadingText);
    }

    @Override
    public int intLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    public void convertView(ViewHolder holder, BaseDialogFragment dialog) {
        dialog.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setAnimStyle(R.style.DialogLoadingAnimation);
        if (!TextUtils.isEmpty(loadingText)) {
            holder.setText(R.id.loading_text,loadingText);
        }
    }
}
