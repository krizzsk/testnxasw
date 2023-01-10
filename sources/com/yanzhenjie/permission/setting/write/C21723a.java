package com.yanzhenjie.permission.setting.write;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.setting.write.a */
/* compiled from: BaseRequest */
abstract class C21723a implements WriteRequest {

    /* renamed from: a */
    private Source f59017a;

    /* renamed from: b */
    private Rationale<Void> f59018b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f59019c;

    /* renamed from: d */
    private Action<Void> f59020d;

    C21723a(Source source) {
        this.f59017a = source;
    }

    public final WriteRequest rationale(Rationale<Void> rationale) {
        this.f59018b = rationale;
        return this;
    }

    public final WriteRequest onGranted(Action<Void> action) {
        this.f59019c = action;
        return this;
    }

    public final WriteRequest onDenied(Action<Void> action) {
        this.f59020d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178939a(RequestExecutor requestExecutor) {
        this.f59018b.showRationale(this.f59017a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178938a() {
        Action<Void> action = this.f59019c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo178940b() {
        Action<Void> action = this.f59020d;
        if (action != null) {
            action.onAction(null);
        }
    }
}
