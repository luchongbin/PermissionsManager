# PermissionsManager
android 权限管理 兼容 6.0以上（包括7、8、9）
## 先来个效果图  
![效果图](https://github.com/luchongbin/PermissionsManager/blob/master/gif/gif.gif)  
[![](https://jitpack.io/v/luchongbin/PermissionsManager.svg)](https://jitpack.io/#luchongbin/PermissionsManager)
## 添加依赖  
1、Add the JitPack repository to your build file  
   Add it in your root build.gradle at the end of repositories:  
 ```
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```  
2、Add the dependency  
```
dependencies {
	        implementation 'com.github.luchongbin:PermissionsManager:1.0.1'
	}
```
## 使用说明  
 如下代码
 ```
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
                    public void onGranted() {//权限申请成功
                        makeText( "权限申请成功");
//
                    }

                    @Override
                    public void onDenied(List<String> permissions) {//权限拒绝
                    }
                });
```
