package com.common.libary.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import com.common.libary.log.MyLog;
import com.vincent.libary.R;

/**
 * Created by Vincent on 2016/10/25.
 */

public class KillNotifacationService extends Service {
    private boolean sPower=true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {//启动一个线程，停止通知，此时通知变的不可见，但是后台Service还在
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        startForeground(250, builder.build());
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(200);
                stopForeground(true);
                NotificationManager manager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.cancel(250);
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

}
