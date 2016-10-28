package com.example.vincent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.libary.log.MyLog;
import com.common.libary.service.JobCastielService;
import com.common.libary.util.AppUtil;
import com.common.libary.util.DateUtil;
import com.common.libary.util.ExitUtil;
import com.common.libary.util.FileUtil;
import com.common.libary.util.ScreenOpenCloseListener;
import com.common.libary.util.SystemUtil;
import com.common.libary.util.ToastUtil;

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
    @BindView(R.id.tv_go)
    TextView tvGo;

    @BindView(R.id.tv_service_show_dialog)
    TextView tvDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();//隐藏actionbar
        MyLog.d("MainActivity", "初始化");
        if (AppUtil.isBackground(this)) {
            MyLog.d(MainActivity.class.getSimpleName(), "后台");
        } else {
            MyLog.d(MainActivity.class.getSimpleName(), "前台");
        }
        MyLog.d("天数", String.valueOf(DateUtil.getDaysOfCurMonth()));

        if (FileUtil.checkExternalSDExists()) {//检查时候有外置ＳＤ卡
            MyLog.d(MainActivity.class.getSimpleName(), "是");
        } else {
            MyLog.d(MainActivity.class.getSimpleName(), "否");
        }

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

        MyLog.d("屏幕分辨率：", SystemUtil.getScreenParameterHeight(this) + "*" + SystemUtil.getScreenParameterHeight(this));
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


    @OnClick({R.id.btn_butterknife, R.id.tv_hello,R.id.tv_go,R.id.tv_service_show_dialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_butterknife:
                MyLog.d("click", "click");
                ToastUtil.showSingleTextToast(this, "butterknife注解，版本8.4，直接在布局文件上右键即可使用，需要另外配置，库配置失败");
                break;
            case R.id.tv_hello:
                MyLog.d("Click");
//                NotificationUtils.sendNotification(MainActivity.this,"com.example.vincent.MainActivity",R.mipmap.ic_launcher,"哈哈","消息..");
//                SystemUtilt.goXiaoMiPermissionManagerActivity(MainActivity.this,"打开失败");
                startService(new Intent(MainActivity.this, JobCastielService.class));
                break;
            case R.id.tv_go:

                break;
            case R.id.tv_service_show_dialog:
                finish();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            startService(new Intent(MainActivity.this,MyService.class));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                break;
        }
    }

}
