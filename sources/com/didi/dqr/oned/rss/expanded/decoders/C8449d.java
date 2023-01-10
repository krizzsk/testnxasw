package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.d */
/* compiled from: AI01393xDecoder */
final class C8449d extends C8453h {

    /* renamed from: b */
    private static final int f20703b = 8;

    /* renamed from: c */
    private static final int f20704c = 2;

    /* renamed from: d */
    private static final int f20705d = 10;

    C8449d(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() >= 48) {
            StringBuilder sb = new StringBuilder();
            mo63384b(sb, 8);
            int a = getGeneralDecoder().mo63400a(48, 2);
            sb.append("(393");
            sb.append(a);
            sb.append(VersionRange.RIGHT_OPEN);
            int a2 = getGeneralDecoder().mo63400a(50, 10);
            if (a2 / 100 == 0) {
                sb.append('0');
            }
            if (a2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(a2);
            sb.append(getGeneralDecoder().mo63401a(60, (String) null).mo63390a());
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
