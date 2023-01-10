package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C20030ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.play.core.missingsplits.a */
final class C20138a {

    /* renamed from: a */
    private static final C20030ag f56136a = new C20030ag("MissingSplitsAppComponentsHelper");

    /* renamed from: b */
    private final Context f56137b;

    /* renamed from: c */
    private final PackageManager f56138c;

    C20138a(Context context, PackageManager packageManager) {
        this.f56137b = context;
        this.f56138c = packageManager;
    }

    /* renamed from: a */
    private final void m42385a(List<ComponentInfo> list, int i) {
        for (ComponentInfo next : list) {
            this.f56138c.setComponentEnabledSetting(new ComponentName(next.packageName, next.name), i, 1);
        }
    }

    /* renamed from: d */
    private final List<ComponentInfo> m42386d() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = SystemUtils.getPackageInfo(this.f56138c, this.f56137b.getPackageName(), 526);
            if (packageInfo.providers != null) {
                Collections.addAll(arrayList, packageInfo.providers);
            }
            if (packageInfo.receivers != null) {
                Collections.addAll(arrayList, packageInfo.receivers);
            }
            if (packageInfo.services != null) {
                Collections.addAll(arrayList, packageInfo.services);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            f56136a.mo164271d("Failed to resolve own package : %s", e);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo164415a() {
        for (ComponentInfo next : m42386d()) {
            if (this.f56138c.getComponentEnabledSetting(new ComponentName(next.packageName, next.name)) != 2) {
                f56136a.mo164267a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f56136a.mo164267a("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo164416b() {
        f56136a.mo164270c("Disabling all non-activity components", new Object[0]);
        m42385a(m42386d(), 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo164417c() {
        f56136a.mo164270c("Resetting enabled state of all non-activity components", new Object[0]);
        m42385a(m42386d(), 0);
    }
}
