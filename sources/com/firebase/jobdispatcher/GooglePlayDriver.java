package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class GooglePlayDriver implements Driver {

    /* renamed from: a */
    static final String f54626a = "com.google.android.gms";

    /* renamed from: b */
    private static final String f54627b = "com.google.android.gms.gcm.ACTION_SCHEDULE";

    /* renamed from: c */
    private static final String f54628c = "scheduler_action";

    /* renamed from: d */
    private static final String f54629d = "tag";

    /* renamed from: e */
    private static final String f54630e = "app";

    /* renamed from: f */
    private static final String f54631f = "component";

    /* renamed from: g */
    private static final String f54632g = "SCHEDULE_TASK";

    /* renamed from: h */
    private static final String f54633h = "CANCEL_TASK";

    /* renamed from: i */
    private static final String f54634i = "CANCEL_ALL";

    /* renamed from: j */
    private static final String f54635j = "source";

    /* renamed from: k */
    private static final String f54636k = "source_version";

    /* renamed from: l */
    private static final int f54637l = 8;

    /* renamed from: m */
    private static final int f54638m = 1;

    /* renamed from: n */
    private final JobValidator f54639n;

    /* renamed from: o */
    private final Context f54640o;

    /* renamed from: p */
    private final PendingIntent f54641p;

    /* renamed from: q */
    private final C18604d f54642q;

    /* renamed from: r */
    private final boolean f54643r = true;

    public boolean isAvailable() {
        return true;
    }

    public GooglePlayDriver(Context context) {
        this.f54640o = context;
        this.f54641p = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.f54642q = new C18604d();
        this.f54639n = new DefaultJobValidator(context);
    }

    public int schedule(Job job) {
        GooglePlayReceiver.m40621a(job);
        this.f54640o.sendBroadcast(m40618a((JobParameters) job));
        return 0;
    }

    public int cancel(String str) {
        this.f54640o.sendBroadcast(createCancelRequest(str));
        return 0;
    }

    public int cancelAll() {
        this.f54640o.sendBroadcast(createBatchCancelRequest());
        return 0;
    }

    /* access modifiers changed from: protected */
    public Intent createCancelRequest(String str) {
        Intent a = m40619a(f54633h);
        a.putExtra("tag", str);
        a.putExtra(f54631f, new ComponentName(this.f54640o, getReceiverClass()));
        return a;
    }

    /* access modifiers changed from: protected */
    public Intent createBatchCancelRequest() {
        Intent a = m40619a(f54634i);
        a.putExtra(f54631f, new ComponentName(this.f54640o, getReceiverClass()));
        return a;
    }

    /* access modifiers changed from: protected */
    public Class<GooglePlayReceiver> getReceiverClass() {
        return GooglePlayReceiver.class;
    }

    public JobValidator getValidator() {
        return this.f54639n;
    }

    /* renamed from: a */
    private Intent m40618a(JobParameters jobParameters) {
        Intent a = m40619a(f54632g);
        a.putExtras(this.f54642q.mo137549a(jobParameters, a.getExtras()));
        return a;
    }

    /* renamed from: a */
    private Intent m40619a(String str) {
        Intent intent = new Intent(f54627b);
        intent.setPackage("com.google.android.gms");
        intent.putExtra(f54628c, str);
        intent.putExtra("app", this.f54641p);
        intent.putExtra("source", 8);
        intent.putExtra(f54636k, 1);
        return intent;
    }
}
