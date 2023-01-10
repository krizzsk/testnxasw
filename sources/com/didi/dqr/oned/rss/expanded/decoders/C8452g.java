package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.g */
/* compiled from: AI01AndOtherAIs */
final class C8452g extends C8453h {

    /* renamed from: b */
    private static final int f20713b = 4;

    C8452g(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(getGeneralDecoder().mo63400a(4, 4));
        mo63383a(sb, 8, length);
        return getGeneralDecoder().mo63402a(sb, 48);
    }
}
