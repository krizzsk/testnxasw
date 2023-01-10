package com.didi.sdk.splash;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.sdk.splash.a */
/* compiled from: FirstStartCheckSp */
class C13961a {

    /* renamed from: a */
    private static final String f40242a = "first_start_check_sp";

    /* renamed from: b */
    private static final String f40243b = "is_first_start";

    /* renamed from: c */
    private final SharedPreferences f40244c;

    /* renamed from: d */
    private final SharedPreferences.Editor f40245d;

    C13961a(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, f40242a, 0);
        this.f40244c = sharedPreferences;
        this.f40245d = sharedPreferences.edit();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo102997a(boolean z) {
        this.f40245d.putBoolean(f40243b, z).apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo102998a() {
        return this.f40244c.getBoolean(f40243b, true);
    }
}
