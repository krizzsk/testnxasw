package com.didi.dimina.container.secondparty.permission.notify.listener;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.listener.a */
/* compiled from: BaseRequest */
abstract class C8207a implements ListenerRequest {

    /* renamed from: a */
    private final Source f19259a;

    /* renamed from: b */
    private Rationale<Void> f19260b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f19261c;

    /* renamed from: d */
    private Action<Void> f19262d;

    C8207a(Source source) {
        this.f19259a = source;
    }

    public final ListenerRequest rationale(Rationale<Void> rationale) {
        this.f19260b = rationale;
        return this;
    }

    public final ListenerRequest onGranted(Action<Void> action) {
        this.f19261c = action;
        return this;
    }

    public final ListenerRequest onDenied(Action<Void> action) {
        this.f19262d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60891a(RequestExecutor requestExecutor) {
        this.f19260b.showRationale(this.f19259a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60890a() {
        Action<Void> action = this.f19261c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo60892b() {
        Action<Void> action = this.f19262d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
