package com.didi.component.business.job;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Trigger;

public class GlobalJobManager {

    /* renamed from: a */
    private static volatile GlobalJobManager f13150a;

    /* renamed from: b */
    private Context f13151b;

    /* renamed from: c */
    private FirebaseJobDispatcher f13152c;

    private GlobalJobManager(Context context) {
        this.f13152c = new FirebaseJobDispatcher(new GooglePlayDriver(context.getApplicationContext()));
        this.f13151b = context.getApplicationContext();
    }

    public static GlobalJobManager getInstance(Context context) {
        if (f13150a == null) {
            synchronized (GlobalJobManager.class) {
                if (f13150a == null) {
                    f13150a = new GlobalJobManager(context);
                }
            }
        }
        return f13150a;
    }

    public String schedule(AbsJob absJob, int i) throws FirebaseJobDispatcher.ScheduleFailedException {
        return schedule(absJob, i, 30);
    }

    public String schedule(AbsJob absJob, int i, int i2) throws FirebaseJobDispatcher.ScheduleFailedException {
        if (this.f13152c == null) {
            return "";
        }
        String str = absJob.getClass().getSimpleName() + "-" + System.currentTimeMillis();
        Job build = this.f13152c.newJobBuilder().setService(GlobalJobDispatcher.class).setLifetime(1).setTag(str).setRecurring(false).setTrigger(Trigger.executionWindow(i, i2 + i)).setReplaceCurrent(true).build();
        absJob.mo51098a(str);
        absJob.mo51097a(this.f13151b);
        this.f13152c.mustSchedule(build);
        SystemUtils.log(4, "JobManager", "job is scheduled tag is " + str, (Throwable) null, "com.didi.component.business.job.GlobalJobManager", 89);
        JobMapping.m11018a().mo51112a(absJob);
        return str;
    }

    public void cancel(String str) {
        if (this.f13152c != null) {
            JobMapping.m11018a().mo51111a(str);
            this.f13152c.cancel(str);
        }
    }

    public void cancelAll() {
        if (this.f13152c != null) {
            JobMapping.m11018a().mo51113b();
            this.f13152c.cancelAll();
        }
    }

    public void destory() {
        FirebaseJobDispatcher firebaseJobDispatcher = this.f13152c;
        if (firebaseJobDispatcher != null) {
            firebaseJobDispatcher.cancelAll();
        }
        JobMapping.m11018a().mo51113b();
        this.f13152c = null;
        f13150a = null;
    }
}
