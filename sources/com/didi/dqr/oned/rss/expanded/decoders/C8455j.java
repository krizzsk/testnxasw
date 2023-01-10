package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.j */
/* compiled from: AnyAIDecoder */
final class C8455j extends AbstractExpandedDecoder {

    /* renamed from: a */
    private static final int f20715a = 5;

    C8455j(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        return getGeneralDecoder().mo63402a(new StringBuilder(), 5);
    }
}
