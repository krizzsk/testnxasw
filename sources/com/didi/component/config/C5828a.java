package com.didi.component.config;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.component.config.a */
/* compiled from: BusinessConfig */
class C5828a {

    /* renamed from: h */
    private static final String f14463h = "pid";

    /* renamed from: i */
    private static final String f14464i = "bid";

    /* renamed from: j */
    private static final String f14465j = "parent_bid";

    /* renamed from: k */
    private static final String f14466k = "pname";

    /* renamed from: l */
    private static final String f14467l = "bdesc";

    /* renamed from: m */
    private static final String f14468m = "pver";

    /* renamed from: a */
    int f14469a;

    /* renamed from: b */
    String f14470b;

    /* renamed from: c */
    String f14471c;

    /* renamed from: d */
    String f14472d;

    /* renamed from: e */
    String f14473e;

    /* renamed from: f */
    String f14474f;

    /* renamed from: g */
    final SparseArray<PageConfig> f14475g = new SparseArray<>();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo52840a() {
        return true;
    }

    C5828a() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", ");
        sb.append("pname");
        sb.append(":");
        sb.append(this.f14471c);
        sb.append(", ");
        sb.append(f14467l);
        sb.append(":");
        sb.append(this.f14472d);
        sb.append(", ");
        sb.append(f14468m);
        sb.append(":");
        sb.append(this.f14473e);
        for (int i = 0; i < this.f14475g.size(); i++) {
            sb.append("\n\n");
            sb.append(this.f14475g.valueAt(i));
        }
        return sb.toString();
    }

    /* renamed from: a */
    static C5828a m11982a(JSONObject jSONObject) throws JSONException {
        PageConfig a;
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("pid");
        String optString = jSONObject.optString("bid");
        String optString2 = jSONObject.optString("pname");
        C5828a aVar = new C5828a();
        aVar.f14469a = optInt;
        aVar.f14470b = optString;
        aVar.f14474f = jSONObject.optString(f14465j);
        aVar.f14471c = optString2;
        aVar.f14472d = jSONObject.optString(f14467l);
        aVar.f14473e = jSONObject.optString(f14468m);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.isEmpty(next)) {
                throw new JSONException("unknown key: " + next);
            } else if (m11983a(next) && (a = PageConfig.m11978a(next, jSONObject.optJSONArray(next))) != null && a.mo52833a()) {
                aVar.f14475g.put(a.f14458a, a);
            }
        }
        if (aVar.mo52840a()) {
            return aVar;
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m11983a(String str) {
        return !TextUtils.isEmpty(str) && !TextUtils.equals(str, "pid") && !TextUtils.equals(str, "bid") && !TextUtils.equals(str, "pname") && !TextUtils.equals(str, f14465j);
    }
}
