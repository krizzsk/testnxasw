package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BackgroundFetchDataSubJSBridge {
    public static final String STORAGE_KEY = "first_together_token";

    /* renamed from: a */
    private final DMMina f18444a;

    public BackgroundFetchDataSubJSBridge(DMMina dMMina) {
        LogUtil.m16841i("FirstTogetherSubJSBridge init");
        this.f18444a = dMMina;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59104a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        try {
            str = jSONObject.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        MMKVUtil.getInstance().save(STORAGE_KEY, str);
        CallBackUtil.onSuccess(callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59105b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        HashMap hashMap = new HashMap();
        if (this.f18444a.getConfig().getAdapterConfig().getFirstFetchService() != null) {
            JSONObject firstTokenTogether = this.f18444a.getConfig().getAdapterConfig().getFirstFetchService().getFirstTokenTogether(this.f18444a);
            TraceUtil.trackBackgroundFetchDataApply(this.f18444a.getMinaIndex(), firstTokenTogether == null ? 0 : 1, (String) MMKVUtil.getInstance().get(STORAGE_KEY, ""));
            if (firstTokenTogether != null) {
                hashMap.put("fetchedData", firstTokenTogether);
                CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
                return;
            }
            CallBackUtil.onFail((Map<String, ? extends Object>) hashMap, "未获取到登录预请求接口数据", callbackFunction);
            return;
        }
        CallBackUtil.onFail((Map<String, ? extends Object>) hashMap, "数据预拉取接口未实现", callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59106c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        try {
            str = jSONObject.getString("duration");
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        DMMina dMMina = this.f18444a;
        TraceUtil.firstLaunch(dMMina == null ? -1 : dMMina.getMinaIndex(), str);
        CallBackUtil.onSuccess(callbackFunction);
    }
}
