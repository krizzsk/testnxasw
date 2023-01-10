package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.da */
public final class C19970da implements C20092co<C19968cz> {

    /* renamed from: a */
    private final C20092co<String> f55920a;

    /* renamed from: b */
    private final C20092co<C19911aw> f55921b;

    /* renamed from: c */
    private final C20092co<C19941bz> f55922c;

    /* renamed from: d */
    private final C20092co<Context> f55923d;

    /* renamed from: e */
    private final C20092co<C19981dl> f55924e;

    /* renamed from: f */
    private final C20092co<Executor> f55925f;

    public C19970da(C20092co<String> coVar, C20092co<C19911aw> coVar2, C20092co<C19941bz> coVar3, C20092co<Context> coVar4, C20092co<C19981dl> coVar5, C20092co<Executor> coVar6) {
        this.f55920a = coVar;
        this.f55921b = coVar2;
        this.f55922c = coVar3;
        this.f55923d = coVar4;
        this.f55924e = coVar5;
        this.f55925f = coVar6;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        String a = this.f55920a.mo163987a();
        C19911aw a2 = this.f55921b.mo163987a();
        C19941bz a3 = this.f55922c.mo163987a();
        Context b = ((C20009s) this.f55923d).mo163987a();
        C19981dl a4 = this.f55924e.mo163987a();
        return new C19968cz(a != null ? new File(b.getExternalFilesDir((String) null), a) : b.getExternalFilesDir((String) null), a2, a3, b, a4, C20090cm.m42286b(this.f55925f));
    }
}
