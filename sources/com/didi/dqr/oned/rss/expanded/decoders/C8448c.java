package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.c */
/* compiled from: AI01392xDecoder */
final class C8448c extends C8453h {

    /* renamed from: b */
    private static final int f20701b = 8;

    /* renamed from: c */
    private static final int f20702c = 2;

    C8448c(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() >= 48) {
            StringBuilder sb = new StringBuilder();
            mo63384b(sb, 8);
            int a = getGeneralDecoder().mo63400a(48, 2);
            sb.append("(392");
            sb.append(a);
            sb.append(VersionRange.RIGHT_OPEN);
            sb.append(getGeneralDecoder().mo63401a(50, (String) null).mo63390a());
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
