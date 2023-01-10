package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.storage.StorageServiceSP;
import com.didi.dimina.container.mina.DMMinaPerfStorage;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.e */
/* compiled from: StorageSubJSBridge */
class C8042e {

    /* renamed from: a */
    private static final String f18602a = "JSONObject";

    /* renamed from: b */
    private static final String f18603b = "JSONArray";

    /* renamed from: c */
    private static final String f18604c = "Boolean";

    /* renamed from: d */
    private static final String f18605d = "Double";

    /* renamed from: e */
    private static final String f18606e = "Integer";

    /* renamed from: f */
    private static final String f18607f = "Long";

    /* renamed from: g */
    private static final String f18608g = "String";

    /* renamed from: h */
    private static final int f18609h = 10240;

    /* renamed from: i */
    private final StorageServiceSP f18610i;

    /* renamed from: j */
    private final DMMinaPerfStorage f18611j;

    C8042e(DMMina dMMina) {
        this.f18611j = dMMina.getPerformance().getMinaPerfStorage();
        this.f18610i = new StorageServiceSP(dMMina);
        LogUtil.m16841i("StorageSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59665a(JSONObject jSONObject) {
        if (jSONObject.has("key")) {
            m15832a(jSONObject.optString("key"), jSONObject.opt("data"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59666a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject b = m15833b(jSONObject);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(b);
        }
    }

    /* renamed from: b */
    private JSONObject m15833b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (!jSONObject.has("key") || !jSONObject.has("data")) {
            JSONUtil.put(jSONObject2, "success", false);
            JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "参数出错：key");
        } else {
            m15832a(jSONObject.optString("key"), jSONObject.opt("data"));
            JSONUtil.put(jSONObject2, "success", true);
            JSONUtil.put(jSONObject2, "data", (Object) "设置成功：");
        }
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo59668b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return m15835c(jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59669c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("StorageSubJSBridge removeStorage: " + jSONObject);
        JSONObject c = m15835c(jSONObject);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(c);
        }
    }

    /* renamed from: c */
    private JSONObject m15835c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has("key")) {
            String optString = jSONObject.optString("key");
            this.f18610i.remove(optString);
            DMMinaPerfStorage dMMinaPerfStorage = this.f18611j;
            if (dMMinaPerfStorage != null) {
                dMMinaPerfStorage.minusStorage(optString);
            }
            JSONUtil.put(jSONObject2, "success", true);
            JSONUtil.put(jSONObject2, "data", (Object) "设置成功：");
        } else {
            JSONUtil.put(jSONObject2, "success", false);
            JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "参数出错：key");
        }
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Object mo59670d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        return jSONObject.has("key") ? m15831a(jSONObject.optString("key")) : "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo59671e(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (callbackFunction == null) {
            return;
        }
        if (jSONObject.has("key")) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, "data", m15831a(jSONObject.optString("key")));
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
            return;
        }
        CallBackUtil.onFail("参数出错：key", callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59664a(CallbackFunction callbackFunction) {
        JSONObject c = m15834c();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo59663a() {
        return m15836d();
    }

    /* renamed from: c */
    private JSONObject m15834c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        List<String> e = m15837e();
        JSONUtil.put(jSONObject2, "keys", (Object) e);
        JSONUtil.put(jSONObject2, "currentSize", e.size());
        JSONUtil.put(jSONObject2, "limitSize", 10240);
        JSONUtil.put(jSONObject, "data", (Object) jSONObject2);
        JSONUtil.put(jSONObject, "success", true);
        return jSONObject;
    }

    /* renamed from: d */
    private JSONObject m15836d() {
        JSONObject jSONObject = new JSONObject();
        List<String> e = m15837e();
        JSONUtil.put(jSONObject, "keys", (Object) e);
        JSONUtil.put(jSONObject, "currentSize", e.size());
        JSONUtil.put(jSONObject, "limitSize", 10240);
        return jSONObject;
    }

    /* renamed from: e */
    private List<String> m15837e() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f18610i.getAllKeys()) {
            if (!str.contains(":type")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo59672f(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("StorageSubJSBridge clearStorage: " + jSONObject);
        this.f18610i.clearAll();
        DMMinaPerfStorage dMMinaPerfStorage = this.f18611j;
        if (dMMinaPerfStorage != null) {
            dMMinaPerfStorage.clear();
        }
        CallBackUtil.onSuccess(callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo59667b() {
        LogUtil.m16841i("StorageSubJSBridge clearStorage: ");
        this.f18610i.clearAll();
        DMMinaPerfStorage dMMinaPerfStorage = this.f18611j;
        if (dMMinaPerfStorage != null) {
            dMMinaPerfStorage.clear();
        }
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "success", true);
        return jSONObject;
    }

    /* renamed from: a */
    private void m15832a(String str, Object obj) {
        String str2 = str + ":type";
        if (obj instanceof JSONArray) {
            this.f18610i.putString(str2, f18603b);
            DMMinaPerfStorage dMMinaPerfStorage = this.f18611j;
            if (dMMinaPerfStorage != null) {
                dMMinaPerfStorage.plusStorage(str2, f18603b);
            }
            this.f18610i.putString(str, obj.toString());
        } else if (obj instanceof JSONObject) {
            this.f18610i.putString(str2, f18602a);
            DMMinaPerfStorage dMMinaPerfStorage2 = this.f18611j;
            if (dMMinaPerfStorage2 != null) {
                dMMinaPerfStorage2.plusStorage(str2, f18602a);
            }
            this.f18610i.putString(str, obj.toString());
        } else if (obj instanceof Boolean) {
            this.f18610i.putString(str2, f18604c);
            DMMinaPerfStorage dMMinaPerfStorage3 = this.f18611j;
            if (dMMinaPerfStorage3 != null) {
                dMMinaPerfStorage3.plusStorage(str2, f18604c);
            }
            this.f18610i.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            this.f18610i.putString(str2, f18605d);
            DMMinaPerfStorage dMMinaPerfStorage4 = this.f18611j;
            if (dMMinaPerfStorage4 != null) {
                dMMinaPerfStorage4.plusStorage(str2, f18605d);
            }
            this.f18610i.putFloat(str, ((Double) obj).floatValue());
        } else if (obj instanceof Integer) {
            this.f18610i.putString(str2, f18606e);
            DMMinaPerfStorage dMMinaPerfStorage5 = this.f18611j;
            if (dMMinaPerfStorage5 != null) {
                dMMinaPerfStorage5.plusStorage(str2, f18606e);
            }
            this.f18610i.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.f18610i.putString(str2, f18607f);
            DMMinaPerfStorage dMMinaPerfStorage6 = this.f18611j;
            if (dMMinaPerfStorage6 != null) {
                dMMinaPerfStorage6.plusStorage(str2, f18607f);
            }
            this.f18610i.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            this.f18610i.putString(str2, f18608g);
            DMMinaPerfStorage dMMinaPerfStorage7 = this.f18611j;
            if (dMMinaPerfStorage7 != null) {
                dMMinaPerfStorage7.plusStorage(str2, f18608g);
            }
            this.f18610i.putString(str, (String) obj);
        }
        DMMinaPerfStorage dMMinaPerfStorage8 = this.f18611j;
        if (dMMinaPerfStorage8 != null) {
            dMMinaPerfStorage8.plusStorage(str, obj);
        }
    }

    /* renamed from: a */
    private Object m15831a(String str) {
        String string = this.f18610i.getString(str + ":type", "");
        if (TextUtils.equals(string, f18603b)) {
            try {
                return new JSONArray(this.f18610i.getString(str, "[]"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TextUtils.equals(string, f18602a)) {
            try {
                return new JSONObject(this.f18610i.getString(str, "{}"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (TextUtils.equals(string, f18604c)) {
            return Boolean.valueOf(this.f18610i.getBoolean(str, false));
        } else {
            if (TextUtils.equals(string, f18605d)) {
                return Double.valueOf(new BigDecimal(String.valueOf(this.f18610i.getFloat(str, 0.0f))).doubleValue());
            }
            if (TextUtils.equals(string, f18606e)) {
                return Integer.valueOf(this.f18610i.getInt(str, 0));
            }
            if (TextUtils.equals(string, f18607f)) {
                return Double.valueOf((double) this.f18610i.getLong(str, 0));
            }
            if (TextUtils.equals(string, f18608g)) {
                return this.f18610i.getString(str, "");
            }
            return "";
        }
    }
}
