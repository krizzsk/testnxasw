package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.IRemoteJobService;
import com.firebase.jobdispatcher.JobInvocation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

public abstract class JobService extends Service {
    public static final int RESULT_FAIL_NORETRY = 2;
    public static final int RESULT_FAIL_RETRY = 1;
    public static final int RESULT_SUCCESS = 0;

    /* renamed from: a */
    static final String f54677a = "FJD.JobService";

    /* renamed from: b */
    static final String f54678b = "com.firebase.jobdispatcher.ACTION_EXECUTE";

    /* renamed from: c */
    private static final Handler f54679c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final SimpleArrayMap<String, JobCallback> f54680d = new SimpleArrayMap<>(1);

    /* renamed from: e */
    private final IRemoteJobService.Stub f54681e = new IRemoteJobService.Stub() {
        public void start(Bundle bundle, IJobCallback iJobCallback) {
            JobInvocation.Builder b = GooglePlayReceiver.m40625c().mo137553b(bundle);
            if (b == null) {
                Log.wtf(JobService.f54677a, "start: unknown invocation provided");
            } else {
                JobService.this.mo137510a((JobParameters) b.build(), iJobCallback);
            }
        }

        public void stop(Bundle bundle, boolean z) {
            JobInvocation.Builder b = GooglePlayReceiver.m40625c().mo137553b(bundle);
            if (b == null) {
                Log.wtf(JobService.f54677a, "stop: unknown invocation provided");
            } else {
                JobService.this.mo137511a((JobParameters) b.build(), z);
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface JobResult {
    }

    public final void onStart(Intent intent, int i) {
    }

    public abstract boolean onStartJob(JobParameters jobParameters);

    public abstract boolean onStopJob(JobParameters jobParameters);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo137510a(final JobParameters jobParameters, IJobCallback iJobCallback) {
        synchronized (this.f54680d) {
            if (this.f54680d.containsKey(jobParameters.getTag())) {
                SystemUtils.log(5, f54677a, String.format(Locale.US, "Job with tag = %s was already running.", new Object[]{jobParameters.getTag()}), (Throwable) null, "com.firebase.jobdispatcher.JobService", 153);
                return;
            }
            this.f54680d.put(jobParameters.getTag(), new JobCallback(jobParameters, iJobCallback));
            f54679c.post(new Runnable() {
                public void run() {
                    JobCallback jobCallback;
                    synchronized (JobService.this.f54680d) {
                        if (!JobService.this.onStartJob(jobParameters) && (jobCallback = (JobCallback) JobService.this.f54680d.remove(jobParameters.getTag())) != null) {
                            jobCallback.sendResult(0);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo137511a(final com.firebase.jobdispatcher.JobParameters r8, final boolean r9) {
        /*
            r7 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobService$JobCallback> r0 = r7.f54680d
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.JobService$JobCallback> r1 = r7.f54680d     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = r8.getTag()     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ all -> 0x0035 }
            com.firebase.jobdispatcher.JobService$JobCallback r1 = (com.firebase.jobdispatcher.JobService.JobCallback) r1     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0029
            java.lang.String r8 = "FJD.JobService"
            r9 = 3
            boolean r8 = android.util.Log.isLoggable(r8, r9)     // Catch:{ all -> 0x0035 }
            if (r8 == 0) goto L_0x0027
            java.lang.String r2 = "FJD.JobService"
            java.lang.String r3 = "Provided job has already been executed."
            r1 = 3
            r4 = 0
            java.lang.String r5 = "com.firebase.jobdispatcher.JobService"
            r6 = 187(0xbb, float:2.62E-43)
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0035 }
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0029:
            android.os.Handler r2 = f54679c     // Catch:{ all -> 0x0035 }
            com.firebase.jobdispatcher.JobService$3 r3 = new com.firebase.jobdispatcher.JobService$3     // Catch:{ all -> 0x0035 }
            r3.<init>(r8, r9, r1)     // Catch:{ all -> 0x0035 }
            r2.post(r3)     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.JobService.mo137511a(com.firebase.jobdispatcher.JobParameters, boolean):void");
    }

    public final void jobFinished(JobParameters jobParameters, boolean z) {
        if (jobParameters == null) {
            SystemUtils.log(6, f54677a, "jobFinished called with a null JobParameters", (Throwable) null, "com.firebase.jobdispatcher.JobService", 215);
            return;
        }
        synchronized (this.f54680d) {
            JobCallback remove = this.f54680d.remove(jobParameters.getTag());
            if (remove != null) {
                remove.sendResult(z ? 1 : 0);
            }
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        stopSelf(i2);
        return 2;
    }

    public final IBinder onBind(Intent intent) {
        return this.f54681e;
    }

    public final boolean onUnbind(Intent intent) {
        synchronized (this.f54680d) {
            for (int size = this.f54680d.size() - 1; size >= 0; size--) {
                JobCallback remove = this.f54680d.remove(this.f54680d.keyAt(size));
                if (remove != null) {
                    remove.sendResult(onStopJob(remove.job) ? 1 : 2);
                }
            }
        }
        return super.onUnbind(intent);
    }

    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    /* access modifiers changed from: protected */
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    private static final class JobCallback {
        final JobParameters job;
        final IJobCallback remoteCallback;

        private JobCallback(JobParameters jobParameters, IJobCallback iJobCallback) {
            this.job = jobParameters;
            this.remoteCallback = iJobCallback;
        }

        /* access modifiers changed from: package-private */
        public void sendResult(int i) {
            try {
                this.remoteCallback.jobFinished(GooglePlayReceiver.m40625c().mo137551a(this.job, new Bundle()), i);
            } catch (RemoteException e) {
                SystemUtils.log(6, JobService.f54677a, "Failed to send result to driver", e, "com.firebase.jobdispatcher.JobService$JobCallback", 298);
            }
        }
    }
}
