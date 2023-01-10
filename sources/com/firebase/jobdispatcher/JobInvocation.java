package com.firebase.jobdispatcher;

import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;

final class JobInvocation implements JobParameters {

    /* renamed from: a */
    private final String f54667a;

    /* renamed from: b */
    private final String f54668b;

    /* renamed from: c */
    private final JobTrigger f54669c;

    /* renamed from: d */
    private final boolean f54670d;

    /* renamed from: e */
    private final int f54671e;

    /* renamed from: f */
    private final int[] f54672f;

    /* renamed from: g */
    private final Bundle f54673g;

    /* renamed from: h */
    private final RetryStrategy f54674h;

    /* renamed from: i */
    private final boolean f54675i;

    /* renamed from: j */
    private final TriggerReason f54676j;

    private JobInvocation(Builder builder) {
        this.f54667a = builder.tag;
        this.f54668b = builder.service;
        this.f54669c = builder.trigger;
        this.f54674h = builder.retryStrategy;
        this.f54670d = builder.recurring;
        this.f54671e = builder.lifetime;
        this.f54672f = builder.constraints;
        this.f54673g = builder.extras;
        this.f54675i = builder.replaceCurrent;
        this.f54676j = builder.triggerReason;
    }

    public String getService() {
        return this.f54668b;
    }

    public String getTag() {
        return this.f54667a;
    }

    public JobTrigger getTrigger() {
        return this.f54669c;
    }

    public int getLifetime() {
        return this.f54671e;
    }

    public boolean isRecurring() {
        return this.f54670d;
    }

    public int[] getConstraints() {
        return this.f54672f;
    }

    public Bundle getExtras() {
        return this.f54673g;
    }

    public RetryStrategy getRetryStrategy() {
        return this.f54674h;
    }

    public boolean shouldReplaceCurrent() {
        return this.f54675i;
    }

    public TriggerReason getTriggerReason() {
        return this.f54676j;
    }

    static final class Builder {
        /* access modifiers changed from: private */
        public int[] constraints;
        /* access modifiers changed from: private */
        public final Bundle extras = new Bundle();
        /* access modifiers changed from: private */
        public int lifetime;
        /* access modifiers changed from: private */
        public boolean recurring;
        /* access modifiers changed from: private */
        public boolean replaceCurrent;
        /* access modifiers changed from: private */
        public RetryStrategy retryStrategy;
        /* access modifiers changed from: private */
        public String service;
        /* access modifiers changed from: private */
        public String tag;
        /* access modifiers changed from: private */
        public JobTrigger trigger;
        /* access modifiers changed from: private */
        public TriggerReason triggerReason;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public JobInvocation build() {
            if (this.tag != null && this.service != null && this.trigger != null) {
                return new JobInvocation(this);
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setService(String str) {
            this.service = str;
            return this;
        }

        public Builder setTrigger(JobTrigger jobTrigger) {
            this.trigger = jobTrigger;
            return this;
        }

        public Builder setRecurring(boolean z) {
            this.recurring = z;
            return this;
        }

        public Builder setLifetime(int i) {
            this.lifetime = i;
            return this;
        }

        public Builder setConstraints(int[] iArr) {
            this.constraints = iArr;
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.extras.putAll(bundle);
            }
            return this;
        }

        public Builder setRetryStrategy(RetryStrategy retryStrategy2) {
            this.retryStrategy = retryStrategy2;
            return this;
        }

        public Builder setReplaceCurrent(boolean z) {
            this.replaceCurrent = z;
            return this;
        }

        public Builder setTriggerReason(TriggerReason triggerReason2) {
            this.triggerReason = triggerReason2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        JobInvocation jobInvocation = (JobInvocation) obj;
        if (!this.f54667a.equals(jobInvocation.f54667a) || !this.f54668b.equals(jobInvocation.f54668b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f54667a.hashCode() * 31) + this.f54668b.hashCode();
    }

    public String toString() {
        return "JobInvocation{tag='" + JSONObject.quote(this.f54667a) + '\'' + ", service='" + this.f54668b + '\'' + ", trigger=" + this.f54669c + ", recurring=" + this.f54670d + ", lifetime=" + this.f54671e + ", constraints=" + Arrays.toString(this.f54672f) + ", extras=" + this.f54673g + ", retryStrategy=" + this.f54674h + ", replaceCurrent=" + this.f54675i + ", triggerReason=" + this.f54676j + '}';
    }
}
