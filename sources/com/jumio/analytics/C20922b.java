package com.jumio.analytics;

import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.jumio.analytics.b */
/* compiled from: Payload.kt */
public final class C20922b<T> implements Serializable {

    /* renamed from: a */
    public final T f57379a;

    /* renamed from: b */
    public final MetaInfo f57380b;

    public C20922b(T t, MetaInfo metaInfo) {
        this.f57379a = t;
        this.f57380b = metaInfo;
    }

    /* renamed from: a */
    public final MetaInfo mo171747a() {
        return this.f57380b;
    }

    /* renamed from: b */
    public final T mo171748b() {
        return this.f57379a;
    }

    /* renamed from: c */
    public final JSONObject mo171749c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        T t = this.f57379a;
        if (t instanceof Map) {
            T t2 = this.f57379a;
            if (t2 != null) {
                t = new JSONObject((Map) t2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            }
        }
        jSONObject.put("value", t);
        MetaInfo metaInfo = this.f57380b;
        if (!(metaInfo == null || metaInfo.size() == 0)) {
            jSONObject.put("metainfo", new JSONObject(metaInfo));
        }
        return jSONObject;
    }
}
