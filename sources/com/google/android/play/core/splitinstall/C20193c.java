package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.C20090cm;
import com.google.android.play.core.internal.C20092co;
import com.google.android.play.core.splitinstall.testing.C20222k;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.c */
public final class C20193c implements C20203m {

    /* renamed from: a */
    private C20092co<Context> f56245a;

    /* renamed from: b */
    private C20092co<C20188av> f56246b;

    /* renamed from: c */
    private C20092co<C20211t> f56247c;

    /* renamed from: d */
    private C20092co<C20207p> f56248d = C20090cm.m42285a(C20208q.m42548a(this.f56245a));

    /* renamed from: e */
    private C20092co<C20190ax> f56249e;

    /* renamed from: f */
    private C20092co<C20225w> f56250f;

    /* renamed from: g */
    private C20092co<File> f56251g;

    /* renamed from: h */
    private C20092co<FakeSplitInstallManager> f56252h;

    /* renamed from: i */
    private C20092co<C20199i> f56253i;

    /* renamed from: j */
    private C20092co<SplitInstallManager> f56254j;

    /* synthetic */ C20193c(C20227y yVar) {
        C20228z zVar = new C20228z(yVar);
        this.f56245a = zVar;
        this.f56246b = C20090cm.m42285a(new C20189aw(zVar));
        this.f56247c = C20090cm.m42285a(new C20168ab(yVar));
        C20092co<C20190ax> a = C20090cm.m42285a(new C20191ay(this.f56245a));
        this.f56249e = a;
        this.f56250f = C20090cm.m42285a(new C20226x(this.f56246b, this.f56247c, this.f56248d, a));
        C20092co<File> a2 = C20090cm.m42285a(new C20167aa(this.f56245a));
        this.f56251g = a2;
        C20092co<FakeSplitInstallManager> a3 = C20090cm.m42285a(new C20222k(this.f56245a, a2, this.f56248d));
        this.f56252h = a3;
        C20092co<C20199i> a4 = C20090cm.m42285a(new C20200j(this.f56250f, a3, this.f56251g));
        this.f56253i = a4;
        this.f56254j = C20090cm.m42285a(new C20169ac(yVar, a4));
    }

    /* renamed from: a */
    public final SplitInstallManager mo164506a() {
        return this.f56254j.mo163987a();
    }

    /* renamed from: b */
    public final File mo164507b() {
        return this.f56251g.mo163987a();
    }
}
