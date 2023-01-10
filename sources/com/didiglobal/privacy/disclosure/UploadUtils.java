package com.didiglobal.privacy.disclosure;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadUtils {

    /* renamed from: a */
    private static final String f53026a = "PrivacyDisclosure";

    /* renamed from: b */
    private static long f53027b = 0;

    /* renamed from: c */
    private static final String f53028c = "pmc/setPermissionNotice";

    public static void upload(Context context, UploadParam uploadParam) {
        if (uploadParam.getClickTime() != f53027b) {
            f53027b = uploadParam.getClickTime();
            Bff.call(new IBffProxy.Ability.Builder(context, f53028c).setParams(m39733a(uploadParam)).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    SystemUtils.log(3, UploadUtils.f53026a, "upload success", (Throwable) null, "com.didiglobal.privacy.disclosure.UploadUtils$1", 32);
                }

                public void onFailure(IOException iOException) {
                    SystemUtils.log(5, UploadUtils.f53026a, "upload failed: " + iOException.getMessage(), (Throwable) null, "com.didiglobal.privacy.disclosure.UploadUtils$1", 37);
                }
            }).build());
        }
    }

    /* renamed from: a */
    private static Map<String, Object> m39733a(UploadParam uploadParam) {
        HashMap hashMap = new HashMap();
        hashMap.put("appID", Integer.valueOf(uploadParam.getAppId()));
        hashMap.put("permissionType", uploadParam.getPermissionType());
        hashMap.put("currentPermissionStatus", Integer.valueOf(uploadParam.getCurrentPermissionStatus()));
        hashMap.put("popContent", uploadParam.getPopContent());
        hashMap.put("userAction", Integer.valueOf(uploadParam.getUserAction()));
        hashMap.put("popTime", Long.valueOf(uploadParam.getPopTime()));
        hashMap.put("clickTime", Long.valueOf(uploadParam.getClickTime()));
        return hashMap;
    }
}
