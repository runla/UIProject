package project.run.com.uiproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import project.run.com.uihelper.dialog.MyLoadingDialog;

public class MainActivity extends AppCompatActivity {

    private Button btn_toast;
    private Button btn_toast2;
    private MyLoadingDialog myLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLoadingDialog = MyLoadingDialog.newInstance();
        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast2 = (Button) findViewById(R.id.toast2);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* MyConfirmDialog myConfirmDialog = MyConfirmDialog.newInstance("测试","亲，你好！你的登录密码有误，请重新登录，谢谢！");
                myConfirmDialog.show(getSupportFragmentManager());*/
                if (myLoadingDialog == null) {
                    myLoadingDialog = MyLoadingDialog.newInstance();
                }
                myLoadingDialog.setOutCancel(true).show(getSupportFragmentManager());
            }
        });

        btn_toast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                myLoadingDialog.dismiss();
//                MyDoubleDialog.newInstance("测试标题","这是双按钮对话框").show(getSupportFragmentManager());
            }
        });

        String string;
    }
}
