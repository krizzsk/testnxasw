package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.i */
/* compiled from: AI01weightDecoder */
abstract class C8454i extends C8453h {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo63381a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo63382a(StringBuilder sb, int i);

    C8454i(BitArray bitArray) {
        super(bitArray);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo63385b(StringBuilder sb, int i, int i2) {
        int a = getGeneralDecoder().mo63400a(i, i2);
        mo63382a(sb, a);
        int a2 = mo63381a(a);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (a2 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(a2);
    }
}
