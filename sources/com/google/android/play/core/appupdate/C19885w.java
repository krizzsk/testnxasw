package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.splitcompat.C20164p;

/* renamed from: com.google.android.play.core.appupdate.w */
public final /* synthetic */ class C19885w {

    /* renamed from: a */
    private static C19887y f55619a;

    /* renamed from: a */
    static synchronized C19887y m41791a(Context context) {
        C19887y yVar;
        synchronized (C19885w.class) {
            if (f55619a == null) {
                C19886x xVar = new C19886x((byte[]) null);
                xVar.mo164025a(new C19869g(C20164p.m42450a(context)));
                f55619a = xVar.mo164024a();
            }
            yVar = f55619a;
        }
        return yVar;
    }
}
