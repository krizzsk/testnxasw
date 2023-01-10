package com.didi.dimina.container.secondparty.permission.overlay;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.secondparty.permission.overlay.a */
/* compiled from: BaseRequest */
abstract class C8210a implements OverlayRequest {

    /* renamed from: a */
    private final Source f19264a;

    /* renamed from: b */
    private Rationale<Void> f19265b = new BaseRequest$1(this);

    /* renamed from: c */
    private Action<Void> f19266c;

    /* renamed from: d */
    private Action<Void> f19267d;

    C8210a(Source source) {
        this.f19264a = source;
    }

    public final OverlayRequest rationale(Rationale<Void> rationale) {
        this.f19265b = rationale;
        return this;
    }

    public final OverlayRequest onGranted(Action<Void> action) {
        this.f19266c = action;
        return this;
    }

    public final OverlayRequest onDenied(Action<Void> action) {
        this.f19267d = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60899a(RequestExecutor requestExecutor) {
        this.f19265b.showRationale(this.f19264a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo60898a() {
        Action<Void> action = this.f19266c;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo60900b() {
        Action<Void> action = this.f19267d;
        if (action != null) {
            action.onAction(null);
        }
    }

    /* renamed from: a */
    static boolean m16352a(Context context) {
        Dialog dialog = new Dialog(context, R.style.DiminaPermissionDialogTransparent);
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
