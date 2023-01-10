package com.didi.dqr.oned;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.ReaderException;
import com.didi.dqr.Result;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.d */
/* compiled from: UPCEANExtensionSupport */
final class C8441d {

    /* renamed from: a */
    private static final int[] f20644a = {1, 1, 2};

    /* renamed from: b */
    private final C8439b f20645b = new C8439b();

    /* renamed from: c */
    private final C8440c f20646c = new C8440c();

    C8441d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Result mo63330a(int i, BitArray bitArray, int i2) throws NotFoundException {
        int[] a = UPCEANReader.m17350a(bitArray, i2, false, f20644a);
        try {
            return this.f20646c.mo63329a(i, bitArray, a);
        } catch (ReaderException unused) {
            return this.f20645b.mo63328a(i, bitArray, a);
        }
    }
}
