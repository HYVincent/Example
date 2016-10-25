package com.common.libary.util;

import android.content.Context;


import com.common.libary.log.MyLog;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Vincent on 2016/9/27.
 */

public class ExitUtil {
    private static boolean isQuit=false;
    /**
     * 在onBackPressed()方法中调用,使用此函数时不能调用onBackPressed()父类方法，应该去掉，
         @Override
        public void onBackPressed() {
        ExitUtils.isQuit(this,"再按一次退出app");
        }
      *true 退出
      *@author Vincent QQ1032006226
      *created at 2016/9/27 11:03
      */
    public static boolean isQuit(Context context,String exitMsg){
        if (isQuit == false) {
            isQuit = true;
            ToastUtil.showSingleTextToast(context.getApplicationContext(), exitMsg);
            TimerTask task = null;
            task = new TimerTask() {
                @Override
                public void run() {
                    isQuit = false;
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, 2000);
            MyLog.d("退出提示","用户正在退出");
            return true;
        } else {
            MyLog.d("app is exit", "app is exit");
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
            return false;
        }
    }

}
