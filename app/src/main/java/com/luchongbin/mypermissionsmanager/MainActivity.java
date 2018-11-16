package com.luchongbin.mypermissionsmanager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

import com.luchongbin.lcbpermissionsmanager.LCBCheckPermissions;
import com.luchongbin.lcbpermissionsmanager.LCBCPListener;
import com.luchongbin.lcbpermissionsmanager.LCBCPOptions;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFragment(View v) {
        BlankActivity.gotoAct(this);
    }

    public void onClickAll(View v) {
        String[] mPermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_PHONE_STATE
                , Manifest.permission.SEND_SMS};

        LCBCheckPermissions.getInstance(this).request(new LCBCPOptions.Builder()
                        .setPermissions(mPermissions)
                        /*以下为自定义提示语、按钮文字
                        .setDeniedMessage()
                        .setDeniedCloseBtn()
                        .setDeniedSettingBtn()
                        .setRationalMessage()
                        .setRationalBtn()*/
                        .build(),
                new LCBCPListener() {
                    @Override
                    public void onGranted() {
                        makeText( "权限申请成功");
//                        writeSD();
//                        getIMEI();
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        makeText(permissions.toString() + "权限拒绝");
                    }
                });
    }

    public void onClickSd(View v) {
        LCBCheckPermissions.getInstance(this).request(new LCBCPOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .build(),
                new LCBCPListener() {
                    @Override
                    public void onGranted() {
                        makeText("权限成功=====");

                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        makeText(permissions.toString() + "权限拒绝");
                    }
                });
    }

    public void onClickImei(View v) {

        LCBCheckPermissions.getInstance(this).request(new LCBCPOptions.Builder()
                        .setPermissions(Manifest.permission.READ_PHONE_STATE)
                        .build(),
                new LCBCPListener() {
                    @Override
                    public void onGranted() {
//                        getIMEI();
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        makeText(permissions.toString() + "权限拒绝");
                    }
                });

    }

    public void onClickCallPhone(View view) {
        LCBCheckPermissions.getInstance(this).request(new LCBCPOptions.Builder().setPermissions(Manifest.permission.CALL_PHONE).build(),
                new LCBCPListener() {
                    @Override
                    public void onGranted() {
                        //注意：不用用带参的构造方法 否则 android studio 环境出错，提示要你检查授权

/*
                        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:13800138000"));
                        intentCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentCall);
*/

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:13800138000"));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        makeText(permissions.toString() + "权限拒绝");
                    }
                });

    }


//    private void getIMEI() {
//        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        if (tm != null)
//            makeText("读imei成功：" + tm.getDeviceId());
//    }

    private void makeText(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
