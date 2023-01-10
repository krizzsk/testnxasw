package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.f */
final class C20154f implements C20156h {

    /* renamed from: a */
    final /* synthetic */ Set f56172a;

    /* renamed from: b */
    final /* synthetic */ C20165q f56173b;

    /* renamed from: c */
    final /* synthetic */ C20159k f56174c;

    C20154f(C20159k kVar, Set set, C20165q qVar) {
        this.f56174c = kVar;
        this.f56172a = set;
        this.f56173b = qVar;
    }

    /* renamed from: a */
    public final void mo164447a(ZipFile zipFile, Set<C20158j> set) throws IOException {
        this.f56172a.addAll(C20159k.m42443a(this.f56174c, (Set) set, this.f56173b, zipFile));
    }
}
