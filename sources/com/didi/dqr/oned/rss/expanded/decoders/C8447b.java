package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.b */
/* compiled from: AI01320xDecoder */
final class C8447b extends C8451f {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo63381a(int i) {
        return i < 10000 ? i : i - 10000;
    }

    C8447b(BitArray bitArray) {
        super(bitArray);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo63382a(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
