package com.didi.raven;

import android.content.Context;
import android.text.TextUtils;
import com.didi.raven.cache.RavenData;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenConstants;
import com.didi.raven.config.RavenEvent;
import com.didi.raven.config.RavenKey;
import com.didi.raven.model.RavenRequestExtInfo;
import com.didi.raven.model.RavenRequestModel;
import com.didi.raven.model.RavenTimeRequestModel;
import com.didi.raven.net.RavenDidiHttpManger;
import com.didi.raven.net.RavenNetManger;
import com.didi.raven.utils.RavenEncryptUtils;
import com.didi.raven.utils.RavenUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RavenHttpManger {

    /* renamed from: a */
    private RavenNetManger f35849a;

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenHttpManger INSTANCE = new RavenHttpManger();

        private SingleTon() {
        }
    }

    public static RavenHttpManger getInstance() {
        return SingleTon.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93559a(Context context) {
        RavenDidiHttpManger instance = RavenDidiHttpManger.getInstance();
        this.f35849a = instance;
        instance.init(context);
    }

    public RavenNetManger getNetManger() {
        return this.f35849a;
    }

    /* renamed from: a */
    private Map<String, Object> m27012a(String str) {
        Map<String, Object> config = RavenDataManger.getInstance().getRavenData(str).getConfig();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (String next : RavenConfigKey.configKeyList) {
            Object obj = config.get(next);
            if (obj != null && !TextUtils.isEmpty(obj.toString())) {
                concurrentHashMap.put(next, obj.toString());
            }
        }
        return concurrentHashMap;
    }

    /* renamed from: a */
    private Map<String, Object> m27013a(String str, String str2, int i, Map<String, Object> map) {
        RavenData ravenData = RavenDataManger.getInstance().getRavenData(str);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Map<String, Object> a = m27012a(str);
        if (a != null && a.size() > 0) {
            for (String next : a.keySet()) {
                if (TextUtils.equals(next, RavenConfigKey.PHONE)) {
                    concurrentHashMap.put(RavenConfigKey.PHONE, RavenEncryptUtils.encodeWithSHA1(String.valueOf(a.get(next))));
                    concurrentHashMap.put(RavenConfigKey.PHONE_ENCRYPT, RavenEncryptUtils.changeP(String.valueOf(a.get(next))));
                } else {
                    concurrentHashMap.put(next, a.get(next));
                }
            }
        }
        concurrentHashMap.put("pt", Long.valueOf(System.currentTimeMillis()));
        concurrentHashMap.put("bid", ravenData.getRavenId());
        concurrentHashMap.put(RavenKey.VERSION, RavenConstants.SDK_VERSION);
        concurrentHashMap.put(RavenKey.EVENT_ID, str2);
        concurrentHashMap.put(RavenKey.TYPE, Integer.valueOf(i));
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(RavenDataManger.getInstance().getRavenData(str).getAttrs());
        if (map != null && map.size() > 0) {
            concurrentHashMap2.putAll(map);
        }
        concurrentHashMap.put(RavenKey.ATTRS, RavenUtils.mapToJson(concurrentHashMap2));
        return concurrentHashMap;
    }

    /* renamed from: b */
    private Map<String, Object> m27021b(String str, String str2, Map<String, Object> map) {
        return m27013a(str, str2, 1, map);
    }

    /* renamed from: b */
    private Map<String, Object> m27022b(String str, Map<String, Object> map, String str2, String str3, String str4) {
        Map<String, Object> a = m27013a(str, "error", 2, map);
        a.put(RavenKey.NAME, str2);
        a.put("m", str3);
        a.put(RavenKey.STACK, str4);
        return a;
    }

    /* renamed from: b */
    private Map<String, Object> m27020b(String str, String str2, String str3, long j, long j2, Object obj, Object obj2, int i, Map<String, Object> map) {
        String str4 = str;
        Map<String, Object> a = m27013a(str, RavenEvent.DefaultEvent.REQUEST, 3, map);
        String str5 = str2;
        a.put(RavenKey.NAME, str2);
        String str6 = str3;
        a.put(RavenKey.TRACE_ID, str3);
        a.put("pt", Long.valueOf(j));
        a.put("ext", RavenUtils.objectToJson(new RavenRequestExtInfo(new RavenRequestModel(obj, obj2, j2 - j, i))));
        return a;
    }

    /* renamed from: a */
    private Map<String, Object> m27014a(String str, String str2, String str3, long j, long j2, Object obj, Object obj2, int i) {
        return m27020b(str, str2, str3, j, j2, obj, obj2, i, (Map<String, Object>) null);
    }

    /* renamed from: b */
    private Map<String, Object> m27019b(String str, String str2, long j, long j2, Map<String, Object> map) {
        Map<String, Object> a = m27013a(str, RavenEvent.DefaultEvent.TIME, 7, map);
        a.put("pt", Long.valueOf(System.currentTimeMillis()));
        a.put(RavenKey.NAME, str2);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("time", new RavenTimeRequestModel(j2 - j, 0));
        a.put("ext", RavenUtils.mapToJson(concurrentHashMap));
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93562a(String str, String str2, Map<String, Object> map) {
        m27016a(str, m27021b(str, str2, map), true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93561a(String str, String str2, String str3, long j, long j2, Object obj, Object obj2, int i, Map<String, Object> map) {
        m27016a(str, m27014a(str, str2, str3, j, j2, obj, obj2, i), true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93563a(String str, Map<String, Object> map, String str2, String str3, String str4) {
        m27016a(str, m27022b(str, map, str2, str3, str4), true);
    }

    public void trackPool(List<Map<String, Object>> list) {
        m27017a(list);
    }

    public void trackPool(String str) {
        m27023b(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93560a(String str, String str2, long j, long j2, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str2)) {
            m27016a(str, m27019b(str, str2, j, j2, map), true);
        }
    }

    /* renamed from: a */
    private void m27015a(String str, Map<String, Object> map) {
        if (this.f35849a != null && RavenSdk.getInstance().getSwitch()) {
            this.f35849a.post(str, map);
        }
    }

    /* renamed from: a */
    private void m27017a(List<Map<String, Object>> list) {
        if (this.f35849a != null && RavenSdk.getInstance().getSwitch() && list.size() > 0) {
            this.f35849a.postPool(list);
        }
    }

    /* renamed from: b */
    private void m27023b(String str) {
        if (this.f35849a != null && RavenSdk.getInstance().getSwitch()) {
            this.f35849a.postPool(str);
        }
    }

    /* renamed from: a */
    private void m27018a(Map<String, Object> map) {
        RavenDataManger.getInstance().addParams(map);
    }

    /* renamed from: a */
    private void m27016a(String str, Map<String, Object> map, boolean z) {
        if (z) {
            m27018a(map);
        } else {
            m27015a(str, map);
        }
    }
}
