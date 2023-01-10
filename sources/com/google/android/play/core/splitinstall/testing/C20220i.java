package com.google.android.play.core.splitinstall.testing;

import android.content.Intent;
import com.google.android.play.core.splitinstall.C20194d;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.i */
final class C20220i implements C20194d {

    /* renamed from: a */
    final /* synthetic */ List f56325a;

    /* renamed from: b */
    final /* synthetic */ List f56326b;

    /* renamed from: c */
    final /* synthetic */ long f56327c;

    /* renamed from: d */
    final /* synthetic */ boolean f56328d;

    /* renamed from: e */
    final /* synthetic */ List f56329e;

    /* renamed from: f */
    final /* synthetic */ FakeSplitInstallManager f56330f;

    C20220i(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f56330f = fakeSplitInstallManager;
        this.f56325a = list;
        this.f56326b = list2;
        this.f56327c = j;
        this.f56328d = z;
        this.f56329e = list3;
    }

    /* renamed from: a */
    public final void mo164508a() {
        this.f56330f.f56295l.addAll(this.f56325a);
        this.f56330f.f56296m.addAll(this.f56326b);
        this.f56330f.m42567a(5, 0, Long.valueOf(this.f56327c), Long.valueOf(this.f56327c), (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* renamed from: a */
    public final void mo164509a(int i) {
        this.f56330f.m42566a(i);
    }

    /* renamed from: b */
    public final void mo164510b() {
        if (!this.f56328d) {
            this.f56330f.m42565a((List<Intent>) this.f56329e, (List<String>) this.f56325a, (List<String>) this.f56326b, this.f56327c, true);
        }
    }
}
