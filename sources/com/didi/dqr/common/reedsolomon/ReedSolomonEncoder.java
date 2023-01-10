package com.didi.dqr.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder {

    /* renamed from: a */
    private final GenericGF f20454a;

    /* renamed from: b */
    private final List<C8422a> f20455b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f20454a = genericGF;
        ArrayList arrayList = new ArrayList();
        this.f20455b = arrayList;
        arrayList.add(new C8422a(genericGF, new int[]{1}));
    }

    /* renamed from: a */
    private C8422a m17178a(int i) {
        if (i >= this.f20455b.size()) {
            List<C8422a> list = this.f20455b;
            C8422a aVar = list.get(list.size() - 1);
            for (int size = this.f20455b.size(); size <= i; size++) {
                GenericGF genericGF = this.f20454a;
                aVar = aVar.mo63247b(new C8422a(genericGF, new int[]{1, genericGF.mo63229a((size - 1) + genericGF.getGeneratorBase())}));
                this.f20455b.add(aVar);
            }
        }
        return this.f20455b.get(i);
    }

    public void encode(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                C8422a a = m17178a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] a2 = new C8422a(this.f20454a, iArr2).mo63242a(i, 1).mo63250c(a)[1].mo63244a();
                int length2 = i - a2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(a2, 0, iArr, length + length2, a2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
