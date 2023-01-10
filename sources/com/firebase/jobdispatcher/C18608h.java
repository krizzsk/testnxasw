package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.IRemoteJobService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.firebase.jobdispatcher.h */
/* compiled from: JobServiceConnection */
class C18608h implements ServiceConnection {

    /* renamed from: a */
    private final Map<JobInvocation, Boolean> f54755a = new HashMap();

    /* renamed from: b */
    private final IJobCallback f54756b;

    /* renamed from: c */
    private final Context f54757c;

    /* renamed from: d */
    private boolean f54758d = false;

    /* renamed from: e */
    private IRemoteJobService f54759e;

    C18608h(IJobCallback iJobCallback, Context context) {
        this.f54756b = iJobCallback;
        this.f54757c = context;
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (mo137556a()) {
            SystemUtils.log(5, "FJD.ExternalReceiver", "Connection have been used already.", (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 62);
            return;
        }
        this.f54759e = IRemoteJobService.Stub.asInterface(iBinder);
        HashSet<JobInvocation> hashSet = new HashSet<>();
        for (Map.Entry next : this.f54755a.entrySet()) {
            if (Boolean.FALSE.equals(next.getValue())) {
                try {
                    this.f54759e.start(m40667a((JobParameters) next.getKey()), this.f54756b);
                    hashSet.add(next.getKey());
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                    SystemUtils.log(6, "FJD.ExternalReceiver", "Failed to start job " + next.getKey(), remoteException, "com.firebase.jobdispatcher.JobServiceConnection", 74);
                    mo137559c();
                    return;
                }
            }
        }
        for (JobInvocation put : hashSet) {
            this.f54755a.put(put, true);
        }
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        mo137559c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo137556a() {
        return this.f54758d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo137557b() {
        return this.f54759e != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo137555a(JobInvocation jobInvocation, boolean z) {
        if (!mo137556a()) {
            if (Boolean.TRUE.equals(this.f54755a.remove(jobInvocation)) && mo137557b()) {
                m40668a(z, jobInvocation);
            }
            if (!z && this.f54755a.isEmpty()) {
                mo137559c();
            }
        } else {
            SystemUtils.log(5, "FJD.ExternalReceiver", "Can't send stop request because service was unbound.", (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 117);
        }
    }

    /* renamed from: a */
    private synchronized void m40668a(boolean z, JobInvocation jobInvocation) {
        try {
            this.f54759e.stop(m40667a((JobParameters) jobInvocation), z);
        } catch (RemoteException e) {
            SystemUtils.log(6, "FJD.ExternalReceiver", "Failed to stop a job", e, "com.firebase.jobdispatcher.JobServiceConnection", 125);
            mo137559c();
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo137559c() {
        if (!mo137556a()) {
            this.f54759e = null;
            this.f54758d = true;
            try {
                this.f54757c.unbindService(this);
            } catch (IllegalArgumentException e) {
                SystemUtils.log(5, "FJD.ExternalReceiver", "Error unbinding service: " + e.getMessage(), (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 137);
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo137554a(JobInvocation jobInvocation) {
        this.f54755a.remove(jobInvocation);
        if (this.f54755a.isEmpty()) {
            mo137559c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo137558b(JobInvocation jobInvocation) {
        boolean b;
        b = mo137557b();
        if (b) {
            if (Boolean.TRUE.equals(this.f54755a.get(jobInvocation))) {
                SystemUtils.log(5, "FJD.ExternalReceiver", "Received an execution request for already running job " + jobInvocation, (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 157);
                m40668a(false, jobInvocation);
            }
            try {
                this.f54759e.start(m40667a((JobParameters) jobInvocation), this.f54756b);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                SystemUtils.log(6, "FJD.ExternalReceiver", "Failed to start the job " + jobInvocation, remoteException, "com.firebase.jobdispatcher.JobServiceConnection", 163);
                mo137559c();
                return false;
            }
        }
        this.f54755a.put(jobInvocation, Boolean.valueOf(b));
        return b;
    }

    /* renamed from: a */
    private static Bundle m40667a(JobParameters jobParameters) {
        return GooglePlayReceiver.m40625c().mo137551a(jobParameters, new Bundle());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized boolean mo137560c(JobInvocation jobInvocation) {
        return this.f54755a.containsKey(jobInvocation);
    }
}
