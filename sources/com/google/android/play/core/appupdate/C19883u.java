package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* renamed from: com.google.android.play.core.appupdate.u */
final class C19883u extends AppUpdateOptions.Builder {

    /* renamed from: a */
    private Integer f55615a;

    /* renamed from: b */
    private Boolean f55616b;

    C19883u() {
    }

    public final AppUpdateOptions build() {
        String str = "";
        if (this.f55615a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.f55616b == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new C19884v(this.f55615a.intValue(), this.f55616b.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }

    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z) {
        this.f55616b = Boolean.valueOf(z);
        return this;
    }

    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.f55615a = Integer.valueOf(i);
        return this;
    }
}
