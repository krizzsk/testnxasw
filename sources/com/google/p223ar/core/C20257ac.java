package com.google.p223ar.core;

import com.google.p223ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.ar.core.ac */
/* compiled from: Session */
class C20257ac implements ArCoreApk.C20243a {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f56439a;

    C20257ac(AtomicReference atomicReference) {
        this.f56439a = atomicReference;
    }

    /* renamed from: a */
    public void mo164600a(ArCoreApk.Availability availability) {
        this.f56439a.set(availability);
    }
}
