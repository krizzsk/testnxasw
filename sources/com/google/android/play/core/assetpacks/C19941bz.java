package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bz */
final class C19941bz {

    /* renamed from: a */
    private final Map<String, Double> f55838a = new HashMap();

    C19941bz() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized double mo164156a(String str, C19960cr crVar) {
        double d;
        d = (((double) ((C19934bs) crVar).f55797e) + 1.0d) / ((double) ((C19934bs) crVar).f55798f);
        this.f55838a.put(str, Double.valueOf(d));
        return d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo164157a(String str) {
        this.f55838a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized double mo164158b(String str) {
        Double d = this.f55838a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }
}
