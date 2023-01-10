package com.didi.raven.cache;

import android.text.TextUtils;
import com.didi.raven.RavenDataManger;
import com.didi.raven.config.RavenConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RavenData {

    /* renamed from: a */
    private final AtomicInteger f35850a = new AtomicInteger(0);

    /* renamed from: b */
    private String f35851b = "";

    /* renamed from: c */
    private String f35852c = RavenConstants.DEFAULT_PATH;

    /* renamed from: d */
    private Map<String, Object> f35853d = new ConcurrentHashMap();

    /* renamed from: e */
    private Map<String, Object> f35854e = new ConcurrentHashMap();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93590a() {
        this.f35850a.set(0);
    }

    public int getIndex() {
        return this.f35850a.incrementAndGet();
    }

    public String getRavenId() {
        if (TextUtils.isEmpty(this.f35851b) || TextUtils.equals("unKnow", this.f35851b)) {
            if (TextUtils.isEmpty(RavenCache.RAVEN_ID)) {
                String loadRavenId = RavenDataManger.getInstance().loadRavenId();
                this.f35851b = loadRavenId;
                RavenCache.RAVEN_ID = loadRavenId;
            } else {
                this.f35851b = RavenCache.RAVEN_ID;
            }
        }
        return this.f35851b;
    }

    public String getBaseUrl() {
        return this.f35852c;
    }

    public void setBaseUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f35852c = str;
        }
    }

    public Map<String, Object> getAttrs() {
        return this.f35853d;
    }

    public void setAttrs(Map<String, Object> map) {
        this.f35853d = map;
    }

    public Map<String, Object> getConfig() {
        return this.f35854e;
    }

    public void setConfig(Map<String, Object> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                if (map.get(next) != null) {
                    this.f35854e.put(next, map.get(next));
                }
            }
        }
    }
}
