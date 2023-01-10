package com.didi.component.business.job;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.firebase.jobdispatcher.JobParameters;

public abstract class AbsJob {

    /* renamed from: a */
    private String f13146a = "";

    /* renamed from: b */
    private boolean f13147b;
    protected Context mContext;
    protected final Handler mHandler = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: protected */
    public abstract void onJobExecution(JobParameters jobParameters);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo51096a() {
        return this.f13146a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo51098a(String str) {
        this.f13146a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo51099b() {
        return this.f13147b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo51097a(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public final void setNeedToReschedule(boolean z) {
        this.f13147b = z;
    }

    public Handler getHandler() {
        return this.mHandler;
    }
}
