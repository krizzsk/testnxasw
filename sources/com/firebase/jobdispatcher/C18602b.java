package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;

/* renamed from: com.firebase.jobdispatcher.b */
/* compiled from: GooglePlayCallbackExtractor */
final class C18602b {

    /* renamed from: a */
    private static final String f54711a = "FJD.GooglePlayReceiver";

    /* renamed from: b */
    private static final String f54712b = "No callback received, terminating";

    /* renamed from: c */
    private static final String f54713c = "Bad callback received, terminating";

    /* renamed from: d */
    private static final String f54714d = "com.google.android.gms.gcm.PendingCallback";

    /* renamed from: e */
    private static final String f54715e = "callback";

    /* renamed from: f */
    private static final int f54716f = 1279544898;

    /* renamed from: g */
    private static final int f54717g = 4;

    /* renamed from: h */
    private static Boolean f54718h;

    C18602b() {
    }

    /* renamed from: a */
    public Pair<JobCallback, Bundle> mo137548a(Bundle bundle) {
        if (bundle != null) {
            return m40643b(bundle);
        }
        SystemUtils.log(6, f54711a, f54712b, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayCallbackExtractor", 56);
        return null;
    }

    /* renamed from: b */
    private static Pair<JobCallback, Bundle> m40643b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Parcel c = m40644c(bundle);
        try {
            if (c.readInt() <= 0) {
                SystemUtils.log(5, f54711a, f54712b, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayCallbackExtractor", 97);
                return null;
            } else if (c.readInt() != f54716f) {
                SystemUtils.log(5, f54711a, f54712b, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayCallbackExtractor", 104);
                c.recycle();
                return null;
            } else {
                int readInt = c.readInt();
                C18603c cVar = null;
                for (int i = 0; i < readInt; i++) {
                    String a = m40640a(c);
                    if (a != null) {
                        if (cVar == null) {
                            if (f54715e.equals(a)) {
                                if (c.readInt() != 4) {
                                    SystemUtils.log(5, f54711a, f54713c, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayCallbackExtractor", 145);
                                    c.recycle();
                                    return null;
                                } else if (!f54714d.equals(c.readString())) {
                                    SystemUtils.log(5, f54711a, f54713c, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayCallbackExtractor", 153);
                                    c.recycle();
                                    return null;
                                } else {
                                    cVar = new C18603c(c.readStrongBinder());
                                }
                            }
                        }
                        Object readValue = c.readValue((ClassLoader) null);
                        if (readValue instanceof String) {
                            bundle2.putString(a, (String) readValue);
                        } else if (readValue instanceof Boolean) {
                            bundle2.putBoolean(a, ((Boolean) readValue).booleanValue());
                        } else if (readValue instanceof Integer) {
                            bundle2.putInt(a, ((Integer) readValue).intValue());
                        } else if (readValue instanceof ArrayList) {
                            bundle2.putParcelableArrayList(a, (ArrayList) readValue);
                        } else if (readValue instanceof Bundle) {
                            bundle2.putBundle(a, (Bundle) readValue);
                        } else if (readValue instanceof Parcelable) {
                            bundle2.putParcelable(a, (Parcelable) readValue);
                        }
                    }
                }
                if (cVar == null) {
                    SystemUtils.log(5, f54711a, f54712b, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayCallbackExtractor", 163);
                    c.recycle();
                    return null;
                }
                Pair<JobCallback, Bundle> create = Pair.create(cVar, bundle2);
                c.recycle();
                return create;
            }
        } finally {
            c.recycle();
        }
    }

    /* renamed from: c */
    private static Parcel m40644c(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }

    /* renamed from: a */
    private static String m40640a(Parcel parcel) {
        if (m40642a()) {
            return parcel.readString();
        }
        Object readValue = parcel.readValue((ClassLoader) null);
        if (readValue instanceof String) {
            return (String) readValue;
        }
        SystemUtils.log(5, f54711a, f54713c, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayCallbackExtractor", 194);
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        f54718h = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0054 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean m40642a() {
        /*
            java.lang.Class<com.firebase.jobdispatcher.b> r0 = com.firebase.jobdispatcher.C18602b.class
            monitor-enter(r0)
            java.lang.Boolean r1 = f54718h     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x005d
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "key"
            java.lang.String r3 = "value"
            r1.putString(r2, r3)     // Catch:{ all -> 0x0065 }
            android.os.Parcel r1 = m40644c(r1)     // Catch:{ all -> 0x0065 }
            int r2 = r1.readInt()     // Catch:{ RuntimeException -> 0x0054 }
            r3 = 0
            r4 = 1
            if (r2 <= 0) goto L_0x0021
            r2 = 1
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            m40641a((boolean) r2)     // Catch:{ RuntimeException -> 0x0054 }
            int r2 = r1.readInt()     // Catch:{ RuntimeException -> 0x0054 }
            r5 = 1279544898(0x4c444e42, float:5.146036E7)
            if (r2 != r5) goto L_0x0030
            r2 = 1
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            m40641a((boolean) r2)     // Catch:{ RuntimeException -> 0x0054 }
            int r2 = r1.readInt()     // Catch:{ RuntimeException -> 0x0054 }
            if (r2 != r4) goto L_0x003b
            r3 = 1
        L_0x003b:
            m40641a((boolean) r3)     // Catch:{ RuntimeException -> 0x0054 }
            java.lang.String r2 = "key"
            java.lang.String r3 = r1.readString()     // Catch:{ RuntimeException -> 0x0054 }
            boolean r2 = r2.equals(r3)     // Catch:{ RuntimeException -> 0x0054 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ RuntimeException -> 0x0054 }
            f54718h = r2     // Catch:{ RuntimeException -> 0x0054 }
        L_0x004e:
            r1.recycle()     // Catch:{ all -> 0x0065 }
            goto L_0x005d
        L_0x0052:
            r2 = move-exception
            goto L_0x0059
        L_0x0054:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0052 }
            f54718h = r2     // Catch:{ all -> 0x0052 }
            goto L_0x004e
        L_0x0059:
            r1.recycle()     // Catch:{ all -> 0x0065 }
            throw r2     // Catch:{ all -> 0x0065 }
        L_0x005d:
            java.lang.Boolean r1 = f54718h     // Catch:{ all -> 0x0065 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0065 }
            monitor-exit(r0)
            return r1
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.C18602b.m40642a():boolean");
    }

    /* renamed from: a */
    private static void m40641a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
