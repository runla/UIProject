package project.run.com.uiproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import project.run.com.uihelper.MyConfirmDialog;

public class MainActivity extends AppCompatActivity {

    private Button btn_toast;
    private Button btn_toast2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast2 = (Button) findViewById(R.id.toast2);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyConfirmDialog myConfirmDialog = MyConfirmDialog.newInstance("亲，你好！你的登录密码有误，请重新登录，谢谢！");
                myConfirmDialog.show(getSupportFragmentManager(),"tag");
            }
        });

        btn_toast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
