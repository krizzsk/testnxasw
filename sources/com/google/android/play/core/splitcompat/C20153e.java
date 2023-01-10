package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.e */
final class C20153e implements C20156h {

    /* renamed from: a */
    final /* synthetic */ C20165q f56168a;

    /* renamed from: b */
    final /* synthetic */ Set f56169b;

    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f56170c;

    /* renamed from: d */
    final /* synthetic */ C20159k f56171d;

    C20153e(C20159k kVar, C20165q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.f56171d = kVar;
        this.f56168a = qVar;
        this.f56169b = set;
        this.f56170c = atomicBoolean;
    }

    /* renamed from: a */
    public final void mo164447a(ZipFile zipFile, Set<C20158j> set) throws IOException {
        this.f56171d.m42446a(this.f56168a, set, new C20152d(this));
    }
}
