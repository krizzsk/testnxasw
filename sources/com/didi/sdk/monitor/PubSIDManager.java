package com.didi.sdk.monitor;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class PubSIDManager {

    /* renamed from: a */
    private static final String f39647a = PubSIDManager.class.getSimpleName();

    /* renamed from: b */
    private static final Map<String, Object> f39648b = new HashMap();

    private PubSIDManager() {
    }

    private static final class Singleton {
        /* access modifiers changed from: private */
        public static final PubSIDManager sInstance = new PubSIDManager();

        private Singleton() {
        }
    }

    public static PubSIDManager getInstance() {
        return Singleton.sInstance;
    }

    public void setPubSID(String str, Object obj) {
        f39648b.put(str, obj);
        String str2 = f39647a;
        SystemUtils.log(3, str2, "setPubSID: pubSID " + m29852a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 48);
        OmegaSDK.putGlobalAttr("pub_sid", m29852a());
    }

    public void setPubSID(Map<String, Object> map) {
        f39648b.putAll(map);
        String str = f39647a;
        SystemUtils.log(3, str, "setPubSID: pubSID " + m29852a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 54);
        OmegaSDK.putGlobalAttr("pub_sid", m29852a());
    }

    public void removePubSID(String str, Object obj) {
        f39648b.remove(str);
        String str2 = f39647a;
        SystemUtils.log(3, str2, "removePubSID: pubSID " + m29852a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 60);
        OmegaSDK.putGlobalAttr("pub_sid", m29852a());
    }

    public void removePubSID(Map<String, Object> map) {
        for (String remove : map.keySet()) {
            f39648b.remove(remove);
        }
        String str = f39647a;
        SystemUtils.log(3, str, "removePubSID: pubSID " + m29852a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 69);
        OmegaSDK.putGlobalAttr("pub_sid", m29852a());
    }

    /* renamed from: a */
    private String m29852a() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : f39648b.entrySet()) {
            Object value = next.getValue();
            sb.append(((String) next.getKey()) + "=" + value + ";");
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }
}
