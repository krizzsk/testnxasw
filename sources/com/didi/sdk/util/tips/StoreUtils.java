package com.didi.sdk.util.tips;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class StoreUtils {

    /* renamed from: a */
    private Context f40455a;

    public StoreUtils(Context context) {
        this.f40455a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo103574a(int i) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f40455a, "showtips", 0);
        return sharedPreferences.getBoolean("id" + i, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo103575b(int i) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f40455a, "showtips", 0).edit();
        edit.putBoolean("id" + i, true).apply();
    }
}
