package com.example.vincent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.vincent.libary.listener.ShowNotificationListener;
import com.vincent.libary.log.MyLog;
import com.vincent.libary.util.ExitUtil;
import com.vincent.libary.util.NotificationUtils;
import com.vincent.libary.util.ScreenOpenCloseListener;
import com.vincent.libary.util.SystemUtilt;
import com.vincent.libary.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static ScreenOpenCloseListener listener;
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.btn_butterknife)
    Button btnButterknife;
    @BindView(R.id.tv_hello)
    TextView tvHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyLog.d("MainActivity", "初始化");

        listener = new ScreenOpenCloseListener(this);
        listener.begin(new ScreenOpenCloseListener.ScreenStateListener() {
            @Override
            public void onScreenOn() {
                MyLog.d(TAG, "用户打开了屏幕");
            }

            @Override
            public void onScreenOff() {
                MyLog.d(TAG, "用户锁屏了");
            }

            @Override
            public void onUserPresent() {
                MyLog.d(TAG, "用户解锁了屏幕");
            }
        });

        MyLog.d("屏幕分辨率：", SystemUtilt.getScreenParameterHeight(this) + "*" + SystemUtilt.getScreenParameterHeight(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listener.unregisterListener();//注意监听屏蔽需要解除注册
    }

    @Override
    public void onBackPressed() {
        ExitUtil.isQuit(this, "再按一次退出app");
    }


    @OnClick({R.id.btn_butterknife, R.id.tv_hello})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_butterknife:
                MyLog.d("click", "click");
                ToastUtil.showSingleTextToast(this, "butterknife注解，版本8.4，直接在布局文件上右键即可使用，需要另外配置，库配置失败");
                break;
            case R.id.tv_hello:
                MyLog.d("Click");
                NotificationUtils.sendNotification(MainActivity.this,"com.example.vincent.MainActivity",R.mipmap.ic_launcher,"哈哈","error");
//                SystemUtilt.goXiaoMiPermissionManagerActivity(MainActivity.this,"打开失败");
                break;
        }
    }

}
