package com.common.libary;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.common.libary.util.ToastUtil;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by Vincent on 2016/10/26.
 */
@RuntimePermissions
public class RequePermissionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RequePermissionActivityPermissionsDispatcher.requeSelfStartUpWithCheck(this);
    }
    @NeedsPermission(Manifest.permission.RECEIVE_BOOT_COMPLETED)
    void requeSelfStartUp() {
    }

    @OnShowRationale(Manifest.permission.RECEIVE_BOOT_COMPLETED)
    void showRationaleForrEqueSelfStartUp(PermissionRequest request) {
        showRationaleDialog("发送短信必须动态授权", request);
    }

    @OnPermissionDenied(Manifest.permission.RECEIVE_BOOT_COMPLETED)
    void requeSelfStartUpDenied() {
        ToastUtil.showDefaultToast(getApplicationContext(), "您拒绝了授予权限，无法发送");
    }

    //拒绝权限不再弹出权限提示框
    @OnNeverAskAgain(Manifest.permission.RECEIVE_BOOT_COMPLETED)
    void requeSelfStartUpNeverAskAgain() {
        ToastUtil.showDefaultToast(getApplicationContext(), "不再允许询问该权限，该功能不可用");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        SendMsgActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    //弹出自定义权限提示框
    private void showRationaleDialog(String messageResId, final PermissionRequest request) {
        new AlertDialog.Builder(this)
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
