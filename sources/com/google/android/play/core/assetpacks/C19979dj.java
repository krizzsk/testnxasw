package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20088ck;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.dj */
final class C19979dj {

    /* renamed from: a */
    private final C19917bb f55947a;

    /* renamed from: b */
    private final C20088ck<C20013w> f55948b;

    /* renamed from: c */
    private final C19958cp f55949c;

    /* renamed from: d */
    private final C20088ck<Executor> f55950d;

    /* renamed from: e */
    private final C19941bz f55951e;

    C19979dj(C19917bb bbVar, C20088ck<C20013w> ckVar, C19958cp cpVar, C20088ck<Executor> ckVar2, C19941bz bzVar) {
        this.f55947a = bbVar;
        this.f55948b = ckVar;
        this.f55949c = cpVar;
        this.f55950d = ckVar2;
        this.f55951e = bzVar;
    }

    /* renamed from: a */
    public final void mo164198a(C19977dh dhVar) {
        File c = this.f55947a.mo164105c(dhVar.f55886k, dhVar.f55944a, dhVar.f55945b);
        File e = this.f55947a.mo164114e(dhVar.f55886k, dhVar.f55944a, dhVar.f55945b);
        if (!c.exists() || !e.exists()) {
            throw new C19937bv(String.format("Cannot find pack files to move for pack %s.", new Object[]{dhVar.f55886k}), dhVar.f55885j);
        }
        File a = this.f55947a.mo164095a(dhVar.f55886k, dhVar.f55944a, dhVar.f55945b);
        a.mkdirs();
        if (c.renameTo(a)) {
            new File(this.f55947a.mo164095a(dhVar.f55886k, dhVar.f55944a, dhVar.f55945b), "merge.tmp").delete();
            File b = this.f55947a.mo164102b(dhVar.f55886k, dhVar.f55944a, dhVar.f55945b);
            b.mkdirs();
            if (e.renameTo(b)) {
                C19917bb bbVar = this.f55947a;
                bbVar.getClass();
                this.f55950d.mo164325a().execute(C19978di.m42029a(bbVar));
                this.f55949c.mo164164a(dhVar.f55886k, dhVar.f55944a, dhVar.f55945b);
                this.f55951e.mo164157a(dhVar.f55886k);
                this.f55948b.mo164325a().mo164079a(dhVar.f55885j, dhVar.f55886k);
                return;
            }
            throw new C19937bv("Cannot move metadata files to final location.", dhVar.f55885j);
        }
        throw new C19937bv("Cannot move merged pack files to final location.", dhVar.f55885j);
    }
}
