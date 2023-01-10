package com.didi.component.business.job.jobs;

import com.didi.component.business.job.AbsJob;
import com.didi.component.business.util.NotificationUtils;
import com.firebase.jobdispatcher.JobParameters;

public class BookHalfHourJob extends AbsJob {

    /* renamed from: a */
    private String f13154a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f13155b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f13156c;

    public BookHalfHourJob(String str, String str2, String str3) {
        this.f13154a = str;
        this.f13155b = str2;
        this.f13156c = str3;
    }

    /* access modifiers changed from: protected */
    public void onJobExecution(JobParameters jobParameters) {
        this.mHandler.post(new Runnable() {
            public void run() {
                NotificationUtils.getInstance(BookHalfHourJob.this.mContext).showNotification(BookHalfHourJob.this.f13155b, BookHalfHourJob.this.f13156c);
            }
        });
    }
}
