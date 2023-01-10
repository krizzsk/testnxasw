package com.didiglobal.enginecore.register;

import android.text.TextUtils;
import android.util.Pair;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EngineTemplateStore {

    /* renamed from: e */
    private static volatile EngineTemplateStore f52703e;

    /* renamed from: a */
    private final List<Pair<String, Integer>> f52704a = new ArrayList();

    /* renamed from: b */
    private final List<XETemplateComponent> f52705b = new LinkedList();

    /* renamed from: c */
    private final Map<String, List<String>> f52706c = new ConcurrentHashMap();

    /* renamed from: d */
    private final Map<String, List<String>> f52707d = new ConcurrentHashMap();

    public static EngineTemplateStore getInstance() {
        if (f52703e == null) {
            synchronized (EngineTemplateStore.class) {
                if (f52703e == null) {
                    f52703e = new EngineTemplateStore();
                }
            }
        }
        return f52703e;
    }

    private EngineTemplateStore() {
        m39572a((Pair<String, Integer>) new Pair(XENetConstant.XE_KEY_ENGINE_COMMIT, 100));
    }

    public void updateRequiredMapScene(String str, String... strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            List list = this.f52707d.get(str);
            List list2 = this.f52706c.get(str);
            if (list != null) {
                for (String str2 : strArr) {
                    if (!list.contains(str2)) {
                        list.add(str2);
                    }
                    if (list2 != null && !list2.contains(str2)) {
                        list2.add(str2);
                    }
                }
            }
        }
    }

    public void put(String str, List<XETemplateComponent> list, List<String> list2, int i, boolean z) {
        m39574a(list);
        m39572a((Pair<String, Integer>) new Pair(str, Integer.valueOf(i)));
        this.f52707d.put(str, list2);
        if (z) {
            this.f52706c.put(str, list2);
        }
    }

    public void remove(String str) {
        m39573a(str);
        this.f52706c.remove(str);
        this.f52707d.remove(str);
    }

    public void clear() {
        this.f52704a.clear();
        this.f52707d.clear();
        this.f52706c.clear();
        this.f52705b.clear();
    }

    /* renamed from: a */
    private synchronized void m39573a(String str) {
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f52704a.size()) {
                break;
            } else if (((String) this.f52704a.get(i2).first).equals(str)) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i > 0) {
            this.f52704a.remove(i);
        }
    }

    public synchronized List<String> getSortedList() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Pair<String, Integer> pair : this.f52704a) {
            arrayList.add(pair.first);
        }
        return arrayList;
    }

    public synchronized boolean setPriority(String str, int i) {
        if (!m39575b(str)) {
            return false;
        }
        m39573a(str);
        m39572a((Pair<String, Integer>) new Pair(str, Integer.valueOf(i)));
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m39572a(android.util.Pair<java.lang.String, java.lang.Integer> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.Object r0 = r5.first     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0044 }
            boolean r0 = r4.m39575b(r0)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r4)
            return
        L_0x000d:
            r0 = -1
            r1 = 1
        L_0x000f:
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r2 = r4.f52704a     // Catch:{ all -> 0x0044 }
            int r2 = r2.size()     // Catch:{ all -> 0x0044 }
            if (r1 >= r2) goto L_0x0035
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r2 = r4.f52704a     // Catch:{ all -> 0x0044 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0044 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0044 }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x0044 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0044 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0044 }
            java.lang.Object r3 = r5.second     // Catch:{ all -> 0x0044 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0044 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0044 }
            if (r2 <= r3) goto L_0x0032
            r0 = r1
        L_0x0032:
            int r1 = r1 + 1
            goto L_0x000f
        L_0x0035:
            if (r0 < 0) goto L_0x003d
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r1 = r4.f52704a     // Catch:{ all -> 0x0044 }
            r1.add(r0, r5)     // Catch:{ all -> 0x0044 }
            goto L_0x0042
        L_0x003d:
            java.util.List<android.util.Pair<java.lang.String, java.lang.Integer>> r0 = r4.f52704a     // Catch:{ all -> 0x0044 }
            r0.add(r5)     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.register.EngineTemplateStore.m39572a(android.util.Pair):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m39574a(java.util.List<com.didiglobal.enginecore.template.temp.XETemplateComponent> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002d
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000a
            goto L_0x002d
        L_0x000a:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x002a }
        L_0x000e:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x002a }
            com.didiglobal.enginecore.template.temp.XETemplateComponent r0 = (com.didiglobal.enginecore.template.temp.XETemplateComponent) r0     // Catch:{ all -> 0x002a }
            java.util.List<com.didiglobal.enginecore.template.temp.XETemplateComponent> r1 = r2.f52705b     // Catch:{ all -> 0x002a }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x002a }
            if (r1 != 0) goto L_0x000e
            java.util.List<com.didiglobal.enginecore.template.temp.XETemplateComponent> r1 = r2.f52705b     // Catch:{ all -> 0x002a }
            r1.add(r0)     // Catch:{ all -> 0x002a }
            goto L_0x000e
        L_0x0028:
            monitor-exit(r2)
            return
        L_0x002a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002d:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.register.EngineTemplateStore.m39574a(java.util.List):void");
    }

    public synchronized XETemplateComponent getComponent(String str) {
        for (XETemplateComponent next : this.f52705b) {
            if (next.getTemplateId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public synchronized List<XETemplateComponent> getTemplateList() {
        return this.f52705b;
    }

    public synchronized Set<String> getRequestkeysMap(String str) {
        HashSet hashSet;
        List list;
        hashSet = new HashSet();
        for (String next : this.f52707d.keySet()) {
            if (!XENetConstant.XE_KEY_ENGINE_COMMIT.equals(next) && (list = this.f52707d.get(next)) != null && list.contains(str)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    public synchronized Set<String> getRequiredMap(String str) {
        HashSet hashSet;
        hashSet = new HashSet();
        for (String next : this.f52706c.keySet()) {
            List list = this.f52706c.get(next);
            if (list != null && list.contains(str)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    private boolean m39575b(String str) {
        for (int i = 1; i < this.f52704a.size(); i++) {
            if (((String) this.f52704a.get(i).first).equals(str)) {
                return true;
            }
        }
        return false;
    }
}
