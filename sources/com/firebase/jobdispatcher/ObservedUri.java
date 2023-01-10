package com.firebase.jobdispatcher;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ObservedUri {

    /* renamed from: a */
    private final Uri f54682a;

    /* renamed from: b */
    private final int f54683b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
        public static final int FLAG_NOTIFY_FOR_DESCENDANTS = 1;
    }

    public ObservedUri(Uri uri, int i) {
        if (uri != null) {
            this.f54682a = uri;
            this.f54683b = i;
            return;
        }
        throw new IllegalArgumentException("URI must not be null.");
    }

    public Uri getUri() {
        return this.f54682a;
    }

    public int getFlags() {
        return this.f54683b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObservedUri)) {
            return false;
        }
        ObservedUri observedUri = (ObservedUri) obj;
        if (this.f54683b != observedUri.f54683b || !this.f54682a.equals(observedUri.f54682a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f54682a.hashCode() ^ this.f54683b;
    }
}
