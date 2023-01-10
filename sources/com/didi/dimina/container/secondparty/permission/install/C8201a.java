package com.didi.dimina.container.secondparty.permission.install;

import android.content.Intent;
import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.AndPermission;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;
import java.io.File;

/* renamed from: com.didi.dimina.container.secondparty.permission.install.a */
/* compiled from: BaseRequest */
abstract class C8201a implements InstallRequest {

    /* renamed from: a */
    private final Source f19244a;

    /* renamed from: b */
    private File f19245b;

    /* renamed from: c */
    private Rationale<File> f19246c = new BaseRequest$1(this);

    /* renamed from: d */
    private Action<File> f19247d;

    /* renamed from: e */
    private Action<File> f19248e;

    C8201a(Source source) {
        this.f19244a = source;
    }

    public final InstallRequest file(File file) {
        this.f19245b = file;
        return this;
    }

    public final InstallRequest rationale(Rationale<File> rationale) {
        this.f19246c = rationale;
        return this;
    }

    public final InstallRequest onGranted(Action<File> action) {
        this.f19247d = action;
        return this;
    }

    public final InstallRequest onDenied(Action<File> action) {
        this.f19248e = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60870a(RequestExecutor requestExecutor) {
        this.f19246c.showRationale(this.f19244a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60869a() {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(AndPermission.getFileUri(this.f19244a.getContext(), this.f19245b), "application/vnd.android.package-archive");
        this.f19244a.startActivity(intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo60871b() {
        Action<File> action = this.f19247d;
        if (action != null) {
            action.onAction(this.f19245b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo60872c() {
        Action<File> action = this.f19248e;
        if (action != null) {
            action.onAction(this.f19245b);
        }
    }
}
