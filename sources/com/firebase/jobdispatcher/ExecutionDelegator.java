package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.firebase.jobdispatcher.IJobCallback;
import com.firebase.jobdispatcher.JobInvocation;

class ExecutionDelegator {

    /* renamed from: a */
    static final String f54618a = "FJD.ExternalReceiver";

    /* renamed from: b */
    private static final SimpleArrayMap<String, C18608h> f54619b = new SimpleArrayMap<>();

    /* renamed from: c */
    private final IJobCallback f54620c = new IJobCallback.Stub() {
        public void jobFinished(Bundle bundle, int i) {
            JobInvocation.Builder b = GooglePlayReceiver.m40625c().mo137553b(bundle);
            if (b == null) {
                Log.wtf(ExecutionDelegator.f54618a, "jobFinished: unknown invocation provided");
            } else {
                ExecutionDelegator.this.m40615a(b.build(), i);
            }
        }
    };

    /* renamed from: d */
    private final Context f54621d;

    /* renamed from: e */
    private final JobFinishedCallback f54622e;

    interface JobFinishedCallback {
        void onJobFinished(JobInvocation jobInvocation, int i);
    }

    /* renamed from: a */
    static C18608h m40612a(String str) {
        C18608h hVar;
        synchronized (f54619b) {
            hVar = f54619b.get(str);
        }
        return hVar;
    }

    /* renamed from: a */
    static void m40613a() {
        synchronized (f54619b) {
            f54619b.clear();
        }
    }

    ExecutionDelegator(Context context, JobFinishedCallback jobFinishedCallback) {
        this.f54621d = context;
        this.f54622e = jobFinishedCallback;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo137443a(com.firebase.jobdispatcher.JobInvocation r10) {
        /*
            r9 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.h> r0 = f54619b
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.h> r1 = f54619b     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r10.getService()     // Catch:{ all -> 0x0072 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0072 }
            com.firebase.jobdispatcher.h r1 = (com.firebase.jobdispatcher.C18608h) r1     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x0028
            boolean r2 = r1.mo137556a()     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x0028
            boolean r2 = r1.mo137560c(r10)     // Catch:{ all -> 0x0072 }
            if (r2 == 0) goto L_0x003a
            boolean r2 = r1.mo137557b()     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x003a
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return
        L_0x0028:
            com.firebase.jobdispatcher.h r1 = new com.firebase.jobdispatcher.h     // Catch:{ all -> 0x0072 }
            com.firebase.jobdispatcher.IJobCallback r2 = r9.f54620c     // Catch:{ all -> 0x0072 }
            android.content.Context r3 = r9.f54621d     // Catch:{ all -> 0x0072 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0072 }
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.h> r2 = f54619b     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = r10.getService()     // Catch:{ all -> 0x0072 }
            r2.put(r3, r1)     // Catch:{ all -> 0x0072 }
        L_0x003a:
            boolean r2 = r1.mo137558b(r10)     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x0070
            android.content.Context r2 = r9.f54621d     // Catch:{ all -> 0x0072 }
            android.content.Intent r3 = r9.m40611a((com.firebase.jobdispatcher.JobParameters) r10)     // Catch:{ all -> 0x0072 }
            r4 = 1
            boolean r2 = r2.bindService(r3, r1, r4)     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x0070
            java.lang.String r4 = "FJD.ExternalReceiver"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r2.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "Unable to bind to "
            r2.append(r3)     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = r10.getService()     // Catch:{ all -> 0x0072 }
            r2.append(r10)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0072 }
            r3 = 6
            r6 = 0
            java.lang.String r7 = "com.firebase.jobdispatcher.ExecutionDelegator"
            r8 = 112(0x70, float:1.57E-43)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0072 }
            r1.mo137559c()     // Catch:{ all -> 0x0072 }
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return
        L_0x0072:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.ExecutionDelegator.mo137443a(com.firebase.jobdispatcher.JobInvocation):void");
    }

    /* renamed from: a */
    private Intent m40611a(JobParameters jobParameters) {
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f54621d, jobParameters.getService());
        return intent;
    }

    /* renamed from: a */
    static void m40616a(JobInvocation jobInvocation, boolean z) {
        synchronized (f54619b) {
            C18608h hVar = f54619b.get(jobInvocation.getService());
            if (hVar != null) {
                hVar.mo137555a(jobInvocation, z);
                if (hVar.mo137556a()) {
                    f54619b.remove(jobInvocation.getService());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40615a(JobInvocation jobInvocation, int i) {
        synchronized (f54619b) {
            C18608h hVar = f54619b.get(jobInvocation.getService());
            if (hVar != null) {
                hVar.mo137554a(jobInvocation);
                if (hVar.mo137556a()) {
                    f54619b.remove(jobInvocation.getService());
                }
            }
        }
        this.f54622e.onJobFinished(jobInvocation, i);
    }
}
