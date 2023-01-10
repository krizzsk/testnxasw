package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SettingSubJSBridge {

    /* renamed from: c */
    private static final String f18543c = "scope.userLocation";

    /* renamed from: d */
    private static final String f18544d = "scope.writePhotosAlbum";

    /* renamed from: e */
    private static final String f18545e = "scope.camera";

    /* renamed from: f */
    private static final String f18546f = "scope.record";

    /* renamed from: g */
    private static final String f18547g = "scope.contact";

    /* renamed from: h */
    private static final String f18548h = "authorize:fail 系统错误，错误码：-12001，invalid scope";

    /* renamed from: i */
    private static final String f18549i = "scope";

    /* renamed from: j */
    private static final Map<String, String> f18550j;

    /* renamed from: a */
    private final DMMina f18551a;

    /* renamed from: b */
    private final Activity f18552b;

    static {
        HashMap hashMap = new HashMap();
        f18550j = hashMap;
        hashMap.put(f18543c, Permission.ACCESS_FINE_LOCATION);
        f18550j.put(f18545e, Permission.CAMERA);
        f18550j.put(f18546f, Permission.RECORD_AUDIO);
    }

    public SettingSubJSBridge(DMMina dMMina, Activity activity) {
        this.f18551a = dMMina;
        this.f18552b = activity;
        LogUtil.m16841i("SettingSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59506a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Dimina.getConfig().getAdapterConfig().getPermissionService().openSetting(this.f18552b, 1);
        CallBackUtil.onSuccess(callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59507b(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("scope");
        String str = f18550j.get(optString);
        if (!TextUtils.isEmpty(str) || (str = JSBridgePluginLoader.getPermission(optString)) != null || callbackFunction == null) {
            PermissionUtil.INSTANCE.checkAndRequestPermissionsWithDescDialog(this.f18552b, str, m15725b(optString), new SinglePermissionCallBack() {
                public void onDenied(String str) {
                    CallbackFunction callbackFunction = callbackFunction;
                    if (callbackFunction != null) {
                        CallBackUtil.onFail("", callbackFunction);
                    }
                }

                public void onGranted(String str) {
                    CallbackFunction callbackFunction = callbackFunction;
                    if (callbackFunction != null) {
                        CallBackUtil.onSuccess(callbackFunction);
                    }
                }
            });
        } else {
            CallBackUtil.onFail(f18548h, callbackFunction);
        }
    }

    /* renamed from: a */
    private String m15724a(String str) {
        if (f18544d.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_STORAGE_REJECTED_HINT;
        }
        if (f18543c.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_LOCATION_REJECTED_HINT;
        }
        if (f18545e.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_CAMERA_REJECTED_HINT;
        }
        if (f18546f.equals(str)) {
            return DiminaPermissionDescDialog.PERMISSION_RECORD_REJECTED_HINT;
        }
        return f18547g.equals(str) ? DiminaPermissionDescDialog.PERMISSION_CONTACT_REJECTED_HINT : "";
    }

    /* renamed from: b */
    private PermissionDescInfo m15725b(String str) {
        if (f18543c.equals(str)) {
            return DiminaPermissionDescDialog.createLocationDescInfo(this.f18551a);
        }
        if (f18545e.equals(str)) {
            return DiminaPermissionDescDialog.createCameraDescInfo(this.f18551a);
        }
        if (f18544d.equals(str)) {
            return DiminaPermissionDescDialog.createStorageDescInfo(this.f18551a);
        }
        if (f18546f.equals(str)) {
            return DiminaPermissionDescDialog.createRecordDescInfo(this.f18551a);
        }
        return new PermissionDescInfo("权限申请说明", "");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59508c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = new JSONObject();
        if (PermissionUtil.hasPermissionOperated(this.f18552b, Permission.ACCESS_COARSE_LOCATION)) {
            JSONUtil.put(jSONObject2, f18543c, PermissionUtil.requestLocationPermission(this.f18552b));
        }
        if (PermissionUtil.hasPermissionOperated(this.f18552b, Permission.READ_CONTACTS)) {
            JSONUtil.put(jSONObject2, "scope.address", PermissionUtil.requestContactPermission(this.f18552b));
        }
        if (PermissionUtil.hasPermissionOperated(this.f18552b, Permission.RECORD_AUDIO)) {
            JSONUtil.put(jSONObject2, f18546f, PermissionUtil.requestAudioPermission(this.f18552b));
        }
        if (PermissionUtil.hasPermissionOperated(this.f18552b, Permission.CAMERA)) {
            JSONUtil.put(jSONObject2, f18545e, PermissionUtil.requestCameraPermission(this.f18552b));
        }
        hashMap.put("authSetting", jSONObject2);
        if (callbackFunction != null) {
            CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
        }
    }
}
