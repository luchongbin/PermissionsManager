package com.luchongbin.lcbpermissionsmanager;

import android.content.Context;

/**
 * Created by luchongbin on 2018/4/28.
 */
public class LCBCheckPermissions {

    private static LCBCheckPermissions mInstance;
    private PermissionsManager mAcpManager;

    public static LCBCheckPermissions getInstance(Context context) {
        if (mInstance == null)
            synchronized (LCBCheckPermissions.class) {
                if (mInstance == null) {
                    mInstance = new LCBCheckPermissions(context);
                }
            }
        return mInstance;
    }

    private LCBCheckPermissions(Context context) {
        mAcpManager = new PermissionsManager(context.getApplicationContext());
    }

    /**
     * 开始请求
     *
     * @param options
     * @param acpListener
     */
    public void request(LCBCPOptions options, LCBCPListener acpListener) {
        if (options == null) new NullPointerException("AcpOptions is null...");
        if (acpListener == null) new NullPointerException("AcpListener is null...");
        mAcpManager.request(options, acpListener);
    }

    PermissionsManager getAcpManager() {
        return mAcpManager;
    }
}
