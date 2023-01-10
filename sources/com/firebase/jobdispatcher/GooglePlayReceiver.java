package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Pair;
import androidx.collection.SimpleArrayMap;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.ExecutionDelegator;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.JobInvocation;
import com.firebase.jobdispatcher.JobTrigger;

public class GooglePlayReceiver extends Service implements ExecutionDelegator.JobFinishedCallback {

    /* renamed from: a */
    static final String f54644a = "FJD.GooglePlayReceiver";

    /* renamed from: b */
    static final String f54645b = "com.google.android.gms.gcm.ACTION_TASK_READY";

    /* renamed from: c */
    static final String f54646c = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";

    /* renamed from: g */
    private static final String f54647g = "Null Intent passed, terminating";

    /* renamed from: h */
    private static final String f54648h = "Unknown action received, terminating";

    /* renamed from: i */
    private static final String f54649i = "No data provided, terminating";

    /* renamed from: j */
    private static final C18607g f54650j = new C18607g("com.firebase.jobdispatcher.");

    /* renamed from: n */
    private static final SimpleArrayMap<String, SimpleArrayMap<String, JobCallback>> f54651n = new SimpleArrayMap<>(1);

    /* renamed from: d */
    Messenger f54652d;

    /* renamed from: e */
    Driver f54653e;

    /* renamed from: f */
    ValidationEnforcer f54654f;

    /* renamed from: k */
    private final C18602b f54655k = new C18602b();

    /* renamed from: l */
    private ExecutionDelegator f54656l;

    /* renamed from: m */
    private int f54657m;

    /* renamed from: a */
    static void m40620a() {
        synchronized (f54651n) {
            f54651n.clear();
        }
    }

