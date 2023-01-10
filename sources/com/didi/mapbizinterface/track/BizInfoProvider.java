package com.didi.mapbizinterface.track;

import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BizInfoProvider {
    public static final int INFO_TYPE_APPPAGE = 4097;
    public static final int INFO_TYPE_VDR_LOCATION = 4098;

    /* renamed from: c */
    private static final int f31530c = 3600;

    /* renamed from: a */
    private SparseArray<Object> f31531a;

    /* renamed from: b */
    private SparseArray<Queue<Object>> f31532b;

    private BizInfoProvider() {
        this.f31531a = new SparseArray<>();
        SparseArray<Queue<Object>> sparseArray = new SparseArray<>();
        this.f31532b = sparseArray;
        sparseArray.put(4098, new ArrayDeque());
    }

    private static class SingletonHolder {
        static BizInfoProvider INSTANCE = new BizInfoProvider();

        private SingletonHolder() {
        }
    }

    /* renamed from: a */
    static BizInfoProvider m24094a() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo85925a(int i, Object obj) {
        if (i == 4097) {
            this.f31531a.put(i, obj);
        } else if (i == 4098) {
            Queue queue = this.f31532b.get(i);
            if (queue.size() >= 3600) {
                queue.poll();
            }
            queue.offer(obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Object mo85923a(int i) {
        return this.f31531a.get(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized int mo85926b(int i) {
        return this.f31532b.get(i).size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized <T> List<T> mo85924a(int i, Class<T> cls, int i2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Queue queue = this.f31532b.get(i);
        int i3 = 0;
        while (!queue.isEmpty() && i3 < i2) {
            try {
                arrayList.add(queue.poll());
            } catch (Exception unused) {
            }
            i3++;
        }
        return arrayList;
    }
}
