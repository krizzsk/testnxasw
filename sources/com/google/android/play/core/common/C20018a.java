package com.google.android.play.core.common;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.common.a */
public final class C20018a {

    /* renamed from: a */
    private final Map<String, Object> f56051a = new HashMap();

    /* renamed from: a */
    public final synchronized void mo164250a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && this.f56051a.get(str) == null) {
                this.f56051a.put(str, obj);
            }
        }
    }

    /* renamed from: a */
    public final synchronized boolean mo164251a() {
        Object obj = this.f56051a.get("usingExtractorStream");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
