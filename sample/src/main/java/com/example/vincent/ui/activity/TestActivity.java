package com.example.vincent.ui.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.common.libary.util.ToastUtil;
import com.elvishew.xlog.XLog;
import com.example.vincent.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by Vincent on 2016/11/13.
 */

@RuntimePermissions
public class TestActivity extends AppCompatActivity {
    private static final int CALL_CAMERA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test);
        XLog.d(TestActivity.class.getSimpleName(),"onCreae()");
        TestActivityPermissionsDispatcher.checkPermissionWithCheck(this);

    }

    /**
     * 检查权限，这里主要是XLog
     */
    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE})
    void checkPermission() {

    }
    @OnShowRationale({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE})
    void showRationaleForSaveLog(PermissionRequest request) {
        showRationaleDialog("更新功能和二维码扫描需要读写外部存储卡权限", request);
    }

    @OnPermissionDenied({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE})
    void turnSavaLog() {
        ToastUtil.showSingleTextToast(TestActivity.this,"拒绝，无法创建XLog保存目录");
    }

    @OnNeverAskAgain({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE})
    void SaveLogAndNoTiShi() {
        ToastUtil.showSingleTextToast(TestActivity.this,"您拒绝授予权限且不再提示授权");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        TestActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    private void showRationaleDialog(String messageResId, final PermissionRequest request) {
        new AlertDialog.Builder(TestActivity.this)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage(messageResId)
                .show();
    }

}
