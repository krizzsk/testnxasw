package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C20030ag;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.play.core.splitinstall.p */
public final class C20207p {

    /* renamed from: a */
    private static final C20030ag f56269a = new C20030ag("SplitInstallInfoProvider");

    /* renamed from: b */
    private final Context f56270b;

    /* renamed from: c */
    private final String f56271c;

    public C20207p(Context context) {
        this.f56270b = context;
        this.f56271c = context.getPackageName();
    }

    public C20207p(Context context, String str) {
        this.f56270b = context;
        this.f56271c = str;
    }

    /* renamed from: a */
    public static boolean m42541a(String str) {
        return str.startsWith("config.");
    }

    /* renamed from: b */
    public static boolean m42542b(String str) {
        return m42541a(str) || str.contains(".config.");
    }

    /* renamed from: d */
    private final Set<String> m42543d() {
        HashSet hashSet = new HashSet();
        Bundle e = m42544e();
        if (e != null) {
            String string = e.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                f56269a.mo164267a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            try {
                PackageInfo packageInfo = SystemUtils.getPackageInfo(this.f56270b.getPackageManager(), this.f56271c, 0);
                if (packageInfo != null) {
                    strArr = packageInfo.splitNames;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f56269a.mo164271d("App is not found in PackageManager", new Object[0]);
            }
            if (strArr != null) {
                f56269a.mo164267a("Adding splits from package manager: %s", Arrays.toString(strArr));
                Collections.addAll(hashSet, strArr);
            } else {
                f56269a.mo164267a("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            C20205n a = C20206o.m42539a();
            if (a != null) {
                hashSet.addAll(a.mo164450a());
            }
        }
        return hashSet;
    }

    /* renamed from: e */
    private final Bundle m42544e() {
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(this.f56270b.getPackageManager(), this.f56271c, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            f56269a.mo164267a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f56269a.mo164271d("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public final Set<String> mo164516a() {
        HashSet hashSet = new HashSet();
        for (String next : m42543d()) {
            if (!m42542b(next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    public final Set<String> mo164517b() {
        C20198h c = mo164518c();
        if (c == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> d = m42543d();
        d.add("");
        Set<String> a = mo164516a();
        a.add("");
        for (Map.Entry next : c.mo164514a(a).entrySet()) {
            if (d.containsAll((Collection) next.getValue())) {
                hashSet.add((String) next.getKey());
            }
        }
        return hashSet;
    }

    /* renamed from: c */
    public final C20198h mo164518c() {
        Bundle e = m42544e();
        if (e == null) {
            f56269a.mo164271d("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = e.getInt("com.android.vending.splits");
        if (i == 0) {
            f56269a.mo164271d("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            C20198h a = C20201k.m42529a((XmlPullParser) this.f56270b.getResources().getXml(i), new C20197g());
            if (a == null) {
                f56269a.mo164271d("Can't parse languages metadata.", new Object[0]);
            }
            return a;
        } catch (Resources.NotFoundException unused) {
            f56269a.mo164271d("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }
}
