package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.j */
public final class C20200j implements C20092co<C20199i> {

    /* renamed from: a */
    private final C20092co<C20225w> f56260a;

    /* renamed from: b */
    private final C20092co<FakeSplitInstallManager> f56261b;

    /* renamed from: c */
    private final C20092co<File> f56262c;

    public C20200j(C20092co<C20225w> coVar, C20092co<FakeSplitInstallManager> coVar2, C20092co<File> coVar3) {
        this.f56260a = coVar;
        this.f56261b = coVar2;
        this.f56262c = coVar3;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo163987a() {
        return new C20199i(C20090cm.m42286b(this.f56260a), C20090cm.m42286b(this.f56261b), C20090cm.m42286b(this.f56262c));
    }
}
