package com.didichuxing.swarm.launcher;

import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/* renamed from: com.didichuxing.swarm.launcher.a */
/* compiled from: BundleDependency */
class C17297a {

    /* renamed from: a */
    private static final String f51756a = "BundleDependency";

    /* renamed from: b */
    private static final JsonParser f51757b = new JsonParser();

    /* renamed from: c */
    private final Bundle f51758c;

    /* renamed from: d */
    private final Map<String, C17298b> f51759d;

    /* renamed from: e */
    private final Map<String, String> f51760e = new HashMap();

    public C17297a(Map<String, C17298b> map, Bundle bundle) {
        this.f51758c = bundle;
        this.f51759d = map;
        String str = bundle.getHeaders().get("Bundle-Dependency");
        if (!TextUtils.isEmpty(str)) {
            for (Map.Entry next : f51757b.parse(str).getAsJsonObject().entrySet()) {
                this.f51760e.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
            }
        }
    }

    /* renamed from: a */
    public List<C17297a> mo127728a() throws BundleException {
        if (this.f51760e.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String next : this.f51760e.keySet()) {
            if (this.f51759d.containsKey(next)) {
                Map<String, C17298b> map = this.f51759d;
                arrayList.add(new C17297a(map, map.get(next).mo127732b()));
            } else {
                throw new BundleException("Bundle " + next + " not found", 4);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo127729b() throws BundleException {
        C17298b bVar = this.f51759d.get(this.f51758c.getSymbolicName());
        if (bVar == null) {
            return;
        }
        if (bVar == null || !bVar.mo127731a()) {
            if (!this.f51760e.isEmpty()) {
                for (C17297a b : mo127728a()) {
                    b.mo127729b();
                }
            }
            this.f51758c.start();
            bVar.mo127730a(true);
        }
    }
}
