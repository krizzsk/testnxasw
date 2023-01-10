package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import com.firebase.jobdispatcher.JobTrigger;

/* renamed from: com.firebase.jobdispatcher.d */
/* compiled from: GooglePlayJobWriter */
final class C18604d {

    /* renamed from: a */
    static final String f54722a = "update_current";

    /* renamed from: b */
    static final String f54723b = "extras";

    /* renamed from: c */
    static final String f54724c = "persisted";

    /* renamed from: d */
    static final String f54725d = "requiredNetwork";

    /* renamed from: e */
    static final String f54726e = "requiresCharging";

    /* renamed from: f */
    static final String f54727f = "requiresIdle";

    /* renamed from: g */
    static final String f54728g = "retryStrategy";

    /* renamed from: h */
    static final String f54729h = "service";

    /* renamed from: i */
    static final String f54730i = "tag";

    /* renamed from: j */
    static final String f54731j = "initial_backoff_seconds";

    /* renamed from: k */
    static final String f54732k = "maximum_backoff_seconds";

    /* renamed from: l */
    static final String f54733l = "retry_policy";

    /* renamed from: m */
    static final String f54734m = "trigger_type";

    /* renamed from: n */
    static final String f54735n = "window_end";

    /* renamed from: o */
    static final String f54736o = "period_flex";

    /* renamed from: p */
    static final String f54737p = "period";

    /* renamed from: q */
    static final String f54738q = "window_start";

    /* renamed from: r */
    static final int f54739r = 0;

    /* renamed from: s */
    static final int f54740s = 1;

    /* renamed from: t */
    static final int f54741t = 1;

    /* renamed from: u */
    static final int f54742u = 0;

    /* renamed from: v */
    static final int f54743v = 2;

    /* renamed from: w */
    private final C18607g f54744w = new C18607g("com.firebase.jobdispatcher.");

    /* renamed from: a */
    private static int m40646a(int i) {
        return i != 2 ? 0 : 1;
    }

    /* renamed from: b */
    private static int m40650b(int i) {
        int i2 = 2;
        if ((i & 2) == 2) {
            i2 = 0;
        }
        if ((i & 1) == 1) {
            return 1;
        }
        return i2;
    }

    C18604d() {
    }

    /* renamed from: a */
    private static void m40649a(JobParameters jobParameters, Bundle bundle, JobTrigger.ExecutionWindowTrigger executionWindowTrigger) {
        bundle.putInt(f54734m, 1);
        if (jobParameters.isRecurring()) {
            bundle.putLong("period", (long) executionWindowTrigger.getWindowEnd());
            bundle.putLong(f54736o, (long) (executionWindowTrigger.getWindowEnd() - executionWindowTrigger.getWindowStart()));
            return;
        }
        bundle.putLong(f54738q, (long) executionWindowTrigger.getWindowStart());
        bundle.putLong(f54735n, (long) executionWindowTrigger.getWindowEnd());
    }

    /* renamed from: a */
    private static void m40647a(Bundle bundle) {
        bundle.putInt(f54734m, 2);
        bundle.putLong(f54738q, 0);
        bundle.putLong(f54735n, 1);
    }

    /* renamed from: a */
    private static void m40648a(Bundle bundle, JobTrigger.ContentUriTrigger contentUriTrigger) {
        bundle.putInt(f54734m, 3);
        int size = contentUriTrigger.getUris().size();
        int[] iArr = new int[size];
        Uri[] uriArr = new Uri[size];
        for (int i = 0; i < size; i++) {
            ObservedUri observedUri = contentUriTrigger.getUris().get(i);
            iArr[i] = observedUri.getFlags();
            uriArr[i] = observedUri.getUri();
        }
        bundle.putIntArray("content_uri_flags_array", iArr);
        bundle.putParcelableArray("content_uri_array", uriArr);
    }

    /* renamed from: a */
    public Bundle mo137549a(JobParameters jobParameters, Bundle bundle) {
        bundle.putString("tag", jobParameters.getTag());
        bundle.putBoolean(f54722a, jobParameters.shouldReplaceCurrent());
        bundle.putBoolean(f54724c, jobParameters.getLifetime() == 2);
        bundle.putString("service", GooglePlayReceiver.class.getName());
        m40652c(jobParameters, bundle);
        m40653d(jobParameters, bundle);
        m40651b(jobParameters, bundle);
        Bundle extras = jobParameters.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        bundle.putBundle("extras", this.f54744w.mo137551a(jobParameters, extras));
        return bundle;
    }

    /* renamed from: b */
    private static void m40651b(JobParameters jobParameters, Bundle bundle) {
        RetryStrategy retryStrategy = jobParameters.getRetryStrategy();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f54733l, m40646a(retryStrategy.getPolicy()));
        bundle2.putInt(f54731j, retryStrategy.getInitialBackoff());
        bundle2.putInt(f54732k, retryStrategy.getMaximumBackoff());
        bundle.putBundle(f54728g, bundle2);
    }

    /* renamed from: c */
    private static void m40652c(JobParameters jobParameters, Bundle bundle) {
        JobTrigger trigger = jobParameters.getTrigger();
        if (trigger == Trigger.NOW) {
            m40647a(bundle);
        } else if (trigger instanceof JobTrigger.ExecutionWindowTrigger) {
            m40649a(jobParameters, bundle, (JobTrigger.ExecutionWindowTrigger) trigger);
        } else if (trigger instanceof JobTrigger.ContentUriTrigger) {
            m40648a(bundle, (JobTrigger.ContentUriTrigger) trigger);
        } else {
            throw new IllegalArgumentException("Unknown trigger: " + trigger.getClass());
        }
    }

    /* renamed from: d */
    private static void m40653d(JobParameters jobParameters, Bundle bundle) {
        int a = Constraint.m40599a(jobParameters.getConstraints());
        boolean z = true;
        bundle.putBoolean(f54726e, (a & 4) == 4);
        if ((a & 8) != 8) {
            z = false;
        }
        bundle.putBoolean(f54727f, z);
        bundle.putInt(f54725d, m40650b(a));
    }
}
