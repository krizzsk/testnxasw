package com.google.android.play.core.internal;

import android.content.Intent;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitinstall.C20194d;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.as */
final class C20042as implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f56084a;

    /* renamed from: b */
    final /* synthetic */ C20194d f56085b;

    /* renamed from: c */
    final /* synthetic */ C20043at f56086c;

    C20042as(C20043at atVar, List list, C20194d dVar) {
        this.f56086c = atVar;
        this.f56084a = list;
        this.f56085b = dVar;
    }

    public final void run() {
        try {
            if (this.f56086c.f56089c.mo164285a((List<Intent>) this.f56084a)) {
                C20043at.m42162a(this.f56086c, this.f56085b);
            } else {
                C20043at.m42163a(this.f56086c, this.f56084a, this.f56085b);
            }
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Error checking verified files.", e, "com.google.android.play.core.internal.as", -1);
            this.f56085b.mo164509a(-11);
        }
    }
}
