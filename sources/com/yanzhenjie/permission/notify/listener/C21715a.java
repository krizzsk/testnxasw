package com.yanzhenjie.permission.notify.listener;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.listener.a */
/* compiled from: BaseRequest */
abstract class C21715a implements ListenerRequest {

    /* renamed from: a */
    private Source f58979a;

    /* renamed from: b */
    private Rationale<Void> f58980b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f58981c;

    /* renamed from: d */
    private Action<Void> f58982d;

    C21715a(Source source) {
        this.f58979a = source;
    }

    public final ListenerRequest rationale(Rationale<Void> rationale) {
        this.f58980b = rationale;
        return this;
    }

    public final ListenerRequest onGranted(Action<Void> action) {
        this.f58981c = action;
        return this;
    }

    public final ListenerRequest onDenied(Action<Void> action) {
        this.f58982d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178899a(RequestExecutor requestExecutor) {
        this.f58980b.showRationale(this.f58979a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178898a() {
        Action<Void> action = this.f58981c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo178900b() {
        Action<Void> action = this.f58982d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