    /* renamed from: a */
    private static void m40622a(JobCallback jobCallback, int i) {
        try {
            jobCallback.jobFinished(i);
        } catch (Throwable th) {
            SystemUtils.log(6, f54644a, "Encountered error running callback", th.getCause(), "com.firebase.jobdispatcher.GooglePlayReceiver", 98);
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            super.onStartCommand(intent, i, i2);
            if (intent == null) {
                SystemUtils.log(5, f54644a, f54647g, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayReceiver", 108);
                synchronized (f54651n) {
                    this.f54657m = i2;
                    if (f54651n.isEmpty()) {
                        stopSelf(this.f54657m);
                    }
                }
                return 2;
            }
            String action = intent.getAction();
            if (f54645b.equals(action)) {
                mo137460b().mo137443a(mo137456a(intent));
                synchronized (f54651n) {
                    this.f54657m = i2;
                    if (f54651n.isEmpty()) {
                        stopSelf(this.f54657m);
                    }
                }
                return 2;
            } else if (f54646c.equals(action)) {
                synchronized (f54651n) {
                    this.f54657m = i2;
                    if (f54651n.isEmpty()) {
                        stopSelf(this.f54657m);
                    }
                }
                return 2;
            } else {
                SystemUtils.log(6, f54644a, f54648h, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayReceiver", 120);
                synchronized (f54651n) {
                    this.f54657m = i2;
                    if (f54651n.isEmpty()) {
                        stopSelf(this.f54657m);
                    }
                }
                return 2;
            }
        } catch (Throwable th) {
            synchronized (f54651n) {
                this.f54657m = i2;
                if (f54651n.isEmpty()) {
                    stopSelf(this.f54657m);
                }
                throw th;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || Build.VERSION.SDK_INT < 21 || !f54645b.equals(intent.getAction())) {
            return null;
        }
        return m40626d().getBinder();
    }

    /* renamed from: d */
    private synchronized Messenger m40626d() {
        if (this.f54652d == null) {
            this.f54652d = new Messenger(new C18605e(Looper.getMainLooper(), this));
        }
        return this.f54652d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized ExecutionDelegator mo137460b() {
        if (this.f54656l == null) {
            this.f54656l = new ExecutionDelegator(this, this);
        }
        return this.f54656l;
    }

    /* renamed from: e */
    private synchronized Driver m40627e() {
        if (this.f54653e == null) {
            this.f54653e = new GooglePlayDriver(getApplicationContext());
        }
        return this.f54653e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo137458a(Driver driver) {
        this.f54653e = driver;
    }

    /* renamed from: f */
    private synchronized ValidationEnforcer m40628f() {
        if (this.f54654f == null) {
            this.f54654f = new ValidationEnforcer(m40627e().getValidator());
        }
        return this.f54654f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo137459a(ValidationEnforcer validationEnforcer) {
        this.f54654f = validationEnforcer;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JobInvocation mo137456a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            SystemUtils.log(6, f54644a, f54649i, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayReceiver", 190);
            return null;
        }
        Pair<JobCallback, Bundle> a = this.f54655k.mo137548a(extras);
        if (a != null) {
            return mo137457a((JobCallback) a.first, (Bundle) a.second);
        }
        SystemUtils.log(4, f54644a, "no callback found", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayReceiver", 197);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JobInvocation mo137457a(JobCallback jobCallback, Bundle bundle) {
        JobInvocation a = f54650j.mo137552a(bundle);
        if (a == null) {
            SystemUtils.log(6, f54644a, "unable to decode job", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayReceiver", 207);
            m40622a(jobCallback, 2);
            return null;
        }
        synchronized (f54651n) {
            SimpleArrayMap simpleArrayMap = f54651n.get(a.getService());
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap(1);
                f54651n.put(a.getService(), simpleArrayMap);
            }
            simpleArrayMap.put(a.getTag(), jobCallback);
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onJobFinished(com.firebase.jobdispatcher.JobInvocation r10, int r11) {
        /*
            r9 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r0 = f54651n
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r1 = f54651n     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = r10.getService()     // Catch:{ all -> 0x0097 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0097 }
            androidx.collection.SimpleArrayMap r1 = (androidx.collection.SimpleArrayMap) r1     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x0020
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r10 = f54651n     // Catch:{ all -> 0x00a6 }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x00a6 }
            if (r10 == 0) goto L_0x001e
            int r10 = r9.f54657m     // Catch:{ all -> 0x00a6 }
            r9.stopSelf(r10)     // Catch:{ all -> 0x00a6 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            return
        L_0x0020:
            java.lang.String r2 = r10.getTag()     // Catch:{ all -> 0x0097 }
            java.lang.Object r2 = r1.remove(r2)     // Catch:{ all -> 0x0097 }
            com.firebase.jobdispatcher.JobCallback r2 = (com.firebase.jobdispatcher.JobCallback) r2     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x003b
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r10 = f54651n     // Catch:{ all -> 0x00a6 }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x00a6 }
            if (r10 == 0) goto L_0x0039
            int r10 = r9.f54657m     // Catch:{ all -> 0x00a6 }
            r9.stopSelf(r10)     // Catch:{ all -> 0x00a6 }
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            return
        L_0x003b:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x004a
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r1 = f54651n     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r10.getService()     // Catch:{ all -> 0x0097 }
            r1.remove(r3)     // Catch:{ all -> 0x0097 }
        L_0x004a:
            boolean r1 = m40624a((com.firebase.jobdispatcher.JobParameters) r10, (int) r11)     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0054
            r9.m40623a((com.firebase.jobdispatcher.JobInvocation) r10)     // Catch:{ all -> 0x0097 }
            goto L_0x0088
        L_0x0054:
            java.lang.String r1 = "FJD.GooglePlayReceiver"
            r3 = 2
            boolean r1 = android.util.Log.isLoggable(r1, r3)     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0085
            java.lang.String r4 = "FJD.GooglePlayReceiver"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            r1.<init>()     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = "sending jobFinished for "
            r1.append(r3)     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = r10.getTag()     // Catch:{ all -> 0x0097 }
            r1.append(r10)     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = " = "
            r1.append(r10)     // Catch:{ all -> 0x0097 }
            r1.append(r11)     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0097 }
            r3 = 2
            r6 = 0
            java.lang.String r7 = "com.firebase.jobdispatcher.GooglePlayReceiver"
            r8 = 243(0xf3, float:3.4E-43)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0097 }
        L_0x0085:
            m40622a((com.firebase.jobdispatcher.JobCallback) r2, (int) r11)     // Catch:{ all -> 0x0097 }
        L_0x0088:
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r10 = f54651n     // Catch:{ all -> 0x00a6 }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x00a6 }
            if (r10 == 0) goto L_0x0095
            int r10 = r9.f54657m     // Catch:{ all -> 0x00a6 }
            r9.stopSelf(r10)     // Catch:{ all -> 0x00a6 }
        L_0x0095:
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            return
        L_0x0097:
            r10 = move-exception
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobCallback>> r11 = f54651n     // Catch:{ all -> 0x00a6 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x00a6 }
            if (r11 == 0) goto L_0x00a5
            int r11 = r9.f54657m     // Catch:{ all -> 0x00a6 }
            r9.stopSelf(r11)     // Catch:{ all -> 0x00a6 }
        L_0x00a5:
            throw r10     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.onJobFinished(com.firebase.jobdispatcher.JobInvocation, int):void");
    }

    /* renamed from: a */
    private void m40623a(JobInvocation jobInvocation) {
        m40627e().schedule(new Job.Builder(m40628f(), jobInvocation).setReplaceCurrent(true).build());
    }

    /* renamed from: a */
    private static boolean m40624a(JobParameters jobParameters, int i) {
        if (!jobParameters.isRecurring() || !(jobParameters.getTrigger() instanceof JobTrigger.ContentUriTrigger) || i == 1) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    static C18607g m40625c() {
        return f54650j;
    }

    /* renamed from: a */
    static void m40621a(Job job) {
        synchronized (f54651n) {
            SimpleArrayMap simpleArrayMap = f54651n.get(job.getService());
            if (simpleArrayMap != null) {
                if (((JobCallback) simpleArrayMap.get(job.getTag())) != null) {
                    ExecutionDelegator.m40616a(new JobInvocation.Builder().setTag(job.getTag()).setService(job.getService()).setTrigger(job.getTrigger()).build(), false);
                }
            }
        }
    }
}
