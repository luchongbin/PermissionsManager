package com.luchongbin.lcbpermissionsmanager;

import java.util.List;

/**
 * Created by luchongbin on 2018/4/28.
 */
public interface LCBCPListener {
    /**
     *同意
     */
    void onGranted();

    /**
     * 拒绝
     */
    void onDenied(List<String> permissions);
}
