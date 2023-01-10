package com.didi.dqr.oned.rss.expanded;

import com.didi.dqr.common.BitArray;
import java.util.List;

/* renamed from: com.didi.dqr.oned.rss.expanded.a */
/* compiled from: BitArrayBuilder */
final class C8443a {
    private C8443a() {
    }

    /* renamed from: a */
    static BitArray m17399a(List<C8444b> list) {
        int size = (list.size() * 2) - 1;
        if (list.get(list.size() - 1).mo63356c() == null) {
            size--;
        }
        BitArray bitArray = new BitArray(size * 12);
        int i = 0;
        int value = list.get(0).mo63356c().getValue();
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & value) != 0) {
                bitArray.set(i);
            }
            i++;
        }
        for (int i3 = 1; i3 < list.size(); i3++) {
            C8444b bVar = list.get(i3);
            int value2 = bVar.mo63355b().getValue();
            for (int i4 = 11; i4 >= 0; i4--) {
                if (((1 << i4) & value2) != 0) {
                    bitArray.set(i);
                }
                i++;
            }
            if (bVar.mo63356c() != null) {
                int value3 = bVar.mo63356c().getValue();
                for (int i5 = 11; i5 >= 0; i5--) {
                    if (((1 << i5) & value3) != 0) {
                        bitArray.set(i);
                    }
                    i++;
                }
            }
        }
        return bitArray;
    }
}
