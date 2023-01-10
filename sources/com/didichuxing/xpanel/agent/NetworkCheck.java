package com.didichuxing.xpanel.agent;

import java.util.HashMap;

public class NetworkCheck {
    public static final int BUFFER_LENGTH = 10;
    public static final long DURATION_TIME = 10500;
    public static final String PARAM_CITY_MIS_ID = "city_id";
    public static NetworkCheck instance;

    /* renamed from: a */
    boolean f51842a = false;

    /* renamed from: b */
    LimitUpdateList<ParamsEntry> f51843b = new LimitUpdateList<ParamsEntry>(10) {
        /* access modifiers changed from: protected */
        public boolean equals(ParamsEntry paramsEntry, ParamsEntry paramsEntry2) {
            return paramsEntry.params.equals(paramsEntry2.params);
        }
    };

    private NetworkCheck() {
    }

    public static NetworkCheck getInstance() {
        if (instance == null) {
            synchronized (NetworkCheck.class) {
                if (instance == null) {
                    instance = new NetworkCheck();
                }
            }
        }
        return instance;
    }

    public void setReadyLoad(boolean z) {
        this.f51842a = z;
    }

    class ParamsEntry {
        HashMap<String, Object> params;
        long time;

        public ParamsEntry(HashMap<String, Object> hashMap, long j) {
            this.params = hashMap;
            this.time = j;
        }
    }

    public boolean checkParamsAndFrequencyControl(HashMap<String, Object> hashMap) {
        if (this.f51842a) {
            m38978c(hashMap);
            return true;
        } else if (mo127907a(hashMap)) {
            m38978c(hashMap);
            return true;
        } else {
            if (System.currentTimeMillis() - m38977b(hashMap).time < DURATION_TIME) {
                return false;
            }
            m38978c(hashMap);
            return true;
        }
    }

    /* renamed from: b */
    private ParamsEntry m38977b(HashMap<String, Object> hashMap) {
        return this.f51843b.getParams(new ParamsEntry(hashMap, 0));
    }

    /* renamed from: c */
    private void m38978c(HashMap<String, Object> hashMap) {
        this.f51843b.putParams(new ParamsEntry(hashMap, System.currentTimeMillis()));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo127907a(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            com.didichuxing.xpanel.agent.NetworkCheck$ParamsEntry r0 = r4.m38977b(r5)
            if (r0 != 0) goto L_0x0008
            r0 = 0
            goto L_0x000a
        L_0x0008:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r0.params
        L_0x000a:
            r1 = 1
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0016:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r3 = r0.containsKey(r3)
            if (r3 != 0) goto L_0x002d
            return r1
        L_0x002d:
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r3 = r0.get(r3)
            java.lang.Object r2 = r2.getValue()
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0016
            return r1
        L_0x0040:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.agent.NetworkCheck.mo127907a(java.util.HashMap):boolean");
    }
}
