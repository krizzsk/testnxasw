package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.JobTrigger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DefaultJobValidator implements JobValidator {
    public static final int MAX_EXTRAS_SIZE_BYTES = 10240;
    public static final int MAX_TAG_LENGTH = 100;

    /* renamed from: a */
    private final Context f54617a;

    public DefaultJobValidator(Context context) {
        this.f54617a = context;
    }

    /* renamed from: a */
    private static int m40601a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        int dataSize = obtain.dataSize();
        obtain.recycle();
        return dataSize;
    }

    /* renamed from: a */
    private static List<String> m40604a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    /* renamed from: a */
    private static List<String> m40603a(List<String> list, String str) {
        if (str == null) {
            return list;
        }
        if (list == null) {
            return m40609c(str);
        }
        Collections.addAll(list, new String[]{str});
        return list;
    }

    /* renamed from: a */
    private static List<String> m40605a(boolean z, List<String> list, String str) {
        return z ? m40603a(list, str) : list;
    }

    public List<String> validate(JobParameters jobParameters) {
        List<String> a = m40604a(m40604a((List<String>) null, validate(jobParameters.getTrigger())), validate(jobParameters.getRetryStrategy()));
        if (jobParameters.isRecurring() && jobParameters.getTrigger() == Trigger.NOW) {
            a = m40603a(a, "ImmediateTriggers can't be used with recurring jobs");
        }
        List<String> a2 = m40604a(a, m40608c(jobParameters.getExtras()));
        if (jobParameters.getLifetime() > 1) {
            a2 = m40604a(a2, m40606b(jobParameters.getExtras()));
        }
        return m40604a(m40604a(a2, m40607b(jobParameters.getTag())), mo137434a(jobParameters.getService()));
    }

    public List<String> validate(JobTrigger jobTrigger) {
        if (jobTrigger == Trigger.NOW || (jobTrigger instanceof JobTrigger.ExecutionWindowTrigger) || (jobTrigger instanceof JobTrigger.ContentUriTrigger)) {
            return null;
        }
        return m40609c("Unknown trigger provided");
    }

    public List<String> validate(RetryStrategy retryStrategy) {
        int policy = retryStrategy.getPolicy();
        int initialBackoff = retryStrategy.getInitialBackoff();
        int maximumBackoff = retryStrategy.getMaximumBackoff();
        boolean z = false;
        List<String> a = m40605a(300 > maximumBackoff, m40605a(maximumBackoff < initialBackoff, m40605a((policy == 1 || policy == 2) ? false : true, (List<String>) null, "Unknown retry policy provided"), "Maximum backoff must be greater than or equal to initial backoff"), "Maximum backoff must be greater than 300s (5 minutes)");
        if (initialBackoff < 30) {
            z = true;
        }
        return m40605a(z, a, "Initial backoff must be at least 30s");
    }

    /* renamed from: b */
    private static List<String> m40606b(Bundle bundle) {
        List<String> list = null;
        if (bundle != null) {
            for (String a : bundle.keySet()) {
                list = m40603a(list, m40602a(bundle, a));
            }
        }
        return list;
    }

    /* renamed from: c */
    private static List<String> m40608c(Bundle bundle) {
        int a;
        if (bundle == null || (a = m40601a(bundle)) <= 10240) {
            return null;
        }
        return m40609c(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", new Object[]{Integer.valueOf(a), 10240}));
    }

    /* renamed from: a */
    private static String m40602a(Bundle bundle, String str) {
        Object obj = bundle.get(str);
        Class<?> cls = null;
        if (obj == null || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) {
            return null;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        if (obj != null) {
            cls = obj.getClass();
        }
        objArr[0] = cls;
        objArr[1] = str;
        return String.format(locale, "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean", objArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<String> mo137434a(String str) {
        if (str == null || str.isEmpty()) {
            return m40609c("Service can't be empty");
        }
        Context context = this.f54617a;
        if (context == null) {
            return m40609c("Context is null, can't query PackageManager");
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return m40609c("PackageManager is null, can't validate service");
        }
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f54617a, str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            SystemUtils.log(6, "FJD.GooglePlayReceiver", "Couldn't find a registered service with the name " + str + ". Is it declared in the manifest with the right intent-filter? If not, the job won't be started.", (Throwable) null, "com.firebase.jobdispatcher.DefaultJobValidator", 275);
            return null;
        }
        for (ResolveInfo next : queryIntentServices) {
            if (next.serviceInfo != null && next.serviceInfo.enabled) {
                return null;
            }
        }
        return m40609c(str + " is disabled.");
    }

    /* renamed from: b */
    private static List<String> m40607b(String str) {
        if (str == null) {
            return m40609c("Tag can't be null");
        }
        if (str.length() > 100) {
            return m40609c("Tag must be shorter than 100");
        }
        return null;
    }

    /* renamed from: c */
    private static List<String> m40609c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }
}
