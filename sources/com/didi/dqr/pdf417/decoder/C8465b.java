package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dqr.pdf417.decoder.b */
/* compiled from: BarcodeValue */
final class C8465b {

    /* renamed from: a */
    private final Map<Integer, Integer> f20791a = new HashMap();

    C8465b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63432a(int i) {
        Integer num = this.f20791a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f20791a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo63433a() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry next : this.f20791a.entrySet()) {
            if (((Integer) next.getValue()).intValue() > i) {
                i = ((Integer) next.getValue()).intValue();
                arrayList.clear();
                arrayList.add(next.getKey());
            } else if (((Integer) next.getValue()).intValue() == i) {
                arrayList.add(next.getKey());
            }
        }
        return PDF417Common.toIntArray(arrayList);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Integer mo63434b(int i) {
        return this.f20791a.get(Integer.valueOf(i));
    }
}
