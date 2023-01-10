package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.f */
/* compiled from: AI013x0xDecoder */
abstract class C8451f extends C8454i {

    /* renamed from: b */
    private static final int f20711b = 5;

    /* renamed from: c */
    private static final int f20712c = 15;

    C8451f(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 60) {
            StringBuilder sb = new StringBuilder();
            mo63384b(sb, 5);
            mo63385b(sb, 45, 15);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
