package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.e */
/* compiled from: AI013x0x1xDecoder */
final class C8450e extends C8454i {

    /* renamed from: b */
    private static final int f20706b = 8;

    /* renamed from: c */
    private static final int f20707c = 20;

    /* renamed from: d */
    private static final int f20708d = 16;

    /* renamed from: e */
    private final String f20709e;

    /* renamed from: f */
    private final String f20710f;

    C8450e(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.f20709e = str2;
        this.f20710f = str;
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 84) {
            StringBuilder sb = new StringBuilder();
            mo63384b(sb, 8);
            mo63385b(sb, 48, 20);
            m17424c(sb, 68);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: c */
    private void m17424c(StringBuilder sb, int i) {
        int a = getGeneralDecoder().mo63400a(i, 16);
        if (a != 38400) {
            sb.append(VersionRange.LEFT_OPEN);
            sb.append(this.f20709e);
            sb.append(VersionRange.RIGHT_OPEN);
            int i2 = a % 32;
            int i3 = a / 32;
            int i4 = (i3 % 12) + 1;
            int i5 = i3 / 12;
            if (i5 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i5);
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo63382a(StringBuilder sb, int i) {
        sb.append(VersionRange.LEFT_OPEN);
        sb.append(this.f20710f);
        sb.append(i / 100000);
        sb.append(VersionRange.RIGHT_OPEN);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo63381a(int i) {
        return i % 100000;
    }
}
