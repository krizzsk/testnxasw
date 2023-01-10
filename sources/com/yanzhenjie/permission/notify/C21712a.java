package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.a */
/* compiled from: BaseRequest */
abstract class C21712a implements PermissionRequest {

    /* renamed from: a */
    private Source f58973a;

    /* renamed from: b */
    private Rationale<Void> f58974b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f58975c;

    /* renamed from: d */
    private Action<Void> f58976d;

    C21712a(Source source) {
        this.f58973a = source;
    }

    public final PermissionRequest rationale(Rationale<Void> rationale) {
        this.f58974b = rationale;
        return this;
    }

    public final PermissionRequest onGranted(Action<Void> action) {
        this.f58975c = action;
        return this;
    }

    public final PermissionRequest onDenied(Action<Void> action) {
        this.f58976d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178891a(RequestExecutor requestExecutor) {
        this.f58974b.showRationale(this.f58973a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178890a() {
        Action<Void> action = this.f58975c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo178892b() {
        Action<Void> action = this.f58976d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
