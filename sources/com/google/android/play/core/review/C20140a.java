package com.google.android.play.core.review;

import android.app.PendingIntent;

/* renamed from: com.google.android.play.core.review.a */
final class C20140a extends ReviewInfo {

    /* renamed from: a */
    private final PendingIntent f56144a;

    C20140a(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f56144a = pendingIntent;
            return;
        }
        throw new NullPointerException("Null pendingIntent");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PendingIntent mo164418a() {
        return this.f56144a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f56144a.equals(((ReviewInfo) obj).mo164418a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f56144a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f56144a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("ReviewInfo{pendingIntent=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
