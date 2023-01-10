package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.splitinstall.g */
public final class C20197g {

    /* renamed from: a */
    private final Map<String, Map<String, String>> f56255a = new HashMap();

    /* renamed from: a */
    public final C20198h mo164512a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f56255a.entrySet()) {
            hashMap.put((String) next.getKey(), Collections.unmodifiableMap(new HashMap((Map) next.getValue())));
        }
        return new C20198h(Collections.unmodifiableMap(hashMap));
    }

    /* renamed from: a */
    public final void mo164513a(String str, String str2, String str3) {
        if (!this.f56255a.containsKey(str2)) {
            this.f56255a.put(str2, new HashMap());
        }
        this.f56255a.get(str2).put(str, str3);
    }
}
