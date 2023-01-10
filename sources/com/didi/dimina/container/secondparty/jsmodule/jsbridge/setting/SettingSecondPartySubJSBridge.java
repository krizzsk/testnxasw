package com.didi.dimina.container.secondparty.jsmodule.jsbridge.setting;

import android.app.Activity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import org.json.JSONObject;

public class SettingSecondPartySubJSBridge {

    /* renamed from: c */
    private static final String f19162c = "scope";

    /* renamed from: a */
    private final DMMina f19163a;

    /* renamed from: b */
    private final Activity f19164b;

    public SettingSecondPartySubJSBridge(DMMina dMMina, Activity activity) {
        this.f19163a = dMMina;
        this.f19164b = activity;
        LogUtil.m16841i("SecondParty SettingSubJSBridge init");
    }

    public void businessAuthorize(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (jSONObject == null || !jSONObject.has("scope")) {
            CallBackUtil.onFail("fail parameter error: parameter.scope should be String instead of Undefined;", callbackFunction);
            return;
        }
        String optString = jSONObject.optString("scope");
        if (BridgePermission.bridgePermissionSet.contains(optString)) {
            PermissionDescInfo parse = PermissionDescInfo.parse(jSONObject);
            if (parse.getIcon().startsWith("difile")) {
                parse.setIcon(new DMSandboxHelper(this.f19163a.getConfig()).url2filepath(parse.getIcon()));
            }
            PermissionUtil.INSTANCE.checkAndRequestBridgePermission(this.f19164b, optString, parse, new SinglePermissionCallBack() {
                public void onDenied(String str) {
                    CallBackUtil.onFail("onDenied", callbackFunction);
                }

                public void onGranted(String str) {
                    CallBackUtil.onSuccess(callbackFunction);
                }
            });
            return;
        }
        CallBackUtil.onFail("fail parameter error: parameter.scope not need authorize", callbackFunction);
    }
}
