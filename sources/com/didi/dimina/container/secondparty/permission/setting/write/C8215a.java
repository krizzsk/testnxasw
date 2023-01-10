package com.didi.dimina.container.secondparty.permission.setting.write;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.setting.write.a */
/* compiled from: BaseRequest */
abstract class C8215a implements WriteRequest {

    /* renamed from: a */
    private final Source f19296a;

    /* renamed from: b */
    private Rationale<Void> f19297b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f19298c;

    /* renamed from: d */
    private Action<Void> f19299d;

    C8215a(Source source) {
        this.f19296a = source;
    }

    public final WriteRequest rationale(Rationale<Void> rationale) {
        this.f19297b = rationale;
        return this;
    }

    public final WriteRequest onGranted(Action<Void> action) {
        this.f19298c = action;
        return this;
    }

    public final WriteRequest onDenied(Action<Void> action) {
        this.f19299d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60931a(RequestExecutor requestExecutor) {
        this.f19297b.showRationale(this.f19296a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60930a() {
        Action<Void> action = this.f19298c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo60932b() {
        Action<Void> action = this.f19299d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
