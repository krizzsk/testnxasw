package com.didichuxing.sofa.permission;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.lang.ref.WeakReference;

public abstract class PermissionRequest<T> {

    /* renamed from: a */
    private static final String f51712a = "PermissionRequest";

    /* renamed from: b */
    private WeakReference<T> f51713b;

    /* renamed from: c */
    private String[] f51714c;

    /* renamed from: d */
    private int f51715d;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo127672a(T t, String[] strArr, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo127673a(T t, String[] strArr);

    public void cancel() {
    }

    PermissionRequest(T t, String[] strArr, int i) {
        this.f51713b = new WeakReference<>(t);
        this.f51714c = strArr;
        this.f51715d = i;
    }

    /* renamed from: b */
    static PermissionRequest m38865b(Object obj, String[] strArr, int i) {
        if (obj instanceof Activity) {
            return new C17279a((Activity) obj, strArr, i);
        }
        if (obj instanceof Fragment) {
            return new C17280b((Fragment) obj, strArr, i);
        }
        SystemUtils.log(6, f51712a, "createRequest: Can't resolve host: " + obj, (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 34);
        return null;
    }

    public void execute() {
        if (this.f51713b.get() == null) {
            SystemUtils.log(6, f51712a, "execute: host is null", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 43);
        } else if (mo127673a(this.f51713b.get(), this.f51714c)) {
            SystemUtils.log(3, f51712a, "execute: permissions " + PermissionUtils.formatArrayAsString(this.f51714c) + " have granted already!", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 47);
        } else {
            mo127672a(this.f51713b.get(), this.f51714c, this.f51715d);
        }
    }

    public void proceed() {
        if (this.f51713b.get() == null) {
            SystemUtils.log(6, f51712a, "proceed: host is null", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 67);
        } else if (mo127673a(this.f51713b.get(), this.f51714c)) {
            SystemUtils.log(3, f51712a, "proceed: permissions " + PermissionUtils.formatArrayAsString(this.f51714c) + " have granted already!", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 71);
        } else {
            mo127672a(this.f51713b.get(), this.f51714c, this.f51715d);
        }
    }

    public String toString() {
        return Const.jaLeft + this.f51713b + "] request permissions: " + PermissionUtils.formatArrayAsString(this.f51714c);
    }
}
