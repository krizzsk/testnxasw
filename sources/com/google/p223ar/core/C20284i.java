package com.google.p223ar.core;

import java.util.Map;

/* renamed from: com.google.ar.core.i */
/* compiled from: FaceCache */
final class C20284i {

    /* renamed from: a */
    private final Map<Long, AugmentedFace> f56478a = new C20285j(1, 0.75f, true);

    C20284i() {
    }

    /* renamed from: a */
    public final synchronized AugmentedFace mo164851a(long j, Session session) {
        AugmentedFace augmentedFace;
        augmentedFace = this.f56478a.get(Long.valueOf(j));
        if (augmentedFace == null) {
            augmentedFace = new AugmentedFace(j, session);
            this.f56478a.put(Long.valueOf(j), augmentedFace);
        }
        return augmentedFace;
    }
}
