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
	        implementation 'com.github.luchongbin:PermissionsManager:v1.0.0'
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
## license  
```
MIT License

Copyright (c) 2018 卢崇斌

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
