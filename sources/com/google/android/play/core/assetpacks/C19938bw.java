package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20088ck;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.bw */
final class C19938bw {

    /* renamed from: a */
    private static final C20030ag f55813a = new C20030ag("ExtractorLooper");

    /* renamed from: b */
    private final C19958cp f55814b;

    /* renamed from: c */
    private final C19935bt f55815c;

    /* renamed from: d */
    private final C19991dv f55816d;

    /* renamed from: e */
    private final C19975df f55817e;

    /* renamed from: f */
    private final C19979dj f55818f;

    /* renamed from: g */
    private final C19984do f55819g;

    /* renamed from: h */
    private final C20088ck<C20013w> f55820h;

    /* renamed from: i */
    private final C19961cs f55821i;

    /* renamed from: j */
    private final AtomicBoolean f55822j = new AtomicBoolean(false);

    C19938bw(C19958cp cpVar, C20088ck<C20013w> ckVar, C19935bt btVar, C19991dv dvVar, C19975df dfVar, C19979dj djVar, C19984do doVar, C19961cs csVar) {
        this.f55814b = cpVar;
        this.f55820h = ckVar;
        this.f55815c = btVar;
        this.f55816d = dvVar;
        this.f55817e = dfVar;
        this.f55818f = djVar;
        this.f55819g = doVar;
        this.f55821i = csVar;
    }

    /* renamed from: a */
    private final void m41945a(int i, Exception exc) {
        try {
            this.f55814b.mo164176d(i);
            this.f55814b.mo164163a(i);
        } catch (C19937bv unused) {
            f55813a.mo164269b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164152a() {
        f55813a.mo164267a("Run extractor loop", new Object[0]);
        if (this.f55822j.compareAndSet(false, true)) {
            while (true) {
                C19960cr crVar = null;
                try {
                    crVar = this.f55821i.mo164177a();
                } catch (C19937bv e) {
                    f55813a.mo164269b("Error while getting next extraction task: %s", e.getMessage());
                    if (e.f55812a >= 0) {
                        this.f55820h.mo164325a().mo164078a(e.f55812a);
                        m41945a(e.f55812a, e);
                    }
                }
                if (crVar != null) {
                    try {
                        if (crVar instanceof C19934bs) {
                            this.f55815c.mo164151a((C19934bs) crVar);
                        } else if (crVar instanceof C19990du) {
                            this.f55816d.mo164223a((C19990du) crVar);
                        } else if (crVar instanceof C19974de) {
                            this.f55817e.mo164196a((C19974de) crVar);
                        } else if (crVar instanceof C19977dh) {
                            this.f55818f.mo164198a((C19977dh) crVar);
                        } else if (crVar instanceof C19983dn) {
                            this.f55819g.mo164200a((C19983dn) crVar);
                        } else {
                            f55813a.mo164269b("Unknown task type: %s", crVar.getClass().getName());
                        }
                    } catch (Exception e2) {
                        f55813a.mo164269b("Error during extraction task: %s", e2.getMessage());
                        this.f55820h.mo164325a().mo164078a(crVar.f55885j);
                        m41945a(crVar.f55885j, e2);
                    }
                } else {
                    this.f55822j.set(false);
                    return;
                }
            }
        } else {
            f55813a.mo164271d("runLoop already looping; return", new Object[0]);
        }
    }
}
