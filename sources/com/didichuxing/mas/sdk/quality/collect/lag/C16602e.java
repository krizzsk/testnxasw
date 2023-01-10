package com.didichuxing.mas.sdk.quality.collect.lag;

import com.didichuxing.mas.sdk.quality.collect.lag.internal.BlockInfo;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.e */
/* compiled from: StackSampler */
class C16602e extends C16598a {

    /* renamed from: c */
    private static final int f50704c = 100;

    /* renamed from: d */
    private static final LinkedHashMap<Long, String> f50705d = new LinkedHashMap<>();

    /* renamed from: e */
    private int f50706e;

    /* renamed from: f */
    private Thread f50707f;

    public C16602e(Thread thread, long j) {
        this(thread, 100, j);
    }

    public C16602e(Thread thread, int i, long j) {
        super(j);
        this.f50706e = 100;
        this.f50707f = thread;
        this.f50706e = i;
    }

    /* renamed from: a */
    public ArrayList<String> mo124927a(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f50705d) {
            for (Long next : f50705d.keySet()) {
                if (j < next.longValue() && next.longValue() < j2) {
                    arrayList.add(BlockInfo.TIME_FORMATTER.format(next) + "\r\n" + "\r\n" + f50705d.get(next));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo124923c() {
        StringBuilder sb = new StringBuilder(2048);
        try {
            for (StackTraceElement stackTraceElement : this.f50707f.getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\r\n");
            }
            synchronized (f50705d) {
                if (f50705d.size() == this.f50706e && this.f50706e > 0) {
                    f50705d.remove(f50705d.keySet().iterator().next());
                }
                f50705d.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
            }
        } catch (Exception e) {
            OLog.m37861e(e.getMessage());
        }
    }
}
