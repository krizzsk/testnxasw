package com.didi.component.business.job;

import com.didi.sdk.apm.SystemUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class JobMapping {

    /* renamed from: a */
    private Map<String, AbsJob> f13153a = new ConcurrentHashMap();

    JobMapping() {
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final JobMapping _this = new JobMapping();

        private InstanceHolder() {
        }
    }

    /* renamed from: a */
    public static JobMapping m11018a() {
        return InstanceHolder._this;
    }

    /* renamed from: a */
    public void mo51112a(AbsJob absJob) {
        if (absJob != null) {
            this.f13153a.put(absJob.mo51096a(), absJob);
            mo51114c();
        }
    }

    /* renamed from: a */
    public AbsJob mo51111a(String str) {
        if (this.f13153a.isEmpty()) {
            return null;
        }
        AbsJob remove = this.f13153a.remove(str);
        mo51114c();
        return remove;
    }

    /* renamed from: b */
    public void mo51113b() {
        this.f13153a.clear();
    }

    /* renamed from: c */
    public void mo51114c() {
        StringBuilder sb = new StringBuilder("JobMapping: ");
        Iterator<String> it = this.f13153a.keySet().iterator();
        if (!it.hasNext()) {
            sb.append("is Empty");
        }
        while (it.hasNext()) {
            sb.append(it.next() + ", ");
        }
        SystemUtils.log(4, "JobManager", sb.toString(), (Throwable) null, "com.didi.component.business.job.JobMapping", 54);
    }
}
