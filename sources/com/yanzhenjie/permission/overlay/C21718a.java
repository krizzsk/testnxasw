package com.yanzhenjie.permission.overlay;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.overlay.a */
/* compiled from: BaseRequest */
abstract class C21718a implements OverlayRequest {

    /* renamed from: a */
    private Source f58984a;

    /* renamed from: b */
    private Rationale<Void> f58985b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f58986c;

    /* renamed from: d */
    private Action<Void> f58987d;

    C21718a(Source source) {
        this.f58984a = source;
    }

    public final OverlayRequest rationale(Rationale<Void> rationale) {
        this.f58985b = rationale;
        return this;
    }

    public final OverlayRequest onGranted(Action<Void> action) {
        this.f58986c = action;
        return this;
    }

    public final OverlayRequest onDenied(Action<Void> action) {
        this.f58987d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178907a(RequestExecutor requestExecutor) {
        this.f58985b.showRationale(this.f58984a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo178906a() {
        Action<Void> action = this.f58986c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo178908b() {
        Action<Void> action = this.f58987d;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* renamed from: a */
    static boolean m44598a(Context context) {
        Dialog dialog = new Dialog(context, 2132017657);
        dialog.getWindow().setType(Build.VERSION.SDK_INT >= 26 ? 2038 : 2003);
        try {
            SystemUtils.showDialog(dialog);
            if (!dialog.isShowing()) {
                return true;
            }
            dialog.dismiss();
            return true;
        } catch (Exception unused) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            return false;
        } catch (Throwable th) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            throw th;
        }
    }
}
