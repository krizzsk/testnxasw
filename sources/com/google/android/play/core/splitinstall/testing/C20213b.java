package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.b */
final /* synthetic */ class C20213b implements C20221j {

    /* renamed from: a */
    private final Integer f56301a;

    /* renamed from: b */
    private final int f56302b;

    /* renamed from: c */
    private final int f56303c;

    /* renamed from: d */
    private final Long f56304d;

    /* renamed from: e */
    private final Long f56305e;

    /* renamed from: f */
    private final List f56306f;

    /* renamed from: g */
    private final List f56307g;

    C20213b(Integer num, int i, int i2, Long l, Long l2, List list, List list2) {
        this.f56301a = num;
        this.f56302b = i;
        this.f56303c = i2;
        this.f56304d = l;
        this.f56305e = l2;
        this.f56306f = list;
        this.f56307g = list2;
    }

    /* renamed from: a */
    public final SplitInstallSessionState mo164526a(SplitInstallSessionState splitInstallSessionState) {
        return FakeSplitInstallManager.m42559a(this.f56301a, this.f56302b, this.f56303c, this.f56304d, this.f56305e, this.f56306f, this.f56307g, splitInstallSessionState);
    }
}
