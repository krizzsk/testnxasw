package com.didi.component.core;

import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.didi.component.core.a */
/* compiled from: IndexAllocator */
class C5908a<K> {

    /* renamed from: a */
    private WeakHashMap<K, Integer> f14594a = new WeakHashMap<>();

    C5908a() {
    }

    /* renamed from: a */
    public synchronized int mo53061a(K k, int i, int i2) {
        if (k == null) {
            return -1;
        }
        if (this.f14594a.containsKey(k)) {
            Integer num = this.f14594a.get(k);
            if (num != null) {
                return num.intValue();
            }
            this.f14594a.remove(k);
        }
        while (i < i2) {
            if (this.f14594a.containsValue(Integer.valueOf(i))) {
                i++;
            } else {
                this.f14594a.put(k, Integer.valueOf(i));
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public synchronized K mo53062a(int i) {
        if (!this.f14594a.containsValue(Integer.valueOf(i))) {
            return null;
        }
        for (Map.Entry next : this.f14594a.entrySet()) {
            Integer num = (Integer) next.getValue();
            if (num != null) {
                if (num.intValue() == i) {
                    return next.getKey();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void mo53063a(K k) {
        if (k != null) {
            this.f14594a.remove(k);
        }
    }
}
