package com.example.vincent;

<<<<<<< HEAD
import android.app.ActivityManager;
=======
>>>>>>> 646463942a8349533894624870bd3f8f4eb81753
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
    @BindView(R.id.tv_okgo)
    TextView tvOkGo;

    @BindView(R.id.tv_service_show_dialog)
    TextView tvDialog;

    /**
     * 此类写法会隐式的持有Activity对象，可能会造成内存泄漏，解决方法 在onDestroy里面调用handle移除消息
     */
    private  Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.arg1==1){
                MyLog.d(MainActivity.class.getSimpleName(),"收到Handler发来的消息了");
                ToastUtil.showDefaultToast(MainActivity.this,"收到Handler发来的消息了");
            }
            super.handleMessage(msg);
        }
    };
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
        startService(new Intent(MainActivity.this, JobCastielService.class));
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

        MyLog.d("屏幕分辨率：", SystemUtil.getScreenParameterWidth(this) + "*" + SystemUtil.getScreenParameterHeight(this));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listener.unregisterListener();//注意监听屏蔽需要解除注册
        handler.removeCallbacksAndMessages(null);//非静态引用会持有外部Activity实例，会导致内存泄漏，此处解决内存泄漏，或者改成静态引用
    }

    @Override
    public void onBackPressed() {
        ExitUtil.isQuit(this, "再按一次退出app");
    }


    @OnClick({R.id.btn_butterknife, R.id.tv_hello,R.id.tv_go,R.id.tv_service_show_dialog,R.id.tv_okgo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_butterknife:
                MyLog.d("click", "click");
                ToastUtil.showSingleTextToast(this, "butterknife注解，版本8.4，直接在布局文件上右键即可使用，需要另外配置，库配置失败");
                break;
            case R.id.tv_hello:
                MyLog.d("Click");
                //还有个API内部的方法，ActivityManager.forceStopPackages(String packageName)
//                可以使用，
//                并且好像很多人都热衷反射,来使用
//                NotificationUtils.sendNotification(MainActivity.this,"com.example.vincent.MainActivity",R.mipmap.ic_launcher,"哈哈","消息..");
//                SystemUtilt.goXiaoMiPermissionManagerActivity(MainActivity.this,"打开失败");
//                startService(new Intent(MainActivity.this, JobCastielService.class));
                ActivityManager a=(ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
                a.killBackgroundProcesses("com.shangyi.netty");



                break;
            case R.id.tv_go:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            Message msg=Message.obtain();
                            msg.arg1=1;
                            handler.sendMessage(msg);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
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
            case R.id.tv_okgo:
                Intent intent = new Intent(MainActivity.this,OkGoTestActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }

}
