package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.internal.C20092co;
import com.google.android.play.core.splitinstall.C20207p;
import com.google.android.play.core.splitinstall.C20228z;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.testing.k */
public final class C20222k implements C20092co<FakeSplitInstallManager> {

    /* renamed from: a */
    private final C20092co<Context> f56331a;

    /* renamed from: b */
    private final C20092co<File> f56332b;

    /* renamed from: c */
    private final C20092co<C20207p> f56333c;

    public C20222k(C20092co<Context> coVar, C20092co<File> coVar2, C20092co<C20207p> coVar3) {
        this.f56331a = coVar;
        this.f56332b = coVar2;
        this.f56333c = coVar3;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        return new FakeSplitInstallManager(((C20228z) this.f56331a).mo163987a(), this.f56332b.mo163987a(), this.f56333c.mo163987a());
    }
}
