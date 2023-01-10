package com.yanzhenjie.permission.install;

import android.content.Intent;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;
import java.io.File;

/* renamed from: com.yanzhenjie.permission.install.a */
/* compiled from: BaseRequest */
abstract class C21709a implements InstallRequest {

    /* renamed from: a */
    private Source f58964a;

    /* renamed from: b */
    private File f58965b;

    /* renamed from: c */
    private Rationale<File> f58966c = new BaseRequest$1(this);

    /* renamed from: d */
    private Action<File> f58967d;

    /* renamed from: e */
    private Action<File> f58968e;

    C21709a(Source source) {
        this.f58964a = source;
    }

    public final InstallRequest file(File file) {
        this.f58965b = file;
        return this;
    }

    public final InstallRequest rationale(Rationale<File> rationale) {
        this.f58966c = rationale;
        return this;
    }

    public final InstallRequest onGranted(Action<File> action) {
        this.f58967d = action;
        return this;
    }

    public final InstallRequest onDenied(Action<File> action) {
        this.f58968e = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178878a(RequestExecutor requestExecutor) {
        this.f58966c.showRationale(this.f58964a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178877a() {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(AndPermission.getFileUri(this.f58964a.getContext(), this.f58965b), "application/vnd.android.package-archive");
        this.f58964a.startActivity(intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo178879b() {
        Action<File> action = this.f58967d;
        if (action != null) {
            action.onAction(this.f58965b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo178880c() {
        Action<File> action = this.f58968e;
        if (action != null) {
            action.onAction(this.f58965b);
        }
    }
}
