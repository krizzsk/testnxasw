package com.google.android.play.core.appupdate;

/* renamed from: com.google.android.play.core.appupdate.v */
final class C19884v extends AppUpdateOptions {

    /* renamed from: a */
    private final int f55617a;

    /* renamed from: b */
    private final boolean f55618b;

    /* synthetic */ C19884v(int i, boolean z) {
        this.f55617a = i;
        this.f55618b = z;
    }

    public final boolean allowAssetPackDeletion() {
        return this.f55618b;
    }

    public final int appUpdateType() {
        return this.f55617a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            return this.f55617a == appUpdateOptions.appUpdateType() && this.f55618b == appUpdateOptions.allowAssetPackDeletion();
        }
    }

    public final int hashCode() {
        return ((this.f55617a ^ 1000003) * 1000003) ^ (true != this.f55618b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.f55617a;
        boolean z = this.f55618b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
