package project.run.com.uihelper.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import project.run.com.uihelper.R;
import project.run.com.uihelper.base.BaseDialogFragment;
import project.run.com.uihelper.base.IConfirmListener;
import project.run.com.uihelper.base.ViewHolder;

/**
 * Created by chenjianrun on 2017/9/18.
 */

public class MyConfirmDialog extends BaseDialogFragment {
    public static final String CONFIRM_PARAM = "confirmListener";
    public static final String MESSAGE_PARAM = "message";
    public static final String TITLE_PARAM = "title";
    private String message;
    private String title;
    private IConfirmListener confirmListener;

    @Override
    public int intLayoutId() {
        return R.layout.dialog_confirm;
    }

    /**
     * 创建对话框实例
     * @param title
     * @param content
     * @return
     */
    public static MyConfirmDialog newInstance(String title,String content){
        Bundle bundle = new Bundle();
        bundle.putString(TITLE_PARAM, title);
        bundle.putString(MESSAGE_PARAM, content);
        MyConfirmDialog dialog = new MyConfirmDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    /**
     * 创建对话框实例
     * @param content
     * @return
     */
    public static MyConfirmDialog newInstance(String content){
        Bundle bundle = new Bundle();
        bundle.putString(TITLE_PARAM, null);
        bundle.putString(MESSAGE_PARAM, content);
        MyConfirmDialog dialog = new MyConfirmDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        message = getArguments().getString(MESSAGE_PARAM);
        title = getArguments().getString(TITLE_PARAM);
        if (savedInstanceState != null) {
            confirmListener = (IConfirmListener) savedInstanceState.getSerializable(CONFIRM_PARAM);
            message = savedInstanceState.getString(MESSAGE_PARAM);
            title = savedInstanceState.getString(TITLE_PARAM);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CONFIRM_PARAM,confirmListener);
        outState.putString(TITLE_PARAM,title);
        outState.putString(MESSAGE_PARAM,message);
    }

    @Override
    public void convertView(ViewHolder holder, final BaseDialogFragment dialog) {
        dialog.setCancelable(true);
        holder.setText(R.id.message,message);
        holder.setText(R.id.title,title);
        if (TextUtils.isEmpty(title)) {
            holder.setVisibility(R.id.title,View.GONE);
        }
        holder.setOnClickListener(R.id.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (confirmListener != null) {
                    confirmListener.onConfirm();
                }
            }
        });
    }

    /**
     * 设置确定按钮事件监听
     * @param confirmListener
     */
    public void setConfirmListener(IConfirmListener confirmListener) {
        this.confirmListener = confirmListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (confirmListener != null) {
            confirmListener = null;
        }
    }
}
