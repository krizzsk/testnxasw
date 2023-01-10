package com.iproov.sdk.core;

import com.iproov.sdk.cameray.C20759const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p235do.C21820break;
import p235do.C21829try;

/* renamed from: com.iproov.sdk.core.else */
/* compiled from: IProovCameraPreviewSizeSelector */
public class C20869else implements C21829try {
    /* renamed from: b */
    private static int m43284b(C21820break breakR) {
        return breakR.mo180435if() * breakR.mo180432do();
    }

    /* renamed from: do */
    public C21820break mo171472do(C20759const constR, List<C21820break> list) {
        return m43282a(m43283a(list, 640, 480, 0.7d)).get(0);
    }

    /* renamed from: a */
    private static List<C21820break> m43282a(List<C21820break> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, $$Lambda$else$VUKPLJQ5bqnPBqLltDQhsfJtGYM.INSTANCE);
        return arrayList;
    }

    /* renamed from: a */
    private static double m43280a(C21820break breakR) {
        return ((double) breakR.mo180432do()) / ((double) breakR.mo180435if());
    }

    /* renamed from: a */
    private static List<C21820break> m43283a(List<C21820break> list, int i, int i2, double d) {
        ArrayList arrayList = new ArrayList();
        for (C21820break next : list) {
            if (next.mo180435if() >= i && next.mo180432do() >= i2 && m43280a(next) >= d) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
