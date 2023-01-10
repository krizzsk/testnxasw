package com.didi.dimina.container.secondparty.permission.notify;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.a */
/* compiled from: BaseRequest */
abstract class C8204a implements PermissionRequest {

    /* renamed from: a */
    private final Source f19253a;

    /* renamed from: b */
    private Rationale<Void> f19254b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f19255c;

    /* renamed from: d */
    private Action<Void> f19256d;

    C8204a(Source source) {
        this.f19253a = source;
    }

    public final PermissionRequest rationale(Rationale<Void> rationale) {
        this.f19254b = rationale;
        return this;
    }

    public final PermissionRequest onGranted(Action<Void> action) {
        this.f19255c = action;
        return this;
    }

    public final PermissionRequest onDenied(Action<Void> action) {
        this.f19256d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60883a(RequestExecutor requestExecutor) {
        this.f19254b.showRationale(this.f19253a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60882a() {
        Action<Void> action = this.f19255c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo60884b() {
        Action<Void> action = this.f19256d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
